//      T H I S   I S   A   B L U E P R I N T   C L A S S

package com.modernpatriot.reimaginedindustries.core.util.blueprints;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IStringSerializable;

/**
 * BLUEPRINT FOR BLOCKS WITH ENUMTYPES (F.E. METADATA) <p>
 * <i> This is a blueprint class. Blueprint classes are used as a template for similar classes. </i>
 * @author MoPat
 */
public class BlockProperties extends Block {


	protected BlockProperties(String unlocalizedName, Material material, float hardness, float resistance) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
	}

	public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockProperties.EnumType.class);
	
	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(TYPE, meta == 0 ? EnumType.NORTH : meta == 1 ? EnumType.SOUTH : meta == 2 ? EnumType.WEST : EnumType.EAST);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumType type = (EnumType) state.getValue(TYPE);
	    return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}
	
	public enum EnumType implements IStringSerializable {
		NORTH(0, "north"),
		SOUTH(1, "south"),
		WEST(2, "west"),
		EAST(3, "east");
		
		private int ID;
	    private String name;
	    
	    private EnumType(int ID, String name) {
	        this.ID = ID;
	        this.name = name;
	    }
	    
	    @Override
	    public String getName() {
	        return name;
	    }

	    public int getID() {
	        return ID;
	    }
	   
	    @Override
	    public String toString() {
	        return getName();
	    }

	}
	
}
