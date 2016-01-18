package com.modernpatriot.reimaginedindustries.items.tools;

import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;

public class SwordTemplate extends ItemSword {
	
	ItemStack swordStack = new ItemStack(this);
	
	public SwordTemplate(ToolMaterial material) {
		super(ReimaginedMaterials.DEFAULT);
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		stack.getTagCompound().setInteger("maxUses", 1);
		stack.getTagCompound().setInteger("damage", 0);
		stack.getTagCompound().setInteger("enchantability", 0);
		stack.getTagCompound().setInteger("templateLevel", 0);
		swordStack = stack;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(itemStackIn.getTagCompound() != null) {
			itemStackIn.getTagCompound().setInteger("damage", itemStackIn.getTagCompound().getInteger("damage") + 1);
			playerIn.addChatComponentMessage(new ChatComponentText("Current Sword Damage: " + itemStackIn.getTagCompound().getInteger("damage")));
			//this.setMaxDamage(new ItemStack(this).getTagCompound().getInteger("maxUses"));
			
		}
		return itemStackIn;
	}
	
	@Override
	public float getDamageVsEntity(){
		if(swordStack.getTagCompound() != null){
			return swordStack.getTagCompound().getInteger("damage");
		}else{
			return 0;
		}
    }
	
	@Override
	 public int getItemEnchantability(){
		if(swordStack.getTagCompound() != null){
			return swordStack.getTagCompound().getInteger("enchantability");
		}else{
			return 0;
		}
    }
	
	@Override
	 public String getToolMaterialName(){
        return "ExoticMatter";
    }
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair){
       return false;
    }

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "May be a bit fragile...");
		if(GuiScreen.isShiftKeyDown()){
			lines.add(EnumChatFormatting.WHITE + "Advanced Crafting Material");
			if(GuiScreen.isCtrlKeyDown()) {
				if(stack.getTagCompound()!=null){
					lines.add(EnumChatFormatting.DARK_PURPLE + "Current Damage: " + stack.getTagCompound().getInteger("damage"));
					lines.add(EnumChatFormatting.DARK_PURPLE + "Current Level: " + stack.getTagCompound().getInteger("templateLevel"));
					lines.add(EnumChatFormatting.DARK_PURPLE + "Current Enchantability: " + stack.getTagCompound().getInteger("enchantability"));
				}else{
					lines.add(EnumChatFormatting.DARK_PURPLE + "Current Damage: " + 0);
					lines.add(EnumChatFormatting.DARK_PURPLE + "Current Level: " + 0);
					lines.add(EnumChatFormatting.DARK_PURPLE + "Current Enchantability: " + 0);
				}
			}else{
				lines.add(EnumChatFormatting.DARK_GRAY + "" + EnumChatFormatting.ITALIC + "PRESS CTRL FOR MORE INFORMATION");
			}
		}
	}
	
	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int metadata, boolean bool){
		if (itemstack.getTagCompound() == null) {
			itemstack.setTagCompound(new NBTTagCompound());
		}else{
			swordStack = itemstack;
		}
	}
	
	
}
