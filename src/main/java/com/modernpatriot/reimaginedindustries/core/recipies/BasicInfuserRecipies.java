package com.modernpatriot.reimaginedindustries.core.recipies;

import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BasicInfuserRecipies {

	static boolean infusionSwortTemplateDiamondStart = false;
	private static BlockPos[] posArray = new BlockPos[4];
	private static World currentWorld;
	private static EntityPlayer currentPlayer;
	private static BasicGearboxData currentBGD;
	private static BlockPos currentMasterBlockPos;


	static int defaultTime = 85;
	static int counter = defaultTime;
	static boolean startCounter = false;

	public static void infusionSwordTemplateDiamond(BlockPos pos, EntityPlayer playerIn, World worldIn, BasicGearboxData bgd) {

		currentWorld = worldIn;
		currentPlayer = playerIn;
		currentBGD = bgd;
		currentMasterBlockPos = pos;

		posArray[0] = new BlockPos(currentMasterBlockPos.getX()+3,currentMasterBlockPos.getY()-1,currentMasterBlockPos.getZ());
		posArray[1] = new BlockPos(currentMasterBlockPos.getX(),currentMasterBlockPos.getY()-1,currentMasterBlockPos.getZ()+3);
		posArray[2] = new BlockPos(currentMasterBlockPos.getX()-3,currentMasterBlockPos.getY()-1,currentMasterBlockPos.getZ());
		posArray[3] = new BlockPos(currentMasterBlockPos.getX(),currentMasterBlockPos.getY()-1,currentMasterBlockPos.getZ()-3);

		startCounter = true;

		infusionSwortTemplateDiamondStart = true;

		playerIn.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.AQUA + "INFUSION"));
	}


	public static void everyTick() {
		if (infusionSwortTemplateDiamondStart == true) {
			if(counter == 84) {
				currentWorld.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, posArray[0].getX() - 0.7, posArray[0].getY() + 0.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 0.7, posArray[0].getY() + 0.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 0.7, posArray[0].getY() + 0.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 0.6F-(currentWorld.rand.nextFloat()*0.2F));
			}
			if(counter == 70) {
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 1.16, posArray[0].getY() + 1, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 1.16, posArray[0].getY() + 1, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 1.16, posArray[0].getY() + 1, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 0.7F-(currentWorld.rand.nextFloat()*0.2F));
			}
			if(counter == 55) {
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 1.62, posArray[0].getY() + 1.2, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 1.62, posArray[0].getY() + 1.2, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 1.62, posArray[0].getY() + 1.2, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 0.8F-(currentWorld.rand.nextFloat()*0.2F));
			}
			if(counter == 40) {
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.08, posArray[0].getY() + 1.4, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.08, posArray[0].getY() + 1.4, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.08, posArray[0].getY() + 1.4, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 0.9F-(currentWorld.rand.nextFloat()*0.2F));
			}
			if(counter == 25) {
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.52, posArray[0].getY() + 1.6, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.52, posArray[0].getY() + 1.6, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.52, posArray[0].getY() + 1.6, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 1.0F-(currentWorld.rand.nextFloat()*0.2F));
			}
			if(counter == 10) {
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 2.98, posArray[0].getY() + 1.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 1.1F-(currentWorld.rand.nextFloat()*0.2F));
			}
			if(counter == 0) {
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 3.5, posArray[0].getY() + 1.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 3.5, posArray[0].getY() + 1.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.spawnParticle(EnumParticleTypes.CLOUD, posArray[0].getX() - 3.5, posArray[0].getY() + 1.8, posArray[0].getZ()+0.5, 0.0D, 0.0D, 0.0D);
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 1.2F-(currentWorld.rand.nextFloat()*0.2F));
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.click", 0.3F, 1.3F-(currentWorld.rand.nextFloat()*0.1F));
				currentWorld.playSoundEffect(currentMasterBlockPos.getX() + 0.5, currentMasterBlockPos.getY() + 0.5, currentMasterBlockPos.getZ() + 0.5, "random.orb", 0.6F, 0.6F-(currentWorld.rand.nextFloat()*0.2F));
				reset();
			}
		}
		if (startCounter == true) {
			counter--;
			if (counter == 0) {
				counter = defaultTime;
				startCounter = false;
			}
		}
	}

	private static void reset() {
		infusionSwortTemplateDiamondStart = false;
	}

}
