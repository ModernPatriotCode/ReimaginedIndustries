package com.modernpatriot.reimaginedindustries.core.util.handlers;

import com.modernpatriot.reimaginedindustries.core.recipes.BasicInfuserRecipe;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

/**
 * Calls methods which need to be called every tick.
 * @author MoPat
 *
 */
public class TickHandler {

	@SubscribeEvent
	public void onRenderTick(PlayerTickEvent event) {
		//BasicInfuserRecipe.everyTick();
	}
}
