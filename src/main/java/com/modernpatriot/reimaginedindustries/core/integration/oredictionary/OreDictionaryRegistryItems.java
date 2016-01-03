package com.modernpatriot.reimaginedindustries.core.integration.oredictionary;

import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistryItems extends ReimaginedItems {

		public static void oreRegistration() {
			// Add Items Here
			
			OreDictionary.registerOre("slimeball", stickySubstance);
			OreDictionary.registerOre("slimeball", superGlue);
			
			
			
			
		}
		

	
	
	
	
	
	
	
	
}
