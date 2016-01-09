package com.modernpatriot.reimaginedindustries.tileentity;

import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;

import com.modernpatriot.reimaginedindustries.core.TileEntityBase;

import io.netty.buffer.ByteBuf;


/**
 * <h1> BasicGearbox TileEntity File </h1>
 * Everything required for the TileEntity
 * @author MoPat
 */
public class BasicGearboxData extends TileEntityBase implements IInventory {


	private final long INVALID_TIME = 0;
	private long lastTime = INVALID_TIME;
	private double lastAngularPosition;
	private String customName;
	private ItemStack[] inventoryContent;
	private float nextAngularPosition1;
	private String itemName;

	public BasicGearboxData() {
		this.inventoryContent = new ItemStack[this.getSizeInventory()];
	}

	/**
	 * Returns a new itemName
	 * @return itemName
	 */
	public String getItemName() {
		return this.itemName;
	}


	/**
	 * Changes the itemName to a new one
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Returns the custom name
	 * @return customName
	 */
	public String getCustomName() {
		return this.customName;
	}


	/**
	 * Overrides the current name with a new one
	 * @param customName
	 */
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	

	/**
	 * Used for the TESR rotation
	 * @param revsPerSecond
	 * @return a new angular position (double)
	 */
	public double getNextAngularPosition(double revsPerSecond) {
		long timeNow = System.nanoTime();
		if (lastTime == INVALID_TIME) {
			lastTime = timeNow;
			lastAngularPosition = 0.0;
		}
		final double DEGREES_PER_REV = 360.0;
		final double NANOSECONDS_PER_SECOND = 1e9;
		double nextAngularPosition = lastAngularPosition + (timeNow - lastTime) * revsPerSecond * DEGREES_PER_REV / NANOSECONDS_PER_SECOND;
		nextAngularPosition = nextAngularPosition % DEGREES_PER_REV;
		lastAngularPosition = nextAngularPosition;
		lastTime = timeNow;
		return nextAngularPosition;
	}
	
	
	/**
	 * Used for the TESR rotation
	 * @param revsPerSecond1
	 * @return a new angular position (double)
	 */
	public float getNextAngularPosition1(float revsPerSecond1) {
		long timeNow = System.nanoTime();
		if (lastTime == INVALID_TIME) {
			lastTime = timeNow;
			lastAngularPosition = 0.0;
		}
		final double DEGREES_PER_REV = 360.0;
		final double NANOSECONDS_PER_SECOND = 1e9;
		double nextAngularPosition = lastAngularPosition + (timeNow - lastTime) * revsPerSecond1 * DEGREES_PER_REV / NANOSECONDS_PER_SECOND;
		nextAngularPosition = nextAngularPosition % DEGREES_PER_REV;
		lastAngularPosition = nextAngularPosition;
		lastTime = timeNow;
		return nextAngularPosition1;
	}

	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "container.basicgearbox";
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.equals("Basic Gearbox");
	}

	@Override
	public IChatComponent getDisplayName() {
		return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index < 0 || index >= this.getSizeInventory())
			return null;
		return this.inventoryContent[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (this.getStackInSlot(index) != null) {
			ItemStack itemstack;

			if (this.getStackInSlot(index).stackSize <= count) {
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.getStackInSlot(index).splitStack(count);

				if (this.getStackInSlot(index).stackSize <= 0) {
					this.setInventorySlotContents(index, null);
				} else {
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}

				this.markDirty();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index < 0 || index >= this.getSizeInventory())
			return;

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
			stack.stackSize = this.getInventoryStackLimit();

		if (stack != null && stack.stackSize == 0)
			stack = null;

		this.inventoryContent[index] = stack;
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
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
		for (int i = 0; i < this.getSizeInventory(); i++)
			this.setInventorySlotContents(i, null);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		NBTTagList listItems = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i) {
			if (this.getStackInSlot(i) != null) {
				NBTTagCompound insideInv = new NBTTagCompound();
				insideInv.setByte("Slots", (byte) i);
				this.getStackInSlot(i).writeToNBT(insideInv);
				listItems.appendTag(insideInv);

			}
		}
		nbt.setTag("Items", listItems);
		worldObj.markBlockForUpdate(getPos());
		if (this.hasCustomName()) {
			nbt.setString("CustomName", this.getCustomName());
		}
		if(this.getInventoryContent()!=null) {
			nbt.setString("ItemName", this.getInventoryContent().getDisplayName());
		}else{
			nbt.setString("ItemName", "");
		}
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		NBTTagList listItems = nbt.getTagList("Items", 10);
		for (int i = 0; i < listItems.tagCount(); ++i) {
			NBTTagCompound stackTag = listItems.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slots") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}

		if (nbt.hasKey("CustomName", 8)) {
			this.setCustomName(nbt.getString("CustomName"));
		}

		if(nbt.hasKey("ItemName", 10)) {
			this.setItemName(nbt.getString("ItemName"));
		}
	}

	/**
	 * Tries to write the inventory contents to a packet
	 * @param buf
	 */
	public void writeToPacket(ByteBuf buf){
		ByteBufUtils.writeItemStack(buf, inventoryContent[0]);
	}

	/**
	 * Tries to read the inventory contents from a packet
	 * @param buf
	 */
	public void readFromPacket(ByteBuf buf) {
		inventoryContent[0] = ByteBufUtils.readItemStack(buf);
		worldObj.markBlockRangeForRenderUpdate(pos, pos);
	}

	@Override
	public void openInventory(EntityPlayer player) {

	}

	@Override
	public void closeInventory(EntityPlayer player) {

	}

	/**
	 * Overrides the inventory content with a new ItemStack
	 * @param newStack
	 */
	public void setInventoryContent(ItemStack newStack){
		inventoryContent[0] = newStack;
		worldObj.markBlockForUpdate(pos);
	}

	/**
	 * Returns the inventory content
	 * @return inventoryContent
	 */
	public ItemStack getInventoryContent() {
		return inventoryContent[0];
	}

	/**
	 * Overrides the comparator Output to 15 if something is inside
	 * @return comparatorOutputStrength
	 */
	public int comparatorStrength() {
		if(this.getInventoryContent()!=null) {
			return 15;
		}else{	
			return 0;
		}
	}
}
