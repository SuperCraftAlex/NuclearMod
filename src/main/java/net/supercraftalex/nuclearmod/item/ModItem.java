package net.supercraftalex.nuclearmod.item;

import net.minecraft.item.Item;

public class ModItem extends Item {

    private double heat = 23;
    private double baseRadiation = 0.0;
    public String name;

    public ModItem() {}

    public ModItem(String name) {this.name = name;}

    public double getHeat() {
        return heat;
    }

    public void setHeat(double heat) {
        this.heat = heat;
    }

    public double getBaseRadiation() {
        return baseRadiation;
    }

    public ModItem setBaseRadiation(double baseRadiation) {
        this.baseRadiation = baseRadiation;
        return this;
    }
}
