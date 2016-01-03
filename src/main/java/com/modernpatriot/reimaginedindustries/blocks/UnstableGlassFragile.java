package com.modernpatriot.reimaginedindustries.blocks;

import java.util.Random;

import javax.swing.Icon;

import com.modernpatriot.reimaginedindustries.core.util.config.ConfigVariables;
import com.modernpatriot.reimaginedindustries.core.util.effects.UtilEffectsMain;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class UnstableGlassFragile extends Block {

	private boolean ignoreSimilarity;

	protected UnstableGlassFragile(Material materialIn, boolean ignoreSimilarityIn)
	{
		super(materialIn);
		this.ignoreSimilarity = ignoreSimilarityIn;
	}
	public int quantityDropped(Random random)
	{
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.TRANSLUCENT;
	}

	public boolean isFullCube()
	{
		return false;
	}

	protected boolean canSilkHarvest()
	{
		return true;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (this == ReimaginedBlocks.unstableGlass)
		{
			if (worldIn.getBlockState(pos.offset(side.getOpposite())) != iblockstate)
			{
				return true;
			}

			if (block == this)
			{
				return false;
			}
		}

		return !this.ignoreSimilarity && block == this ? false : super.shouldSideBeRendered(worldIn, pos, side);
	}


	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(worldIn.isRemote) {
			if (ConfigVariables.enableParticleEffects) {
				worldIn.spawnParticle(EnumParticleTypes.CLOUD, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
				worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
				worldIn.spawnParticle(EnumParticleTypes.SPELL_INSTANT, x + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, y + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, z + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
			}
		}
		return this.getStateFromMeta(meta);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(! worldIn.isRemote) {
			//SERVERSIDE (NOT REMOTE)
			if (playerIn.isSneaking()) {
				worldIn.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "game.potion.smash", 0.8F, 0.8F);
				playerIn.addPotionEffect((new PotionEffect(Potion.harm.getId(), 1, 1)));
				worldIn.setBlockToAir(pos);
			}
			worldIn.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "game.potion.smash", 0.8F, 0.8F);
			playerIn.addPotionEffect((new PotionEffect(Potion.harm.getId(), 1, 1)));
			worldIn.setBlockToAir(pos);
		}else{
			//CLIENTSIDE (REMOTE)
			if (playerIn.isSneaking()) {
				if (ConfigVariables.enableParticleEffects) {
					UtilEffectsMain.spawnUnstableParticles(pos, worldIn);
				}
				worldIn.setBlockToAir(pos);
			}
			if (ConfigVariables.enableParticleEffects) {
				UtilEffectsMain.spawnUnstableParticles(pos, worldIn);
			}
			worldIn.setBlockToAir(pos);
		}
		return true;
	}
	@Override
	public boolean removedByPlayer(World worldIn, BlockPos pos, EntityPlayer playerIn, boolean willHarvest)
	{
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(! worldIn.isRemote) {
			playerIn.addPotionEffect((new PotionEffect(Potion.harm.getId(), 1, 1)));
			worldIn.setBlockToAir(pos);
		}else{
			if (ConfigVariables.enableParticleEffects) {
				UtilEffectsMain.spawnUnstableParticles(pos, worldIn);
			}
			worldIn.setBlockToAir(pos);
		}
		return willHarvest;
	}
	//TODO: ADDING IBLOCKSTATE STATE AFTER POS
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(! worldIn.isRemote) {
			worldIn.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "game.potion.smash", 0.8F, 0.8F);
			entityIn.attackEntityFrom(DamageSource.magic, 8.0F);
			worldIn.setBlockToAir(pos);
		}else{
			if (ConfigVariables.enableParticleEffects) {
				UtilEffectsMain.spawnUnstableParticles(pos, worldIn);
			}
			worldIn.setBlockToAir(pos);
		}
	}
	@Override
	public void fillWithRain(World worldIn, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(! worldIn.isRemote) {
			worldIn.playSoundEffect(x + 0.5F, y + 0.5F, z + 0.5F, "game.potion.smash", 0.8F, 0.8F);
			worldIn.setBlockToAir(pos);
		}else{
			if (ConfigVariables.enableParticleEffects) {
				UtilEffectsMain.spawnUnstableParticles(pos, worldIn);
			}
			worldIn.setBlockToAir(pos);
		}
	}
	@Override
	public void onBlockExploded(World worldIn, BlockPos pos, Explosion explosion) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		if(! worldIn.isRemote) {
			worldIn.setBlockToAir(pos);
		}else{
			if (ConfigVariables.enableParticleEffects) {
				UtilEffectsMain.spawnUnstableParticles(pos, worldIn);
			}
		}
	}
	// yes this isn't needed
	@Override
	public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side) 
	{
		return true;
	}
	@Override
	public boolean canPlaceTorchOnTop(IBlockAccess world, BlockPos pos)
	{
		return false;
	}
	@Override
	public float getEnchantPowerBonus(World world, BlockPos pos)
	{
		return 0.25F;
	}



}
