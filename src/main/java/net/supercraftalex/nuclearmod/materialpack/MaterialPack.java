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

    public ModItem baseItem = null;

    public List<ModBlock> pBlocks = new ArrayList<ModBlock>();
    public List<ModItem> pSticks = new ArrayList<ModItem>();
    public List<ModItem> pPlates = new ArrayList<ModItem>();
    public List<ModItem> pPowders = new ArrayList<ModItem>();
    public List<ModItem> pGems = new ArrayList<ModItem>();
    public List<ModItem> pIngots = new ArrayList<ModItem>();
    public List<ModBlock> pOres = new ArrayList<ModBlock>();
    public List<ModItem> pPellets = new ArrayList<ModItem>();
    public List<ModItem> pFuelCells = new ArrayList<ModItem>();
    public List<ModItem> pFuelCellsDepleted = new ArrayList<ModItem>();
    public List<ModItem> pNuggets = new ArrayList<ModItem>();

    public List<Item> pArmor = new ArrayList<Item>();
    public List<Item> pTools = new ArrayList<Item>();

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
        this.pBlocks.add(new ModBlock(Material.IRON, name + "_block"));
        return this;
    }
    public MaterialPack createStick() {
        this.pSticks.add(new ModItem(name + "_stick").setBaseRadiation(this.ingotRadiation));
        return this;
    }
    public MaterialPack createPlate() {
        this.pPlates.add(new ModItem(name + "_plate").setBaseRadiation(this.ingotRadiation));
        return this;
    }
    public MaterialPack createPowder() {
        this.pPowders.add(new ModItem(name + "_powder").setBaseRadiation(this.ingotRadiation));
        if(baseItem == null) {baseItem = this.pPowders.get(this.pPowders.size() - 1);}
        return this;
    }
    public MaterialPack createGem() {
        this.pGems.add(new ModItem(name + "_gem").setBaseRadiation(this.ingotRadiation));
        if(baseItem == null) {baseItem = this.pGems.get(this.pGems.size() -1);}
        return this;
    }
    public MaterialPack createIngot() {
        this.pIngots.add(new ModItem(name + "_ingot").setBaseRadiation(this.ingotRadiation));
        if(baseItem == null) {baseItem = this.pIngots.get(this.pIngots.size() -1);}
        this.pNuggets.add(new ModItem(name + "_nugget").setBaseRadiation(this.ingotRadiation));
        return this;
    }
    public MaterialPack createIngot(int heat) {
        this.pIngots.add(new ModItem(name + "_ingot").setBaseRadiation(this.ingotRadiation).setHeat(heat));
        if(baseItem == null) {baseItem = this.pIngots.get(this.pIngots.size() -1);}
        this.pNuggets.add(new ModItem(name + "_nugget").setBaseRadiation(this.ingotRadiation));
        return this;
    }
    public MaterialPack createOre(Boolean drops) {
        this.pOres.add(new BlockOre(name + "_ore", hardness, resistance, harvestlevel));
        return this;
    }
    public MaterialPack createOre(Boolean drops, double radiation) {
        this.pOres.add(new BlockOre(name + "_ore", hardness, resistance, harvestlevel));
        return this;
    }
    public MaterialPack createArmor(int durability, float thoughtness) {
        this.armorMaterial = EnumHelper.addArmorMaterial(name, ModConstants.MODID + ":" + name, durability, new int[] { 3, 5, 7, 3 }, 30, SoundEvents.ENTITY_ZOMBIE_VILLAGER_HURT, thoughtness);
        this.pArmor.add(setName((Item)new ItemArmor(armorMaterial, 0, EntityEquipmentSlot.HEAD), name + "_helmet"));
        this.pArmor.add(setName((Item)new ItemArmor(armorMaterial, 1, EntityEquipmentSlot.CHEST),name + "_chestplate"));
        this.pArmor.add(setName((Item)new ItemArmor(armorMaterial, 2, EntityEquipmentSlot.LEGS),name + "_leggings"));
        this.pArmor.add(setName((Item)new ItemArmor(armorMaterial, 3, EntityEquipmentSlot.FEET),name + "_boots"));
        return this;
    }
    public MaterialPack createTools(int harvesLevel, int durability, float efficiency, float damage, int enchantability) {
        this.toolMaterial = EnumHelper.addToolMaterial(name, harvesLevel, durability, efficiency, damage, enchantability);
        this.pTools.add(setName((Item)new ModPickaxe(this.toolMaterial),name + "_pickaxe"));
        this.pTools.add(setName((Item)new ModAxe(this.toolMaterial, this.toolMaterial.getAttackDamage(), this.toolMaterial.getEfficiency()),name + "_axe"));
        this.pTools.add(setName((Item)new ModHoe(this.toolMaterial),name + "_hoe"));
        this.pTools.add(setName((Item)new ModSpade(this.toolMaterial),name + "_spade"));
        this.pTools.add(setName((Item)new ModSword(this.toolMaterial),name + "_sword"));
        return this;
    }
    public MaterialPack createPellet(double radiation) {
        this.pPellets.add(new ItemPellet(name + "_pellet"));
        return this;
    }
    public MaterialPack createFuelCell(double radiation, int durability, int hpf, int npf, int heatmelt) {
        this.pFuelCells.add(new ItemFuelCell(name + "_fuelcell", false, durability, hpf, npf, heatmelt, radiation));
        this.pFuelCellsDepleted.add(new ItemFuelCell(name + "_fuelcell_depleted", true, 0, 0, 0, 0, radiation * 2));
        this.pFuelCells.add(new ItemFuelCell(name + "_fuelcell_double", false, durability, hpf*2, npf*2, heatmelt, radiation*2));
        this.pFuelCellsDepleted.add(new ItemFuelCell(name + "_fuelcell_double_depleted", true, 0, 0, 0, 0, radiation * 4));
        this.pFuelCells.add(new ItemFuelCell(name + "_fuelcell_quad", false, durability, hpf*4, npf*4, heatmelt, radiation*4));
        this.pFuelCellsDepleted.add(new ItemFuelCell(name + "_fuelcell_quad_depleted", true, 0, 0, 0, 0, radiation * 8));
        return this;
    }

    public Item setName(Item item, String name) {
        item.setRegistryName(new ResourceLocation(ModConstants.MODID, name));
        item.setUnlocalizedName(name);
        return item;
    }

}