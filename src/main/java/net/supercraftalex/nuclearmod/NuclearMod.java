package net.supercraftalex.nuclearmod;

import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.item.ModItems;
import net.supercraftalex.nuclearmod.materialpack.MaterialPacks;
import net.supercraftalex.nuclearmod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModConstants.MODID, name = ModConstants.NAME, version = ModConstants.VERSION)
public class NuclearMod {

	public static final Logger LOGGER = LogManager.getLogger();

	public static boolean DebugMode = true;

	@Instance
	private static NuclearMod instance;

	public static NuclearMod getInstance() {
		return instance;
	}

	@SidedProxy(serverSide = "net.supercraftalex.nuclearmod.proxy.CommonProxy", clientSide = "net.supercraftalex.nuclearmod.proxy.ClientProxy")
	private static CommonProxy proxy;

	public MaterialPacks materialPacks = new MaterialPacks();

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		ModItems.addItems();ModBlocks.addBlocks();proxy.preinit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postinit(FMLPostInitializationEvent event) { proxy.postinit(event);ModInitTabs.setIcons(); }

	public static void logDebug(String s) {
		if(DebugMode) {
			LOGGER.info(s);
		}
	}

}
