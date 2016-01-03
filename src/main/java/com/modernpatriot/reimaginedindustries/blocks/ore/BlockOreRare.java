package com.modernpatriot.reimaginedindustries.blocks.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;

public class BlockOreRare extends Block {

	public BlockOreRare(Material materialIn) {
		super(materialIn);
	}
	@Override
	public boolean isOpaqueCube()
	{
		return true;
	}
	
	@Override
	public boolean isFullCube()
	{
		return true;
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	
	@Override
	public boolean isCollidable()
    {
        return true;
    }
	

}

