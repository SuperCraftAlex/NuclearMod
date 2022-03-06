package net.supercraftalex.nuclearmod.block;

import java.util.Random;

import net.supercraftalex.nuclearmod.init.ModInitItems;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.supercraftalex.nuclearmod.item.ModItems;

public class BlockTutorial extends ModBlock {

	public BlockTutorial() {
		super(Material.ROCK);
		setCreativeTab(ModInitTabs.utilities);
		setHardness(2.5F);
		setResistance(100F);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.5F);
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return random.nextInt(5) + 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.tutitem;
	}

}
