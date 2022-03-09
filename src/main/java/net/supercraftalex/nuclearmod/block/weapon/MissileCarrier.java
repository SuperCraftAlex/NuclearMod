package net.supercraftalex.nuclearmod.block.weapon;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.supercraftalex.nuclearmod.ModConstants;
import net.supercraftalex.nuclearmod.block.ModBlock;
import net.supercraftalex.nuclearmod.entities.EntityMissile1;
import net.supercraftalex.nuclearmod.entities.ModMissile;
import net.supercraftalex.nuclearmod.init.ModInitTabs;
import net.supercraftalex.nuclearmod.tileentity.TileEntityMissileCarrier;

public class MissileCarrier extends ModBlock implements ITileEntityProvider {

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public MissileCarrier() {
        super(Material.IRON);
        this.setCreativeTab(ModInitTabs.missiles);
        setDefaultState(getDefaultState().withProperty(FACING, EnumFacing.NORTH));
        GameRegistry.registerTileEntity(TileEntityMissileCarrier.class, new ResourceLocation(ModConstants.MODID, "missile_carrier"));
    }


    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        if (!worldIn.isRemote) {
            ModMissile missile = new EntityMissile1(worldIn);
            missile.setLocationAndAngles(pos.getX(), pos.getY()-1.5, pos.getZ(), 0, 0);
            worldIn.spawnEntity(missile);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMissileCarrier();
    }

}