package com.modernpatriot.reimaginedindustries.core.gui;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.core.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigurationGui extends GuiConfig {
	
	public ConfigurationGui(GuiScreen screen) {
		super(screen, new ConfigElement(ReimaginedIndustries.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MODNAME, false, false, GuiConfig.getAbridgedConfigPath(ReimaginedIndustries.configuration.toString()));
	}

}
