package com.modernpatriot.reimaginedindustries.items.records;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.core.util.config.ConfigVariables;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RecordWaves extends ItemRecord {

	public RecordWaves(String name) {
		super("recordWaves");
	}
	public ResourceLocation getRecordResource(String name) {
		if (ConfigVariables.enableCustomSounds) {
			return new ResourceLocation("reimaginedindustries:recordWaves");
		}else{
			return new ResourceLocation("");
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemstack)
	{
	    return EnumRarity.RARE;
	}

}
