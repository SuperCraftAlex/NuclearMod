package net.supercraftalex.nuclearmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.ModBlocks;
import net.supercraftalex.nuclearmod.item.ModItem;
import net.supercraftalex.nuclearmod.item.ModItems;
import net.supercraftalex.nuclearmod.materialpack.MaterialPacks;
import net.supercraftalex.nuclearmod.tab.*;
import net.minecraft.creativetab.CreativeTabs;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ModInitTabs {

	public static final ModTab utilities = new ModTab("nuclearmod_utilities");
	public static final ModTab resources = new ModTab("nuclearmod_resources");
	public static final ModTab machines = new ModTab("nuclearmod_machines");
	public static final ModTab equipment = new ModTab("nuclearmod_equipment");
	public static final ModTab blocks = new ModTab("nuclearmod_blocks");
	public static final ModTab bombs = new ModTab("nuclearmod_bombs");
	public static final ModTab missiles = new ModTab("nuclearmod_missiles");
	public static final ModTab reactors = new ModTab("nuclearmod_reactors");
	public static final ModTab food = new ModTab("nuclearmod_food");
	public static final ModTab kitchen = new ModTab("nuclearmod_kitchen");
	public static final ModTab decoration = new ModTab("nuclearmod_decoration");

	public static void setIcons() {

		utilities.icon = new ItemStack(Blocks.AIR);
		resources.icon = new ItemStack(Blocks.AIR);
		machines.icon = new ItemStack(Blocks.AIR);
		equipment.icon = new ItemStack(Blocks.AIR);
		blocks.icon = new ItemStack(Blocks.AIR);
		bombs.icon = new ItemStack(Blocks.AIR);
		missiles.icon = new ItemStack(Blocks.AIR);
		reactors.icon = new ItemStack(Blocks.AIR);
		food.icon = new ItemStack(Blocks.AIR);
		kitchen.icon = new ItemStack(Blocks.AIR);
		decoration.icon = new ItemStack(Blocks.AIR);

	}

	public static void addItemToCreativeTab(ItemStack s, ModTab t) {

	}

}
