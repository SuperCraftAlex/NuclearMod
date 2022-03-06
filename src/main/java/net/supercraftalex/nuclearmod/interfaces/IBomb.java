package net.supercraftalex.nuclearmod.interfaces;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IBomb {

	void explode(World world, BlockPos pos);

}
