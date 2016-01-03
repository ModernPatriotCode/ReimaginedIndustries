package com.modernpatriot.reimaginedindustries.world.biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeDecoratorWasteland extends BiomeDecorator {

	protected int deadbushGen;
	
	public BiomeDecoratorWasteland(BiomeGenBase biomegenbase) {
		super();
	}

	@Override
	public void decorate(World worldIn, Random random, BiomeGenBase biomegenbase, BlockPos pos) {
		Block block;

        do
        {
            block = worldIn.getBlockState(pos).getBlock();
            if (!block.isLeaves(worldIn, pos) && !block.isLeaves(worldIn, pos)) break;
            pos = pos.down();
        } while (pos.getY() > 0);

        for (int i = 0; i < deadbushGen; ++i)
        {
            BlockPos blockpos1 = pos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));

            if (worldIn.isAirBlock(blockpos1) && worldIn.getBlockState(blockpos1.down()).getBlock() == Blocks.cobblestone)
            {
                worldIn.setBlockState(blockpos1, Blocks.deadbush.getDefaultState(), 2);
            }
        }
		super.decorate(worldIn, random, biomegenbase, pos);
	}
	
}
