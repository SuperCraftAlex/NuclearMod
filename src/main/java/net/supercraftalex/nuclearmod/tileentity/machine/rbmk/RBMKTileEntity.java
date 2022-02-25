package net.supercraftalex.nuclearmod.tileentity.machine.rbmk;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.supercraftalex.nuclearmod.block.machine.rbmk.RBMKBlockType;
import net.supercraftalex.nuclearmod.tileentity.ModTileEntity;
import net.supercraftalex.nuclearmod.util.RandomUtil;

public class RBMKTileEntity extends ModTileEntity implements ITickable {

//Neutron speed: 0-50 slow 50-100 medium 100+ fast

    public RBMKBlockType    type;
    public double           arg1,arg2,arg3;
    public double           BlockHeat;
    public double           NeutronsRecievedPerTick;
    public int              NeutronRecievedSpeed;
    public double           NeutronsSendPerTick;
    public int              NeutronSendSpeed;
    public int              HeatRecievedPerTick;
    public boolean          meltdown;

    public RBMKTileEntity(String name, RBMKBlockType BlockType, double aarg1, double aarg2, double aarg3) {
        this.type = BlockType;
        this.arg1 = aarg1;
        this.arg2 = aarg2;
        this.arg3 = aarg3;
    }

    @Override
    public void update() {

        if (this.BlockHeat >= 40) {this.BlockHeat = this.BlockHeat - 40;}
        if (getFuelHeat() >= 40) { setFuelHeat(getFuelHeat() - 40); }
        if (this.BlockHeat < 3000) {
            this.BlockHeat = this.BlockHeat + getFuelHeat()/100*70;
            setFuelHeat(getFuelHeat()/100*70);
        }

        if(this.meltdown) {meltdown();}

        this.BlockHeat = this.BlockHeat + this.HeatRecievedPerTick;

        int surroundingRBMK = 0;
        if(isRBMKBlock(EnumFacing.NORTH)) {surroundingRBMK++;}
        if(isRBMKBlock(EnumFacing.SOUTH)) {surroundingRBMK++;}
        if(isRBMKBlock(EnumFacing.EAST)) {surroundingRBMK++;}
        if(isRBMKBlock(EnumFacing.WEST)) {surroundingRBMK++;}
        int howmuchheat = (int) (this.BlockHeat / 100 * 70 / surroundingRBMK);
        if(isCoolant(EnumFacing.NORTH)) {this.BlockHeat = this.BlockHeat -50;}
        if(isCoolant(EnumFacing.SOUTH)) {this.BlockHeat = this.BlockHeat -50;}
        if(isCoolant(EnumFacing.EAST)) {this.BlockHeat = this.BlockHeat -50;}
        if(isCoolant(EnumFacing.WEST)) {this.BlockHeat = this.BlockHeat -50;}

        if (isRBMKBlock(EnumFacing.NORTH)) {sendHeat(EnumFacing.NORTH, howmuchheat);this.BlockHeat = this.BlockHeat - howmuchheat;}
        if (isRBMKBlock(EnumFacing.EAST)) {sendHeat(EnumFacing.SOUTH, howmuchheat);this.BlockHeat = this.BlockHeat - howmuchheat;}
        if (isRBMKBlock(EnumFacing.SOUTH)) {sendHeat(EnumFacing.EAST, howmuchheat);this.BlockHeat = this.BlockHeat - howmuchheat;}
        if (isRBMKBlock(EnumFacing.WEST)) {sendHeat(EnumFacing.WEST, howmuchheat);this.BlockHeat = this.BlockHeat - howmuchheat;}

        for(int i = 0; i < this.NeutronsSendPerTick; i = i + 4) {
           if (this.NeutronsSendPerTick >=1 && isRBMKBlock(EnumFacing.NORTH)) {sendNeutrons(EnumFacing.NORTH);this.NeutronsSendPerTick--;}
           if (this.NeutronsSendPerTick >=1 && isRBMKBlock(EnumFacing.EAST)) {sendNeutrons(EnumFacing.EAST);this.NeutronsSendPerTick--;}
           if (this.NeutronsSendPerTick >=1 && isRBMKBlock(EnumFacing.SOUTH)) {sendNeutrons(EnumFacing.SOUTH);this.NeutronsSendPerTick--;}
           if (this.NeutronsSendPerTick >=1 && isRBMKBlock(EnumFacing.WEST)) {sendNeutrons(EnumFacing.WEST);this.NeutronsSendPerTick--;}
        }


        if (this.type == RBMKBlockType.FUEL) {
            //replce with heat get of fuel rod
            double FuelHeat = 0.0;
            if (NeutronsRecievedPerTick >= 1 &&  NeutronRecievedSpeed <= 100) {
                    //replace this with heat set of fuel rod
                    setFuelHeat(getFuelHeat() + 0.1 * NeutronsRecievedPerTick);
                    this.BlockHeat = this.BlockHeat + this.arg2 / this.NeutronRecievedSpeed;
                    this.NeutronsSendPerTick = this.NeutronsRecievedPerTick * this.arg1;
                    this.NeutronSendSpeed = (int) RandomUtil.randomD(90,160);
                }
                if(getFuelHeat() > this.arg3) {meltdown();}
        }
        if (this.type == RBMKBlockType.MODERATE) {
                this.NeutronsSendPerTick = NeutronsRecievedPerTick;
                this.NeutronSendSpeed = (int) (NeutronRecievedSpeed / 100 * this.arg1);
        }
        if (this.type == RBMKBlockType.TRANSMIT) {
            this.NeutronsSendPerTick = NeutronsRecievedPerTick;
            this.NeutronSendSpeed = NeutronRecievedSpeed;
        }
        if (this.type == RBMKBlockType.REDUCE) {
            this.NeutronsSendPerTick = NeutronsRecievedPerTick / 100 * this.arg1;
            this.NeutronSendSpeed = NeutronRecievedSpeed;
        }

    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.HeatRecievedPerTick = compound.getInteger("heatpertick");
        this.NeutronRecievedSpeed = compound.getInteger("neutronspeed");
        this.NeutronsRecievedPerTick = compound.getInteger("neutronpertick");
        this.meltdown = compound.getBoolean("meltdown");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("heatpertick", HeatRecievedPerTick);
        compound.setInteger("neutronspeed", NeutronRecievedSpeed);
        compound.setInteger("neutronpertick", (int) NeutronsRecievedPerTick);
        compound.setBoolean("meltdown", meltdown);
        return compound;
    }

