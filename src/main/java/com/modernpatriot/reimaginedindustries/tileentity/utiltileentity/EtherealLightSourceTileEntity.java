package com.modernpatriot.reimaginedindustries.tileentity.utiltileentity;

import com.modernpatriot.reimaginedindustries.core.TileEntityBase;
import com.modernpatriot.reimaginedindustries.core.util.effects.UtilEffectsMain;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EtherealLightSourceTileEntity extends TileEntityBase implements IUpdatePlayerListBox{

	private static int counter;
	@Override
	public void update() {
		counter++;
		if (counter == 0) {
			UtilEffectsMain.spawnParticleAtBlockMiddle(EnumParticleTypes.DRIP_LAVA, pos, worldObj);
		}
		if (counter == 5){
			UtilEffectsMain.spawnParticleAtBlockMiddle(EnumParticleTypes.SUSPENDED_DEPTH, pos, worldObj);
			counter = 0;
		}
	}

	@Override
	public boolean shouldRefresh(World worldIn, BlockPos pos, IBlockState state, IBlockState newState) {
		return (state.getBlock() != newState.getBlock());
	}

}
