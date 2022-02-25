package net.supercraftalex.nuclearmod;

import net.supercraftalex.nuclearmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModConstants.MODID, name = ModConstants.NAME, version = ModConstants.VERSION)
public class NuclearMod {

	@Instance
	private static NuclearMod instance;

	public static NuclearMod getInstance() {
		return instance;
	}

	@SidedProxy(serverSide = "net.supercraftalex.nuclearmod.proxy.CommonProxy", clientSide = "net.supercraftalex.nuclearmod.proxy.ClientProxy")
	private static CommonProxy proxy;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		proxy.preinit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		proxy.postinit(event);
	}

}
