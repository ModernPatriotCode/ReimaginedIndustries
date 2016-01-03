package com.modernpatriot.reimaginedindustries.core.util.effects;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class UtilEffectsMain {


	/* SPAWNS A PARTICLE AT THE MIDDLE OF A BLOCK */
	public static void spawnParticleAtBlockMiddle(EnumParticleTypes type, BlockPos pos, World worldIn, boolean randomize) {
		if (worldIn != null && type != null && pos != null) {
			if (randomize==true) {
				worldIn.spawnParticle(type, pos.getX() + 0.5 + ((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.6), pos.getY() + 0.5 + ((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.6), pos.getZ() + 0.5 + ((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.6), 0.0D, 0.0D, 0.0D);
			}else{
				worldIn.spawnParticle(type, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	public static void spawnParticleAtBlockMiddle(EnumParticleTypes type, BlockPos pos, World worldIn) {
		if (worldIn != null && type != null && pos != null) {
			worldIn.spawnParticle(type, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0D, 0.0D, 0.0D);
		}
	}

	/* SPAWNS THE PARTICLES YOU SEE WHEN UNSTABLE GLASS IS BROKEN */
	public static void spawnUnstableParticles(BlockPos pos, World worldIn) {
		for(int i = 0; i < 4; i++) {
			spawnParticleAtBlockMiddle(EnumParticleTypes.CLOUD, pos, worldIn, true);
			spawnParticleAtBlockMiddle(EnumParticleTypes.SPELL_INSTANT, pos, worldIn, true);
			spawnParticleAtBlockMiddle(EnumParticleTypes.SPELL_MOB, pos, worldIn, true);
			worldIn.spawnParticle(EnumParticleTypes.SPELL_MOB, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, worldIn.rand.nextFloat()*100D, worldIn.rand.nextFloat()*100D, worldIn.rand.nextFloat()*100D);
		}
	}

	/* PLAYS A SOUND AT THE MIDDLE OF A BLOCK */
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos) {
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, 1, 1);
	}

	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, float volume) {
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume, 1);
	}

	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, float volume, float pitch) {
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume, pitch);
	}

	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, float volume, float pitch, boolean randomizeSound) {
		if (randomizeSound) {
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F, pitch + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F);
		}else{
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume, pitch);
		}
	}
	
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, boolean randomizeSound) {
		if (randomizeSound) {
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, 1 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F, 1 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F);
		}else{
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, 1, 1);
		}
	}
}
