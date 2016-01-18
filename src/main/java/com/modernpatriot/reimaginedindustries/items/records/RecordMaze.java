package com.modernpatriot.reimaginedindustries.items.records;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.core.util.config.ConfigVariables;


import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.Optional.Method;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class RecordMaze extends ItemRecord{

	public RecordMaze(String name) {
		super("recordMaze");
		setCreativeTab(ReimaginedIndustries.tabIndustries);
	}
	public ResourceLocation getRecordResource(String name) {
		if (ConfigVariables.enableCustomSounds) {
			return new ResourceLocation("reimaginedindustries:recordMaze");
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
