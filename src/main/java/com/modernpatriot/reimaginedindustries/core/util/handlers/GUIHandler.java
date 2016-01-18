package com.modernpatriot.reimaginedindustries.core.util.handlers;

import com.modernpatriot.reimaginedindustries.core.gui.FireboxInterfaceGUI;
import com.modernpatriot.reimaginedindustries.tileentity.FireboxInterfaceData;
import com.modernpatriot.reimaginedindustries.tileentity.container.FireboxInterfaceContainer;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Distributes the gui elements between the server and the client.
 * @author MoPat
 */
public class GUIHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World worldIn, int x, int y, int z) {
		if(ID == 0){
			FireboxInterfaceData fid = (FireboxInterfaceData)worldIn.getTileEntity(new BlockPos(x,y,z));
			return new FireboxInterfaceContainer(player.inventory, fid);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World worldIn, int x, int y, int z) {
		if(ID == 0){
			FireboxInterfaceData fid = (FireboxInterfaceData)worldIn.getTileEntity(new BlockPos(x,y,z));
			return new FireboxInterfaceGUI(player.inventory, fid);
		}
		return null;
	}

}
