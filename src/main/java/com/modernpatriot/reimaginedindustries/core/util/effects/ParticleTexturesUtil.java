package com.modernpatriot.reimaginedindustries.core.util.effects;

import com.modernpatriot.reimaginedindustries.core.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class ParticleTexturesUtil {
	public static final ResourceLocation spherebig = new ResourceLocation(Reference.MODID, "textures/particles/spherebig.png");
	public static final ResourceLocation sphere1 = new ResourceLocation(Reference.MODID, "textures/particles/sphere1.png");
	public static final ResourceLocation spheretest = new ResourceLocation(Reference.MODID, "textures/particles/spheretest.png");
	public static final ResourceLocation sphere = new ResourceLocation(Reference.MODID, "textures/particles/sphere.png");
}
