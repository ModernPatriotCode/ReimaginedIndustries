package com.modernpatriot.reimaginedindustries.tileentity.container;

import com.modernpatriot.reimaginedindustries.tileentity.FireboxInterfaceData;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireboxInterfaceContainer extends Container {

	private FireboxInterfaceData fid;
	private int lastCookTime;
	private int lastHeatValue;
	private int lastCurrentTemperature;
	private int lastHeatingTemperature;
	
	public FireboxInterfaceContainer(InventoryPlayer iPlayer, FireboxInterfaceData fireboxInterfaceData) {
		this.fid = fireboxInterfaceData;
		this.addSlotToContainer(new Slot(fireboxInterfaceData, 1, 26, 53));
		this.addSlotToContainer(new Slot(fireboxInterfaceData, 2, 54, 9));
		this.addSlotToContainer(new Slot(fireboxInterfaceData, 3, 54, 30));
		this.addSlotToContainer(new Slot(fireboxInterfaceData, 4, 54, 51));
		this.addSlotToContainer(new Slot(fireboxInterfaceData, 5, 116, 31));
		this.addSlotToContainer(new Slot(fireboxInterfaceData, 6, 144, 31));
		
		for(int i=0; i<3; ++i){
			for(int j=0; j < 9; ++j){
				this.addSlotToContainer(new Slot(iPlayer, j+i*9+9,8+j*18,90+i*18));
			}
		}
		for(int i=0; i<9; ++i){
			this.addSlotToContainer(new Slot(iPlayer, i, 8+i*18, 148));
		}
	}
	
	public void addCraftingToCrafters(ICrafting craft){
		super.addCraftingToCrafters(craft);
		craft.sendProgressBarUpdate(this, 0, (int)this.fid.fidCurrentBurnTemp);
		craft.sendProgressBarUpdate(this, 1, this.fid.fidCookTime);
		craft.sendProgressBarUpdate(this, 2, this.fid.fidBurnTemp);
	}
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i=0; i<this.crafters.size(); ++i){
			ICrafting craft = (ICrafting) this.crafters.get(i);
			if(this.lastCookTime != this.fid.fidCookTime){
				craft.sendProgressBarUpdate(this, 0, this.fid.fidCookTime);
			}
			if(this.lastHeatingTemperature != this.fid.fidBurnTemp){
				craft.sendProgressBarUpdate(this, 2, this.fid.fidBurnTemp);
			}
			if(this.lastCurrentTemperature != this.fid.fidCurrentBurnTemp){
				craft.sendProgressBarUpdate(this, 1, (int)this.fid.fidCurrentBurnTemp);
			}
		}
		this.lastCookTime = this.fid.fidCookTime;
		this.lastCurrentTemperature = (int)this.fid.fidCurrentBurnTemp;
		this.lastHeatingTemperature = this.fid.fidBurnTemp;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data){
		if(id == 0){
			this.fid.fidCookTime = data;
		}
		if(id == 1){
			this.fid.fidCookTime = data;
		}
		if(id == 0){
			this.fid.fidCookTime = data;
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return this.fid.isUseableByPlayer(playerIn);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
		ItemStack stack = null;
		Slot slot = (Slot) this.inventorySlots.get(index);
		if(slot != null && slot.getHasStack()){
			ItemStack stackSlot = slot.getStack();
			stack = stackSlot.copy();
			if(index == 5 || index == 6){
				if(!this.mergeItemStack(stackSlot, 7, 42, true)){
					return null;
				}
				
				slot.onSlotChange(stackSlot, stack);
				
			}else if(index != 1 && index != 0 && index != 2 && index != 3 && index != 4){
				if(FurnaceRecipes.instance().getSmeltingResult(stackSlot) != null){
					if(!this.mergeItemStack(stackSlot, 1, 5, false)){
						return null;
					}
				}else if(FireboxInterfaceData.isItemFuel(stackSlot)){
					if(!this.mergeItemStack(stackSlot, 0, 1, false)){
						return null;
					}
				}else if(index >= 7 && index < 33){
					if(!this.mergeItemStack(stackSlot, 33, 42, false)){
						return null;
					}
				}else if(index >= 33 && index < 42 && !this.mergeItemStack(stackSlot, 6, 33, false)){
					return null;
				}
			}else if(!this.mergeItemStack(stackSlot, 6, 42, false)){
				return null;
			}
			if(stackSlot.stackSize == 0){
				slot.putStack((ItemStack)null);
			}else{
				slot.onSlotChanged();
			}
			if(stackSlot.stackSize == stack.stackSize){
				return null;
			}
			slot.onPickupFromSlot(playerIn, stackSlot);
		}
		return stack;
	}

}
