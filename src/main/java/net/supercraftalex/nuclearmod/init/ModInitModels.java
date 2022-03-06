package net.supercraftalex.nuclearmod.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.item.ModItem;
import net.supercraftalex.nuclearmod.item.ModItems;
import net.supercraftalex.nuclearmod.materialpack.MaterialPack;

public class ModInitModels {
	
	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		register(ModItems.tutitem);
		register(ModItems.teleporter);
		register(ModItems.wrench);

		for(ModItem i : ModItems.modItems) {
			register(i);
		}
		for(ModBlock b : ModBlocks.modBlocks) {
			register(Item.getItemFromBlock(b));
		}
		for(ModItem i : NuclearMod.getInstance().materialPacks.items) {
			register(i);
		}
		for(ModBlock b : NuclearMod.getInstance().materialPacks.blocks) {
			register(Item.getItemFromBlock(b));
		}
		for(Item i : NuclearMod.getInstance().materialPacks.items2) {
			register(i);
		}

	}
	
	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
