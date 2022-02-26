package net.supercraftalex.nuclearmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class ModBlock extends Block {

    public double radiation = 0.0;

    public String name;

    public ModBlock(Material blockMaterialIn, MapColor blockMapColorIn) {
        super(blockMaterialIn, blockMapColorIn);
    }

    public ModBlock(Material materialIn) {
        super(materialIn);
    }
    public ModBlock(Material materialIn, String name) {
        super(materialIn);
        this.name = name;
    }

    public ModBlock setRadiation(double radiation) {
        this.radiation = radiation;
        return this;
    }

    public double getRadiation() {
        return radiation;
    }

}
