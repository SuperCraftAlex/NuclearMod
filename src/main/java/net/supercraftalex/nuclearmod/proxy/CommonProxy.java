package net.supercraftalex.nuclearmod.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.supercraftalex.nuclearmod.init.*;

public class CommonProxy {
	
	public void preinit(FMLPreInitializationEvent event) {
		ModInitItems.init();
		ModInitBlocks.init();
		
		MinecraftForge.EVENT_BUS.register(ModInitItems.class);
		MinecraftForge.EVENT_BUS.register(ModInitBlocks.class);

		ModInitEntities.registerEntities();
		ModInitEntities.registerEntityRenders();
		
		//GameRegistry.registerWorldGenerator(new ModInitWorldGeneration(), 0);
	}
	
	public void init(FMLInitializationEvent event) {
		ModInitSmelting.init();
	}
	
	public void postinit(FMLPostInitializationEvent event) {
	}
	
}
