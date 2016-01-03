package com.modernpatriot.reimaginedindustries.world;

import com.modernpatriot.reimaginedindustries.world.worldGen.WorldNatureGen;

import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldRegistry {

	public static void MainRegistry() {
		registerWorldGen(new WorldNatureGen(), 1);
		
	}
	
	public static void registerWorldGen(IWorldGenerator IGenerator, int weightedProbability){
		GameRegistry.registerWorldGenerator(IGenerator, weightedProbability);
		
		
	}
	
}
