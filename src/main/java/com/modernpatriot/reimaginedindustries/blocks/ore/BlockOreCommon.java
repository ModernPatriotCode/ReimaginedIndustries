package com.modernpatriot.reimaginedindustries.blocks.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;

/**
 * Class all common ores use. 
 * @author MoPat
 */
public class BlockOreCommon extends Block {

	public BlockOreCommon(Material materialIn) {
		super(materialIn);
		this.translucent = !materialIn.blocksLight();
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
