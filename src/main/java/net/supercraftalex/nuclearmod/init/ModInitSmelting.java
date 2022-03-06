package net.supercraftalex.nuclearmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.item.ModItems;

public class ModInitSmelting {

	public static void init() {
		GameRegistry.addSmelting(ModBlocks.tutblock, new ItemStack(ModItems.tutitem, 2), 2F);
	}

}
