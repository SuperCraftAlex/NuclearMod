package net.supercraftalex.nuclearmod.init;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModInitModels {
	
	@SubscribeEvent
	public static void register(ModelRegistryEvent event) {
		register(ModInitItems.tutitem);
		
		register(ModInitItems.teleporter);
		
		register(ModInitItems.superfood);
		
		register(ModInitItems.emeraldSword);
		register(ModInitItems.emeraldPickaxe);
		register(ModInitItems.emeraldAxe);
		register(ModInitItems.emeraldSpade);
		register(ModInitItems.emeraldHoe);
		
		register(ModInitItems.emeraldHelmet);
		register(ModInitItems.emeraldChestplate);
		register(ModInitItems.emeraldLeggings);
		register(ModInitItems.emeraldBoots);
		
		register(ModInitItems.wrench);
		
		register(Item.getItemFromBlock(ModInitBlocks.tutblock));
		
		register(Item.getItemFromBlock(ModInitBlocks.tutblockfacing));
	}
	
	private static void register(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
}
