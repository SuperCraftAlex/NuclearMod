package net.supercraftalex.nuclearmod.block.bomb;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.interfaces.IBomb;
import net.supercraftalex.nuclearmod.util.RandomUtil;

public class BombCluster extends ModBomb {

	public BombCluster() {
		super(Material.IRON);
		setCreativeTab(ModInitTabs.bombs);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote && worldIn.isBlockIndirectlyGettingPowered(pos) > 0)
        {
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 60.0F, true);
			if(RandomUtil.randomD(1,2) == 1) {
				worldIn.createExplosion(null, pos.getX()+10, pos.getY(), pos.getZ(), 60.0F, true);
				worldIn.createExplosion(null, pos.getX()-10, pos.getY(), pos.getZ(), 60.0F, true);
				worldIn.createExplosion(null, pos.getX()+20, pos.getY(), pos.getZ(), 60.0F, true);
				worldIn.createExplosion(null, pos.getX()-20, pos.getY(), pos.getZ(), 60.0F, true);
				worldIn.createExplosion(null, pos.getX()+30, pos.getY(), pos.getZ(), 60.0F, true);
				worldIn.createExplosion(null, pos.getX()-30, pos.getY(), pos.getZ(), 60.0F, true);
			}
			else {
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()+10, 60.0F, true);
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()-10, 60.0F, true);
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()+20, 60.0F, true);
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()-20, 60.0F, true);
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()+30, 60.0F, true);
				worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()-30, 60.0F, true);
			}
        }
	}
	
	

	@Override
	public void explode(World world, BlockPos pos) {
		if(world.isRemote)
			return;
		world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 60.0F, true);
		if(RandomUtil.randomD(1,2) == 1) {
			world.createExplosion(null, pos.getX()+30, pos.getY(), pos.getZ(), 60.0F, true);
			world.createExplosion(null, pos.getX()-30, pos.getY(), pos.getZ(), 60.0F, true);
			world.createExplosion(null, pos.getX()+60, pos.getY(), pos.getZ(), 60.0F, true);
			world.createExplosion(null, pos.getX()-60, pos.getY(), pos.getZ(), 60.0F, true);
		}
		else {
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()+30, 60.0F, true);
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()-30, 60.0F, true);
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()+60, 60.0F, true);
			world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ()-60, 60.0F, true);
		}
	}

}
