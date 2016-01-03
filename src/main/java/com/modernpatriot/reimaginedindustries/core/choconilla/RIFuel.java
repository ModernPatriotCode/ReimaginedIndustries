package com.modernpatriot.reimaginedindustries.core.choconilla;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class RIFuel implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if(fuel.getItem() == Item.getItemFromBlock(ReimaginedBlocks.woodenStructure)) 
			return 64400; 
		else return 0;
	}

}
