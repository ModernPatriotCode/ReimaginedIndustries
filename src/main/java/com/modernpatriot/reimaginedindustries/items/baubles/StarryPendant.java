package com.modernpatriot.reimaginedindustries.items.baubles;

import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.Optional.Method;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

@Optional.Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true)
public class StarryPendant extends Item implements IBauble{
	int ticker;
	
	@Method(modid="Baubles")
	@Override
	public boolean canEquip(ItemStack stack, EntityLivingBase player) {
		return true;
	}
	@Method(modid="Baubles")
	@Override
	public boolean canUnequip(ItemStack stack, EntityLivingBase player) {
		return true;
	}
	@Method(modid="Baubles")
	@Override
	public BaubleType getBaubleType(ItemStack stack) {
		return BaubleType.AMULET;
	}
	@Method(modid="Baubles")
	@Override
	public void onEquipped(ItemStack stack, EntityLivingBase player) {
		player.addVelocity(0, 2, 0);
	}
	@Method(modid="Baubles")
	@Override
	public void onUnequipped(ItemStack stack, EntityLivingBase player) {
		player.clearActivePotions();
		player.addVelocity(0, 2, 0);
		player.jumpMovementFactor = 1.0F;
	}
	@Method(modid="Baubles")
	@Override
	public void onWornTick(ItemStack stack, EntityLivingBase player) {
		World worldIn = player.getEntityWorld();
		player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), 5, 1, true, false));
		player.jumpMovementFactor = 0.8F;
		ticker++;
		if(ticker == 10){
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, player.posX, player.posY, player.posZ, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0);
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, player.posX, player.posY, player.posZ, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0);
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, player.posX, player.posY, player.posZ, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0);
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, player.posX, player.posY, player.posZ, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0);
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, player.posX, player.posY, player.posZ, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0);
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, player.posX, player.posY, player.posZ, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0);
		}
		if(ticker == 40) {
			player.addVelocity((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2, (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.4, (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2);
			ticker = 0;
		}
	}

}
