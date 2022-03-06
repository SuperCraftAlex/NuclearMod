package net.supercraftalex.nuclearmod.block.bomb;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.interfaces.IBomb;

public class ModBomb extends ModBlock implements IBomb {
    public ModBomb(Material blockMaterialIn) {
        super(blockMaterialIn);
    }

    @Override
    public void explode(World world, BlockPos pos) {}
}
