package com.modernpatriot.reimaginedindustries.tileentity.tesr;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.jcraft.jorbis.Block;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BasicGearboxTESR extends TileEntitySpecialRenderer {
	public BasicGearboxTESR() {
	}
	
	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f, int i) {
		World worldIn = te.getWorld();
		BlockPos posB = te.getPos();
		BasicGearboxData bgd = (BasicGearboxData)worldIn.getTileEntity(posB);
		ItemStack itemstack = bgd.getInventoryContent();
		if(itemstack!=null){
			double angularPositionInDegrees = bgd.getNextAngularPosition(0.07);
			float floating = bgd.getNextAngularPosition1(0.5F)-180F;
			EntityItem entItem = new EntityItem(bgd.getWorld(), x, y, z, bgd.getStackInSlot(0));
			GL11.glPushMatrix();
			GL11.glDepthMask(true); 
			entItem.hoverStart = 0.0F;
			GL11.glColor4f(0F, 0F, 0F, 0.35F);
			GL11.glTranslatef((float)x + 0.5F, (float)y + 0.7F , (float)z + 0.5F);
			GlStateManager.scale(1.2, 1.2, 1.2);
			GlStateManager.rotate((float)angularPositionInDegrees, 0, 1, 0);
			Minecraft.getMinecraft().getRenderManager().renderEntityWithPosYaw(entItem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
			GL11.glPopMatrix();
		}
	}

}
