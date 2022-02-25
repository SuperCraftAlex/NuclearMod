package net.supercraftalex.nuclearmod.tab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.supercraftalex.nuclearmod.block.ModBlock;

public class ModTab extends CreativeTabs {

    private ItemStack icon;

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

}
