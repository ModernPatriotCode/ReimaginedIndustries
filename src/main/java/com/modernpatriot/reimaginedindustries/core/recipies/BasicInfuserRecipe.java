package com.modernpatriot.reimaginedindustries.core.recipies;

import java.util.List;

import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Contains all BasicInfuserRecipes and their effects.
 */
public class BasicInfuserRecipe {
	
	private ItemStack[] input;
	private ItemStack output;
	private int time;
	private List<BasicInfuserRecipe> recipeList;
	
	/**
	 * Used for creating kindof EnumType-like recipes.
	 * @param inputItems
	 * @param outputItem
	 * @param timeUsedForRecipe (in seconds)
	 */
	public BasicInfuserRecipe(ItemStack[] inputItems, ItemStack outputItem, int timeUsedForRecipe){
		input = inputItems;
		output = outputItem;
		time = timeUsedForRecipe;
	}
	
	/**
	 * Simpler constructor. The time required is always 10 seconds.
	 * @param inputItems
	 * @param outputItem
	 */
	public BasicInfuserRecipe(ItemStack[] inputItems, ItemStack outputItem){
		input = inputItems;
		output = outputItem;
		time = 10;
	}
	
	/**
	 * Returns the input ItemStack.
	 * @return The input ItemStack.
	 */
	public ItemStack[] getInput(){
		return input;
	}
	
	/**
	 * Returns the input ItemStack at a give index.
	 * @param index
	 * @return InputItemStack at index.
	 */
	public ItemStack getInputItemStackAt(int index){
		if(input[index] != null){
			return input[index];
		}else{
			return null;
		}
	}
	
	/**
	 * Returns the input Item at a given index.
	 * @param index
	 * @return InputItem at index.
	 */
	public Item getInputItemAt(int index){
		if(input[index] != null){
			return input[index].getItem();
		}else{
			return null;
		}
	}
	
	/**
	 * Returns the fifth item inside the StackArray (the item in the middle).
	 * @return middleStack
	 */
	public ItemStack getMiddleInput(){
		if (input != null){
			return input[4];
		}else{
			return null;
		}
	}
	
	/**
	 * Returns the output of a recipe.
	 * @return OutputItemStack
	 */
	public ItemStack getOutput() {
		return output;
	}
	
	/**
	 * Returns the OutputItem of a recipe.
	 * @return OutputItem
	 */
	public Item getOutputItem(){
		if(output != null){
			return output.getItem();
		}else{
			return null;
		}
	}
	
	/**
	 * Returns the time the recipe takes for completion (in seconds).
	 * @return time in seconds.
	 */
	public int getTime(){
		return time;
	}
	
	/**
	 * Adds the BasicInfuserRecipe to the recipeList.
	 * @param recipe
	 */
	public void addBasicInfuserRecipe(BasicInfuserRecipe recipe){
		if(recipe != null){
			this.recipeList.add(recipe);
		}else{
			
		}
	}
	
	/**
	 * Returns true if a given recipe would be possible with the given ItemStacks.
	 * @param recipe
	 * @param inputStack
	 * @return true, false or null
	 */
	public boolean isRecipeEqualTo(BasicInfuserRecipe recipe, ItemStack[] inputStack) {
		if(inputStack != null){
			if(inputStack.length > 5 || recipe == null || inputStack[0] == null || inputStack[1] == null || inputStack[2] == null || inputStack[3] == null){
				return false;
			}else if(recipe.getMiddleInput().isItemEqual(inputStack[4])){
				ItemStack[] recipeInStack = recipe.getInput();
				if (recipeInStack[0] == inputStack[0] && recipeInStack[1] == inputStack[1] && recipeInStack[2] == inputStack[2] && recipeInStack[3] == inputStack[3]){
					return true;
				}else if(recipeInStack[1] == inputStack[0] && recipeInStack[2] == inputStack[1] && recipeInStack[3] == inputStack[2] && recipeInStack[0] == inputStack[3]){
					return true;
				}else if(recipeInStack[2] == inputStack[0] && recipeInStack[3] == inputStack[1] && recipeInStack[0] == inputStack[2] && recipeInStack[1] == inputStack[3]){
					return true;
				}else if(recipeInStack[3] == inputStack[0] && recipeInStack[0] == inputStack[1] && recipeInStack[1] == inputStack[2] && recipeInStack[2] == inputStack[3]){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	/**
	 * Returns a basic infuser recipe for the given ItemStacks.
	 * @param inputStack
	 * @return recipe or null.
	 */
	public BasicInfuserRecipe getRecipeForInputItems(ItemStack[] inputStack){
		if(inputStack != null){
			for(int i = 0; i >= recipeList.size(); i++){
				if(recipeList.get(i) != null){
					if(this.isRecipeEqualTo(recipeList.get(i), inputStack)) {
						return recipeList.get(i);
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Called during init. Used for adding the BasicInfuserRecipes to the list.
	 */
	public void preInit(){
		recipeList.add(SWORDTEMPLATEDIAMOND);
	}
	
	public static final BasicInfuserRecipe SWORDTEMPLATEDIAMOND = new BasicInfuserRecipe(new ItemStack[]{new ItemStack(Items.diamond, 1), new ItemStack(Items.diamond, 1), new ItemStack(Items.diamond, 1), new ItemStack(Items.potionitem, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ReimaginedItems.swordTemplate, 1)}, new ItemStack(ReimaginedItems.swordTemplateDiamond));
	
}
