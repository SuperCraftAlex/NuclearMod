package net.supercraftalex.nuclearmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.tab.ModTab;

public class ModItem extends Item {

    private double heat = 23;
    private double baseRadiation = 0.0;
    public String name;

    public ModItem() {}

    public ModItem(String name) {this.name = name;}

    public double getHeat() {
        return heat;
    }

    public ModItem setHeat(double heat) {
        this.heat = heat;
        return this;
    }

    public double getBaseRadiation() {
        return baseRadiation;
    }

    public ModItem setBaseRadiation(double baseRadiation) {
        this.baseRadiation = baseRadiation;
        return this;
    }

    @Override
    public Item setCreativeTab(CreativeTabs tab)
    {
        super.setCreativeTab(tab);
        ModInitTabs.addItemToCreativeTab(new ItemStack(this), (ModTab) tab);
        return this;
    }

}
