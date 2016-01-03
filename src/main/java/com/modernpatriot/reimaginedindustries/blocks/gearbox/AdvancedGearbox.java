package com.modernpatriot.reimaginedindustries.blocks.gearbox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;

public class AdvancedGearbox extends Block {

	public AdvancedGearbox(Material materialIn) {
		super(materialIn);
		this.isBlockContainer = true;
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
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState blockstate) {
		// Effects
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.click", 0.6F, 0.8F-(worldIn.rand.nextFloat()*0.1F));
		worldIn.playSoundEffect(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, "random.fizz", 0.4F, 0.5F-(worldIn.rand.nextFloat()*0.3F));
	}
	
	@Override
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	    

}
