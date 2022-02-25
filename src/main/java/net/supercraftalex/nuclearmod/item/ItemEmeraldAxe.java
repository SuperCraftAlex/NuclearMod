package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.item.ItemAxe;

public class ItemEmeraldAxe extends ItemAxe {

	public ItemEmeraldAxe(ToolMaterial material) {
		super(material, 10.0F, 0F);
		setCreativeTab(ModInitTabs.utilities);
	}

}
