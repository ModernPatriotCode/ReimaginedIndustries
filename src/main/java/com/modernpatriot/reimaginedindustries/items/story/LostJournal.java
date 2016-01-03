package com.modernpatriot.reimaginedindustries.items.story;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class LostJournal extends Item {
	
	@Override
	public boolean doesSneakBypassUse(World world, BlockPos pos, EntityPlayer player) {
		return false;
	}
	
}
