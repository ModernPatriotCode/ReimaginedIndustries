package com.modernpatriot.reimaginedindustries.blocks.nature;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class BlockDust extends Block {

	public BlockDust(Material materialIn) {
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
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
    {
        entityIn.motionX *= 0.8D;
        entityIn.motionZ *= 0.8D;
    }
	
	
	
	
	
	

}
