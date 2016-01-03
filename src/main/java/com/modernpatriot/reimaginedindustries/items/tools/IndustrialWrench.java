package com.modernpatriot.reimaginedindustries.items.tools;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class IndustrialWrench extends Item { 

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "Seriously? Another one?");
	}	
}
