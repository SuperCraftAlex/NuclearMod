package net.supercraftalex.nuclearmod.tileentity;

public class NbtTag {

    public String key;
    public int value;
    public ModTileEntity.rw direction;

    //true = write     false = read
    public NbtTag(String key, int value, ModTileEntity.rw direction) {
        this.key = key;
        this.value = value;
        this.direction = direction;
    }

}
