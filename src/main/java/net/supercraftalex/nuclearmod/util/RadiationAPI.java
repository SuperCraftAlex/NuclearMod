package net.supercraftalex.nuclearmod.util;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.item.ModItem;

public class RadiationAPI {

    public static double getRadiation(ModItem i) {
        //Every Item has a Heat of 23.0 (23°C = room temperature)
        //Not Radeoactive items have a base radiation of 0.0
        return i.getHeat() * i.getBaseRadiation();
    }

    public static boolean isDangerousForPlayer(ItemStack i) {
        //base radiation about 100 is dangerous
        //radiation about 2300 is dangerous
        double stackrad;
        stackrad = ((ModItem)i.getItem()).getBaseRadiation() * i.getCount();
        if(((ModItem)i.getItem()).getHeat() * stackrad > 100) {
            return true;
        }
        return false;
    }

    public static double getBlockRadiation(BlockPos pos) {
        Block b = Minecraft.getMinecraft().world.getBlockState(pos).getBlock();
        if(b instanceof ModBlock) {
            return ((ModBlock) b).getRadiation();
        }
        return 0.0;
    }

}