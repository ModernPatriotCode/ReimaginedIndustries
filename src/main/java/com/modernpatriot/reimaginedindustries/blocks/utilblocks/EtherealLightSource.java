package com.modernpatriot.reimaginedindustries.blocks.utilblocks;

import com.modernpatriot.reimaginedindustries.core.util.effects.UtilEffectsMain;
import com.modernpatriot.reimaginedindustries.tileentity.utiltileentity.EtherealLightSourceTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EtherealLightSource extends Block implements ITileEntityProvider {

	public EtherealLightSource(Material materialIn) {
		super(materialIn);
		setDefaultState(blockState.getBaseState());
		setTickRandomly(false);
		setLightLevel(0.94F);
	}
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.removeTileEntity(pos);
		UtilEffectsMain.spawnParticleAtBlockMiddle(EnumParticleTypes.CLOUD, pos, worldIn, true);
		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, net.minecraft.entity.player.EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		worldIn.removeTileEntity(pos);
		UtilEffectsMain.spawnParticleAtBlockMiddle(EnumParticleTypes.CLOUD, pos, worldIn, true);
		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
		return true;
	}

	@Override
	public boolean isReplaceable(World worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new EtherealLightSourceTileEntity();
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean isFullCube() {
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return getDefaultState();
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
		return null;
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		return;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		return;
	}

	@Override
	public void onLanded(World worldIn, Entity entityIn) {
		return;
	}

	@Override
	protected BlockState createBlockState() {
		return new BlockState(this);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer() {
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		return;
	}

}
