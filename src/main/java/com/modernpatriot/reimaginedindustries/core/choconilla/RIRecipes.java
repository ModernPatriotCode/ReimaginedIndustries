package com.modernpatriot.reimaginedindustries.core.choconilla;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.integration.oredictionary.OreDictionaryRegistryItems;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * <h1> Main crafting recipe class </h1>
 * Adds the custom recipes for ReimaginedIndustries.
 * @author MoPat
 */
public class RIRecipes
{
	public static void addRecipes()
	 {
		// Recipes that require an event to happen are all in AchievementEvents
		
		GameRegistry.addRecipe(new ItemStack(ReimaginedBlocks.cobbleStructure, 2),
				"BBB",
				"ASA",
				"BBB",
				'B', Blocks.cobblestone , 'A', Blocks.cobblestone_wall , 'S', ReimaginedItems.stickySubstance);
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ReimaginedItems.stickySubstance), Items.slime_ball, Blocks.sand, Items.water_bucket, Blocks.leaves);
		GameRegistry.addShapelessRecipe(new ItemStack(ReimaginedItems.superGlue), ReimaginedItems.stickySubstance, ReimaginedItems.stickySubstance, Items.slime_ball, Blocks.sand, Items.water_bucket, Blocks.leaves);
		GameRegistry.addShapelessRecipe(new ItemStack(ReimaginedItems.stickySubstance), Items.slime_ball, Blocks.sand, Items.potionitem, Blocks.leaves);
		GameRegistry.addShapelessRecipe(new ItemStack(ReimaginedItems.superGlue), ReimaginedItems.stickySubstance, ReimaginedItems.stickySubstance, Items.slime_ball, Blocks.sand, Items.potionitem, Blocks.leaves);
	}
}
