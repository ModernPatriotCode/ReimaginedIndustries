package com.modernpatriot.reimaginedindustries.core.integration.waila.handlers;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

/*import mcp.mobius.waila.api.ITaggedList.ITipList;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataAccessorServer;
import mcp.mobius.waila.api.IWailaDataProvider;*/
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class WailaBasicGearboxHandler /*implements IWailaDataProvider*/ {
	/*private String itemName;

	@Override
	public NBTTagCompound getNBTData(TileEntity te, NBTTagCompound tagcompound, IWailaDataAccessorServer server) {
		BasicGearboxData bgd = (BasicGearboxData)server.getTileEntity();
		if(bgd.getInventoryContent()!=null) {
			if(bgd.getInventoryContent().getDisplayName()!=null && bgd.getInventoryContent().getDisplayName()!="") {
				tagcompound.setString("ItemName", bgd.getInventoryContent().getDisplayName());
			}
		}
		return tagcompound;
	}

	@Override
	public ITipList getWailaBody(ItemStack stack, ITipList tiplist, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		if(accessor.getTileEntity() != null) {
			BasicGearboxData bgd = (BasicGearboxData)accessor.getTileEntity();
			NBTTagCompound tagcompound = accessor.getNBTData();
			if(tagcompound.getString("ItemName")!=null && tagcompound.getString("ItemName")!="") {
				String itemNameLocal = tagcompound.getString("ItemName");
				tiplist.add(EnumChatFormatting.WHITE + I18n.format("reimaginedindustries.waila.basicgearbox.iteminside") + " " + EnumChatFormatting.RESET + EnumChatFormatting.ITALIC + EnumChatFormatting.getTextWithoutFormattingCodes(itemNameLocal));
			}else{
				tiplist.add(EnumChatFormatting.WHITE + I18n.format("reimaginedindustries.waila.basicgearbox.empty"));
			}
		}
		return tiplist;
	}

	@Override
	public ITipList getWailaHead(ItemStack stack, ITipList tiplist, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return tiplist;
	}

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return new ItemStack(ReimaginedBlocks.basicGearbox);
	}

	@Override
	public ITipList getWailaTail(ItemStack stack, ITipList tiplist, IWailaDataAccessor accessor, IWailaConfigHandler config) {
		return tiplist;
	}*/

}
