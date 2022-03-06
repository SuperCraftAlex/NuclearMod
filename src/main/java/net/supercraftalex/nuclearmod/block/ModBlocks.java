package net.supercraftalex.nuclearmod.block;

import net.supercraftalex.nuclearmod.block.bomb.BombC4;
import net.supercraftalex.nuclearmod.block.bomb.BombCluster;
import net.supercraftalex.nuclearmod.block.bomb.BombThermo;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static List<ModBlock> modBlocks = new ArrayList<ModBlock>();

    public static final ModBlock tutblock = new BlockTutorial();
    public static final ModBlock tutblockfacing = new BlockTutorialFacing();

    public static final ModBlock brick_obsidian = new BrickObsidian();
    public static final ModBlock gravel_obsidian = new GravelObsidian();

    public static final ModBlock waste_earth = new BlockWaste();
    public static final ModBlock waste_mycelium = new BlockWaste();
    public static final ModBlock waste_log = new BlockWaste();
    public static final ModBlock waste_planks = new BlockWaste();

    public static final ModBlock therm_endo = new BombThermo(); //Kalt
    public static final ModBlock therm_snow = new BombThermo(); //Kalt Schnee
    public static final ModBlock therm_endo_safe = new BombThermo(); //Kalt safe
    public static final ModBlock therm_exo = new BombThermo();  //Warm
    public static final ModBlock bomb_c4 = new BombC4();
    public static final ModBlock bomb_cluster = new BombCluster();

    public static void addBlocks() {

        addBlock(tutblock, "tutblock");
        addBlock(tutblockfacing, "tutblockfacing");

        addBlock(brick_obsidian, "brick_obsidian");
        addBlock(gravel_obsidian, "gravel_obsidian");

        addBlock(waste_earth, "waste_earth");
        addBlock(waste_mycelium, "waste_mycelium");
        addBlock(waste_log, "waste_log");
        addBlock(waste_planks, "waste_planks");

        addBlock(therm_endo, "bomb_thermo_endo");
        addBlock(therm_snow, "bomb_thermo_snow");
        addBlock(therm_endo_safe, "bomb_thermo_endo_safe");
        addBlock(therm_exo, "bomb_thermo_exo");
        addBlock(bomb_c4, "bomb_c4");
        addBlock(bomb_cluster, "bomb_cluster");

    }


    private static void addBlock(ModBlock m, String name) {
        m.name = name;
        modBlocks.add(m);
    }

}
