package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.block.ModBlock;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static List<ModItem> modItems = new ArrayList<ModItem>();

    public static final ModItem tutitem = new ItemTutorial();
    public static final ModItem teleporter = new ItemTeleporter();
    public static final ModItem wrench = new ItemWrench();

    public static void addItems() {
        addItem(tutitem, "tutitem");
        addItem(teleporter, "teleporter");
        addItem(wrench, "wrench");
    }


    private static void addItem(ModItem m, String name) {
        m.name = name;
        modItems.add(m);
    }

}
