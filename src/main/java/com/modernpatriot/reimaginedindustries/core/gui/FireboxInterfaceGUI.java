package com.modernpatriot.reimaginedindustries.core.gui;

import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.modernpatriot.reimaginedindustries.core.Reference;
import com.modernpatriot.reimaginedindustries.tileentity.FireboxInterfaceData;
import com.modernpatriot.reimaginedindustries.tileentity.container.FireboxInterfaceContainer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class FireboxInterfaceGUI extends GuiContainer {
	
	private final static ResourceLocation fireboxInterfaceGUITexture = new ResourceLocation(Reference.MODID + ":textures/gui/BasicFireboxInterfaceGUI.png");
	private FireboxInterfaceData fidData;
	
	public FireboxInterfaceGUI(InventoryPlayer iPlayer, FireboxInterfaceData fid) {
		super(new FireboxInterfaceContainer(iPlayer, fid));
		this.fidData = fid;
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		//String string = this.fidData.hasCustomName() ? this.fidData.getName() : I18n.format(this.fidData.getName(), new Object[0]);
		//this.fontRendererObj.drawString(string, this.xSize/2 - this.fontRendererObj.getStringWidth(string), 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(fireboxInterfaceGUITexture);
		int k = (this.width-this.xSize)/2;
		int l = (this.height-this.ySize)/2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize+6);
		int i1;
		if(this.fidData.fidCurrentBurnTemp > 0){
			i1 = (int)this.fidData.getCurrentBurnTempTillHottestScaled(53);
			this.drawTexturedModalRect(k + 17, l + 69 - i1, 251, 53-i1, 5, i1);
		}
		
		i1 = this.fidData.getCookProgressScaled(40);
		this.drawTexturedModalRect(k + 72, l + 15 , 211, 0, i1, 47);
	}

}
