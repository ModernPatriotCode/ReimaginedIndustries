package com.modernpatriot.reimaginedindustries.core.util.effects;

import com.modernpatriot.reimaginedindustries.core.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Used to have a separate reference for particle textures.
 * @author MoPat
 */
@SideOnly(Side.CLIENT)
public class ParticleTexturesUtil {
	public static final ResourceLocation SPHEREBIG = new ResourceLocation(Reference.MODID, "textures/particles/spherebig.png");
	public static final ResourceLocation SPHEREONE = new ResourceLocation(Reference.MODID, "textures/particles/sphere1.png");
	public static final ResourceLocation SPHERETEST = new ResourceLocation(Reference.MODID, "textures/particles/spheretest.png");
	public static final ResourceLocation SPHERE = new ResourceLocation(Reference.MODID, "textures/particles/sphere.png");
}
