package net.supercraftalex.nuclearmod.util;

import net.supercraftalex.nuclearmod.item.ModItem;

public class RadiationAPI {

    public static double getRadiation(ModItem i) {
        //Every Item has a Heat of 23.0 (23°C = room temperature)
        //Not Radeoactive items have a base radiation of 0.0
        return i.getHeat() * i.getBaseRadiation();
    }

    public static boolean isDangerousForPlayer(ModItem i) {
        //radiation about 100 is dangerous
        if(i.getHeat() * i.getBaseRadiation() > 100) {
            return true;
        }
        return false;
    }

}