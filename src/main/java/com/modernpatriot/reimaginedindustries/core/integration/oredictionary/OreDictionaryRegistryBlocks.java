package com.modernpatriot.reimaginedindustries.core.integration.oredictionary;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

/**
 * Registers Blocks to the OreDictionary.
 * @author MoPat
 */
public class OreDictionaryRegistryBlocks extends ReimaginedBlocks {

	/**
	 * Called in the init. Used to register blocks.
	 */
	public static void oreRegistration() {
		
		//  A D D  B L O C K S   H E R E
		
		OreDictionary.registerOre("dustUnstable", unstableDust);
		OreDictionary.registerOre("dustLoam", industrialLoam);
		
		//  W O O D
		
		OreDictionary.registerOre("treeWood", Blocks.log);
		OreDictionary.registerOre("treeWood", new ItemStack(Blocks.log, 1, 1));
		OreDictionary.registerOre("treeWood", new ItemStack(Blocks.log, 1, 2));
		OreDictionary.registerOre("treeWood", new ItemStack(Blocks.log, 1, 3));
		OreDictionary.registerOre("treeWood", Blocks.log2);
		OreDictionary.registerOre("treeWood", new ItemStack(Blocks.log2, 1, 1));
		
		//  O R E
		
		OreDictionary.registerOre("orePromethium", orePromethium);
		OreDictionary.registerOre("orePlatinum", oreSperrylite);
		OreDictionary.registerOre("oreShiny", oreSperrylite);
		OreDictionary.registerOre("oreSperrylite", oreSperrylite);
		OreDictionary.registerOre("oreTungsten", oreWolframite);
		OreDictionary.registerOre("oreWolframite", oreWolframite);
		OreDictionary.registerOre("oreZirconium", oreBaddeleyite);
		OreDictionary.registerOre("oreBaddeleyite", oreBaddeleyite);
		OreDictionary.registerOre("oreChrome", oreChromite);
		OreDictionary.registerOre("oreChromite", oreChromite);
		OreDictionary.registerOre("oreRichIron", oreMagnetite);
		OreDictionary.registerOre("denseIronOre", oreMagnetite);
		OreDictionary.registerOre("oreMagnetite", oreMagnetite);
		OreDictionary.registerOre("oreManganese", orePyrolusite);
		OreDictionary.registerOre("orePyrolusite", orePyrolusite);
		OreDictionary.registerOre("oreRhodochrosite", oreRhodochrosite);
		OreDictionary.registerOre("oreManganese", oreRhodochrosite);
	}
}
