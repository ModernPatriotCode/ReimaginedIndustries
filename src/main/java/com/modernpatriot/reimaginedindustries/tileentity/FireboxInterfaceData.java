// FOR BETTER COMPREHENSION LOOK AT BASICGEARBOXDATA
package com.modernpatriot.reimaginedindustries.tileentity;

import com.modernpatriot.reimaginedindustries.blocks.multiblock.FireboxInterface;
import com.modernpatriot.reimaginedindustries.core.logic.FireboxInterfaceLogic;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class FireboxInterfaceData extends TileEntity implements ISidedInventory,IUpdatePlayerListBox{

	private static final int[] slotsTop = new int[]{0};
	private static final int[] slotsBot = new int[]{2,1};
	private static final int[] slotsSid = new int[]{1};
	
	public int counter = 0;
	
	private ItemStack[] fidStack = new ItemStack[7];
	public int fidBurnTemp;
	public double fidCurrentBurnTemp;
	public boolean fidFueled;
	public int fidCookTime;
	private String fidName;
	private int doneHeating;
	private int wantedHeat = 0;
	
	public void fireboxName(String string){
		this.fidName = string;
	}
	
	@Override
	public int getSizeInventory() {
		return this.fidStack.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.fidStack[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if(this.fidStack[index] != null){
			ItemStack stack;
			if(this.fidStack[index].stackSize <= count) {
				stack = this.fidStack[index];
				this.fidStack[index] = null;
				return stack;
			}else{
				stack = this.fidStack[index].splitStack(count);
				if(this.fidStack[index].stackSize == 0) {
					this.fidStack[index] = null;
				}
				return stack;
			}
		}else{
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if(this.fidStack[index] != null){
			ItemStack stack = this.fidStack[index];
			this.fidStack[index] = null;
			return stack;
		}else{
		return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.fidStack[index] = stack;
		if(stack != null && stack.stackSize > this.getInventoryStackLimit()){
			stack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(pos)!= this ? false : player.getDistanceSq((double)pos.getX()+0.5D,(double)pos.getY()+0.5D,(double)pos.getZ()+0.5D) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return index == 5 ? false : index == 6 ? false : index == 1 ? isItemFuel(stack) : true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}
	
	public static boolean isItemFuel(ItemStack stack){
		if(getHeatOutputFromItem(stack.getItem()) > 0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.fidName : "Firebox Interface";
	}

	@Override
	public boolean hasCustomName() {
		return this.fidName != null && this.fidName.length() > 0;
	}
	
	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.fidStack = new ItemStack[this.getSizeInventory()];
		for(int i = 0;i < tagList.tagCount();++i){
			NBTTagCompound tagCompoundI = tagList.getCompoundTagAt(i);
			byte byteZERO = tagCompoundI.getByte("Slot");
			if(byteZERO >= 0 && byteZERO < this.fidStack.length){
				this.fidStack[byteZERO] = ItemStack.loadItemStackFromNBT(tagCompoundI);
			}
		}
		// FUELED ISNT 100% REALLY NECESSARY (BUT EASIER TO WORK WITH)
		this.fidBurnTemp = tagCompound.getShort("BurnTemp");
		this.fidCookTime = tagCompound.getShort("CookTime");
		this.fidFueled = tagCompound.getBoolean("Fueled");
		this.doneHeating = tagCompound.getShort("DoneHeating");
		this.fidCurrentBurnTemp = getCurrentTemperature(this.fidBurnTemp, this.doneHeating);
		
		if(tagCompound.hasKey("CustomName", 8)){
			this.fidName = tagCompound.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		tagCompound.setShort("BurnTemp", (short)this.fidBurnTemp);
		tagCompound.setShort("CookTime", (short)this.fidCookTime);
		tagCompound.setBoolean("Fueled", this.fidFueled);
		tagCompound.setShort("DoneHeating", (short)this.doneHeating);
		NBTTagList tagList = new NBTTagList();
		for(int i = 0; i < this.fidStack.length;++i){
			if(this.fidStack[i] != null){
				NBTTagCompound tagCompoundI = new NBTTagCompound();
				tagCompoundI.setByte("Slot", (byte)i);
				tagList.appendTag(tagCompoundI);
			}
		}
		tagCompound.setTag("Items", tagList);
		if(this.hasCustomName()){
			tagCompound.setString("CustomName", this.fidName);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int maximum){
		if(this.canSmelt()){
			return this.fidCookTime*maximum/240;
		}else{
			return 0;
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	public double getCurrentBurnTempTillHottestScaled(int maximum){
		if((this.fidCurrentBurnTemp/1000)*maximum >= maximum) {
			return maximum;
		}else if((this.fidCurrentBurnTemp/1000)*maximum < 0){
			return 0;
		}else{
			return (this.fidCurrentBurnTemp/1000)*maximum;
		}
	}
	
	public boolean isBurning(){
		return this.fidCurrentBurnTemp > 0;
	}
	
	public int getCurrentTemperature(int burnTempHeatingTo, int percentageDoneHeating){
		return burnTempHeatingTo*percentageDoneHeating;
	}

	@Override
	public IChatComponent getDisplayName() {
		return null;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return false;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return false;
	}

	public void furnaceName(String displayName) {
		
	}

	@Override
	public void update() {
		if(this.fidCookTime > 0 && !this.canSmelt()){
			fidCookTime = 0;
		}
		counter++;
			if(counter%30 == 0){
				//Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("COOK TIME SCALED: " + this.getCookProgressScaled(40) + "        BURN TEMP SCALED: " + this.getCurrentBurnTempTillHottestScaled(53) + "         COOK TIME: " + this.fidCookTime));
			}
		this.fidBurnTemp = wantedHeat;
		if(!this.fidFueled){
			this.fidCurrentBurnTemp = this.fidCurrentBurnTemp - 0.025;
		}
		if(this.fidFueled && this.fidCurrentBurnTemp <= wantedHeat){
			this.fidCurrentBurnTemp = this.fidCurrentBurnTemp + 0.05;
		}else if(this.fidCurrentBurnTemp > wantedHeat){
			this.fidFueled = false;
		}
		boolean flag = this.fidCurrentBurnTemp > 0;
		if(this.fidCurrentBurnTemp < 0){
			this.fidCurrentBurnTemp = 0;
		}
		boolean flag1 = false;
		/*if(this.isBurning() && this.canSmelt() && this.fidCurrentBurnTemp > 50){
			this.fidCookTime += new Float(Math.round(1.0F * (this.fidCurrentBurnTemp/500)));
			if(this.fidCookTime%20 == 0 && this.fidCookTime != 0){
				--this.fidCurrentBurnTemp;
				--this.fidBurnTemp;
			}
			if(this.fidCookTime == 240){
				this.fidCookTime = 0;
				this.smeltItem();
				flag1 = true;
			}
		}else{
			this.fidCookTime = 0;
		}*/
		/*if(flag != this.fidCurrentBurnTemp - 1 > 0){
			flag1=true;
			FireboxInterface.updateBlockState(this.fidCurrentBurnTemp > 0, this.worldObj, this.pos);
		}*/
		if(flag1){
			this.markDirty();
		}
		if(this.fidFueled){
			if(this.fidCurrentBurnTemp < wantedHeat && fidCurrentBurnTemp < 1000){
				this.fidCurrentBurnTemp += 0.05;
			}else{
				this.fidFueled = false;
			}
		}else{
			if(this.fidCurrentBurnTemp > 0){
				this.fidCurrentBurnTemp -= 0.025;
			}
			if(this.fidStack[1] != null && this.fidStack[1].stackSize!=0){
				if(this.canHeatUp() >= this.getHeatOutputFromItem(this.fidStack[1].getItem()) && this.getHeatOutputFromItem(this.fidStack[1].getItem()) != 0) {
					this.fidFueled = true;
					wantedHeat += this.getHeatOutputFromItem(this.fidStack[1].getItem());
					int size = this.fidStack[1].stackSize-1;
					if(size <= 0){
						this.setInventorySlotContents(1, null);
					}else{
						this.setInventorySlotContents(1, new ItemStack(this.fidStack[1].getItem(), size, this.fidStack[1].getItemDamage()));
					}
					// IF IT STILL GOES ABOVE A THOUSAND DEGREES
					if(wantedHeat>1000){
						wantedHeat = 1000;
					}
				}
			}
		}
		if(this.fidBurnTemp!=0){
			this.doneHeating = (int)this.fidCurrentBurnTemp/this.fidBurnTemp;
		}else{
			this.doneHeating = 100;
		}
	}
	
	private boolean canSmelt(){
		if(fidStack[2] == null && fidStack[3] == null && fidStack[4] == null){
			return false;
		}else{
			ItemStack stack1 = null;
			ItemStack stack2 = null;
			ItemStack stack3 = null;
			if(fidStack[2] != null){
				stack1 = FurnaceRecipes.instance().getSmeltingResult(fidStack[2]);
			}
			if(fidStack[3] != null){
				stack2 = FurnaceRecipes.instance().getSmeltingResult(fidStack[3]);	
			}
			if(fidStack[4] != null){
				stack3 = FurnaceRecipes.instance().getSmeltingResult(fidStack[4]);	
			}
			if(stack1 == null){
				if(stack2 == null){
					if(stack3 == null){
						return false;
					}else{
						if(fidStack[5]!=null){
							int result = fidStack[5].stackSize + stack3.stackSize;
							return this.isSomethingElseInOutput(this.fidStack[4], result);
						}else{
							return this.isSomethingElseInOutput(this.fidStack[4], this.fidStack[4].stackSize);
						}
					}
				}else{
					if(stack3 == null){
						if(fidStack[5]!=null){
							int result = fidStack[5].stackSize + stack2.stackSize;
							return this.isSomethingElseInOutput(this.fidStack[3], result);
						}else{
							return this.isSomethingElseInOutput(this.fidStack[3], this.fidStack[3].stackSize);
						}
					}else{
						return false;
					}
				}
			}else{
				if(stack2 == null){
					if(stack3 == null){
						if(fidStack[5]!=null){
							int result = fidStack[5].stackSize + stack1.stackSize;
							return this.isSomethingElseInOutput(this.fidStack[2], result);
						}else{
							return this.isSomethingElseInOutput(this.fidStack[2], this.fidStack[2].stackSize);
						}
					}else{
						return false;
					}
				}else{
					return false;
				}
			}
		}
	}
	
	private boolean isSomethingElseInOutput(ItemStack stack, int numberItems){
		if(this.fidStack[5] == null){
			return true;
		}
		if(!this.fidStack[5].isItemEqual(FurnaceRecipes.instance().getSmeltingResult(stack))){
			return false;
		}else{
			return numberItems <= getInventoryStackLimit() && numberItems <= this.fidStack[5].getMaxStackSize();
		}
	}
	
	public void smeltItem() {
		if(this.canSmelt()){
			ItemStack stack = null;
			ItemStack stack1 = FurnaceRecipes.instance().getSmeltingResult(fidStack[2]);
			ItemStack stack2 = FurnaceRecipes.instance().getSmeltingResult(fidStack[3]);
			ItemStack stack3 = FurnaceRecipes.instance().getSmeltingResult(fidStack[4]);
			if(stack1 != null){
				stack = stack1;
			}
			if(stack2 != null){
				stack = stack2;
			}
			if(stack3 != null){
				stack = stack3;
			}
			if(stack!=null){
				if(this.fidStack[5] == null){
					this.fidStack[5] = stack.copy();
				}else if(this.fidStack[5].getItem() == stack.getItem()){
					this.fidStack[5].stackSize += stack.stackSize;
				}
			}
			if(stack1!=null){
				--this.fidStack[2].stackSize;
				if(fidStack[2].stackSize >= 0){
					this.fidStack[2] = null;
				}
			}else if(stack2!=null){
				--this.fidStack[3].stackSize;
				if(fidStack[3].stackSize >= 0){
					this.fidStack[3] = null;
				}
			}else{
				--this.fidStack[4].stackSize;
				if(fidStack[4].stackSize >= 0){
					this.fidStack[4] = null;
				}
			}
		}
	}
	
	public int canHeatUp(){
		return 1000 - (int)this.fidCurrentBurnTemp;
	}
	
	public static int getHeatOutputFromItem(Item item){
		if(item!=null){
			if(item.equals(Items.coal)){
				return 100;
			}else if(item.equals(Item.getItemFromBlock(Blocks.coal_block))){
				return 950;
			}else if(item.equals((new ItemStack(Items.coal,1,1)).getItem())){
				return 80;
			}else if(item.equals((new ItemStack(Item.getItemFromBlock(Blocks.coal_block),1,1)).getItem())){
				return 720;
			}else if(item.equals(Item.getItemFromBlock(Blocks.planks))){
				return 18;
			}else if(item.equals(Item.getItemFromBlock(Blocks.log))){
				return 18;
			}else if(item.equals(Item.getItemFromBlock(Blocks.log2))){
				return 18;
			}else if(item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) {
				return 15;
			}else if(item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")){
				return 15;
			}else if(item instanceof ItemHoe && ((ItemHoe)item).getMaterialName().equals("WOOD")){
				return 15;
			}else if(item == Items.stick){
				return 7;
			}else if(item == Items.lava_bucket){
				return 1000;
			}else if(item == Items.blaze_rod){
				return 160;
			}else if(item == Item.getItemFromBlock(Blocks.sapling)){
				return 7;
			}else{
				return 0;
			}
		}else{
			return 0;
		}
	}

}
