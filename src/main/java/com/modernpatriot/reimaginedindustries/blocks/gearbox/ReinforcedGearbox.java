package com.modernpatriot.reimaginedindustries.blocks.gearbox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;

public class ReinforcedGearbox extends Block {

	public ReinforcedGearbox(Material materialIn) {
		super(materialIn);
		this.isBlockContainer = true;
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
		return EnumWorldBlockLayer.CUTOUT;
	}
}
