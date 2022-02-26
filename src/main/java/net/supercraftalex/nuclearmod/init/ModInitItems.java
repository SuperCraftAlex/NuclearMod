package net.supercraftalex.nuclearmod.init;

import net.minecraft.item.ItemArmor;
import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.item.*;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.supercraftalex.nuclearmod.item.*;
import net.supercraftalex.nuclearmod.materialpack.MaterialPack;

public class ModInitItems {
	
	public static final ItemTutorial tutitem = new ItemTutorial();
	
	public static final ItemTeleporter teleporter = new ItemTeleporter();
	
	public static final ItemSuperFood superfood = new ItemSuperFood();
	
	public static final ItemWrench wrench = new ItemWrench();
	
	public static void init() {
		setName(tutitem, "tutitem");
		setName(teleporter, "teleporter");
		setName(superfood, "superfood");
		
		setName(wrench, "wrench");

		for(MaterialPack mp : NuclearMod.getInstance().materialPacks.packs) {
			for(ModItem i : mp.items) {
				setName(i, i.name);
			}
		}

	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(tutitem);
		
		registry.register(teleporter);
		
		registry.register(superfood);
		
		registry.register(wrench);

		for(MaterialPack mp : NuclearMod.getInstance().materialPacks.packs) {
			for(ModItem i : mp.items) {
				registry.register(i);
			}
			for(Item i : mp.items2) {
				registry.register(i);
			}
		}

	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		item.setUnlocalizedName(name);
	}
	
}
