package net.supercraftalex.nuclearmod.init;

import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModInitBlocks {

	public static void init() {

		for(ModBlock b : ModBlocks.modBlocks) {
			setName(b, b.name);
		}

		for(ModBlock b : NuclearMod.getInstance().materialPacks.blocks) {
			try {
				setName(b, b.name);
			}
			catch(Exception e) {}
		}

	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {

		IForgeRegistry<Block> registry = event.getRegistry();

		for(ModBlock b : ModBlocks.modBlocks) {
			registry.register(b);
		}

		for(ModBlock b : NuclearMod.getInstance().materialPacks.blocks) {
			try {
				registry.register(b);
			}
			catch(Exception e) {}
		}

	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {

		IForgeRegistry<Item> registry = event.getRegistry();

		for(ModBlock b : ModBlocks.modBlocks) {
			registry.register(new ItemBlock(b).setRegistryName(b.getRegistryName()));
		}

		for(ModBlock b : NuclearMod.getInstance().materialPacks.blocks) {
			try {
				registry.register(new ItemBlock(b).setRegistryName(b.getRegistryName()));
			}
			catch(Exception e) {}
		}

	}
	

	public static void setName(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		block.setUnlocalizedName(name);
	}
	
}
