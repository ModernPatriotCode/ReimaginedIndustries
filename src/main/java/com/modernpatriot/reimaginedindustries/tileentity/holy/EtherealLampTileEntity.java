package com.modernpatriot.reimaginedindustries.tileentity.holy;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.util.effects.UtilEffectsMain;
import com.modernpatriot.reimaginedindustries.effects.EntityFloatingOrbFX;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class EtherealLampTileEntity extends TileEntity implements IUpdatePlayerListBox{

	private static int counter;
	private static int alreadyPlaced;
	private static int alreadyInside;
	private static BlockPos[] positionOfLightSources = new BlockPos[24];
	public static boolean notYetExecuted = true;
	private static BlockPos position;


	public void removeLightSources() {
		if (positionOfLightSources!=null) {
			for (int i = 0; i < 24; i++) {
				if (positionOfLightSources[i]!=null && positionOfLightSources[i]!=BlockPos.ORIGIN) {
					Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.RED + "REMOVING BLOCK AT " + EnumChatFormatting.GRAY + " X: " + positionOfLightSources[i].getX() + " Y: " + positionOfLightSources[i].getY() + " Z: " + positionOfLightSources[i].getZ()));
					worldObj.setBlockState(positionOfLightSources[i], Blocks.air.getDefaultState());
				}
			}
		}
		reset();
	}

	public void spawnParticlesAbove(BlockPos pos, World worldIn) {
		if (worldIn.isRemote) {
			float random = (worldIn.rand.nextFloat()-worldIn.rand.nextFloat());
			float speedBase = 0.02F;
			Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFloatingOrbFX(worldIn, pos.getX() + 0.5 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.1F, pos.getY() + 0.5 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.1F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat()-worldIn.rand.nextFloat())*0.1F, speedBase * random, speedBase * random, speedBase * random));
		}
	}

	public static void setPosition(BlockPos positionNew) {
		position = positionNew;
	}

	private void reset() {
		for (int i = 0; i < 24; i++) {
			positionOfLightSources[i] = BlockPos.ORIGIN;
			alreadyPlaced=0;
			alreadyInside=0;
		}
	}

	public void placeLightSources(BlockPos lampPos) {
		/* double x = lampPos.getX();
		double y = lampPos.getY();
		double z = lampPos.getZ();
		int a = worldObj.rand.nextInt(25);
		int b = worldObj.rand.nextInt(25);
		int c = worldObj.rand.nextInt(25);
		boolean donePlacingAtPos = false;
		if (worldObj.getLight(new BlockPos(x + a - 12, y + b - 12, z + c - 12)) < 3) {
			if (worldObj.getBlockState(new BlockPos(x + a - 12, y + b - 11, z + c - 12))==Blocks.air.getDefaultState()) {
				for (int i = 0; i < 6; i++) {
					UtilEffectsMain.spawnParticleAtBlockMiddle(EnumParticleTypes.CLOUD, new BlockPos(x + a - 12, y + b - 11, z + c - 12), worldObj);
				}
				if (alreadyPlaced < 24 && y+b-12>0) {
					alreadyPlaced++;
					worldObj.setBlockState(new BlockPos(x + a - 12, y + b - 11, z + c - 12), Blocks.glowstone.getDefaultState());
					alreadyInside++;
					for (int i = 0; i < 24; i++) {
						if (positionOfLightSources[i] == BlockPos.ORIGIN && !donePlacingAtPos) {
							if(i!=alreadyInside) {
								positionOfLightSources[i] = new BlockPos(x + a - 12, y + b - 11, z + c - 12);
								System.out.println("BLOCK AT X: " + positionOfLightSources[i].getX() + " Y: " + positionOfLightSources[i].getY() + " Z: " + positionOfLightSources[i].getZ());
								donePlacingAtPos = true;
								alreadyInside++;
							}
						}
					}
				}
			}
		}*/
	}

	@Override
	public void update() {
		counter++;
		if (notYetExecuted = true) {
			reset();
			notYetExecuted = false;
		}
		if (position!=null) {
			spawnParticlesAbove(position, worldObj);
			if (counter > 30) {
				placeLightSources(position);
			}
			counter = 0;
		}
	}
	/* double xpos = x+a-12;
		double ypos = y+b-11;
		double zpos = z+c-12;
		Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(EnumChatFormatting.GREEN + "PLACING BLOCK AT: " + EnumChatFormatting.GRAY + " X: " + xpos + " Y: " + ypos + " Z: " + zpos));*/

}
