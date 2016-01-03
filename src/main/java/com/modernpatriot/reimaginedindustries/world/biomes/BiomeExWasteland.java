package com.modernpatriot.reimaginedindustries.world.biomes;

import java.util.Random;

import net.minecraft.client.particle.EntityBubbleFX;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.item.EntityMinecartEmpty;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeExWasteland extends BiomeGenBase{

	BiomeDecoratorWasteland specialDeco;
	
	public BiomeExWasteland(int biomeId) {
		super(biomeId);
		BiomeDecoratorWasteland biomeDecorator = new BiomeDecoratorWasteland(this);
		specialDeco = (BiomeDecoratorWasteland)biomeDecorator;
		specialDeco.deadbushGen = 11;
		
		biomeName = "Extreme Wasteland WIP";
		
		setHeight(height_LowPlains);
		topBlock = Blocks.cobblestone.getDefaultState();
		fillerBlock = Blocks.gravel.getDefaultState();
		
		specialDeco.deadbushGen = 11;
		
		enableRain = false;
		enableSnow = false;
		theBiomeDecorator.generateLakes = false;
		
		spawnableCaveCreatureList.clear();
		spawnableCaveCreatureList.add(new SpawnListEntry(EntityBlaze.class, 6, 1, 3));
		spawnableCaveCreatureList.add(new SpawnListEntry(EntitySkeleton.class, 60, 2, 6));
		spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 40, 5, 10));
		spawnableCaveCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 4, 2, 3));
		spawnableCreatureList.clear();
		spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 2, 1, 3));
		spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 40, 2, 5));
		spawnableCreatureList.add(new SpawnListEntry(EntityCaveSpider.class, 40, 1, 3));
		spawnableCreatureList.add(new SpawnListEntry(EntityLightningBolt.class, 1, 1, 3));
		spawnableMonsterList.clear();
		spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 1, 2, 3));
		spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 2, 2, 3));
		spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 2, 2, 3));
		spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 40, 3, 6));
		spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 5, 4, 5));
		spawnableMonsterList.add(new SpawnListEntry(EntityBat.class, 8, 2, 3));
		spawnableMonsterList.add(new SpawnListEntry(EntityGiantZombie.class, 1, 1, 1));
	}
	
	@Override
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x9E9E9E;
	}
	@Override
	public int getGrassColorAtPos(BlockPos p_180627_1_) {
		return 0xB1C97B;
	}
	@Override
	public int getWaterColorMultiplier() {
		return 0x94887F;
	}
	@Override
	public int getFoliageColorAtPos(BlockPos p_180625_1_) {
		return 0xC9C87B;
	}
	
}
