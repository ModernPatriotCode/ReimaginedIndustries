package com.modernpatriot.reimaginedindustries.blocks.multiblock;

import java.util.Random;

import com.modernpatriot.reimaginedindustries.ReimaginedIndustries;
import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;
import com.modernpatriot.reimaginedindustries.core.util.blueprints.BlockProperties;
import com.modernpatriot.reimaginedindustries.core.util.blueprints.BlockProperties.EnumType;
import com.modernpatriot.reimaginedindustries.tileentity.FireboxInterfaceData;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FireboxInterface extends BlockContainer{
	
	// TODO: Implement BlockFacing + Implement Block Textures (Blockstates)
	
	private static boolean isBurning;
	private final boolean isBurning2;
	private static boolean isFormed;
	private final Random random = new Random();

	public FireboxInterface(Material materialIn, boolean isActive) {
		super(materialIn);
		isBurning2 = isActive;
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumType.NORTH));
	}
	
	@Override
	public int getRenderType()
	{
	return 3;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ){
		if(!worldIn.isRemote){
			player.openGui(ReimaginedIndustries.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());	
		}
		return true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int index){
		return new FireboxInterfaceData();
	}
	
	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(ReimaginedBlocks.fireboxInterface);
	}
	
	public Item getItem(World worldIn, int par2, int par3, int par4) {
		return Item.getItemFromBlock(ReimaginedBlocks.fireboxInterface);
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        if(facing == EnumFacing.NORTH){
        	return this.getDefaultState().withProperty(FACING, EnumType.NORTH);
        }else if(facing == EnumFacing.EAST){
        	return this.getDefaultState().withProperty(FACING, EnumType.EAST);
        }else if(facing == EnumFacing.SOUTH){
        	return this.getDefaultState().withProperty(FACING, EnumType.SOUTH);
        }else if(facing == EnumFacing.WEST){
        	return this.getDefaultState().withProperty(FACING, EnumType.WEST);
        }else if(facing == EnumFacing.UP || facing == EnumFacing.DOWN){
        	// ROTATION IS MIRRORED BECAUSE ITS NOW THE ROTATION OF THE PERSPECTIVE OF THE PLAYER
        	if(placer.getHorizontalFacing()==EnumFacing.NORTH){
        		return this.getDefaultState().withProperty(FACING, EnumType.SOUTH);
        	}else if(placer.getHorizontalFacing()==EnumFacing.EAST){
        		return this.getDefaultState().withProperty(FACING, EnumType.WEST);
        	}else if(placer.getHorizontalFacing()==EnumFacing.SOUTH){
        		return this.getDefaultState().withProperty(FACING, EnumType.NORTH);
        	}else if(placer.getHorizontalFacing()==EnumFacing.WEST){
        		return this.getDefaultState().withProperty(FACING, EnumType.EAST);
        	}else{
        		return this.getDefaultState().withProperty(FACING, EnumType.NORTH);
        	}
        }else{
        	return this.getDefaultState().withProperty(FACING, EnumType.NORTH);
        }
    }
	
	public static final PropertyEnum FACING = PropertyEnum.create("facing", EnumType.class);
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
	    return getDefaultState().withProperty(FACING, meta == 0 ? EnumType.NORTH : meta == 1 ? EnumType.SOUTH : meta == 2 ? EnumType.WEST : EnumType.EAST);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumType type = (EnumType) state.getValue(FACING);
	    return type.getID();
	}
	
	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { FACING });
	}
	
	private void getBedDirection(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		if(!worldIn.isRemote) {
			BlockPos bPos1 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1);
			BlockPos bPos2 = new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1);
			BlockPos bPos3 = new BlockPos(pos.getX()-1, pos.getY(), pos.getZ());
			BlockPos bPos4 = new BlockPos(pos.getX()+1, pos.getY(), pos.getZ());
			Block direction1 = worldIn.getBlockState(bPos1).getBlock();
			Block direction2 = worldIn.getBlockState(bPos2).getBlock();
			Block direction3 = worldIn.getBlockState(bPos3).getBlock();
			Block direction4 = worldIn.getBlockState(bPos4).getBlock();
			byte byteZERO = 0;
			//NORTH
			if (direction1.isOpaqueCube() && !direction2.isOpaqueCube()) {
				byteZERO = 0;
			}
			//SOUTH
			if (direction2.isOpaqueCube() && !direction1.isOpaqueCube()) {
				byteZERO = 1;
			}
			//WEST
			if (direction3.isOpaqueCube() && !direction4.isOpaqueCube()) {
				byteZERO = 2;
			}
			//EAST
			if (direction4.isOpaqueCube() && !direction3.isOpaqueCube()) {
				byteZERO = 3;
			}
			worldIn.setBlockState(pos, worldIn.getBlockState(pos).getBlock().getStateFromMeta(byteZERO));
		}
	}
	
	public void breakBlock(World worldIn, BlockPos pos, Block block) {
		if(!isBurning){
			FireboxInterfaceData fid = (FireboxInterfaceData)worldIn.getTileEntity(pos);
			if(fid != null){
				for(int i = 0;i < fid.getSizeInventory(); i++) {
					ItemStack stack = fid.getStackInSlot(i);
					if(stack != null){
						float r1 = this.random.nextFloat()*0.6F+0.1F;
						float r2 = this.random.nextFloat()*0.6F+0.1F;
						float r3 = this.random.nextFloat()*0.6F+0.1F;
						while(stack.stackSize > 0){
							int j = this.random.nextInt(21)+10;
							if(j > stack.stackSize) {
								j = stack.stackSize;
							}
							stack.stackSize -= j;
							EntityItem entityitem = new EntityItem(worldIn,(double)((float)pos.getX()+r1),(double)((float)pos.getY()+r2),(double)((float)pos.getZ()+r3), new ItemStack(stack.getItem(), j, stack.getItemDamage()));
							if(stack.hasTagCompound()){
								entityitem.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
							}
							float f4 = 0.025F;
							entityitem.motionX = (double)((float)this.random.nextGaussian()*f4);
							entityitem.motionY = (double)((float)this.random.nextGaussian()*f4+0.1F);
							entityitem.motionZ = (double)((float)this.random.nextGaussian()*f4);
							worldIn.spawnEntityInWorld(entityitem);
						}
					}
				}
			}
		}
		super.breakBlock(worldIn, pos, worldIn.getBlockState(pos));
	}
	
	@SideOnly(Side.CLIENT)
	public void randomTickDisplay(World worldIn, BlockPos pos, Random random) {
		if(this.isBurning2){
			int direction = worldIn.getBlockState(pos).getBlock().getMetaFromState(worldIn.getBlockState(pos));
			float x = (float) pos.getX()+0.5F,y = (float) pos.getY() + random.nextFloat()*6.0F/16.0F, z = (float) pos.getZ() + 0.5F, x2 = random.nextFloat() * 0.3F - 0.2F, z2 = 0.5F;
			if (direction == 0) {
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 1) {
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 2) {
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 3) {
				worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
				worldIn.spawnParticle(EnumParticleTypes.FLAME, (double) (x - z2), (double) y, (double) (z + x2), 0.0F, 0.0F, 0.0F);
			}
		}
	}
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, EntityLivingBase entity, ItemStack itemstack) {
		int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(direction == 0) {
			worldIn.setBlockState(pos, worldIn.getBlockState(pos).getBlock().getStateFromMeta(0));
		}
		
		if(direction == 1) {
			worldIn.setBlockState(pos, worldIn.getBlockState(pos).getBlock().getStateFromMeta(1));
		}
		
		if(direction == 2) {
			worldIn.setBlockState(pos, worldIn.getBlockState(pos).getBlock().getStateFromMeta(2));
		}
		
		if(direction == 3) {
			worldIn.setBlockState(pos, worldIn.getBlockState(pos).getBlock().getStateFromMeta(3));
		}
		
		if(itemstack.hasDisplayName()) {
			((FireboxInterfaceData)worldIn.getTileEntity(pos)).furnaceName(itemstack.getDisplayName());
		}
	}
	
	public static void updateBlockState(boolean burning, World worldIn, BlockPos pos) {
		int direction = worldIn.getBlockState(pos).getBlock().getMetaFromState(worldIn.getBlockState(pos));
		TileEntity tileentity = worldIn.getTileEntity(pos);
		isBurning = true;
		if(burning){
			worldIn.setBlockState(pos, ReimaginedBlocks.fireboxInterfaceActive.getStateFromMeta(direction));
		}else{
			worldIn.setBlockState(pos, ReimaginedBlocks.fireboxInterface.getStateFromMeta(direction));
		}
		worldIn.setBlockState(pos, worldIn.getBlockState(pos).getBlock().getStateFromMeta(direction));
		isBurning = false;
		if (tileentity != null){
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}
	
	public enum EnumType implements IStringSerializable {
		NORTH(2, "north"),
		SOUTH(0, "south"),
		WEST(1, "west"),
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