    public void sendHeat(EnumFacing dir,int amount) {
        setNbtOnSide(dir, "heatpertick", amount);
    }

    public void sendNeutrons(EnumFacing dir,int amount, int speed) {
        setNbtOnSide(dir, "neutronpertick", amount);
        setNbtOnSide(dir, "neutronspeed", speed);
    }
    public void sendNeutrons(EnumFacing dir) {
        sendNeutrons(dir, (int) this.NeutronsSendPerTick, this.NeutronSendSpeed);
    }

    public boolean isRBMKBlock(EnumFacing direction) {
        if(getTileEntityOnSide(direction) instanceof RBMKTileEntity) {
            return true;
        }
        return false;
    }

    public boolean isCoolant(EnumFacing direction) {
        if(getBlockOnSide(direction).getRegistryName() == Blocks.WATER.getRegistryName()) {
            return true;
        }
        return false;
    }

    public double getFuelHeat() {return 0;}
    public void setFuelHeat(Double d) {}



    public void meltdown() {
        if (isRBMKBlock(EnumFacing.NORTH)) {setNbtOnSide(EnumFacing.NORTH, "meltdown", true);}
        if (isRBMKBlock(EnumFacing.EAST)) {setNbtOnSide(EnumFacing.EAST, "meltdown", true);}
        if (isRBMKBlock(EnumFacing.SOUTH)) {setNbtOnSide(EnumFacing.SOUTH, "meltdown", true);}
        if (isRBMKBlock(EnumFacing.WEST)) {setNbtOnSide(EnumFacing.WEST, "meltdown", true);}

        //do explosive and radeoactive stuff here

    }

}