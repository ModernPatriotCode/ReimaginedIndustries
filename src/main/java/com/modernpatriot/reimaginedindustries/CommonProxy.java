package com.modernpatriot.reimaginedindustries;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.util.handlers.GUIHandler;
import com.modernpatriot.reimaginedindustries.core.util.handlers.TickHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public abstract class CommonProxy {

   public void registerRenders() {
	   
	   
   }
	
	
	public void preInit(FMLPreInitializationEvent e) {
    	 
    }

    public void init(FMLInitializationEvent e) {
    	NetworkRegistry.INSTANCE.registerGuiHandler(ReimaginedIndustries.instance, new GUIHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
    public abstract EntityPlayer getClientPlayer();
}
