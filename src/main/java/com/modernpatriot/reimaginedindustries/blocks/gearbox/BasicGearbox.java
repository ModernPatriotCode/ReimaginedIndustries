package com.modernpatriot.reimaginedindustries.blocks.gearbox;

import com.modernpatriot.reimaginedindustries.core.logic.BasicInfuserLogic;
import com.modernpatriot.reimaginedindustries.core.util.UtilMethods;
import com.modernpatriot.reimaginedindustries.core.util.UtilStrings;
import com.modernpatriot.reimaginedindustries.items.ReimaginedItems;
import com.modernpatriot.reimaginedindustries.items.tools.IndustrialWrench;
import com.modernpatriot.reimaginedindustries.items.tools.SwordTemplate;
import com.modernpatriot.reimaginedindustries.tileentity.BasicGearboxData;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovementInputFromOptions;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class BasicGearbox extends BlockDirectional implements ITileEntityProvider {
	ItemStack[] infusionItems = new ItemStack[4];

	/*	isItemEqualOne and isItemEqualTwo
	 * 	are containing the information how many
	 * 	items of the type whatItemIsOne or whatItemIsTwo
	 * 	are there. */

	public BasicGearbox(Material materialIn) {
		super(materialIn);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new BasicGearboxData();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
		BasicGearboxData bgd = (BasicGearboxData)worldIn.getTileEntity(pos);
		if(bgd.getInventoryContent() == null) {
			if(playerIn.getCurrentEquippedItem() != null) {
				// SOMETHING IN HAND, NOTHING IN INVENTORY
				ItemStack holding = playerIn.getCurrentEquippedItem().copy();
				holding.stackSize = 1;
				bgd.setInventoryContent(holding);
				if(playerIn.getCurrentEquippedItem().stackSize!=0 && playerIn.capabilities.isCreativeMode != true) {
					playerIn.getCurrentEquippedItem().stackSize--;
				}
				worldIn.markBlockForUpdate(pos);
				UtilMethods.updateComparators(worldIn, pos);
				return true;
			}else{
				// NOTHING IN HAND AND INVENTORY
				worldIn.markBlockForUpdate(pos);
				UtilMethods.updateComparators(worldIn, pos);
				return false;
			}
		}else{
			if(playerIn.getCurrentEquippedItem() == null) {
				// SOMETHING IN INVENTORY, NOTHING IN HAND
				ItemStack inInv = bgd.getInventoryContent().copy();
				if(!worldIn.isRemote) {
					worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, inInv));
					// Effects
					worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.click", 0.3F, 1.3F-(worldIn.rand.nextFloat()*0.1F));
					worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.orb", 0.6F, 0.6F-(worldIn.rand.nextFloat()*0.2F));
					// Reset
					bgd.setInventoryContent(null);
					worldIn.markBlockForUpdate(pos);

				}
				UtilMethods.updateComparators(worldIn, pos);
				return true;
			}else{
				// SOMETHING IN INVENTORY AND HAND
				if(playerIn.getCurrentEquippedItem().getItem() instanceof IndustrialWrench) {
					double x = pos.getX();
					double y = pos.getY();
					double z = pos.getZ();
					BlockPos pos1 = new BlockPos(x+3,y-1,z);
					BlockPos pos2 = new BlockPos(x,y-1,z+3);
					BlockPos pos3 = new BlockPos(x-3,y-1,z);
					BlockPos pos4 = new BlockPos(x,y-1,z-3);
					if(worldIn.getTileEntity(pos1) instanceof BasicGearboxData) {
						BasicGearboxData bgd1 = (BasicGearboxData)worldIn.getTileEntity(pos1);
						if(worldIn.getTileEntity(pos2) instanceof BasicGearboxData) {
							BasicGearboxData bgd2 = (BasicGearboxData)worldIn.getTileEntity(pos2);
							if(worldIn.getTileEntity(pos3) instanceof BasicGearboxData) {
								BasicGearboxData bgd3 = (BasicGearboxData)worldIn.getTileEntity(pos3);
								if(worldIn.getTileEntity(pos4) instanceof BasicGearboxData) {
									BasicGearboxData bgd4 = (BasicGearboxData)worldIn.getTileEntity(pos4);
									if(bgd1.getInventoryContent()!=null) {
										infusionItems[0] = bgd1.getInventoryContent();
										if(bgd2.getInventoryContent()!=null) {
											infusionItems[1] = bgd2.getInventoryContent();
											if(bgd3.getInventoryContent()!=null) {
												infusionItems[2] = bgd3.getInventoryContent();
												if(bgd4.getInventoryContent()!=null) {
													infusionItems[3] = bgd4.getInventoryContent();
													BasicInfuserLogic.checkForRecipeItems(infusionItems, pos, worldIn, playerIn, bgd);
												}	
											}	
										}
									}
								}
							}
						}
					}
					UtilMethods.updateComparators(worldIn, pos);
					return true;
				}else{
					UtilMethods.updateComparators(worldIn, pos);
					return false;
				}
			}
		}

	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState blockstate) {
		// Effects
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.click", 0.6F, 0.8F-(worldIn.rand.nextFloat()*0.1F));
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.fizz", 0.4F, 0.5F-(worldIn.rand.nextFloat()*0.3F));
		// TileEntity
		BasicGearboxData bg = (BasicGearboxData) worldIn.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(worldIn, pos, bg);
		super.breakBlock(worldIn, pos, blockstate);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		// Effects
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.anvil_land", 1, 1-(worldIn.rand.nextFloat()*0.1F));
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.click", 0.6F, 1);
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.fizz", 0.6F, 0.6F-(worldIn.rand.nextFloat()*0.1F));
		worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 1.2, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
		worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 1.2, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 1.2 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 1.2 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 1.2 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
		worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getY() + 1.2 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, pos.getZ() + 0.5 + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.6F, 0.0D, 0.0D, 0.0D);
		// TileEntity
		if (stack.hasDisplayName()) {
			((BasicGearboxData) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean isFullCube()
	{
		return false;
	}

	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}

	@Override
	public boolean hasComparatorInputOverride() {
		return true;
	}

	@Override
	public int getComparatorInputOverride(World worldIn, BlockPos pos) {
		BasicGearboxData bgd = (BasicGearboxData)worldIn.getTileEntity(pos);
		return bgd.comparatorStrength();
	}

	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
		if (worldIn.isBlockPowered(pos) == true) {
			BasicGearboxData bgd = (BasicGearboxData)worldIn.getTileEntity(pos);
			ItemStack inInv = bgd.getInventoryContent();
			if(!worldIn.isRemote && inInv!=null) {
				worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, inInv));
				// Effects
				worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.click", 0.3F, 1.3F-(worldIn.rand.nextFloat()*0.1F));
				worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.orb", 0.6F, 0.6F-(worldIn.rand.nextFloat()*0.2F));
				// Reset
				bgd.setInventoryContent(null);
				worldIn.markBlockForUpdate(pos);
			}
		}
		worldIn.updateComparatorOutputLevel(pos, this);
		super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);
	}

}

