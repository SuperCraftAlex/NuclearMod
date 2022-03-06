package net.supercraftalex.nuclearmod.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.supercraftalex.nuclearmod.init.ModInitTabs;

public class BrickObsidian extends ModBlock {

    public BrickObsidian() {
        super(Material.ROCK);
        setCreativeTab(ModInitTabs.blocks);
        setHardness(2000.0F);
        setResistance(5000F);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 5);
        setLightLevel(0.5F);
    }

}
