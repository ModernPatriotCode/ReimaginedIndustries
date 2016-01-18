package com.modernpatriot.reimaginedindustries.core.util;

import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Contains important methods.
 * @author MoPat
 */
public class UtilMethods {
	
	/**
	 * Updates all reachable comparators.
	 * @param worldIn
	 * @param pos
	 */
	public static void updateComparators(World worldIn, BlockPos pos) {
		
		BlockPos posA = new BlockPos(pos.getX()+1,pos.getY(),pos.getZ());
		BlockPos posB = new BlockPos(pos.getX()-1,pos.getY(),pos.getZ());
		BlockPos posC = new BlockPos(pos.getX(),pos.getY(),pos.getZ()+1);
		BlockPos posD = new BlockPos(pos.getX(),pos.getY(),pos.getZ()-1);
		BlockPos posE = new BlockPos(pos.getX()+2,pos.getY(),pos.getZ());
		BlockPos posF = new BlockPos(pos.getX()-2,pos.getY(),pos.getZ());
		BlockPos posG = new BlockPos(pos.getX(),pos.getY(),pos.getZ()+2);
		BlockPos posH = new BlockPos(pos.getX(),pos.getY(),pos.getZ()-2);
		
		if(worldIn.getBlockState(posA).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posA).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posA).getBlock().onNeighborBlockChange(worldIn, posA, worldIn.getBlockState(posA), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posB).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posB).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posB).getBlock().onNeighborBlockChange(worldIn, posB, worldIn.getBlockState(posB), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posC).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posC).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posC).getBlock().onNeighborBlockChange(worldIn, posC, worldIn.getBlockState(posC), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posD).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posD).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posD).getBlock().onNeighborBlockChange(worldIn, posD, worldIn.getBlockState(posD), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posE).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posE).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posE).getBlock().onNeighborBlockChange(worldIn, posE, worldIn.getBlockState(posE), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posF).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posF).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posF).getBlock().onNeighborBlockChange(worldIn, posF, worldIn.getBlockState(posF), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posG).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posG).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posG).getBlock().onNeighborBlockChange(worldIn, posG, worldIn.getBlockState(posG), worldIn.getBlockState(pos).getBlock());
		}
		if(worldIn.getBlockState(posH).getBlock()==Blocks.powered_comparator || worldIn.getBlockState(posH).getBlock()==Blocks.unpowered_comparator) {
			worldIn.getBlockState(posH).getBlock().onNeighborBlockChange(worldIn, posH, worldIn.getBlockState(posH), worldIn.getBlockState(pos).getBlock());
		}
	}
	

}
