package com.modernpatriot.reimaginedindustries.achievements;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * List and implementation of all custom achievements
 * @author MoPat
 */
public class AchievementLists {
	// Blocks
	public static Achievement Achievement_woodenStructure;
	public static Achievement Achievement_smoothStructure;
	public static Achievement Achievement_netherStructure;
	public static Achievement Achievement_reinforcedStructure;
	// Gearboxes
	public static Achievement Achievement_basicGearbox;
	public static Achievement Achievement_advancedGearbox;
	public static Achievement Achievement_reinforcedGearbox;
	// Ores
	public static Achievement Achievement_oreMagnetite;
	public static Achievement Achievement_oreChromite;
	public static Achievement Achievement_oreWolframite;
	public static Achievement Achievement_oreRhodochrosite;
	public static Achievement Achievement_orePromethium;
	// Records
	public static Achievement Achievement_recordMaze;
	public static Achievement Achievement_recordWaves;
	public static Achievement Achievement_recordLost;
	// Items
	public static Achievement Achievement_superGlue;
	
	/**
	 * Registers the achievements and the achievement page
	 */
	public static void mainRegistry() {
		// Crafted Block
		Achievement_woodenStructure = new Achievement("achievement.woodenStructureC", "woodenStructureC", 0, 0, ReimaginedBlocks.woodenStructure, null);
		Achievement_smoothStructure = new Achievement("achievement.smoothStructureC", "smoothStructureC", 2, -1, ReimaginedBlocks.smoothStructure, Achievement_woodenStructure);
		Achievement_netherStructure = new Achievement("achievement.netherStructureC", "netherStructureC", 4, -1, ReimaginedBlocks.netherStructure, Achievement_smoothStructure);
		Achievement_reinforcedStructure = new Achievement("achievement.reinforcedStructureC", "reinforcedStructureC", 5, 1, ReimaginedBlocks.reinforcedStructure, Achievement_netherStructure).setSpecial();
		Achievement_basicGearbox = new Achievement("achievement.basicGearboxC", "basicGearboxC", 0, 2, ReimaginedBlocks.basicGearbox, null);
		Achievement_advancedGearbox = new Achievement("achievement.advancedGearboxC", "advancedGearboxC", 2, 3, ReimaginedBlocks.advancedGearbox, Achievement_basicGearbox);
		Achievement_reinforcedGearbox = new Achievement("achievement.reinforcedGearboxC", "reinforcedGearboxC", 4, 4, ReimaginedBlocks.basicGearbox, Achievement_advancedGearbox).setSpecial();
		
		// Crafted Item
		Achievement_superGlue = new Achievement("achievement.superGlueC", "superGlueC", 2, 1, ReimaginedItems.superGlue, Achievement_woodenStructure);
		
		// Ore Pickup
		Achievement_oreMagnetite = new Achievement("achievement.oreMagnetiteP", "oreMagnetiteP", 8, 4, Item.getItemFromBlock(ReimaginedBlocks.oreMagnetite), null);
		Achievement_oreChromite = new Achievement("achievement.oreChromiteP", "oreChromiteP", 8, 2, Item.getItemFromBlock(ReimaginedBlocks.oreChromite), Achievement_oreMagnetite);
		Achievement_oreWolframite = new Achievement("achievement.oreWolframiteP", "oreWolframiteP", 6, 4, Item.getItemFromBlock(ReimaginedBlocks.oreWolframite), Achievement_oreMagnetite);
		Achievement_oreRhodochrosite = new Achievement("achievement.oreRhodochrositeP", "oreRhodochrositeP", 10, 4, Item.getItemFromBlock(ReimaginedBlocks.oreRhodochrosite), Achievement_oreMagnetite);
		Achievement_orePromethium = new Achievement("achievement.orePromethiumP", "orePromethiumP", 8, 6, Item.getItemFromBlock(ReimaginedBlocks.orePromethium), Achievement_oreMagnetite).setSpecial();
		
		// Item Pickup
		Achievement_recordMaze = new Achievement("achievement.recordMazeP", "recordMazeP", 11, 3, ReimaginedItems.recordMaze, Achievement_oreMagnetite);
		Achievement_recordWaves = new Achievement("achievement.recordWavesP", "recordWavesP", 11, 5, ReimaginedItems.recordWaves, Achievement_oreMagnetite);
		Achievement_recordLost = new Achievement("achievement.recordLostP", "recordLostP", 12, 4, ReimaginedItems.recordLost, Achievement_oreMagnetite);
		
		// Achievement Page
		AchievementPage.registerAchievementPage(new AchievementPage("Reimagined Industries", new Achievement[]{Achievement_woodenStructure, Achievement_smoothStructure, Achievement_netherStructure, Achievement_reinforcedStructure, Achievement_basicGearbox, Achievement_superGlue, Achievement_advancedGearbox, Achievement_reinforcedGearbox, Achievement_oreMagnetite, Achievement_oreChromite, Achievement_oreRhodochrosite, Achievement_orePromethium, Achievement_oreWolframite, Achievement_recordMaze, Achievement_recordWaves, Achievement_recordLost}));
		
		FMLCommonHandler.instance().bus().register(new AchievementEvents());
	}
}
