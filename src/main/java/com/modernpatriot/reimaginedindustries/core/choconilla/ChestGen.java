package com.modernpatriot.reimaginedindustries.core.choconilla;

import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

public class ChestGen {
	
	public static void init() {
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordMaze), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordWaves), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordLost), 1, 1, 5));
    	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordMaze), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordWaves), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordLost), 1, 1, 5));
    	ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordMaze), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordWaves), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordLost), 1, 1, 20));
    	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordMaze), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordWaves), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordLost), 1, 1, 2));
    	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordMaze), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordWaves), 1, 1, 10));
    	ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(ReimaginedItems.recordLost), 1, 1, 20));
	}

}
