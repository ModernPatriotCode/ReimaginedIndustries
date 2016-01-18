package com.modernpatriot.reimaginedindustries.core;

import com.modernpatriot.reimaginedindustries.core.network.DescHandler;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

/**
 * Contains most basic TE nbt functions.
 * @author MoPat
 */
public class TileEntityBase extends TileEntity {
	
	public Packet getDescriptionPacket() {
		ByteBuf bufB = Unpooled.buffer();
		bufB.writeInt(pos.getX());
		bufB.writeInt(pos.getY());
		bufB.writeInt(pos.getZ());
		writeToPacket(bufB);
		PacketBuffer buf = new PacketBuffer(bufB);
		return new FMLProxyPacket(buf, DescHandler.CHANNEL);
	}

	public void writeToPacket(ByteBuf buf) {
		
	}

	public void readFromPacket(ByteBuf buf) {
		
	}
}
