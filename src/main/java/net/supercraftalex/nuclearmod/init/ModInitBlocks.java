package net.supercraftalex.nuclearmod.init;

import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.supercraftalex.nuclearmod.block.BlockTutorial;
import net.supercraftalex.nuclearmod.block.BlockTutorialFacing;

public class ModInitBlocks {
	
	public static final BlockTutorial tutblock = new BlockTutorial();
	
	public static final BlockTutorialFacing tutblockfacing = new BlockTutorialFacing();
	
	public static void init() {
		setName(tutblock, "tutblock");
		setName(tutblockfacing, "tutblockfacing");
	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		registry.register(tutblock);
		registry.register(tutblockfacing);
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(new ItemBlock(tutblock).setRegistryName(tutblock.getRegistryName()));
		registry.register(new ItemBlock(tutblockfacing).setRegistryName(tutblockfacing.getRegistryName()));
	}
	
	public static void setName(Block block, String name) {
		block.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		block.setUnlocalizedName(name);
	}
	
}
