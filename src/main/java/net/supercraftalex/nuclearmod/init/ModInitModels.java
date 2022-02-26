package net.supercraftalex.nuclearmod.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.item.ModItem;
import net.supercraftalex.nuclearmod.materialpack.MaterialPack;

public class ModInitModels {
	
	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		register(ModInitItems.tutitem);
		
		register(ModInitItems.teleporter);
		
		register(ModInitItems.superfood);
		
		register(ModInitItems.wrench);
		
		register(Item.getItemFromBlock(ModInitBlocks.tutblock));
		register(Item.getItemFromBlock(ModInitBlocks.tutblockfacing));

		for(MaterialPack mp : NuclearMod.getInstance().materialPacks.packs) {
			for(ModItem i : mp.items) {
				register(i);
			}
			for(ModBlock b : mp.blocks) {
				register(Item.getItemFromBlock(b));
			}
			for(Item i : mp.items2) {
				register(i);
			}
		}

	}
	
	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
