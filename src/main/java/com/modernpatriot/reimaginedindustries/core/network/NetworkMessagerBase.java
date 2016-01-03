package com.modernpatriot.reimaginedindustries.core.network;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public abstract class NetworkMessagerBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ> {

	@Override
	public REQ onMessage(REQ message, MessageContext context) {
		if(context.side == Side.SERVER) {
			handleServerSide(message, context.getServerHandler().playerEntity);
		}else{
			handleClientSide(message, null);
		}
		return null;
	}

	public abstract void handleServerSide(REQ message, EntityPlayer player);
	
	public abstract void handleClientSide(REQ message, EntityPlayer player);
	
	
}
