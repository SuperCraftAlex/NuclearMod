package net.supercraftalex.nuclearmod.util;

import java.util.Random;

public class RandomUtil {

    public static double randomD(int min, int max) {
        double random = new Random().nextDouble();
        return min + (random * (max - min));
    }

}
