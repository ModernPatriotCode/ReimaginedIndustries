package com.modernpatriot.reimaginedindustries.items.tools;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class SwordTemplateDiamond extends Item {

	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "Well that's expensive!");
		if(GuiScreen.isShiftKeyDown()){
			lines.add(EnumChatFormatting.AQUA + "Luxurious sword - but is it stable?");
		}
	}
}
