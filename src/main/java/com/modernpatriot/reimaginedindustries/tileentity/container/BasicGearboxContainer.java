// Currently not used
package com.modernpatriot.reimaginedindustries.tileentity.container;

import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class BasicGearboxContainer extends Container {

	private BasicGearboxData bgd;
	
	public BasicGearboxContainer(IInventory inventory, BasicGearboxData bgd) {
		this.bgd = bgd;
	    this.addSlotToContainer(new Slot(bgd, 0, 1, 1));
	        
		
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.bgd.isUseableByPlayer(playerIn);
	}

}
