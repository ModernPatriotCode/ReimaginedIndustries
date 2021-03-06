package com.modernpatriot.reimaginedindustries;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * <h1> ReimaginedIndustries ServerProxy class </h1>
 * Used to do stuff only on server side
 * @author MoPat
 */
public class ServerProxy extends CommonProxy {
	 
	@Override
	    public void preInit(FMLPreInitializationEvent e) {
	        super.preInit(e);
	    }

	    @Override
	    public void init(FMLInitializationEvent e) {
	        super.init(e);
	    }

	    @Override
	    public void postInit(FMLPostInitializationEvent e) {
	        super.postInit(e);
	    }

		@Override
		public EntityPlayer getClientPlayer() {
			return null;
		}
}

