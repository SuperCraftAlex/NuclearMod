package net.supercraftalex.nuclearmod.explosion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.util.DamageSource;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import org.apache.logging.log4j.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHugeMushroom;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class ExplosionNukeGeneric {

    private final static Random random = new Random();

	public static void detonateTestBomb(World world, int x, int y, int z, int bombStartStrength) {
        int r = bombStartStrength;
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
                    if (r22 >= 25) {
                        if (ZZ < r22 + world.rand.nextInt(r22 / 25)) {
                            if (Y >= y)
                                destruction(world, new BlockPos(X,Y,Z));
                        }
                    } else {
                        if (ZZ < r22) {
                            if (Y >= y)
                                destruction(world, new BlockPos(X,Y,Z));
                        }
                    }
                }
            }
        }
        for (int xx = -r; xx < r; xx++) {
            int X = xx + x;
            int XX = xx * xx;
            for (int yy = -r; yy < r; yy++) {
                int Y = yy + y;
                int YY = XX + yy * yy * 50;
                for (int zz = -r; zz < r; zz++) {
                    int Z = zz + z;
                    int ZZ = YY + zz * zz;
                    if (ZZ < r22) {
                        if (Y < y) {
                            destruction(world, new BlockPos(X, Y, Z));
                        }
                    }
                }
            }
        }
    }


    public static void empBlast(World world, int x, int y, int z, int bombStartStrength) {
        MutableBlockPos pos = new BlockPos.MutableBlockPos();
        int r = bombStartStrength;
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
                    if (ZZ < r22) {
                        pos.setPos(X, Y, Z);
                        emp(world, pos);
                    }
                }
            }
        }
    }

    public static void dealDamage(World world, double x, double y, double z, double radius) {
        dealDamage(world, x, y, z, radius, 250F);
    }

    public static void dealDamage(World world, double x, double y, double z, double radius, float maxDamage) {
        List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(x, y, z, x, y, z).grow(radius, radius, radius));

        for(Entity e : list) {

            double dist = e.getDistance(x, y, z);

            if(dist <= radius) {

                double entX = e.posX;
                double entY = e.posY + e.getEyeHeight();
                double entZ = e.posZ;

                double damage = maxDamage * (radius - dist) / radius;
                e.attackEntityFrom(DamageSource.GENERIC, (float)damage);
                e.setFire(5);

                double knockX = e.posX - x;
                double knockY = e.posY + e.getEyeHeight() - y;
                double knockZ = e.posZ - z;

                Vec3d knock = new Vec3d(knockX, knockY, knockZ);
                knock = knock.normalize();

                e.motionX += knock.x * 0.2D;
                e.motionY += knock.y * 0.2D;
                e.motionZ += knock.z * 0.2D;

            }
        }

    }

    public static void succ(World world, int x, int y, int z, int radius) {
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

                    if (!(entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode)) {
                        double d8 = 0.125 + (random.nextDouble() * 0.25);
                        entity.motionX -= d5 * d8;
                        entity.motionY -= d6 * d8;
                        entity.motionZ -= d7 * d8;
                    }
                }
            }
        }
    }

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

    /*public static void vapor(World world, int x, int y, int z, int bombStartStrength) {
        int r = bombStartStrength * 2;
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
                    if (ZZ < r22)
                        vaporDest(world, X, Y, Z);
                }
            }
        }
    }
*/

    public static int destruction(World world, BlockPos pos) {
        int rand;
        if (!world.isRemote) {
            IBlockState b = world.getBlockState(pos);
            if (b.getBlock().getExplosionResistance(null)>=200f) {	//500 is the resistance of liquids
                //blocks to be spared
                int protection = (int)(b.getBlock().getExplosionResistance(null)/300f);
                if (b.getBlock() == ModBlocks.brick_obsidian) {
                    rand = random.nextInt(20);
                    if (rand == 0) {
                        world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
                    }
                } else if (b.getBlock() == Blocks.OBSIDIAN) {
                    world.setBlockState(pos, ModBlocks.gravel_obsidian.getDefaultState(), 3);
                    return 0;
                } else if(random.nextInt(protection+3)==0){
                    world.setBlockState(pos, ModBlocks.block_scrap.getDefaultState());
                }
                return protection;
            }else{//otherwise, kill the block!
                world.setBlockToAir(pos);
            }
        }
        return 0;
    }

    @SuppressWarnings("deprecation")
    public static int vaporDest(World world, BlockPos pos) {
        if (!world.isRemote) {
            IBlockState b = world.getBlockState(pos);
            if (b.getBlock().getExplosionResistance(null)<0.5f //most light things
                    || b.getBlock() == Blocks.WEB || b.getBlock() instanceof BlockLiquid) {
                world.setBlockToAir(pos);
                return 0;
            } else if (b.getBlock().getExplosionResistance(null)<=3.0f && !b.isOpaqueCube()){
                if(b.getBlock() != Blocks.CHEST && b.getBlock() != Blocks.FARMLAND){
                    //destroy all medium resistance blocks that aren't chests or farmland
                    world.setBlockToAir(pos);
                    return 0;
                }
            }

            if (b.getBlock().isFlammable(world, pos, EnumFacing.UP)
                    && world.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
                world.setBlockState(pos.up(), Blocks.FIRE.getDefaultState(),2);
            }
            return (int)( b.getBlock().getExplosionResistance(null)/300f);
        }
        return 0;
    }

    public static void waste(World world, int x, int y, int z, int radius) {
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
                        if (world.getBlockState(pos.setPos(X, Y, Z)).getBlock() != Blocks.AIR)
                            wasteDest(world, pos);
                    }
                }
            }
        }
    }

    public static void wasteDest(World world, BlockPos pos) {
        if (!world.isRemote) {
            int rand;
            IBlockState bs = world.getBlockState(pos);
            Block b = bs.getBlock();
            if (b == Blocks.ACACIA_DOOR || b == Blocks.BIRCH_DOOR || b == Blocks.DARK_OAK_DOOR || b == Blocks.JUNGLE_DOOR || b == Blocks.OAK_DOOR || b == Blocks.SPRUCE_DOOR || b == Blocks.IRON_DOOR) {
                world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
            }

            else if (b == Blocks.GRASS) {
                world.setBlockState(pos, ModBlocks.waste_earth.getDefaultState());
            }

            else if (b == Blocks.MYCELIUM) {
                world.setBlockState(pos, ModBlocks.waste_mycelium.getDefaultState());
            }

            else if (b == Blocks.SAND) {
                rand = random.nextInt(20);
                if (rand == 1) {
                    world.setBlockState(pos, ModBlocks.waste_earth.getDefaultState());
                }
            }

            else if (b == Blocks.CLAY) {
                world.setBlockState(pos, Blocks.HARDENED_CLAY.getDefaultState());
            }

            else if (b == Blocks.MOSSY_COBBLESTONE) {
                world.setBlockState(pos, Blocks.COAL_ORE.getDefaultState());
            }

            else if (b == Blocks.COAL_ORE) {
                rand = random.nextInt(10);
                if (rand == 1 || rand == 2 || rand == 3) {
                    world.setBlockState(pos, Blocks.DIAMOND_ORE.getDefaultState());
                }
                if (rand == 9) {
                    world.setBlockState(pos, Blocks.EMERALD_ORE.getDefaultState());
                }
            }

            else if (b == Blocks.LOG || b == Blocks.LOG2) {
                world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
            }

            else if (b == Blocks.BROWN_MUSHROOM_BLOCK) {
                if (bs.getValue(BlockHugeMushroom.VARIANT) == BlockHugeMushroom.EnumType.STEM) {
                    world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
                } else {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(),2);
                }
            }

            else if (b == Blocks.RED_MUSHROOM_BLOCK) {
                if (bs.getValue(BlockHugeMushroom.VARIANT) == BlockHugeMushroom.EnumType.STEM) {
                    world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
                } else {
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(),2);
                }
            }

            else if (bs.getMaterial() == Material.WOOD && bs.isOpaqueCube() && b != ModBlocks.waste_log) {
                world.setBlockState(pos, ModBlocks.waste_planks.getDefaultState());
            }

        }
    }

    public static void emp(World world, BlockPos pos) {
        if (!world.isRemote) {

            Block b = world.getBlockState(pos).getBlock();
            TileEntity te = world.getTileEntity(pos);

            if(te != null && te.hasCapability(CapabilityEnergy.ENERGY, null)){
                IEnergyStorage handle = te.getCapability(CapabilityEnergy.ENERGY, null);
                handle.extractEnergy(handle.getEnergyStored(), false);
                if(random.nextInt(5) <= 1)
                    world.setBlockState(pos, ModBlocks.block_electrical_scrap.getDefaultState());
            }

        }
    }

}