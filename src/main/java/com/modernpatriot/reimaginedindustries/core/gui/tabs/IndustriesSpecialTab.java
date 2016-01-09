package com.modernpatriot.reimaginedindustries.core.gui.tabs;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Used for the visuals of the SpecialTab.
 * @author MoPat
 */
public class IndustriesSpecialTab extends CreativeTabs {
	public IndustriesSpecialTab(String label) {
		super(label);
		this.setBackgroundImageName("industries.png");
	}

	@Override
	public Item getTabIconItem() {
		return ReimaginedItems.recordWaves;
	}
}
