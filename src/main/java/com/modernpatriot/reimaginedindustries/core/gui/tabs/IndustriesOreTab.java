package com.modernpatriot.reimaginedindustries.core.gui.tabs;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Used for the visuals of the OreTab.
 * @author MoPat
 */
public class IndustriesOreTab extends CreativeTabs {

	public IndustriesOreTab(String label) {
		super(label);
		this.setBackgroundImageName("industries.png");

	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(ReimaginedBlocks.orePromethium);
	}

}
