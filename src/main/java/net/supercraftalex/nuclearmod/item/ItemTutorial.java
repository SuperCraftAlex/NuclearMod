package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemTutorial extends ModItem {

	public ItemTutorial() {
		setCreativeTab(ModInitTabs.utilities);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!worldIn.isRemote) {
			worldIn.setBlockState(playerIn.getPosition().down(), Blocks.DIAMOND_BLOCK.getDefaultState());
		}
		playerIn.jump();
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

}
