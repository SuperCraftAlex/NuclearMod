package net.supercraftalex.nuclearmod.entities;

import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMissile1 extends ModMissile {

    public EntityMissile1(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    public EntityMissile1(World worldIn, BlockPos pos) {
        super(worldIn);
        this.setSize(1F, 1F);
        this.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(),0,0);
    }

    @Override
    public void shoot() {
        System.out.println(this.posX + " " + this.posY + " " + this.posZ);
        this.motionX = 10;
    }

    @Override
    public void shoot(BlockPos target) {

    }

    @Override
    public void shoot(Entity target) {

    }

    @Override
    protected void entityInit() {

    }

    public EntityMissile1(World worldIn, double x, double y, double z) {
        super(worldIn);
        this.setPosition(x, y, z);
        this.setSize(0.9F, 2.8F);
    }

    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }

}
