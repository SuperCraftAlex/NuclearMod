package net.supercraftalex.nuclearmod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
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

    public RayTraceResult rayTrace(EntityPlayer player, double blockReachDistance) {
        Vec3d vec3d = player.getPositionEyes(1.0F);
        Vec3d vec3d1 = player.getLook(1.0F);
        Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance, vec3d1.z * blockReachDistance);
        return player.getEntityWorld().rayTraceBlocks(vec3d, vec3d2, false, false, true);
    }

}
