package net.supercraftalex.nuclearmod.tileentity;

import net.supercraftalex.nuclearmod.block.BlockTutorialFacing;
import net.supercraftalex.nuclearmod.util.RedstoneUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.*;

public class TileEntityTutorialFacing extends ModTileEntity implements ITickable {
	
	private int cooldown;
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}
	
	@Override
	public void update() {
		if (world.isRemote) {
			return;
		}
		if (cooldown < 50) {
			cooldown++;
			return;
		}
		cooldown = 0;
		
		if (!RedstoneUtil.isPowered(world, pos)) {
			return;
		}
		
		IBlockState ourState = world.getBlockState(pos);
		EnumFacing facing = ourState.getValue(BlockTutorialFacing.FACING);
		BlockPos destinationPos = pos.offset(facing);
		
		TileEntity tileentity = world.getTileEntity(destinationPos);
		
		if (tileentity == null) {
			return;
		}
		if (!tileentity.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing.getOpposite())) {
			return;
		}
		IItemHandler handler = tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, facing.getOpposite());
		ItemHandlerHelper.insertItemStacked(handler, new ItemStack(Items.STICK, 2), false);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		cooldown = compound.getInteger("cooldown");
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger("cooldown", cooldown);
		return compound;
	}
	
}
