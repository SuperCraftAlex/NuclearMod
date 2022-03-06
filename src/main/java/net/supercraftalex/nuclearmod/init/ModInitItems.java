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
	
	public static void init() {

		for(ModItem i : ModItems.modItems) {
			setName(i, i.name);
		}

		for(ModItem i : NuclearMod.getInstance().materialPacks.items) {
			setName(i, i.name);
		}

	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		for(ModItem i : ModItems.modItems) {
			registry.register(i);
		}

		for(ModItem i : NuclearMod.getInstance().materialPacks.items) {
			registry.register(i);
		}
		for(Item i : NuclearMod.getInstance().materialPacks.items2) {
			registry.register(i);
		}

	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
		item.setUnlocalizedName(name);
	}
	
}
