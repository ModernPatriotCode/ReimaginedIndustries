package com.modernpatriot.reimaginedindustries.items.itemblock;

import java.util.List;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class AdvancedBlockItem extends ItemBlock {

	public AdvancedBlockItem(Block block) {
		super(block);
	}
	
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "Oddly mesmerizing...");
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, net.minecraft.entity.Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

		if (entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.moveSlowdown.getId(), 10, 2));
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.hunger.getId(), 10, 1));
		}
	}

}
