package com.modernpatriot.reimaginedindustries.effects;

import static org.lwjgl.opengl.GL11.*;

import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.core.util.effects.ParticleTexturesUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.SimpleTexture;

/**
 * Particle class.
 * @author MoPat
 */
public class EntityFloatingOrbFX extends EntityFX{

	public EntityFloatingOrbFX(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn*0.01, ySpeedIn*0.01, zSpeedIn*0.01);
		setGravity(0.00004F);
		setMaxAge((int)(20.0F / (this.rand.nextFloat() * 0.9F + 0.1F)));
	}

	@Override
	public void func_180434_a(WorldRenderer renderer, Entity entityfx, float partialTicks, float par3, float par4, float par5, float par6, float par7) {
		Minecraft.getMinecraft().renderEngine.bindTexture(ParticleTexturesUtil.SPHERE);
		Tessellator tess = Tessellator.getInstance();
		glPushMatrix();
		glDepthMask(false);
		glEnable(GL_BLEND);
		glAlphaFunc(GL_GREATER, 0.003921549F);
		renderer.startDrawingQuads();
		renderer.setBrightness(getBrightnessForRender(partialTicks));
		int counter = particleAge * 4;
		float red = 1F;
		float blue = 0.1F;
		float green = 0.5F;
		float opacity = 0.9F * (0.4F * particleMaxAge/particleAge);
		 if (red <= 0.9F && green <= 0.9F && blue <= 0.9F) {
			if (counter < 10) {
				red += 0.1;
			}else if(counter > 10 && counter < 20) {
				blue += 0.1;
			}else if(counter > 20 && counter < 30) {
				green += 0.1;
			}else if(counter > 30 && counter < 40) {
				red += 0.1;
			}else if(counter > 40 && counter < 50) {
				blue += 0.1;
			}else if(counter > 50 && counter < 60) {
				green += 0.1;
			}else{}
		}
		float scale = (10F*particleScale) / particleMaxAge / particleAge;
		float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);
		glColor4f(red, green, blue, opacity);
		renderer.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 * scale - par7 * scale, 0, 0);
		renderer.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 * scale + par7 * scale, 1, 0);
		renderer.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z + par5 * scale + par7 * scale, 1, 1);
		renderer.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z + par5 * scale - par7 * scale, 0, 1);
		tess.draw();
		glDisable(GL_BLEND);
		glDepthMask(true);
		glAlphaFunc(GL_GREATER, 0.1F);
		glPopMatrix();
	}

	@Override
	public int getFXLayer() {
		return 3;
	}

	public EntityFloatingOrbFX setMaxAge(int maxAge) {
		particleMaxAge = maxAge;
		return this;
	}

	public EntityFloatingOrbFX setGravity(float newGravity) {
		particleGravity = newGravity;
		return this;
	}

	public EntityFloatingOrbFX setScale(float newScale) {
		particleScale = newScale;
		return this;
	}

}
