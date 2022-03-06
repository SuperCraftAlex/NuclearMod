package net.supercraftalex.nuclearmod.block.bomb;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.explosion.ExplosionNukeGeneric;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.interfaces.IBomb;

public class BombNuke extends ModBomb {

	public int strength = 0;

	public BombNuke(int strength) {
		super(Material.IRON);
		setCreativeTab(ModInitTabs.bombs);
		this.strength=strength;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote && worldIn.isBlockIndirectlyGettingPowered(pos) > 0)
        {
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			ExplosionNukeGeneric.dedify(worldIn,pos.getX(),pos.getY(),pos.getZ(),strength*2);
			if(this == ModBlocks.bomb_nuke_hydrogen) {
				ExplosionNukeGeneric.waste(worldIn,pos.getX(),pos.getY(),pos.getZ(),strength);
			}
			else {
				ExplosionNukeGeneric.detonateTestBomb(worldIn,pos.getX(),pos.getY(),pos.getZ(),strength);
			}
			ExplosionNukeGeneric.empBlast(worldIn,pos.getX(),pos.getY(),pos.getZ(),strength);
        }
	}

	@Override
	public void explode(World world, BlockPos pos) {
		if(world.isRemote)
			return;
		world.setBlockState(pos, Blocks.AIR.getDefaultState());
		ExplosionNukeGeneric.dedify(world,pos.getX(),pos.getY(),pos.getZ(),strength*2);
		if(this == ModBlocks.bomb_nuke_hydrogen) {
			ExplosionNukeGeneric.waste(world,pos.getX(),pos.getY(),pos.getZ(),strength);
		}
		else {
			ExplosionNukeGeneric.detonateTestBomb(world,pos.getX(),pos.getY(),pos.getZ(),strength);
		}
		ExplosionNukeGeneric.empBlast(world,pos.getX(),pos.getY(),pos.getZ(),strength);
	}

}
