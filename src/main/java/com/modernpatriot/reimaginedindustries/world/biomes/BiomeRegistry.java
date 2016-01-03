package com.modernpatriot.reimaginedindustries.world.biomes;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;

public class BiomeRegistry {
	
	public static void MainBiome() {
		BiomeRegistry.initBiome();
		BiomeRegistry.regBiome();
	}
	
	public static BiomeGenBase extremeWasteland;
	
	
	public static void initBiome() {
		extremeWasteland = new BiomeExWasteland(66).setBiomeName("extremeWasteland");
		
	}
	public static void regBiome() {
		BiomeDictionary.registerBiomeType(extremeWasteland, Type.WASTELAND);
		BiomeManager.addSpawnBiome(extremeWasteland);
	}

}
