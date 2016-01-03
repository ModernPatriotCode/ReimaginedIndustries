package com.modernpatriot.reimaginedindustries.core.util.config;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;

import net.minecraftforge.fml.common.FMLCommonHandler;

public class ReimaginedConfig {

	public static void syncConfig() {
		FMLCommonHandler.instance().bus().register(ReimaginedIndustries.instance);

		final String EFFECTS = ReimaginedIndustries.configuration.CATEGORY_GENERAL + ReimaginedIndustries.configuration.CATEGORY_SPLITTER + "Effects";
		ReimaginedIndustries.configuration.addCustomCategoryComment(EFFECTS, "Enable or disable particle effects and sounds");

		ConfigVariables.enableParticleEffects = ReimaginedIndustries.configuration.get(EFFECTS, ConfigVariables.enableParEffDesc, ConfigVariables.EFFECT_DEFAULT).getBoolean(ConfigVariables.EFFECT_DEFAULT);
		ConfigVariables.enableParticleRandomization = ReimaginedIndustries.configuration.get(EFFECTS, ConfigVariables.enableParRandDesc, ConfigVariables.EFFECT_DEFAULT).getBoolean(ConfigVariables.EFFECT_DEFAULT);
		ConfigVariables.enableCustomParticles = ReimaginedIndustries.configuration.get(EFFECTS, ConfigVariables.enableCusParDesc, ConfigVariables.EFFECT_DEFAULT).getBoolean(ConfigVariables.EFFECT_DEFAULT);
		ConfigVariables.enableCustomSounds = ReimaginedIndustries.configuration.get(EFFECTS, ConfigVariables.enableCusSoundDesc, ConfigVariables.EFFECT_DEFAULT).getBoolean(ConfigVariables.EFFECT_DEFAULT);
		if (ReimaginedIndustries.configuration.hasChanged()) {
			ReimaginedIndustries.configuration.save();
		}
	}

}
