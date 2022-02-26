package net.supercraftalex.nuclearmod.materialpack;

import java.util.ArrayList;
import java.util.List;

public class MaterialPacks {

    public List<MaterialPack> packs = new ArrayList<MaterialPack>();

    public MaterialPacks() {
        MaterialPack p;


        p = new MaterialPack("uranium",2.5F, 100F, 2, 40);
        p.createOre(false, 20);
        p.createIngot();
        p.createBlock();
        packs.add(p);

        p = new MaterialPack("uranium_233",2.5F, 100F, 2, 110);
        p.createPellet(230);
        p.createFuelCell(230, 0, 0, 0, 1000);
        p.createIngot();
        packs.add(p);

        p = new MaterialPack("copper",2.5F, 100F, 2);
        p.createOre(false);
        p.createIngot();
        p.createBlock();
        packs.add(p);

        p = new MaterialPack("ruby",2.5F, 100F, 2);
        p.createOre(true);
        p.createGem();
        p.createBlock();
        packs.add(p);

        p = new MaterialPack("emerald",2.5F, 100F, 2);
        p.createArmor(1000,0F);
        p.createTools(3, 1000, 16.0F, 6, 30);
        packs.add(p);


        for(MaterialPack pack : packs) {
            System.out.println(p.name);
        }
    }

}
