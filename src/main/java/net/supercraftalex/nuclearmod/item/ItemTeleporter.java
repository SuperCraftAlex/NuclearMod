package net.supercraftalex.nuclearmod.item;

import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class ItemTeleporter extends ModItem {

	public ItemTeleporter() {
		setCreativeTab(ModInitTabs.utilities);
		setMaxStackSize(1);
		setMaxDamage(20);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			RayTraceResult result = rayTrace(playerIn, 50);
			if (result.typeOfHit == Type.MISS) {
				playerIn.sendStatusMessage(new TextComponentString("\u00A74Out of range"), true);
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
			}
			BlockPos pos = result.getBlockPos();
			if (!(playerIn instanceof EntityPlayerMP)) {
				return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
			}
			EntityPlayerMP playermp = (EntityPlayerMP) playerIn;
			playermp.connection.setPlayerLocation(pos.getX(), pos.getY() + 1, pos.getZ(), playermp.rotationYaw, playermp.rotationPitch);
			stack.damageItem(1, playerIn);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

}
