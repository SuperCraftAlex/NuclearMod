package net.supercraftalex.nuclearmod.tab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.item.ModItem;

import java.util.Comparator;
import java.util.List;

public class TabItemSorter implements Comparator<ItemStack> {

    private int getPriority(ItemStack itemStack) {
        int priority = 100;
        String name = itemStack.getItem().getUnlocalizedName();

        if(contains2(NuclearMod.getInstance().materialPacks.pBlocks,name)) {return 0;}
        if(contains2(NuclearMod.getInstance().materialPacks.pOres,name)) {return 1;}
        if(contains1(NuclearMod.getInstance().materialPacks.pIngots,name)) {return 2;}
        if(contains1(NuclearMod.getInstance().materialPacks.pGems,name)) {return 3;}
        if(contains1(NuclearMod.getInstance().materialPacks.pNuggets,name)) {return 4;}
        if(contains1(NuclearMod.getInstance().materialPacks.pPowders,name)) {return 5;}
        if(contains1(NuclearMod.getInstance().materialPacks.pPlates,name)) {return 6;}
        if(contains1(NuclearMod.getInstance().materialPacks.pSticks,name)) {return 7;}
        if(contains1(NuclearMod.getInstance().materialPacks.pPellets,name)) {return 8;}
        if(contains1(NuclearMod.getInstance().materialPacks.pFuelCells,name)) {return 9;}
        if(contains1(NuclearMod.getInstance().materialPacks.pFuelCellsDepleted,name)) {return 10;}
        if(contains3(NuclearMod.getInstance().materialPacks.pTools,name)) {return 11;}
        if(contains3(NuclearMod.getInstance().materialPacks.pArmor,name)) {return 12;}

        return priority;
    }

    public boolean contains1(List<ModItem> list, String name) {
        for(ModItem i : list) {
            if(i.getUnlocalizedName().equals(name)) {return true;}
        }
        return false;
    }
    public boolean contains2(List<ModBlock> list, String name) {
        for(ModBlock i : list) {
            if(i.getUnlocalizedName().equals(name)) {return true;}
        }
        return false;
    }
    public boolean contains3(List<Item> list, String name) {
        for(Item i : list) {
            if(i.getUnlocalizedName().equals(name)) {return true;}
        }
        return false;
    }

    @Override
    public int compare(ItemStack stack1, ItemStack stack2) {
        int priority1 = getPriority(stack1), priority2 = getPriority(stack2);

        if (priority1 == priority2) { // Both stacks have the same priority, order them by their ID/metadata
            Item item1 = stack1.getItem();
            Item item2 = stack2.getItem();

            if (item1 == item2) { // If the stacks have the same item, order them by their metadata
                return stack1.getMetadata() - stack2.getMetadata();
            } else { // Else order them by their ID
                return Item.getIdFromItem(item1) - Item.getIdFromItem(item2);
            }
        } else { // Stacks have different priorities, order them by priority instead
            return Integer.compare(priority1,priority2);
        }
    }
}