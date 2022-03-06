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

public class BombC4 extends ModBlock implements IBomb {

	public BombC4() {
		super(Material.IRON);
		setCreativeTab(ModInitTabs.bombs);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote && worldIn.isBlockIndirectlyGettingPowered(pos) > 0)
        {
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 20.0F, true);
        }
	}
	
	

	@Override
	public void explode(World world, BlockPos pos) {
		if(world.isRemote)
			return;
    	world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 20.0F, true);
	}

}
