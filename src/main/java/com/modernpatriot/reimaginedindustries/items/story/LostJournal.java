package com.modernpatriot.reimaginedindustries.items.story;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class LostJournal extends Item {
	
	private int counter;
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		counter += player.worldObj.rand.nextInt(3);
		lines.add(EnumChatFormatting.DARK_GRAY + "It's dusty...");	
		if(GuiScreen.isShiftKeyDown()){
			if(counter == 10 || counter == 56 || counter == 66 || counter == 127 || counter == 130 || counter == 132){
				lines.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "" + EnumChatFormatting.STRIKETHROUGH + "DON'T EVEN " + EnumChatFormatting.OBFUSCATED + "" + EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + "TRY TO DESTROY IT");
			}else{
				lines.add(EnumChatFormatting.DARK_RED + "" + EnumChatFormatting.ITALIC + "DON'T EVEN TRY TO DESTROY IT");
			}
		}
		if(counter >= 150){
			counter = 0;
		}
	}	
	
	@Override
	public boolean doesSneakBypassUse(World world, BlockPos pos, EntityPlayer player) {
		return false;
	}
	
}
