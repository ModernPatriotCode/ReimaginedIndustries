package com.modernpatriot.reimaginedindustries.core.util.effects;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

/**
 * Used to have easier methods for common effects.
 * @author MoPat
 */
public class UtilEffectsMain {


	/**
	 * Used to spawn a particle at the middle of a block.
	 * @param type
	 * @param pos
	 * @param worldIn
	 * @param randomize
	 */
	public static void spawnParticleAtBlockMiddle(EnumParticleTypes type, BlockPos pos, World worldIn, boolean randomize) {
		if (worldIn != null && type != null && pos != null) {
			if (randomize==true) {
				worldIn.spawnParticle(type, pos.getX() + 0.5 + ((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.6), pos.getY() + 0.5 + ((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.6), pos.getZ() + 0.5 + ((worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.6), 0.0D, 0.0D, 0.0D);
			}else{
				worldIn.spawnParticle(type, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0D, 0.0D, 0.0D);
			}
		}
	}

	/**
	 * Used to spawn a particle at the middle of a block. No randomization.
	 * @param type
	 * @param pos
	 * @param worldIn
	 */
	public static void spawnParticleAtBlockMiddle(EnumParticleTypes type, BlockPos pos, World worldIn) {
		if (worldIn != null && type != null && pos != null) {
			worldIn.spawnParticle(type, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0D, 0.0D, 0.0D);
		}
	}

	/**
	 * Spawns the particles you see when unstable glass shatters.
	 * @param pos
	 * @param worldIn
	 */
	public static void spawnUnstableParticles(BlockPos pos, World worldIn) {
		for(int i = 0; i < 4; i++) {
			spawnParticleAtBlockMiddle(EnumParticleTypes.CLOUD, pos, worldIn, true);
			spawnParticleAtBlockMiddle(EnumParticleTypes.SPELL_INSTANT, pos, worldIn, true);
			spawnParticleAtBlockMiddle(EnumParticleTypes.SPELL_MOB, pos, worldIn, true);
			worldIn.spawnParticle(EnumParticleTypes.SPELL_MOB, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, worldIn.rand.nextFloat()*100D, worldIn.rand.nextFloat()*100D, worldIn.rand.nextFloat()*100D);
		}
	}

	/**
	 * Plays a sound at the middle of a block.
	 * @param soundPath
	 * @param worldIn
	 * @param pos
	 */
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos) {
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, 1, 1);
	}

	/**
	 * Plays a sound at the middle of a block. Volume can be changed.
	 * @param soundPath
	 * @param worldIn
	 * @param pos
	 * @param volume
	 */
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, float volume) {
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume, 1);
	}

	/**
	 * Plays a sound at the middle of a block. Volume and pitch can be changed.
	 * @param soundPath
	 * @param worldIn
	 * @param pos
	 * @param volume
	 * @param pitch
	 */
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, float volume, float pitch) {
		worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume, pitch);
	}
	

	/**
	 * Plays a sound at the middle of a block. Volume and pitch can be changed and is randomized in a certain tolerance zone.
	 * @param soundPath
	 * @param worldIn
	 * @param pos
	 * @param volume
	 * @param pitch
	 * @param randomizeSound
	 */
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, float volume, float pitch, boolean randomizeSound) {
		if (randomizeSound) {
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F, pitch + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F);
		}else{
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, volume, pitch);
		}
	}
	
	/**
	 * Plays a sound at the middle of a block. The pitch and volume is randomized in a certain tolerance zone.
	 * @param soundPath
	 * @param worldIn
	 * @param pos
	 * @param randomizeSound
	 */
	public static void playSoundAtBlockMiddle(String soundPath, World worldIn, BlockPos pos, boolean randomizeSound) {
		if (randomizeSound) {
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, 1 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F, 1 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.2F);
		}else{
			worldIn.playSoundEffect(pos.getX(), pos.getY(), pos.getZ(), soundPath, 1, 1);
		}
	}
}
