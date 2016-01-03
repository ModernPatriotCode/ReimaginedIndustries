package com.modernpatriot.reimaginedindustries.items.itemblock;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class IndustrialLoamItem extends ItemBlock {

	public IndustrialLoamItem(Block block) {
		super(block);
	}
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "Pretty and smooth");
	}
}
