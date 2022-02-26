package net.supercraftalex.nuclearmod.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockOre extends ModBlock{

    public BlockOre(String name, float hardness, float resistance, int harvestlevel) {
        super(Material.ROCK);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", harvestlevel);
        setLightLevel(0.2F);
        setHardness(hardness);
        setResistance(resistance);
        this.name = name;
    }

}
