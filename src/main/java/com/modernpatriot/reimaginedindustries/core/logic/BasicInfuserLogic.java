package com.modernpatriot.reimaginedindustries.core.logic;

import com.modernpatriot.reimaginedindustries.core.recipies.BasicInfuserRecipe;
import com.modernpatriot.reimaginedindustries.core.util.UtilStrings;
import com.modernpatriot.reimaginedindustries.items.tools.SwordTemplate;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Important basic infuser code. Separate for easier usage.
 * @author MoPat
 */
public class BasicInfuserLogic {
	private static int itemCountOne;
	private static String whatItemIsOne;

	private static int itemCountTwo;
	private static String whatItemIsTwo;

	private static int itemCountThree;
	private static String whatItemIsThree;

	private static int itemCountFour;
	private static String whatItemIsFour;
	
	/**
	 * Checks the items inside the BasicGearboxes and changes variables accordingly.
	 * @param infusionItems
	 * @param pos
	 * @param worldIn
	 * @param playerIn
	 * @param bgd
	 */
	public static void checkForRecipeItems(ItemStack[] infusionItems, BlockPos pos, World worldIn, EntityPlayer playerIn, BasicGearboxData bgd) {

		double x = pos.getX();
		double y = pos.getY();
		double z = pos.getZ();
		BlockPos pos1 = new BlockPos(x+3,y-1,z);
		BlockPos pos2 = new BlockPos(x,y-1,z+3);
		BlockPos pos3 = new BlockPos(x-3,y-1,z);
		BlockPos pos4 = new BlockPos(x,y-1,z-3);
		for(int i = 0; i <= 3; i++) {
			if(infusionItems[i].getItem() == Items.diamond) {
				whatItemIsOne = UtilStrings.DIAMOND;
				itemCountOne++;
			}
			if(infusionItems[i] == new ItemStack(Item.getItemFromBlock(Blocks.log), 1, OreDictionary.WILDCARD_VALUE) || infusionItems[i] == new ItemStack(Item.getItemFromBlock(Blocks.log2), 1, OreDictionary.WILDCARD_VALUE)) {
				whatItemIsOne = UtilStrings.WOODLOG;
				itemCountOne++;
			}
			if(infusionItems[i].getItem() == Items.iron_ingot) {
				whatItemIsOne = UtilStrings.IRON;
				itemCountOne++;
			}
			if(infusionItems[i].getItem() == Items.gold_ingot) {
				whatItemIsTwo = UtilStrings.GOLD;
				itemCountTwo++;
			}
		}

		executeRecipe(bgd, pos, worldIn, playerIn);
	}

	
	/**
	 * Checks if a recipe requirement is fulfilled and begins with crafting accordingly.
	 * @param bgd
	 * @param pos
	 * @param worldIn
	 * @param playerIn
	 */
	public static void executeRecipe(BasicGearboxData bgd, BlockPos pos, World worldIn, EntityPlayer playerIn) {
		if(bgd.getInventoryContent().getItem() instanceof SwordTemplate) {
			if(whatItemIsOne.equals("diamond") && itemCountOne == 2 && whatItemIsTwo.equals("gold") && itemCountTwo == 2) {
				worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.click", 0.3F, 1.3F-(worldIn.rand.nextFloat()*0.1F));
				worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.orb", 0.6F, 0.6F-(worldIn.rand.nextFloat()*0.2F));
				//BasicInfuserRecipe.infusionSwordTemplateDiamond(pos, playerIn, worldIn, bgd);
				clearVariables();
			}
		}else{
			clearVariables();
		}

	}
	
	/**
	 * Clears all variables.
	 */
	public static void clearVariables() {
		whatItemIsOne = UtilStrings.EMPTY;
		itemCountOne = 0;
		whatItemIsTwo = UtilStrings.EMPTY;
		itemCountTwo = 0;
		whatItemIsThree = UtilStrings.EMPTY;
		itemCountThree = 0;
		whatItemIsFour = UtilStrings.EMPTY;
		itemCountFour = 0;
	}
}

