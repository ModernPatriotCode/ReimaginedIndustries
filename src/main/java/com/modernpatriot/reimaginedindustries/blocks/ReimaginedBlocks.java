// Includes Basic Block code

package com.modernpatriot.reimaginedindustries.blocks;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.blocks.gearbox.AdvancedGearbox;
import com.modernpatriot.reimaginedindustries.blocks.gearbox.BasicGearbox;
import com.modernpatriot.reimaginedindustries.blocks.gearbox.ReinforcedGearbox;
import com.modernpatriot.reimaginedindustries.blocks.holy.AngelicAltar;
import com.modernpatriot.reimaginedindustries.blocks.holy.EtherealLamp;
import com.modernpatriot.reimaginedindustries.blocks.multiblock.EnchantedBricks;
import com.modernpatriot.reimaginedindustries.blocks.multiblock.EnchantedBricksFormed;
import com.modernpatriot.reimaginedindustries.blocks.multiblock.FireboxInterface;
import com.modernpatriot.reimaginedindustries.blocks.multiblock.FireboxInterfaceActive;
import com.modernpatriot.reimaginedindustries.blocks.nature.BlockDust;
import com.modernpatriot.reimaginedindustries.blocks.nature.BlockLoam;
import com.modernpatriot.reimaginedindustries.blocks.ore.BlockOreCommon;
import com.modernpatriot.reimaginedindustries.blocks.ore.BlockOreRare;
import com.modernpatriot.reimaginedindustries.blocks.ore.BlockOreUncommon;
import com.modernpatriot.reimaginedindustries.blocks.structures.AdvancedBlock;
import com.modernpatriot.reimaginedindustries.blocks.structures.Structure;
import com.modernpatriot.reimaginedindustries.blocks.utilblocks.EtherealLightSource;
import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.items.itemblock.AdvancedBlockItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.AdvancedGearboxItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.AngelicAltarItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.BasicGearboxItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.CommonOreItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.EnchantedBricksItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.EtherealLampItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.FireboxInterfaceItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.IndustrialLoamItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.RareOreItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.ReinforcedGearboxItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.UncommonOreItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.UnstableDustItem;
import com.modernpatriot.reimaginedindustries.items.itemblock.UnstableGlassItem;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * <h1> ReimaginedIndustries blockregistry </h1>
 * Registers blocks and itemblocks and gives them some basic properties.
 * @author MoPat
 *
 */
public class ReimaginedBlocks {

	//Structures

	public static Block woodenStructure;
	public static Block cobbleStructure;
	public static Block smoothStructure;
	public static Block netherStructure;

	public static Block reinforcedStructure;
	public static Item reinforcedStructureItem;

	//Gearboxes

	public static Block basicGearbox;
	public static Item basicGearboxItem;

	public static Block advancedGearbox;
	public static Item advancedGearboxItem;

	public static Block reinforcedGearbox;
	public static Item reinforcedGearboxItem;

	//Basic Blocks

	public static Block industrialLoam;
	public static Block unstableGlass;
	public static Block unstableGlassColored;

	//Natural

	public static Block unstableDust;
	public static Item unstableDustItem;

	public static Block orePromethium;
	public static Block oreRhodochrosite;
	public static Block oreChromite;
	public static Block orePyrolusite;
	public static Block oreWolframite;
	public static Block oreBaddeleyite;
	public static Block oreSperrylite;
	public static Block oreMagnetite;

	//Multiblock

	public static Block basicGearboxFormed;

	public static Block enchantedBricks;
	public static Block enchantedBricksFormed;
	public static Block fireboxInterface;
	public static Block fireboxInterfaceActive;

	//Fluid 

	public static Block moltenLux;
	public static Fluid moltenLuxFluid;
	public static Material moltenLuxMaterial;

	//Holy

	public static Block angelicAltar;
	public static Block etherealLightSource;
	public static Block etherealLamp;

	// Initialization

