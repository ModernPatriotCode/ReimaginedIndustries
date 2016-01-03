// Tries to send/receive important information to/from the server and/or the client
package com.modernpatriot.reimaginedindustries.core.network;

import com.modernpatriot.reimaginedindustries.core.Reference;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkHandlerMain {
	private static SimpleNetworkWrapper INSTANCE;
	
	public static void init() {
		 NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MODID);
	}
	
	public static void sendToServer(IMessage message) {
		INSTANCE.sendToServer(message);
	}
	
	public static void sendToAll(IMessage message) {
		INSTANCE.sendToAll(message);
	}
	
}
