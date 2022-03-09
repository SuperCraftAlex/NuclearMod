package net.supercraftalex.nuclearmod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ModMissile extends Entity {
    public ModMissile(World worldIn) {
        super(worldIn);
    }

    public abstract void shoot();

    public abstract void shoot(BlockPos target);

    public abstract void shoot(Entity target);

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {

    }

}
