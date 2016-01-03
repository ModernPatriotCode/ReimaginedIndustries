package com.modernpatriot.reimaginedindustries.core.choconilla;

import java.util.Random;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VanillaEntityProvider {
	
	 boolean pageDragonDropped = false;
	 boolean pageWitherDropped = false;
	 public static double rand;
     public Random r = new Random();
	
	@SubscribeEvent
	public void onDrop(LivingDropsEvent event) {
		if(event.entityLiving instanceof EntitySlime) {
			event.entityLiving.dropItem(ReimaginedItems.stickySubstance, r.nextInt(2));
			event.entityLiving.dropItem(ReimaginedItems.superGlue, r.nextInt(1));
			
		}
		if(event.entityLiving instanceof EntityDragon) {
			if(!pageDragonDropped){
				pageDragonDropped = true;
			}
			
		}
		if(event.entityLiving instanceof EntityWither) {
			if(!pageWitherDropped) {
				pageWitherDropped = true;
			}
			
		}

		
		
	}
}
