package com.modernpatriot.reimaginedindustries.items.itemblock;

import java.util.List;

import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class BasicGearboxItem extends ItemBlock {

	public BasicGearboxItem(Block block) {
		super(block);
		this.setMaxStackSize(16);
		
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "You can hear it ticking...");
	}

	

}
