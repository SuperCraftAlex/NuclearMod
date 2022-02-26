package net.supercraftalex.nuclearmod.materialpack;

import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.block.BlockOre;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.item.*;
import net.supercraftalex.nuclearmod.tab.ModTab;

import java.util.ArrayList;
import java.util.List;

public class MaterialPack {

    public String name;
    public float hardness;
    public float resistance;
    public int harvestlevel;
    public double ingotRadiation = 0.0;

    public ModItem baseItem;

    public List<ModBlock> blocks = new ArrayList<ModBlock>();
    public List<ModItem> items = new ArrayList<ModItem>();
    public List<Item> items2 = new ArrayList<Item>();

    public ItemArmor.ArmorMaterial armorMaterial;
    public Item.ToolMaterial toolMaterial;

    public MaterialPack(String name, float hardness, float resistance, int harvestlevel) {
        this.name = name;
    }

    public MaterialPack(String name, float hardness, float resistance, int harvestlevel, double radiation) {
        this.name = name;
        this.ingotRadiation = radiation;
    }

    public MaterialPack createBlock() {
        this.blocks.add(new ModBlock(Material.IRON, name + "_block"));
        setBlockCreativeTab(ModInitTabs.resources);
        return this;
    }
    public MaterialPack createStick() {
        this.items.add((new ModItem(name + "_stick").setBaseRadiation(this.ingotRadiation)));
        setItemCreativeTab(ModInitTabs.resources);
        return this;
    }
    public MaterialPack createPlate() {
        this.items.add((new ModItem(name + "_plate").setBaseRadiation(this.ingotRadiation)));
        setItemCreativeTab(ModInitTabs.resources);
        return this;
    }
    public MaterialPack createPowder() {
        this.items.add((new ModItem(name + "_powder").setBaseRadiation(this.ingotRadiation)));
        setItemCreativeTab(ModInitTabs.resources);
        if(baseItem == null) {baseItem = this.items.get(this.items.size() -1);}
        return this;
    }
    public MaterialPack createGem() {
        this.items.add((new ModItem(name + "_gem").setBaseRadiation(this.ingotRadiation)));
        setItemCreativeTab(ModInitTabs.resources);
        if(baseItem == null) {baseItem = this.items.get(this.items.size() -1);}
        return this;
    }
    public MaterialPack createIngot() {
        this.items.add((new ModItem(name + "_ingot").setBaseRadiation(this.ingotRadiation)));
        setItemCreativeTab(ModInitTabs.resources);
        if(baseItem == null) {baseItem = this.items.get(this.items.size() -1);}
        return this;
    }
    public MaterialPack createOre(Boolean drops) {
        this.blocks.add(new BlockOre(name + "_ore", hardness, resistance, harvestlevel));
        setBlockCreativeTab(ModInitTabs.resources);
        return this;
    }
    public MaterialPack createOre(Boolean drops, double radiation) {
        this.blocks.add(new BlockOre(name + "_ore", hardness, resistance, harvestlevel));
        setBlockCreativeTab(ModInitTabs.resources);
        this.blocks.get(this.blocks.size() - 1).setRadiation(radiation);
        return this;
    }
    public MaterialPack createArmor(int durability, float thoughtness) {
        this.armorMaterial = EnumHelper.addArmorMaterial(name, ModConstants.MODID + ":" + name, durability, new int[] { 3, 5, 7, 3 }, 30, SoundEvents.ENTITY_ZOMBIE_VILLAGER_HURT, thoughtness);
        this.items2.add(setCreativeTab(setName((Item)new ItemArmor(armorMaterial, 0, EntityEquipmentSlot.HEAD), name + "_helmet"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ItemArmor(armorMaterial, 1, EntityEquipmentSlot.CHEST),name + "_chestplate"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ItemArmor(armorMaterial, 2, EntityEquipmentSlot.LEGS),name + "_leggings"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ItemArmor(armorMaterial, 3, EntityEquipmentSlot.FEET),name + "_boots"),ModInitTabs.equipment));
        return this;
    }
    public MaterialPack createTools(int harvesLevel, int durability, float efficiency, float damage, int enchantability) {
        this.toolMaterial = EnumHelper.addToolMaterial(name, harvesLevel, durability, efficiency, damage, enchantability);
        this.items2.add(setCreativeTab(setName((Item)new ModPickaxe(this.toolMaterial),name + "_pickaxe"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ModAxe(this.toolMaterial, this.toolMaterial.getAttackDamage(), this.toolMaterial.getEfficiency()),name + "_axe"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ModHoe(this.toolMaterial),name + "_hoe"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ModSpade(this.toolMaterial),name + "_spade"),ModInitTabs.equipment));
        this.items2.add(setCreativeTab(setName((Item)new ModSword(this.toolMaterial),name + "_sword"), ModInitTabs.equipment));
        return this;
    }
    public MaterialPack createPellet(double radiation) {
        this.items.add(new ItemPellet(name + "_pellet"));
        setItemCreativeTab(ModInitTabs.resources);
        return this;
    }
    public MaterialPack createFuelCell(double radiation, int durability, int hpf, int npf, int heatmelt) {
        this.items.add(new ItemFuelCell(name + "_fuelcell", false, durability, hpf, npf, heatmelt, radiation));
        this.items.add(new ItemFuelCell(name + "_fuelcell_depleted", true, 0, 0, 0, 0, radiation * 2));
        setItemCreativeTab(ModInitTabs.resources);
        return this;
    }

    private void setItemCreativeTab(ModTab t) {
        if(items.size() >= 1) {
            this.items.get(items.size()-1).setCreativeTab(t);
        }
        else {
            //this.items.get(0).setCreativeTab(t);
        }
    }
    private void setItem2CreativeTab(ModTab t) {
        if(items2.size() >= 1) {
            this.items2.get(items2.size()-1).setCreativeTab(t);
        }
        else {
            //this.items.get(0).setCreativeTab(t);
        }
    }
    private void setBlockCreativeTab(ModTab t) {
        if(blocks.size() >= 1) {
            this.blocks.get(blocks.size()-1).setCreativeTab(t);
        }
        else {
            //this.blocks.get(0).setCreativeTab(t);
        }
    }
    public Item setName(Item item, String name) {
        item.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
        item.setUnlocalizedName(name);
        return item;
    }
    public Item setCreativeTab(Item item, ModTab t) {
        item.setCreativeTab(t);
        return item;
    }

}
