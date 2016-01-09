package com.modernpatriot.reimaginedindustries.items;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class SuperGlue extends Item {
	
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "Sticky Suprise...");	
		if(GuiScreen.isShiftKeyDown()){
			lines.add(EnumChatFormatting.WHITE + "Advanced Crafting Material");
		}
	}

}
