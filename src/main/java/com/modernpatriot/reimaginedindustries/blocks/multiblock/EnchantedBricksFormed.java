package com.modernpatriot.reimaginedindustries.blocks.multiblock;

import com.modernpatriot.reimaginedindustries.tileentity.SlaveEnchantedBricks;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class EnchantedBricksFormed extends BlockDirectional implements ITileEntityProvider{

	public EnchantedBricksFormed(Material materialIn) {
		super(materialIn);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new SlaveEnchantedBricks();
	}

}
