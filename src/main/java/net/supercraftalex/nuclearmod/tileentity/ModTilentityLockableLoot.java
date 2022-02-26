package net.supercraftalex.nuclearmod.tileentity;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;

public class ModTilentityLockableLoot extends TileEntityLockableLoot {

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    public int getSizeInventory() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 0;
    }

    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return null;
    }

    @Override
    public String getGuiID() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public enum rw {READ, WRITE};

    public TileEntity getTileEntityOnSide(EnumFacing dir) {
        if(dir == EnumFacing.NORTH) {return world.getTileEntity(getPos().north());}
        if(dir == EnumFacing.EAST) {return world.getTileEntity(getPos().east());}
        if(dir == EnumFacing.SOUTH) {return world.getTileEntity(getPos().south());}
        if(dir == EnumFacing.WEST) {return world.getTileEntity(getPos().west());}
        if(dir == EnumFacing.UP) {return world.getTileEntity(getPos().up());}
        if(dir == EnumFacing.DOWN) {return world.getTileEntity(getPos().down());}
        return null;
    }

    public Block getBlockOnSide(EnumFacing dir) {
        if(dir == EnumFacing.NORTH) {return world.getBlockState(getPos().north()).getBlock();}
        if(dir == EnumFacing.EAST) {return world.getBlockState(getPos().east()).getBlock();}
        if(dir == EnumFacing.SOUTH) {return world.getBlockState(getPos().south()).getBlock();}
        if(dir == EnumFacing.WEST) {return world.getBlockState(getPos().west()).getBlock();}
        if(dir == EnumFacing.UP) {return world.getBlockState(getPos().up()).getBlock();}
        if(dir == EnumFacing.DOWN) {return world.getBlockState(getPos().down()).getBlock();}
        return null;
    }

    public void setNbtOnSide(EnumFacing dir, String key, int value) {
        NBTTagCompound c = new NBTTagCompound();
        c.setInteger(key, value);
        getTileEntityOnSide(dir).writeToNBT(c);
    }

    public void setNbtOnSide(EnumFacing dir, String key, boolean value) {
        NBTTagCompound c = new NBTTagCompound();
        c.setBoolean(key, value);
        getTileEntityOnSide(dir).writeToNBT(c);
    }

        /*private List<NbtTag> nbt = new ArrayList<NbtTag>();

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        int i = 0;
        for ( NbtTag tag : nbt) {
            if(tag.direction == rw.READ) {
                tag.value = compound.getInteger(tag.key);
            }
            i++;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        int i = 0;
        for ( NbtTag tag : nbt ) {
            if(tag.direction == rw.WRITE) {
                compound.setInteger(tag.key, tag.value);
            }
            i++;
        }
        return compound;
    }

    public void addNbtTagListener(NBTrw dir, String key) {
        nbt.add(new NbtTag(key, 0, dir));
    }

    public int readNBT(String key) {
        for ( NbtTag tag : nbt ) {
            if(tag.key == key) {
                return tag.value;
            }
        }
        return 0;
    }

    public void writeNBT(String key, int value) {
        for ( NbtTag tag : nbt ) {
            if(tag.key == key) {
                tag.value = value;
            }
        }
    }*/

}
