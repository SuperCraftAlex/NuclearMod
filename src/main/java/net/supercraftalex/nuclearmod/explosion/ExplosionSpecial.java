package net.supercraftalex.nuclearmod.explosion;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlocks;

import java.util.List;
import java.util.Random;

public class ExplosionSpecial {

    private final static Random random = new Random();

    public static boolean dedify(World world, int x, int y, int z, int radius) {
        int i;
        int j;
        int k;
        double d5;
        double d6;
        double d7;
        double wat = radius;

        // bombStartStrength *= 2.0F;
        i = MathHelper.floor(x - wat - 1.0D);
        j = MathHelper.floor(x + wat + 1.0D);
        k = MathHelper.floor(y - wat - 1.0D);
        int i2 = MathHelper.floor(y + wat + 1.0D);
        int l = MathHelper.floor(z - wat - 1.0D);
        int j2 = MathHelper.floor(z + wat + 1.0D);
        List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(i, k, l, j, i2, j2));

        for (int i1 = 0; i1 < list.size(); ++i1) {
            Entity entity = (Entity) list.get(i1);
            double d4 = entity.getDistance(x, y, z) / radius;

            if (d4 <= 1.0D) {
                d5 = entity.posX - x;
                d6 = entity.posY + entity.getEyeHeight() - y;
                d7 = entity.posZ - z;
                double d9 = MathHelper.sqrt(d5 * d5 + d6 * d6 + d7 * d7);
                if (d9 < wat) {
                    d5 /= d9;
                    d6 /= d9;
                    d7 /= d9;
                    // double d10 = (double)world.getBlockDensity(vec3,
                    // entity.boundingBox);
                    // if(d10 > 0) isOccupied = true;

                    if (!(entity instanceof EntityPlayerMP && ((EntityPlayerMP) entity).interactionManager.getGameType() == GameType.CREATIVE)) {
                        entity.attackEntityFrom(DamageSource.GENERIC, 1000F);
                    }
                }
            }
        }

        return false;
    }

    public static void AntiWater(World world, int x, int y, int z, int radius) {
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int r = radius;
        int r2 = r * r;
        int r22 = r2 / 2;
        for (int xx = -r; xx < r; xx++) {
            int X = xx + x;
            int XX = xx * xx;
            for (int yy = -r; yy < r; yy++) {
                int Y = yy + y;
                int YY = XX + yy * yy;
                for (int zz = -r; zz < r; zz++) {
                    int Z = zz + z;
                    int ZZ = YY + zz * zz;
                    if (ZZ < r22 + world.rand.nextInt(r22 / 5)) {
                        if (world.getBlockState(pos.setPos(X, Y, Z)).getBlock() != Blocks.AIR) {
                            if (world.getBlockState(pos).getBlock() == Blocks.WATER || world.getBlockState(pos).getBlock() == Blocks.FLOWING_WATER) {
                                world.setBlockToAir(pos);
                            }
                        }
                    }
                }
            }
        }
    }

}
