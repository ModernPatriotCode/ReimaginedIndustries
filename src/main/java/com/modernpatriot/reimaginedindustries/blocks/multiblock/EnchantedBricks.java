package com.modernpatriot.reimaginedindustries.blocks.multiblock;

import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EnchantedBricks extends BlockDirectional {

	public EnchantedBricks(Material materialIn) {
		super(materialIn);
	}


}
