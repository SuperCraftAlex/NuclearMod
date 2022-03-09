package net.supercraftalex.nuclearmod.block.bomb;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.explosion.ExplosionNukeGeneric;
import net.supercraftalex.nuclearmod.explosion.ExplosionSpecial;
import net.supercraftalex.nuclearmod.init.ModInitTabs;

public class BombAntiWater extends ModBomb {

	public BombAntiWater() {
		super(Material.IRON);
		setCreativeTab(ModInitTabs.bombs);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote && worldIn.isBlockIndirectlyGettingPowered(pos) > 0)
        {
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			ExplosionSpecial.AntiWater(worldIn, pos.getX(), pos.getY(), pos.getZ(), 90);
        }
	}

	@Override
	public void explode(World world, BlockPos pos) {
		if(world.isRemote)
			return;
		world.setBlockState(pos, Blocks.AIR.getDefaultState());
		ExplosionSpecial.AntiWater(world, pos.getX(), pos.getY(), pos.getZ(), 90);
	}

}
