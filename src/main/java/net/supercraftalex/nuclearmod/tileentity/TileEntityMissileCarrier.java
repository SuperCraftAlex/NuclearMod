package net.supercraftalex.nuclearmod.tileentity;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.supercraftalex.nuclearmod.block.BlockTutorialFacing;
import net.supercraftalex.nuclearmod.entities.EntityMissile1;
import net.supercraftalex.nuclearmod.entities.ModMissile;
import net.supercraftalex.nuclearmod.util.RedstoneUtil;

public class TileEntityMissileCarrier extends ModTileEntity implements ITickable {

    private ModMissile missile;

    @Override
    public void update() {
        if (world.isRemote) {
            return;
        }

        IBlockState ourState = world.getBlockState(pos);
        EnumFacing facing = ourState.getValue(BlockTutorialFacing.FACING);
        BlockPos destinationPos = pos.offset(facing);

        TileEntity tileentity = world.getTileEntity(destinationPos);

        if (tileentity == null) {
            return;
        }

        Entity entity = world.getEntitiesWithinAABB(EntityMissile1.class, new AxisAlignedBB(this.pos)).get(1);
        if(entity != null) {
            this.missile = (ModMissile) entity;
        }

        if (RedstoneUtil.isPowered(world, pos)) {
            missile.shoot();
            this.missile = null;
        }

    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        return compound;
    }

}
