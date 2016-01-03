package com.modernpatriot.reimaginedindustries.blocks.holy;

import com.modernpatriot.reimaginedindustries.core.util.effects.UtilEffectsMain;
import com.modernpatriot.reimaginedindustries.tileentity.holy.EtherealLampTileEntity;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EtherealLamp extends BlockDirectional implements ITileEntityProvider {

	public EtherealLamp(Material materialIn) {
		super(materialIn);
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		EtherealLampTileEntity elte = (EtherealLampTileEntity)worldIn.getTileEntity(pos);
		elte.notYetExecuted = true;
		elte.setPosition(pos);
		UtilEffectsMain.playSoundAtBlockMiddle("random.orb", worldIn, pos, 0.6F, 0.6F, true);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		EtherealLampTileEntity elte = (EtherealLampTileEntity)worldIn.getTileEntity(pos);
		//elte.removeLightSources();
		worldIn.removeTileEntity(pos);
		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
		UtilEffectsMain.playSoundAtBlockMiddle("random.orb", worldIn, pos, 0.6F, 0.6F, true);
	}
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, net.minecraft.world.Explosion explosionIn) {
		EtherealLampTileEntity elte = (EtherealLampTileEntity)worldIn.getTileEntity(pos);
		//elte.removeLightSources();
		worldIn.removeTileEntity(pos);
		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
		UtilEffectsMain.playSoundAtBlockMiddle("random.orb", worldIn, pos, 0.6F, 0.6F, true);
	}
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		EtherealLampTileEntity elte = (EtherealLampTileEntity)worldIn.getTileEntity(pos);
		//elte.removeLightSources();
		worldIn.removeTileEntity(pos);
		worldIn.setBlockState(pos, Blocks.air.getDefaultState());
		UtilEffectsMain.playSoundAtBlockMiddle("random.orb", worldIn, pos, 0.6F, 0.6F, true);
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new EtherealLampTileEntity();
	}

}
