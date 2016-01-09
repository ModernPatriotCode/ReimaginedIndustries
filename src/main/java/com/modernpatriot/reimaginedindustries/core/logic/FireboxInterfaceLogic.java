package com.modernpatriot.reimaginedindustries.core.logic;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Important parts of the code behind the fireboxInterface. Separate for easier and tidier usage.
 * @author MoPat
 */
public class FireboxInterfaceLogic {
	
	/**
	 * Checks if the items inside are part of a firebox recipe.
	 * @param stack1
	 * @param stack2
	 * @param stack3
	 * @return
	 */
	public static boolean isPartOfRecipeItems(ItemStack stack1, ItemStack stack2, ItemStack stack3) {
		if(stack1.getItem().equals(new ItemStack(Item.getItemFromBlock(Blocks.log),1,OreDictionary.WILDCARD_VALUE).getItem())||stack2.getItem().equals(new ItemStack(Item.getItemFromBlock(Blocks.log),1,OreDictionary.WILDCARD_VALUE).getItem())||stack3.getItem().equals(new ItemStack(Item.getItemFromBlock(Blocks.log),1,OreDictionary.WILDCARD_VALUE).getItem())|| stack1.getItem().equals(new ItemStack(Item.getItemFromBlock(Blocks.log2),1,OreDictionary.WILDCARD_VALUE).getItem())|| stack2.getItem().equals(new ItemStack(Item.getItemFromBlock(Blocks.log2),1,OreDictionary.WILDCARD_VALUE).getItem())|| stack3.getItem().equals(new ItemStack(Item.getItemFromBlock(Blocks.log2),1,OreDictionary.WILDCARD_VALUE).getItem())){
			return true;
		}else{
			return false;
		}
	}
	
}
