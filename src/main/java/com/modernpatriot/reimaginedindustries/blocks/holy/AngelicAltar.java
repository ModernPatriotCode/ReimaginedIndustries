package com.modernpatriot.reimaginedindustries.blocks.holy;

import com.modernpatriot.reimaginedindustries.tileentity.holy.AngelicAltarData;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class AngelicAltar extends BlockDirectional implements ITileEntityProvider {

	public AngelicAltar(Material materialIn) {
		super(materialIn);
		this.setLightLevel(1.5F);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new AngelicAltarData();
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

}
