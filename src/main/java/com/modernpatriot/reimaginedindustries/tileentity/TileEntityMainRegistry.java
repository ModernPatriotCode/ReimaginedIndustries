package com.modernpatriot.reimaginedindustries.tileentity;

import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.tileentity.holy.EtherealLampTileEntity;
import com.modernpatriot.reimaginedindustries.tileentity.utiltileentity.EtherealLightSourceTileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityMainRegistry {

	public static void init() {
		GameRegistry.registerTileEntity(BasicGearboxData.class, Reference.MODID + ":basicGearboxEntity");
		GameRegistry.registerTileEntity(FireboxInterfaceData.class, Reference.MODID + ":fireboxInterfaceEntity");
		GameRegistry.registerTileEntity(EtherealLightSourceTileEntity.class, Reference.MODID + ":etherealLightSourceEntity");
		GameRegistry.registerTileEntity(EtherealLampTileEntity.class, Reference.MODID + ":etherealLampEntity");
	}
	
}
