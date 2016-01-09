package com.modernpatriot.reimaginedindustries;

import com.modernpatriot.reimaginedindustries.blocks.BasicBlock;
import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.util.handlers.TickHandler;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;
import com.modernpatriot.reimaginedindustries.tileentity.tesr.BasicGearboxTESR;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * <h1> ReimaginedIndustries ClientProxy class </h1>
 * Used to do stuff only on client side
 * @author MoPat
 */
public class ClientProxy extends CommonProxy {
	

	
	@Override
	public void registerRenders() {
		ReimaginedBlocks.registerRenders();
		ReimaginedItems.registerRenders();
		   
	}
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	    @Override
	    public void init(FMLInitializationEvent e) {
	        super.init(e);
	        ClientRegistry.bindTileEntitySpecialRenderer(BasicGearboxData.class, new BasicGearboxTESR());
	    }

	    @Override
	    public void postInit(FMLPostInitializationEvent e) {
	        super.postInit(e);
	    }
	   
	    public void registerTESR() {
	    	ClientRegistry.bindTileEntitySpecialRenderer(BasicGearboxData.class, new BasicGearboxTESR());
	    }
	    @SideOnly(Side.CLIENT)
	    public static void registerSided() {
	    	
	    }
		@Override
		public EntityPlayer getClientPlayer() {
			return Minecraft.getMinecraft().thePlayer;
		}
}
