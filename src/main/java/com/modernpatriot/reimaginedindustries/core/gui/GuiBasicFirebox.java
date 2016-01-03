package com.modernpatriot.reimaginedindustries.core.gui;

import com.modernpatriot.reimaginedindustries.core.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiBasicFirebox extends GuiContainer {
	
	public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MODID + ":textures/gui/BasicFireboxInterfaceGUI.png");

	public GuiBasicFirebox(Container container) {
		super(container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		mc.renderEngine.bindTexture(TEXTURE);
		int wMiddle = (this.width - this.xSize)/2;
		int hMiddle = (this.height - this.ySize)/2;
		drawTexturedModalRect(wMiddle,hMiddle,0,0,xSize,ySize);
	}

}
