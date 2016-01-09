package com.modernpatriot.reimaginedindustries.core.integration.oredictionary;

import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Registers Items to the OreDictionary.
 * @author MoPat
 */
public class OreDictionaryRegistryItems extends ReimaginedItems {

	/**
	 * Called in the init. Used to register the items.
	 */
	public static void oreRegistration() {
		OreDictionary.registerOre("slimeball", stickySubstance);
		OreDictionary.registerOre("slimeball", superGlue);
			
			
			
			
	}
		

	
	
	
	
	
	
	
	
}
