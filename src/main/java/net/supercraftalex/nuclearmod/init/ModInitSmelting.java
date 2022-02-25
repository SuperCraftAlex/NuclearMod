package net.supercraftalex.nuclearmod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModInitSmelting {

	public static void init() {
		GameRegistry.addSmelting(ModInitBlocks.tutblock, new ItemStack(ModInitItems.tutitem, 2), 2F);
	}

}
