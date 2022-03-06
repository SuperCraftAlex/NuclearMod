package net.supercraftalex.nuclearmod.tab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.item.ModItem;

import java.util.*;

public class ModTab extends CreativeTabs {

    public TabItemSorter itemSorter = new TabItemSorter();
    public ItemStack icon;

    public ModTab(String label) {
        super(label);
    }

    public ModTab(String label, Item t_icon) {
        super(label);
        this.icon = new ItemStack(t_icon);
    }

    public ModTab(String label, Block t_icon) {
        super(label);
        this.icon = new ItemStack(t_icon);
    }

    public ModTab(String label, ModBlock t_icon) {
        super(label);
        this.icon = new ItemStack(t_icon);
    }

    @Override
    public ItemStack getTabIconItem() {
        return this.icon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        super.displayAllRelevantItems(items);
        Collections.sort(items, itemSorter);
    }

}
