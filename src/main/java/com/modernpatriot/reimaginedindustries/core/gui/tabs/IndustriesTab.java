package com.modernpatriot.reimaginedindustries.core.gui.tabs;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Used for the visuals of the MainTab.
 * @author MoPat
 */
public class IndustriesTab extends CreativeTabs {

	public IndustriesTab(String label) {
		super(label);
		this.setBackgroundImageName("industries.png");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ReimaginedBlocks.woodenStructure);
	}

}
