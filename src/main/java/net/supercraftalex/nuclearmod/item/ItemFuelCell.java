package net.supercraftalex.nuclearmod.item;

public class ItemFuelCell extends ModItem {

    public boolean depleted;
    public double heatperfission, neutronperfission, meltheat;

    public ItemFuelCell(String name, boolean depleted, int durability, double heatperfission, double neutronperfission, double meltheat, double baseRadiation) {
        this.name = name;
        this.depleted = depleted;
        if(!depleted) {
            this.setMaxDamage(durability);
        }
        this.heatperfission = heatperfission;
        this.neutronperfission = neutronperfission;
        this.meltheat = meltheat;
        this.setBaseRadiation(baseRadiation);
    }

}
