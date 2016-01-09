package com.modernpatriot.reimaginedindustries.core.integration.thaumcraft5;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;


/**
 * Used to work with Thaumcraft 5.0.3 and give Items the ThaumcraftAspects
 * @author MoPat
 */
public class ObjectAspectRegistry {
	
	private static final ResourceLocation IMMOBILITARESOURCE = new ResourceLocation(Reference.MODID, "textures/aspects/tacitioAspect.png");
	private static final ResourceLocation MEMENTORESOURCE = new ResourceLocation(Reference.MODID, "textures/aspects/admontioAspect.png");
	private static final ResourceLocation INSPECTIORESOURCE = new ResourceLocation(Reference.MODID, "textures/aspects/inspectioAspect.png");
	
	public static final Aspect IMMOBILITY = new Aspect("immobilita", 0xE60073, new Aspect[]{Aspect.MOTION, Aspect.ORDER}, IMMOBILITARESOURCE, 1);
	public static final Aspect MEMORY = new Aspect("memento", 0x00D17D, new Aspect[]{Aspect.MIND, IMMOBILITY}, MEMENTORESOURCE, 1);
	public static final Aspect CONTROL = new Aspect("inspectio", 0xFFA600, new Aspect[]{Aspect.SENSES, Aspect.ORDER}, INSPECTIORESOURCE, 1);
	
	/**
	 * Called in the ReimaginedIndustries mainfile init(){}. Registers aspects for custom and vanilla blocks and items.
	 */
	public static void registerAspectsForItemsAndBlocks(){
		ThaumcraftApi.registerObjectTag(new ItemStack(Items.painting), new AspectList().add(IMMOBILITY, 2).add(MEMORY, 4).add(Aspect.PLANT, 2).add(Aspect.SENSES, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(ReimaginedItems.industrialWrench), new AspectList().add(Aspect.MECHANISM, 5).add(Aspect.ENERGY, 2).add(Aspect.METAL, 2).add(Aspect.TOOL, 5).add(Aspect.CRYSTAL, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(Item.getItemFromBlock(ReimaginedBlocks.fireboxInterface)), new int[]{OreDictionary.WILDCARD_VALUE}, new AspectList().add(Aspect.FIRE, 10).add(Aspect.ENERGY, 4).add(Aspect.EXCHANGE, 6).add(Aspect.CRAFT, 2).add(Aspect.DARKNESS, 1).add(Aspect.AIR, 1));
	}
	
}
