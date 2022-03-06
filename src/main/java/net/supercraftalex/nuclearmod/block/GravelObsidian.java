package net.supercraftalex.nuclearmod.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.supercraftalex.nuclearmod.init.ModInitTabs;

public class GravelObsidian extends ModBlock {

    public GravelObsidian() {
        super(Material.ROCK);
        setCreativeTab(ModInitTabs.blocks);
        setHardness(1.0F);
        setResistance(40F);
        setSoundType(SoundType.GROUND);
        setLightLevel(0.5F);
    }

}
