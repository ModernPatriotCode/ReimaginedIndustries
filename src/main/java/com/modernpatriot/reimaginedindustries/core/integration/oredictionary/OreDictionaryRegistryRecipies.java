package com.modernpatriot.reimaginedindustries.core.integration.oredictionary;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistryRecipies {
	
	public static void addOreRecipes()
    {
		/*  EXAMPLE: GameRegistry.addRecipe(new ShapedOreRecipe(ReimaginedItems.superGlue, true, new Object[]{
            		"AAA",
            		"A A",
            		"AAA", 'A', "slimeball"})); */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.woodenStructure), 2), true, new Object[]{
			"BBB",
			"ASA",
			"BBB",
			'B', "treeWood" , 'A', "plankWood" , 'S', "slimeball"}));
            
            
    }
	

}
