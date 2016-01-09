package com.modernpatriot.reimaginedindustries.achievements;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Gives achievements when the required objective is completed and adds crafting recipes once specific achievements are completed.
 * @author MoPat
 */
public class AchievementEvents {

	/**
	 * Gives achievements/adds crafting recipes once certain blockcrafting objectives are completed
	 * @param e
	 */
	@SubscribeEvent
	public void onBlockCrafted(PlayerEvent.ItemCraftedEvent e) {
		if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.woodenStructure))) {
			e.player.addStat(AchievementLists.Achievement_woodenStructure, 1);
			GameRegistry.addRecipe(new ItemStack(ReimaginedBlocks.smoothStructure, 1),
					"CBC",
					"ASA",
					"CBC",
					'B', Blocks.stone , 'A', Blocks.cobblestone , 'C', Blocks.stone_slab, 'S', ReimaginedItems.stickySubstance);
		}
		else if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.smoothStructure))) {
			e.player.addStat(AchievementLists.Achievement_smoothStructure, 1);
			GameRegistry.addRecipe(new ItemStack(ReimaginedBlocks.netherStructure, 1),
					"CBC",
					"ASA",
					"CBC",
					'B', Blocks.netherrack , 'A', Blocks.nether_brick_fence , 'C', Blocks.nether_brick, 'S', ReimaginedItems.superGlue);
		}
		else if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.netherStructure))) {
			e.player.addStat(AchievementLists.Achievement_netherStructure, 1);
		}
		else if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.reinforcedStructure))) {
			e.player.addStat(AchievementLists.Achievement_reinforcedStructure, 1);
		}
		else if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.basicGearbox))) {
			e.player.addStat(AchievementLists.Achievement_basicGearbox, 1);
		}
		else if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.advancedGearbox))) {
			e.player.addStat(AchievementLists.Achievement_advancedGearbox, 1);
		}
		else if(e.crafting.getItem().equals(Item.getItemFromBlock(ReimaginedBlocks.reinforcedGearbox))) {
			e.player.addStat(AchievementLists.Achievement_reinforcedGearbox, 1);
		}
	}
	
	//  N o t   n e c e s s a r y   b u t   I   l i k e   t o   k e e p   t h i n g s   s e p a r a t e d
	
	/**
	 * Gives achievements/adds crafting recipes once certain itemcrafting objectives are completed
	 * @param e
	 */
	@SubscribeEvent
	public void onItemCrafted(PlayerEvent.ItemCraftedEvent e) {
		if(e.crafting.getItem().equals(ReimaginedItems.superGlue)) {
			e.player.addStat(AchievementLists.Achievement_superGlue, 1);
		}
	}
	
	/**
	 * Gives achievements/adds crafting recipes once certain itempickup objectives are completed
	 * @param e
	 */
	@SubscribeEvent
	public void onItemPickup(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ReimaginedItems.recordMaze))) {
			e.player.addStat(AchievementLists.Achievement_recordMaze, 1);
		}else if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ReimaginedItems.recordWaves))) {
			e.player.addStat(AchievementLists.Achievement_recordWaves, 1);
		}else if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(ReimaginedItems.recordLost))) {
			e.player.addStat(AchievementLists.Achievement_recordLost, 1);
		}
	}
	
	/**
	 * Gives achievements/adds crafting recipes once certain orepickup objectives are completed
	 * @param e
	 */
	@SubscribeEvent
	public void onOrePickup(PlayerEvent.ItemPickupEvent e) {
		if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.oreMagnetite)))) {
			e.player.addStat(AchievementLists.Achievement_oreMagnetite, 1);
		}else if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.oreChromite)))) {
			e.player.addStat(AchievementLists.Achievement_oreChromite, 1);
		}else if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.oreWolframite)))) {
			e.player.addStat(AchievementLists.Achievement_oreWolframite, 1);
		}else if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.oreRhodochrosite)))) {
			e.player.addStat(AchievementLists.Achievement_oreRhodochrosite, 1);
		}else if(e.pickedUp.getEntityItem().isItemEqual(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.orePromethium)))) {
			e.player.addStat(AchievementLists.Achievement_orePromethium, 1);
		}
	}
	
}

