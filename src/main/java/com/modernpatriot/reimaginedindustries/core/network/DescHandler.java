package com.modernpatriot.reimaginedindustries.core.network;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;

@ChannelHandler.Sharable
public class DescHandler extends SimpleChannelInboundHandler<FMLProxyPacket>{

	public static final String CHANNEL = Reference.MODID + "Description";
	
	static {
		NetworkRegistry.INSTANCE.newChannel(CHANNEL, new DescHandler());
	}
	
	public static void init() {
		
	}
	
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
		ByteBuf bufB = msg.payload();
		int x = bufB.readInt();
		int y = bufB.readInt();
		int z = bufB.readInt();
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = ReimaginedIndustries.proxy.getClientPlayer().worldObj.getTileEntity(pos);
		if(te instanceof BasicGearboxData) {
			((BasicGearboxData)te).readFromPacket(bufB);
		}
	}

}