	/**
	 * Defines the blocks as being a new instance of the blockfiles and gives the basic properties.
	 */
	public static void init()
	{
		// Block initialization + material

		// S T R U C T U R E S
		woodenStructure = new BasicBlock(Material.wood).setUnlocalizedName("woodenStructure").setHardness(3.0F).setStepSound(Block.soundTypeWood).setCreativeTab(ReimaginedIndustries.tabIndustries);
		cobbleStructure = new Structure(Material.rock).setUnlocalizedName("cobbleStructure").setHardness(4.0F).setStepSound(Block.soundTypeStone).setCreativeTab(ReimaginedIndustries.tabIndustries);
		smoothStructure = new Structure(Material.rock).setUnlocalizedName("smoothStructure").setHardness(4.0F).setStepSound(Block.soundTypeStone).setCreativeTab(ReimaginedIndustries.tabIndustries);
		netherStructure = new Structure(Material.rock).setUnlocalizedName("netherStructure").setHardness(1.0F).setStepSound(Block.soundTypeStone).setCreativeTab(ReimaginedIndustries.tabIndustries);
		reinforcedStructure = new AdvancedBlock(Material.iron).setUnlocalizedName("reinforcedStructure").setHardness(6.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(ReimaginedIndustries.tabIndustries);
		reinforcedStructureItem = new AdvancedBlockItem(reinforcedStructure);

		// G E A R B O X E S 
		basicGearbox = new BasicGearbox(Material.anvil).setUnlocalizedName("basicGearbox").setHardness(8.0F).setStepSound(Block.soundTypeWood).setCreativeTab(ReimaginedIndustries.tabIndustries);
		basicGearboxItem = new BasicGearboxItem(basicGearbox);

		advancedGearbox = new AdvancedGearbox(Material.anvil).setUnlocalizedName("advancedGearbox").setHardness(10.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(ReimaginedIndustries.tabIndustries);
		advancedGearboxItem = new AdvancedGearboxItem(advancedGearbox);

		reinforcedGearbox = new ReinforcedGearbox(Material.anvil).setUnlocalizedName("reinforcedGearbox").setHardness(12.0F).setStepSound(Block.soundTypeMetal).setCreativeTab(ReimaginedIndustries.tabIndustries);
		reinforcedGearboxItem = new ReinforcedGearboxItem(reinforcedGearbox);

		// U N S T A B L E (Tier1)
		unstableDust = new BlockDust(Material.sand).setUnlocalizedName("unstableDust").setHardness(1.5F).setStepSound(Block.soundTypeSand).setCreativeTab(ReimaginedIndustries.tabIndustries);
		unstableDustItem = new UnstableDustItem(unstableDust);
		industrialLoam = new BlockLoam(Material.sand).setUnlocalizedName("industrialLoam").setHardness(2.5F).setStepSound(Block.soundTypeSand).setCreativeTab(ReimaginedIndustries.tabIndustries);
		unstableGlass = new UnstableGlassFragile(Material.glass, false).setUnlocalizedName("unstableGlass").setHardness(0.25F).setStepSound(Block.soundTypeGlass).setCreativeTab(ReimaginedIndustries.tabIndustries);
		unstableGlassColored = new UnstableGlassFragile(Material.glass, false).setUnlocalizedName("unstableGlassColored").setHardness(0.3F).setStepSound(Block.soundTypeGlass).setCreativeTab(ReimaginedIndustries.tabIndustries);

		// O R E S
		orePromethium = new BlockOreRare(Material.rock).setUnlocalizedName("orePromethium").setHardness(5.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		oreSperrylite = new BlockOreRare(Material.rock).setUnlocalizedName("oreSperrylite").setHardness(5.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		oreWolframite = new BlockOreUncommon(Material.rock).setUnlocalizedName("oreWolframite").setHardness(8.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		oreBaddeleyite = new BlockOreUncommon(Material.rock).setUnlocalizedName("oreBaddeleyite").setHardness(5.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		oreChromite = new BlockOreUncommon(Material.rock).setUnlocalizedName("oreChromite").setHardness(5.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		oreMagnetite = new BlockOreUncommon(Material.rock).setUnlocalizedName("oreMagnetite").setHardness(3.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		orePyrolusite = new BlockOreCommon(Material.rock).setUnlocalizedName("orePyrolusite").setHardness(4.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);
		oreRhodochrosite = new BlockOreCommon(Material.rock).setUnlocalizedName("oreRhodochrosite").setHardness(6.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustriesOre);

		// M U L T I B L O C K S
		enchantedBricks = new EnchantedBricks(Material.rock).setUnlocalizedName("enchantedBricks").setHardness(3.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustries);
		fireboxInterface = new FireboxInterface(Material.rock, false).setUnlocalizedName("fireboxInterface").setHardness(3.0F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustries);
		enchantedBricksFormed = new EnchantedBricksFormed(Material.rock).setUnlocalizedName("enchantedBricksFormed").setHardness(3.0F).setStepSound(Block.soundTypePiston);
		fireboxInterfaceActive = new FireboxInterface(Material.rock, true).setUnlocalizedName("fireboxInterfaceActive").setHardness(3.5F).setStepSound(Block.soundTypePiston).setCreativeTab(ReimaginedIndustries.tabIndustries);

		// F L U I D S  (W I P)


		// H O L Y
		angelicAltar = new AngelicAltar(Material.rock).setUnlocalizedName("angelicAltar").setHardness(4.5F).setStepSound(Block.soundTypeStone).setCreativeTab(ReimaginedIndustries.tabIndustries);
		etherealLightSource = new EtherealLightSource(Material.air).setUnlocalizedName("etherealLightSource").setHardness(0F);
		etherealLamp = new EtherealLamp(Material.iron).setUnlocalizedName("etherealLamp").setHardness(2.0F);

		// Harvest Level + Properties

		woodenStructure.setHarvestLevel("axe", 1);
		netherStructure.setHarvestLevel("pickaxe", 0);
		smoothStructure.setHarvestLevel("pickaxe", 1);
		smoothStructure.slipperiness = 0.65F;
		cobbleStructure.setHarvestLevel("pickaxe", 1);

		basicGearbox.setHarvestLevel("axe", 2);
		basicGearbox.setBlockBounds(0.12F, 0, 0.12F, 0.88F, 0.69F, 0.88F);
		advancedGearbox.setHarvestLevel("pickaxe", 2);
		advancedGearbox.setBlockBounds(0.1F, 0, 0.1F, 0.9F, 0.78F, 0.9F);
		reinforcedGearbox.setHarvestLevel("pickaxe", 3);

		reinforcedStructure.setHarvestLevel("pickaxe", 2);

		unstableDust.setHarvestLevel("shovel", 1);
		industrialLoam.setHarvestLevel("shovel", 2);

		unstableGlass.setHarvestLevel("sword", 3);
		unstableGlass.slipperiness = 0.69F;
		//unstableGlass.setBlockBounds(0.01F, 0.01F, 0.01F, 0.96F, 0.96F, 0.96F);
		unstableGlassColored.setHarvestLevel("sword", 3);
		unstableGlassColored.slipperiness = 0.71F;

		orePromethium.setHarvestLevel("pickaxe", 4);
		oreSperrylite.setHarvestLevel("pickaxe", 4);
		oreWolframite.setHarvestLevel("pickaxe", 4);
		oreBaddeleyite.setHarvestLevel("pickaxe", 2);
		oreChromite.setHarvestLevel("pickaxe", 3);
		oreMagnetite.setHarvestLevel("pickaxe", 1);
		orePyrolusite.setHarvestLevel("pickaxe", 2);
		oreRhodochrosite.setHarvestLevel("pickaxe", 2);

		enchantedBricks.setHarvestLevel("pickaxe", 2);
		fireboxInterface.setHarvestLevel("pickaxe", 2);
		fireboxInterfaceActive.setHarvestLevel("pickaxe", 2);
		enchantedBricksFormed.setHarvestLevel("pickaxe", 2);

		angelicAltar.setHarvestLevel("pickaxe", 2);
		etherealLamp.setHarvestLevel("pickaxe", 0);

	}

	// Registration

	/**
	 * Registers the blocks and their itemblocks.
	 */
	public static void register()
	{
		GameRegistry.registerBlock(woodenStructure, woodenStructure.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(cobbleStructure, cobbleStructure.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(smoothStructure, smoothStructure.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(netherStructure, netherStructure.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(reinforcedStructure, AdvancedBlockItem.class, "reinforcedStructure");

		GameRegistry.registerBlock(basicGearbox, BasicGearboxItem.class, "basicGearbox");
		GameRegistry.registerBlock(advancedGearbox, AdvancedGearboxItem.class, "advancedGearbox");
		GameRegistry.registerBlock(reinforcedGearbox, ReinforcedGearboxItem.class, "reinforcedGearbox");

		GameRegistry.registerBlock(unstableDust, UnstableDustItem.class, "unstableDust");
		GameRegistry.registerBlock(industrialLoam, IndustrialLoamItem.class, "industrialLoam");
		GameRegistry.registerBlock(unstableGlass, UnstableGlassItem.class, "unstableGlass");
		GameRegistry.registerBlock(unstableGlassColored, UnstableGlassItem.class, "unstableGlassColored");

		GameRegistry.registerBlock(orePromethium, RareOreItem.class, "orePromethium");
		GameRegistry.registerBlock(oreSperrylite, RareOreItem.class, "oreSperrylite");
		GameRegistry.registerBlock(oreWolframite, UncommonOreItem.class, "oreWolframite");
		GameRegistry.registerBlock(oreBaddeleyite, UncommonOreItem.class, "oreBaddeleyite");
		GameRegistry.registerBlock(oreChromite, UncommonOreItem.class, "oreChromite");
		GameRegistry.registerBlock(oreMagnetite, UncommonOreItem.class, "oreMagnetite");
		GameRegistry.registerBlock(orePyrolusite, CommonOreItem.class, "orePyrolusite");
		GameRegistry.registerBlock(oreRhodochrosite, CommonOreItem.class, "oreRhodochrosite");

		GameRegistry.registerBlock(enchantedBricks, EnchantedBricksItem.class, "enchantedBricks");
		GameRegistry.registerBlock(fireboxInterface, FireboxInterfaceItem.class, "fireboxInterface");
		GameRegistry.registerBlock(fireboxInterfaceActive, fireboxInterfaceActive.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(enchantedBricksFormed, enchantedBricksFormed.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(angelicAltar, AngelicAltarItem.class, "angelicAltar");
		GameRegistry.registerBlock(etherealLightSource, etherealLightSource.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(etherealLamp, EtherealLampItem.class, "etherealLamp");
	}

	/**
	 * Registers the itemblockrendering through the registerRender() method.
	 */
	public static void registerRenders()
	{
		registerRender(woodenStructure);
		registerRender(cobbleStructure);
		registerRender(smoothStructure);
		registerRender(reinforcedStructure);
		registerRender(netherStructure);

		registerRender(basicGearbox);
		registerRender(advancedGearbox);
		registerRender(reinforcedGearbox);

		registerRender(unstableDust);
		registerRender(industrialLoam);

		registerRender(unstableGlass);
		registerRender(unstableGlassColored);

		registerRender(orePromethium);
		registerRender(oreSperrylite);
		registerRender(oreWolframite);
		registerRender(oreBaddeleyite);
		registerRender(oreChromite);
		registerRender(oreMagnetite);
		registerRender(orePyrolusite);
		registerRender(oreRhodochrosite);

		registerRender(enchantedBricks);
		registerRender(fireboxInterface);
		registerRender(fireboxInterfaceActive);
		registerRender(enchantedBricksFormed);

		registerRender(angelicAltar);
		registerRender(etherealLightSource);
		registerRender(etherealLamp);
	}

	/**
	 * Basic template for registring the itemblock rendering.
	 * @param block
	 */
	public static void registerRender(Block block)
	{
		Item itemBlock = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlock, 0, new ModelResourceLocation(Reference.MODID + ":" + itemBlock.getUnlocalizedName().substring(5), "inventory"));

	}

}

