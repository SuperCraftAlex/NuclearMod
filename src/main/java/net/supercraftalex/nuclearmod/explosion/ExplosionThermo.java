package net.supercraftalex.nuclearmod.explosion;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.MutableBlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlocks;

public class ExplosionThermo {

	public static void freeze(World world, int x, int y, int z, int bombStartStrength) {
		MutableBlockPos pos = new BlockPos.MutableBlockPos();
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
					if (ZZ < r22 + world.rand.nextInt(r22 / 2))
						pos.setPos(X, Y, Z);
					freezeDest(world, pos);
				}
			}
		}
	}

	public static void scorch(World world, int x, int y, int z, int bombStartStrength) {
		MutableBlockPos pos = new BlockPos.MutableBlockPos();
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
					if (ZZ < r22 + world.rand.nextInt(r22 / 2))
						pos.setPos(X, Y, Z);
					scorchDest(world, pos);
				}
			}
		}
	}

	public static void scorchDest(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();

		if (block == Blocks.GRASS) {
			world.setBlockState(pos, Blocks.DIRT.getDefaultState());
		}

		if (block == Blocks.DIRT) {
			world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
		}

		if (block == Blocks.NETHERRACK) {
			world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
		}

		if (block == Blocks.LOG) {
			world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
		}

		if (block == Blocks.LOG2) {
			world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
		}

		if (block == Blocks.PLANKS) {
			world.setBlockState(pos, ModBlocks.waste_planks.getDefaultState());
		}

		if (block == Blocks.STONE) {
			world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
		}

		if (block == Blocks.COBBLESTONE) {
			world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
		}

		if (block == Blocks.STONEBRICK) {
			world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
		}

		if (block == Blocks.OBSIDIAN) {
			world.setBlockState(pos, Blocks.FLOWING_LAVA.getDefaultState());
		}

		if (block == Blocks.LEAVES) {
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}

		if (block == Blocks.LEAVES2) {
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}

		if (block == Blocks.WATER) {
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}

		if (block == Blocks.FLOWING_WATER) {
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}

		if (block == Blocks.PACKED_ICE) {
			world.setBlockState(pos, Blocks.FLOWING_WATER.getDefaultState());
		}

		if (block == Blocks.ICE) {
			world.setBlockState(pos, Blocks.AIR.getDefaultState());
		}
	}

	public static void freezeDest(World world, BlockPos pos) {

		Block block = world.getBlockState(pos).getBlock();
		Block blockUp = world.getBlockState(pos.up()).getBlock();

		if (block == Blocks.TALLGRASS) {
			world.setBlockState(pos, Blocks.PUMPKIN.getDefaultState());
		}

		if (block == Blocks.STONE) {
			world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
		}

		if (block == Blocks.DIRT) {
			world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
		}

		if (block == Blocks.GRASS) {
			world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
		}

		if (block == Blocks.COBBLESTONE) {
			world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
		}

		if (block == Blocks.STONEBRICK) {
			world.setBlockState(pos, Blocks.PACKED_ICE.getDefaultState());
		}

		if (block == Blocks.LEAVES) {
			world.setBlockState(pos, Blocks.SNOW.getDefaultState());
		}

		if (block == Blocks.LEAVES2) {
			world.setBlockState(pos, Blocks.SNOW.getDefaultState());
		}

		if (block == Blocks.LAVA) {
			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
		}

		if (block == Blocks.FLOWING_LAVA) {
			world.setBlockState(pos, Blocks.OBSIDIAN.getDefaultState());
		}

		if (block == Blocks.WATER) {
			world.setBlockState(pos, Blocks.ICE.getDefaultState());
		}

		if (block == Blocks.FLOWING_WATER) {
			world.setBlockState(pos, Blocks.ICE.getDefaultState());
		}

		if (block == Blocks.SAND) {
			world.setBlockState(pos, Blocks.SNOW.getDefaultState());
			if(blockUp != Blocks.WATER) {
				world.setBlockState(pos.up(), Blocks.SNOW_LAYER.getDefaultState());
			}
		}

		if (block == Blocks.GRAVEL) {
			world.setBlockState(pos, Blocks.SNOW.getDefaultState());
			if(blockUp != Blocks.WATER) {
				world.setBlockState(pos.up(), Blocks.SNOW_LAYER.getDefaultState());
			}
		}

	}

	public static void freezer(World world, int x, int y, int z, int bombStartStrength) {
		float f = bombStartStrength;
		int i;
		int j;
		int k;
		double d5;
		double d6;
		double d7;
		double wat = bombStartStrength;

		bombStartStrength *= 2.0F;
		i = MathHelper.floor(x - wat - 1.0D);
		j = MathHelper.floor(x + wat + 1.0D);
		k = MathHelper.floor(y - wat - 1.0D);
		int i2 = MathHelper.floor(y + wat + 1.0D);
		int l = MathHelper.floor(z - wat - 1.0D);
		int j2 = MathHelper.floor(z + wat + 1.0D);
		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(i, k, l, j, i2, j2));

		MutableBlockPos pos = new BlockPos.MutableBlockPos();

		for (int i1 = 0; i1 < list.size(); ++i1) {
			Entity entity = (Entity) list.get(i1);
			double d4 = entity.getDistance(x, y, z) / bombStartStrength;

			if (d4 <= 1.0D) {
				d5 = entity.posX - x;
				d6 = entity.posY + entity.getEyeHeight() - y;
				d7 = entity.posZ - z;
				double d9 = MathHelper.sqrt(d5 * d5 + d6 * d6 + d7 * d7);
				if (d9 < wat && !(entity instanceof EntityOcelot) && entity instanceof EntityLivingBase) {
					for (int a = (int) entity.posX - 2; a < (int) entity.posX + 1; a++) {
						for (int b = (int) entity.posY; b < (int) entity.posY + 3; b++) {
							for (int c = (int) entity.posZ - 1; c < (int) entity.posZ + 2; c++) {
								pos.setPos(a, b, c);
								world.setBlockState(pos, Blocks.ICE.getDefaultState());
							}
						}
					}

					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 2 * 60 * 20, 4));
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 90 * 20, 2));
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 3 * 60 * 20, 2));
				}
			}
		}

		bombStartStrength = (int) f;
	}

	public static void setEntitiesOnFire(World world, double x, double y, double z, int radius) {

		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(x - radius, y - radius, z - radius, x + radius, y + radius, z + radius));

		for(Entity e : list) {
			
			if(e.getDistance(x, y, z) <= radius) {
				if(e instanceof EntityLivingBase)
					((EntityLivingBase) e).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 15 * 20, 4));
			}
		}
	}
	
	public static void scorchLight(World world, int x, int y, int z, int bombStartStrength) {
		MutableBlockPos pos = new BlockPos.MutableBlockPos();
		int r = bombStartStrength * 2;
		int r2 = r*r;
		int r22 = r2/2;
		for (int xx = -r; xx < r; xx++)
		{
			int X = xx+x;
			int XX = xx*xx;
			for (int yy = -r; yy < r; yy++)
			{
				int Y = yy+y;
				int YY = XX+yy*yy;
				for (int zz = -r; zz < r; zz++)
				{
					int Z = zz+z;
					int ZZ = YY+zz*zz;
					if (ZZ<r22 + world.rand.nextInt(r22/2))
						scorchDestLight(world, pos.setPos(X, Y, Z));
				}
			}
		}
	}
	
	public static void scorchDestLight(World world, BlockPos pos) {
		IBlockState blockstate = world.getBlockState(pos);
		Block block = blockstate.getBlock();
		
		if(block == Blocks.GRASS)
		{
			world.setBlockState(pos, Blocks.DIRT.getDefaultState());
		}
		
		if(block == Blocks.DIRT)
		{
			world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
		}
		
		if(block == ModBlocks.waste_earth)
		{
			world.setBlockState(pos, Blocks.NETHERRACK.getDefaultState());
		}
		
		if(block == Blocks.LOG)
		{
			world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
		}
		
		if(block == Blocks.LOG2)
		{
			world.setBlockState(pos, ModBlocks.waste_log.getDefaultState());
		}
		
		if(block == Blocks.PLANKS)
		{
			world.setBlockState(pos, ModBlocks.waste_planks.getDefaultState());
		}
		
		if(block == Blocks.OBSIDIAN)
		{
			world.setBlockState(pos, ModBlocks.gravel_obsidian.getDefaultState());
		}
		
		if(block == Blocks.LEAVES)
		{
			world.setBlockToAir(pos);
		}
		
		if(block == Blocks.LEAVES2)
		{
			world.setBlockToAir(pos);
		}
		
		if(block == Blocks.WATER)
		{
			world.setBlockToAir(pos);
		}
		
		if(block == Blocks.FLOWING_WATER)
		{
			world.setBlockToAir(pos);
		}
		
		if(block == Blocks.PACKED_ICE)
		{
			world.setBlockState(pos, Blocks.FLOWING_WATER.getDefaultState());
		}
		
		if(block == Blocks.ICE)
		{
			world.setBlockToAir(pos);
		}
		
		if(block == Blocks.SAND)
		{
			world.setBlockState(pos, Blocks.GLASS.getDefaultState());
		}
		
		if(block == Blocks.CLAY)
		{
			world.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.values()[world.rand.nextInt(16)]));
		}
	}
	public static void snow(World world, int x, int y, int z, int bound) {
    	MutableBlockPos pos = new BlockPos.MutableBlockPos();
		
    	int r = bound;
    	int r2 = r*r;
    	int r22 = r2/2;
    	for (int xx = -r; xx < r; xx++)
    	{
    		int X = xx+x;
    		int XX = xx*xx;
    		for (int yy = -r; yy < r; yy++)
    		{
    			int Y = yy+y;
    			int YY = XX+yy*yy;
    			for (int zz = -r; zz < r; zz++)
    			{
    				int Z = zz+z;
    				int ZZ = YY+zz*zz;
    				if (ZZ<r22)
    				{
    					pos.setPos(X, Y + 1, Z);
    					if(Blocks.SNOW_LAYER.canPlaceBlockAt(world, pos) && (world.getBlockState(pos).getBlock() == Blocks.AIR || world.getBlockState(pos).getBlock() == Blocks.TALLGRASS)) {
    						world.setBlockState(pos, Blocks.SNOW_LAYER.getDefaultState());
    					}
						pos.setPos(X, Y, Z);
						if(Blocks.SNOW_LAYER.canPlaceBlockAt(world, pos) && (world.getBlockState(pos).getBlock() == Blocks.LEAVES || world.getBlockState(pos).getBlock() == Blocks.LEAVES2)) {
							world.setBlockState(pos, Blocks.SNOW.getDefaultState());
						}
    				}
    			}
    		}
    	}
    	
    }
}
