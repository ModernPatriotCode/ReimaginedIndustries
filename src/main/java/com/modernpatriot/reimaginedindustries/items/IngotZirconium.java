package com.modernpatriot.reimaginedindustries.items;

import java.util.List;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class IngotZirconium extends Item {

	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
		lines.add(EnumChatFormatting.DARK_GRAY + "Lighter than I expected...");	
	}	
	@Override
	public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entityItem) {
		if (entityItem.isInsideOfMaterial(Material.water)) {
			double x = entityItem.posX;
			double y = entityItem.posY;
			double z = entityItem.posZ;
			World worldIn = entityItem.getEntityWorld();
			worldIn.playSoundEffect(x, y, z, "random.explode", 1.2F, 1.2F);
			worldIn.playSoundEffect(x, y, z, "random.fizz", 2F, 2F);
			worldIn.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, x, y + 1, z, 0, 0, 0, 0);
			worldIn.spawnParticle(EnumParticleTypes.CLOUD, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.CLOUD, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.CLOUD, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.CLOUD, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);				
			worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 1 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			EntityPlayer player = entityItem.worldObj.getClosestPlayer(x, y, z, 5);
			if(player != null && player instanceof EntityPlayer) {
				player.addPotionEffect((new PotionEffect(Potion.harm.getId(), 1, 1)));
				player.setFire(4);
			}
			entityItem.lifespan = 0;
		}
	return super.onEntityItemUpdate(entityItem);
	}
	
}
