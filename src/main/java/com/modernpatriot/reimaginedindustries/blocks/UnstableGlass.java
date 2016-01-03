package com.modernpatriot.reimaginedindustries.blocks;

import java.util.Random;

import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UnstableGlass extends BlockBreakable
{
    protected UnstableGlass(Material materialIn, boolean ignoreSimilarityIn) {
		super(materialIn, ignoreSimilarityIn);
		
	}
    
    public int quantityDropped(Random random)
    {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    public boolean isFullCube()
    {
        return false;
    }

    protected boolean canSilkHarvest()
    {
        return true;
    }
   
	
    
    
    
    
}