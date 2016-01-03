package com.modernpatriot.reimaginedindustries.items.itemblock;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.util.config.ConfigVariables;
import com.modernpatriot.reimaginedindustries.core.util.effects.UtilEffectsMain;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class UnstableGlassItem extends ItemBlock {

	public UnstableGlassItem(Block block) {
		super(block);
	}

	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
		return true;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, net.minecraft.entity.Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);

		if (entityIn instanceof EntityLivingBase) {
			((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.wither.getId(), 10, 1));
		}
	}


	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "It's really delicate...");
	}
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player)
	{
		double x = player.posX;
		double y = player.posY;
		double z = player.posZ;
		World worldIn = player.getEntityWorld();
		if(! worldIn.isRemote) {
			player.addPotionEffect((new PotionEffect(Potion.harm.getId(), 1, 1)));
		}
		return true;
	}


	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {
		double x = entityItem.posX;
		double y = entityItem.posY;
		double z = entityItem.posZ;
		World worldIn = entityItem.getEntityWorld();
		if(! worldIn.isRemote) {
			worldIn.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "game.potion.smash", 0.8F, 0.8F);
			entityItem.lifespan = 0;
		}else{
			if (ConfigVariables.enableParticleEffects) {
				UtilEffectsMain.spawnUnstableParticles(entityItem.getPosition(), worldIn);
			}
		}
		return false;
	}
}
