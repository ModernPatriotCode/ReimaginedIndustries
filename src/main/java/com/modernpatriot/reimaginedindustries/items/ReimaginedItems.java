package com.modernpatriot.reimaginedindustries.items;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.items.baubles.StarryPendant;
import com.modernpatriot.reimaginedindustries.items.records.RecordLost;
import com.modernpatriot.reimaginedindustries.items.records.RecordMaze;
import com.modernpatriot.reimaginedindustries.items.records.RecordWaves;
import com.modernpatriot.reimaginedindustries.items.story.LostJournal;
import com.modernpatriot.reimaginedindustries.items.tools.IndustrialWrench;
import com.modernpatriot.reimaginedindustries.items.tools.SwordTemplate;
import com.modernpatriot.reimaginedindustries.items.tools.SwordTemplateDiamond;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ReimaginedItems {


	public static Item swordTemplate;
	public static Item swordTemplateDiamond;

	// Sticky Substances
	public static Item stickySubstance;
	public static Item superGlue;

	// Ingots
	public static Item ingotZirconium;

	// Records
	public static Item recordMaze;
	public static Item recordWaves;
	public static Item recordLost;

	// Baubles
	public static Item pendantStarry;

	// Tools
	public static Item industrialWrench;

	//Story
	public static Item lostJournal;


	public static void init() {
		swordTemplate = new SwordTemplate().setUnlocalizedName("swordTemplate").setCreativeTab(ReimaginedIndustries.tabIndustries);
		swordTemplateDiamond = new SwordTemplateDiamond().setUnlocalizedName("swordTemplateDiamond").setCreativeTab(ReimaginedIndustries.tabIndustries);

		stickySubstance = new StickySubstance().setUnlocalizedName("stickySubstance").setCreativeTab(ReimaginedIndustries.tabIndustries);
		superGlue = new SuperGlue().setUnlocalizedName("superGlue").setCreativeTab(ReimaginedIndustries.tabIndustries);

		ingotZirconium = new IngotZirconium().setUnlocalizedName("ingotZirconium").setCreativeTab(ReimaginedIndustries.tabIndustriesOre);

		recordMaze = new RecordMaze("recordMaze").setUnlocalizedName("recordMaze").setCreativeTab(ReimaginedIndustries.tabIndustriesSpecial);
		recordWaves = new RecordWaves("recordWaves").setUnlocalizedName("recordWaves").setCreativeTab(ReimaginedIndustries.tabIndustriesSpecial);
		recordLost = new RecordLost("recordLost").setUnlocalizedName("recordLost").setCreativeTab(ReimaginedIndustries.tabIndustriesSpecial);

		pendantStarry = new StarryPendant().setUnlocalizedName("pendantStarry").setCreativeTab(ReimaginedIndustries.tabIndustriesSpecial);

		industrialWrench = new IndustrialWrench().setUnlocalizedName("industrialWrench").setCreativeTab(ReimaginedIndustries.tabIndustries);

		lostJournal = new LostJournal().setUnlocalizedName("lostJournal").setCreativeTab(ReimaginedIndustries.tabIndustriesSpecial);

	}

	public static void register()
	{
		GameRegistry.registerItem(swordTemplate, swordTemplate.getUnlocalizedName().substring(5));
		swordTemplate.setMaxStackSize(1);

		GameRegistry.registerItem(stickySubstance, stickySubstance.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(superGlue, superGlue.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(ingotZirconium, ingotZirconium.getUnlocalizedName().substring(5));

		GameRegistry.registerItem(recordMaze, recordMaze.getUnlocalizedName().substring(5));
		recordMaze.setMaxStackSize(1);
		GameRegistry.registerItem(recordWaves, recordWaves.getUnlocalizedName().substring(5));
		recordWaves.setMaxStackSize(1);
		GameRegistry.registerItem(recordLost, recordLost.getUnlocalizedName().substring(5));
		recordLost.setMaxStackSize(1);

		GameRegistry.registerItem(pendantStarry, pendantStarry.getUnlocalizedName().substring(5));
		pendantStarry.setMaxStackSize(1);

		GameRegistry.registerItem(industrialWrench, industrialWrench.getUnlocalizedName().substring(5));
		industrialWrench.setMaxStackSize(1);

		GameRegistry.registerItem(lostJournal, lostJournal.getUnlocalizedName().substring(5));
		lostJournal.setMaxStackSize(1);
	}

	public static void registerRenders()
	{
		registerRender(swordTemplate);
		registerRender(superGlue);
		registerRender(stickySubstance);
		registerRender(ingotZirconium);
		registerRender(recordMaze);
		registerRender(recordWaves);
		registerRender(recordLost);
		registerRender(pendantStarry);
		registerRender(industrialWrench);
		registerRender(lostJournal);
	}

	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	}

}
