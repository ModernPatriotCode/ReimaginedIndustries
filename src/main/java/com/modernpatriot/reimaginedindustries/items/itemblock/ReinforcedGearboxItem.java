package com.modernpatriot.reimaginedindustries.items.itemblock;

import java.util.List;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ReinforcedGearboxItem extends ItemBlock {

	public ReinforcedGearboxItem(Block block) {
		super(block);
		this.setMaxStackSize(1);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "It vibrates scarily...");
	}

}
