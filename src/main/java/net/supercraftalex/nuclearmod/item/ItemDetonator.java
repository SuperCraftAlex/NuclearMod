package net.supercraftalex.nuclearmod.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.supercraftalex.nuclearmod.NuclearMod;
import net.supercraftalex.nuclearmod.block.bomb.ModBomb;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.interfaces.IBomb;

import javax.annotation.Nullable;
import java.util.List;

public class ItemDetonator extends ModItem {

    ItemDetonator() {
        this.setCreativeTab(ModInitTabs.bombs);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {

        ItemStack stack = playerIn.getHeldItem(handIn);

        NBTTagCompound nbt;
        if (stack.hasTagCompound() && !(
                stack.getTagCompound().getInteger("x") == 0 &&
                stack.getTagCompound().getInteger("y") == 0 &&
                stack.getTagCompound().getInteger("z") == 0))
        {
            int x = stack.getTagCompound().getInteger("x");
            int y = stack.getTagCompound().getInteger("y");
            int z = stack.getTagCompound().getInteger("z");
            NuclearMod.logDebug(x + " " + y + " " + z);
            nbt = stack.getTagCompound();
            BlockPos pos = new BlockPos(x,y,z);
            if(worldIn.getBlockState(pos).getBlock() instanceof ModBomb) {
                ((ModBomb)worldIn.getBlockState(pos).getBlock()).explode(worldIn,pos);
            }
            nbt.setInteger("x", 0);
            nbt.setInteger("y", 0);
            nbt.setInteger("z", 0);
        }
        else
        {
            nbt = new NBTTagCompound();

            if (!worldIn.isRemote) {
                RayTraceResult result = rayTrace(playerIn, 4);
                if (result.typeOfHit == RayTraceResult.Type.MISS) {
                    return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
                }
                if(worldIn.getBlockState(result.getBlockPos()).getBlock() instanceof ModBomb) {
                    playerIn.sendMessage(new TextComponentString("Set Bomb position."));
                    nbt.setInteger("x", result.getBlockPos().getX());
                    nbt.setInteger("y", result.getBlockPos().getY());
                    nbt.setInteger("z", result.getBlockPos().getZ());
                }
            }
        }

        stack.setTagCompound(nbt);

        Minecraft.getMinecraft().player.setHeldItem(handIn, stack);

        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        int x = 0;
        int y = 0;
        int z = 0;
        if (stack.hasTagCompound()) {
            x = stack.getTagCompound().getInteger("x");
            y = stack.getTagCompound().getInteger("y");
            z = stack.getTagCompound().getInteger("z");
        }
        tooltip.add(x + " " + y + " " + z);
    }

}
