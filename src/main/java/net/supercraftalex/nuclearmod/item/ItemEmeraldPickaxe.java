package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemEmeraldPickaxe extends ItemPickaxe {

	public ItemEmeraldPickaxe(ToolMaterial material) {
		super(material);
		setCreativeTab(ModInitTabs.utilities);
		attackSpeed = -8;
	}

}
