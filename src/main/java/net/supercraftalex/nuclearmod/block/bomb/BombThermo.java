package net.supercraftalex.nuclearmod.block.bomb;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.explosion.ExplosionThermo;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.interfaces.IBomb;

public class BombThermo extends ModBomb {

	public BombThermo() {
		super(Material.IRON);
		setCreativeTab(ModInitTabs.bombs);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote && worldIn.isBlockIndirectlyGettingPowered(pos) > 0) {
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			if (this == ModBlocks.therm_endo ||this == ModBlocks.therm_endo_safe) {
				ExplosionThermo.freeze(worldIn, pos.getX(), pos.getY(), pos.getZ(), 15);
				ExplosionThermo.freezer(worldIn, pos.getX(), pos.getY(), pos.getZ(), 20);
			}
			if (this == ModBlocks.therm_snow) {
				ExplosionThermo.snow(worldIn, pos.getX(), pos.getY(), pos.getZ(), 80);
				ExplosionThermo.freezer(worldIn, pos.getX(), pos.getY(), pos.getZ(), 20);
			}
			if (this == ModBlocks.therm_exo) {
				ExplosionThermo.scorch(worldIn, pos.getX(), pos.getY(), pos.getZ(), 15);
				ExplosionThermo.setEntitiesOnFire(worldIn, pos.getX(), pos.getY(), pos.getZ(), 20);
			}
			if (this != ModBlocks.therm_endo_safe &&  this !=ModBlocks.therm_snow) {
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 5.0F, true);
			}
		}
	}
	
	

	@Override
	public void explode(World world, BlockPos pos) {
		if(world.isRemote)
			return;
		if (this == ModBlocks.therm_endo ||this == ModBlocks.therm_endo_safe) {
			ExplosionThermo.freeze(world, pos.getX(), pos.getY(), pos.getZ(), 15);
			ExplosionThermo.freezer(world, pos.getX(), pos.getY(), pos.getZ(), 20);
		}
		if (this == ModBlocks.therm_snow) {
			ExplosionThermo.snow(world, pos.getX(), pos.getY(), pos.getZ(), 80);
			ExplosionThermo.freezer(world, pos.getX(), pos.getY(), pos.getZ(), 20);
		}
		if (this == ModBlocks.therm_exo) {
			ExplosionThermo.scorch(world, pos.getX(), pos.getY(), pos.getZ(), 15);
			ExplosionThermo.setEntitiesOnFire(world, pos.getX(), pos.getY(), pos.getZ(), 20);
		}
		if (this != ModBlocks.therm_endo_safe &&  this !=ModBlocks.therm_snow) {
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 5.0F, true);
		}
	}

}
