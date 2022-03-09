package net.supercraftalex.nuclearmod.materialpack;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.ProgressManager;
import net.minecraftforge.fml.common.ProgressManager.ProgressBar;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.item.ModItem;
import net.supercraftalex.nuclearmod.tab.ModTab;

import java.util.ArrayList;
import java.util.List;

public class MaterialPacks {

    //TODO: Dense Plates and Gears

    public List<MaterialPack> packs = new ArrayList<MaterialPack>();

    public List<ModBlock> blocks = new ArrayList<ModBlock>();
    public List<ModItem> items = new ArrayList<ModItem>();
    public List<Item> items2 = new ArrayList<Item>();

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

    public MaterialPacks() {

        ProgressBar bar = ProgressManager.push("NuclearMod MaterialPacks", 2); //here, 2 means there would be 2 steps to run.

        MaterialPack p;

        NuclearMod.LOGGER.info("[NuclearMod] Loading material packs...");

        bar.step("Adding Packs");

        //RAD START

        p = new MaterialPack("uranium",2.5F, 100F, 2, 40);
        p.createOre(false, 20);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("uranium_233",2.5F, 100F, 2, 110);
        p.createPellet(230);
        p.createFuelCell(230, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("uranium_235",2.5F, 100F, 2, 70);
        p.createPellet(100);
        p.createFuelCell(110, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("uranium_238",2.5F, 100F, 2, 40);
        p.createPellet(50);
        p.createFuelCell(70, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("thorium_232",2.5F, 100F, 2, 20);
        p.createOre(false, 10);
        p.createPellet(27);
        p.createFuelCell(40, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("plutonium",2.5F, 100F, 2, 200);
        p.createOre(false,100);
        p.createPellet(400);
        p.createFuelCell(410, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("plutonium_238",2.5F, 100F, 2, 260);
        p.createPellet(450);
        p.createFuelCell(470, 0, 0, 0, 1000);
        p.createIngot(1000);
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("plutonium_239",2.5F, 100F, 2, 180);
        p.createPellet(360);
        p.createFuelCell(360, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("plutonium_240",2.5F, 100F, 2, 200);
        p.createPellet(400);
        p.createFuelCell(410, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("plutonium_241",2.5F, 100F, 2, 800);
        p.createPellet(1600);
        p.createFuelCell(1600, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("neptunium",2.5F, 100F, 2, 90);
        p.createPellet(150);
        p.createFuelCell(150, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("technetium_99",2.5F, 100F, 2, 90);
        p.createPellet(150);
        p.createFuelCell(150, 0, 0, 0, 1000);
        p.createIngot();
        p.createPlate();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("cobalt_60",2.5F, 100F, 2, 100);
        p.createPellet(2000);
        p.createFuelCell(2200, 0, 0, 0, 1000);
        p.createIngot(1100);
        p.createPlate();
        p.createPowder();
        packs.add(p);

        //RAD END

        p = new MaterialPack("lead",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("titanium",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("tungsten",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("aluminium",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("steel",2.5F, 100F, 2);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("cobald",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("beryllium",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("boron",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("graphite",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("copper",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        p.createPlate();
        p.createStick();
        p.createPowder();
        packs.add(p);

        p = new MaterialPack("ruby",2.5F, 100F, 2);
        p.createOre(true);
        p.createGem();
        p.createBlock();
        packs.add(p);

        p = new MaterialPack("emerald",2.5F, 100F, 2);
        p.createArmor(1000,0F);
        p.createTools(3, 1000, 16.0F, 6, 30);
        packs.add(p);

        bar.step("Sorting Items");

        this.addToListsSorted();

        NuclearMod.LOGGER.info("Material Packs created!");
        NuclearMod.LOGGER.info("Material Packs:");
        NuclearMod.LOGGER.info("==============================");
        for(MaterialPack pack : packs) {
            NuclearMod.LOGGER.info(pack.name);
        }
        NuclearMod.LOGGER.info("==============================");

        ProgressManager.pop(bar);

    }

    public MaterialPack getMaterialPack(String name) {
        for (MaterialPack pack : packs) {
            if(pack.name == name) {
                return pack;
            }
        }
        return null;
    }

    public void addToListsSorted() {
        for (MaterialPack pack : packs) {
            for(ModBlock i : pack.pBlocks) {this.pBlocks.add(setCreativeTab(i, ModInitTabs.blocks));}
            for(ModBlock i : pack.pOres) {this.pOres.add(setCreativeTab(i, ModInitTabs.blocks));}
            for(ModItem i : pack.pIngots) {this.pIngots.add(setCreativeTab(i, ModInitTabs.resources));}
            for(ModItem i : pack.pGems) {this.pGems.add(setCreativeTab(i, ModInitTabs.resources));}
            for(ModItem i : pack.pPowders) {this.pPowders.add(setCreativeTab(i, ModInitTabs.resources));}
            for(ModItem i : pack.pPlates) {this.pPlates.add(setCreativeTab(i, ModInitTabs.resources));}
            for(ModItem i : pack.pSticks) {this.pSticks.add(setCreativeTab(i, ModInitTabs.resources));}
            for(ModItem i : pack.pPellets) {this.pPellets.add(setCreativeTab(i, ModInitTabs.resources));}
            for(ModItem i : pack.pFuelCells) {this.pFuelCells.add(setCreativeTab(i, ModInitTabs.reactors));}
            for(ModItem i : pack.pFuelCellsDepleted) {this.pFuelCellsDepleted.add(setCreativeTab(i, ModInitTabs.reactors));}
            for(ModItem i : pack.pNuggets) {this.pNuggets.add(setCreativeTab(i, ModInitTabs.resources));}
            for(Item i : pack.pTools) {this.pTools.add(setCreativeTab(i, ModInitTabs.equipment));}
            for(Item i : pack.pArmor) {this.pArmor.add(setCreativeTab(i, ModInitTabs.equipment));}
        }

        for(ModBlock i : pBlocks) {blocks.add(i);}
        for(ModBlock i : pOres) {blocks.add(i);}
        for(ModItem i : pIngots) {items.add(i);}
        for(ModItem i : pGems) {items.add(i);}
        for(ModItem i : pPowders) {items.add(i);}
        for(ModItem i : pPlates) {items.add(i);}
        for(ModItem i : pSticks) {items.add(i);}
        for(ModItem i : pPellets) {items.add(i);}
        for(ModItem i : pFuelCells) {items.add(i);}
        for(ModItem i : pFuelCellsDepleted) {items.add(i);}
        for(ModItem i : pNuggets) {items.add(i);}
        for(Item i : pTools) {items2.add(i);}
        for(Item i : pArmor) {items2.add(i);}
    }

    public Item setCreativeTab(Item item, ModTab t) {
        item.setCreativeTab(t);
        return item;
    }
    public ModItem setCreativeTab(ModItem item, ModTab t) {
        item.setCreativeTab(t);
        return item;
    }
    public ModBlock setCreativeTab(ModBlock item, ModTab t) {
        item.setCreativeTab(t);
        return item;
    }

    public ModItem getItem(String name) {
        for(ModItem item : items) {
            if(item.name == name) {
                return item;
            }
        }
        for(Item item : items) {
            if(item.getUnlocalizedName() == name) {
                return (ModItem)item;
            }
        }
        return null;
    }
    public ModBlock getBlock(String name) {
        for(ModBlock item : blocks) {
            if(item.name == name) {
                return item;
            }
        }
        return null;
    }

}
