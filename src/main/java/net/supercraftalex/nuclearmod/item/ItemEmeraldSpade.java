package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.item.ItemSpade;

public class ItemEmeraldSpade extends ItemSpade {

	public ItemEmeraldSpade(ToolMaterial material) {
		super(material);
		setCreativeTab(ModInitTabs.utilities);
		attackDamage = 55;
	}

}
