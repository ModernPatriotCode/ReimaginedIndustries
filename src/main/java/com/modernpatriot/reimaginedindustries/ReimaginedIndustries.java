package com.modernpatriot.reimaginedindustries;
// W E L C O M E   T O   T H E   M A I N   F I L E 

import scala.Console;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.modernpatriot.reimaginedindustries.achievements.AchievementLists;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;
import com.modernpatriot.reimaginedindustries.tileentity.TileEntityMainRegistry;
import com.modernpatriot.reimaginedindustries.world.WorldRegistry;
import com.modernpatriot.reimaginedindustries.world.biomes.BiomeExWasteland;
import com.modernpatriot.reimaginedindustries.world.biomes.BiomeRegistry;
import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.core.choconilla.ChestGen;
import com.modernpatriot.reimaginedindustries.core.choconilla.RIFuel;
import com.modernpatriot.reimaginedindustries.core.choconilla.RIRecipes;
import com.modernpatriot.reimaginedindustries.core.choconilla.VanillaEntityProvider;
import com.modernpatriot.reimaginedindustries.core.gui.tabs.IndustriesOreTab;
import com.modernpatriot.reimaginedindustries.core.gui.tabs.IndustriesSpecialTab;
import com.modernpatriot.reimaginedindustries.core.gui.tabs.IndustriesTab;
import com.modernpatriot.reimaginedindustries.core.integration.oredictionary.OreDictionaryRegistryBlocks;
import com.modernpatriot.reimaginedindustries.core.integration.oredictionary.OreDictionaryRegistryItems;
import com.modernpatriot.reimaginedindustries.core.integration.oredictionary.OreDictionaryRegistryRecipies;
import com.modernpatriot.reimaginedindustries.core.network.DescHandler;
import com.modernpatriot.reimaginedindustries.core.network.NetworkHandlerMain;
import com.modernpatriot.reimaginedindustries.core.util.config.ReimaginedConfig;
import com.modernpatriot.reimaginedindustries.core.util.handlers.GUIHandler;
import com.modernpatriot.reimaginedindustries.core.util.handlers.TickHandler;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;



@Mod(modid = Reference.MODID, name = Reference.MODNAME, version = Reference.VERSION, guiFactory = Reference.GUIFACTORYCLASS)
public class ReimaginedIndustries
{
	public static boolean isClientRunning;

	public static Configuration configuration;

	@SidedProxy(clientSide = Reference.CLIENTPROXYCLASS, serverSide = Reference.SERVERPROXYCLASS)
	public static CommonProxy proxy;

	public static final IndustriesTab tabIndustries = new IndustriesTab("tabIndustries");
	public static final IndustriesOreTab tabIndustriesOre = new IndustriesOreTab("tabIndustriesOre");
	public static final IndustriesSpecialTab tabIndustriesSpecial = new IndustriesSpecialTab("tabIndustriesSpecial");

	@Mod.Instance(Reference.MODID)
	public static ReimaginedIndustries instance = new ReimaginedIndustries();

	@EventHandler
	public void preInit (FMLPreInitializationEvent event)
	{
		//   N E T W O R K   &   P R O X Y
		isClientRunning = event.getSide().isClient();
		this.proxy.preInit(event);
		NetworkHandlerMain.init();

		//   B L O C K S
		ReimaginedBlocks.init();
		ReimaginedBlocks.register();

		//   I T E M S
		ReimaginedItems.init();
		ReimaginedItems.register();

		//   T I L E E N T I T I E S
		TileEntityMainRegistry.init();

		//   U T I L
		DescHandler.init();


		//   B I O M E S
		BiomeRegistry.MainBiome();
		/*BiomeManager.addBiome(BiomeType.WARM, new BiomeEntry(new BiomeExWasteland(66), 10));*/

		//   I N T E G R A T I O N
		FMLInterModComms.sendMessage("Waila", "register", "com.modernpatriot.reimaginedindustries.core.integration.waila.WailaRegistry.onWailaCall");

		//   C O N F I G
		configuration = new Configuration(event.getSuggestedConfigurationFile());
		ReimaginedConfig.syncConfig();
	}
	@SubscribeEvent
	public void onConfigChange(ConfigChangedEvent event) {
		if (event.modID.equals(Reference.MODID)) {
			ReimaginedConfig.syncConfig();
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

		//   V A N I L L A   I N T E R A C T I O N
		MinecraftForge.EVENT_BUS.register(new VanillaEntityProvider());
		WorldRegistry.MainRegistry();
		GameRegistry.registerFuelHandler(new RIFuel());
		ChestGen.init();

		//   O R E   D I C T I O N A R Y
		OreDictionaryRegistryBlocks.oreRegistration();
		OreDictionaryRegistryItems.oreRegistration();
		OreDictionaryRegistryRecipies.addOreRecipes();

		//    R E C I P I E S
		RIRecipes.addRecipes();
		FMLCommonHandler.instance().bus().register(new TickHandler());

		//   A C H I E V E M E N T S   &   E V E N T S
		AchievementLists.MainRegistry();

		//   P R O X Y
		this.proxy.init(event);
		proxy.registerRenders();
		
		//	 R E N D E R I N G
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GUIHandler());

		if(isClientRunning) {
		}
	}
	@EventHandler
	public void postInit (FMLPostInitializationEvent event)
	{
		//   P R O X Y
		this.proxy.postInit(event);

		//   M E S S A G E
		System.out.println("Welcome to Reimagined Industries "+ Reference.VERSION +"! Have Fun :)");

	}

}
