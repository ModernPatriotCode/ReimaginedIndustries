package com.modernpatriot.reimaginedindustries.core.util.handlers;

import com.modernpatriot.reimaginedindustries.core.recipies.BasicInfuserRecipies;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickHandler {

	@SubscribeEvent
	public void onRenderTick(PlayerTickEvent event) {
		BasicInfuserRecipies.everyTick();
	}
}