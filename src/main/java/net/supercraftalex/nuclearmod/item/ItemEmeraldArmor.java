package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.init.ModInitItems;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEmeraldArmor extends ItemArmor {

	public ItemEmeraldArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setCreativeTab(ModInitTabs.utilities);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (ModInitItems.emeraldChestplate.equals(itemStack.getItem())) {
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 20));
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 1));
		}
	}

}
