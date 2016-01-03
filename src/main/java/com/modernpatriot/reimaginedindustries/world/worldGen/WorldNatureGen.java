package com.modernpatriot.reimaginedindustries.world.worldGen;

import java.util.Random;

import com.modernpatriot.reimaginedindustries.blocks.ReimaginedBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldNatureGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimensionId()){
		
		case -1:
			GenerateNether(world, chunkX * 16, chunkZ * 16, random);
			break;
		case 0:
			GenerateOverworld(world, chunkX * 16, chunkZ * 16, random);
			break;
		case 1:
			GenerateEnd(world, chunkX * 16, chunkZ * 16, random);
			break;
		case 7:
			GenerateTwighlightForest(world, chunkX * 16, chunkZ * 16, random);
			break;
		case -100:
			GenerateDeepDark(world, chunkX * 16, chunkZ * 16, random);
			break;
		}
		

	}
	
	private void addGen(Block block, Block blockSpawn, Random random, World world, int posX, int posZ, int minY, int maxY, int minVein, int maxVein, int spawnChance) {
		for(int i = 0; i < spawnChance; i++) {
			int defaultChunkSize = 16;
			
			int Xpos = posX + random.nextInt(defaultChunkSize);
			int Zpos = posZ + random.nextInt(defaultChunkSize);
			int Ypos = minY + random.nextInt(maxY - minY);
			
			IBlockState state = block.getDefaultState();
			BlockPos blockPos = new BlockPos(Xpos, Ypos, Zpos);
			
			new WorldGenMinable(state, maxVein).generate(world, random, blockPos);
		}
		
	}

	private void GenerateEnd(World world, int i, int j, Random random) {
		addGen(ReimaginedBlocks.unstableDust, Blocks.end_stone, random, world, i, j, 13, 60, 2, 20, 2);
		
	}

	private void GenerateDeepDark(World world, int i, int j, Random random) {
		addGen(ReimaginedBlocks.unstableDust, Blocks.cobblestone, random, world, i, j, 0, 400, 2, 20, 10);
		addGen(ReimaginedBlocks.unstableDust, Blocks.stone, random, world, i, j, 0, 400, 2, 6, 30);
		
	}

	private void GenerateTwighlightForest(World world, int i, int j, Random random) {
		addGen(ReimaginedBlocks.unstableDust, Blocks.cobblestone, random, world, i, j, 0, 400, 2, 15, 20);
		addGen(ReimaginedBlocks.unstableDust, Blocks.stone, random, world, i, j, 0, 400, 2, 6, 20);
		
	}

	private void GenerateOverworld(World world, int i, int j, Random random) {
		addGen(ReimaginedBlocks.unstableDust, Blocks.stone, random, world, i, j, 10, 300, 2, 12, 20);
		addGen(ReimaginedBlocks.unstableDust, Blocks.sand, random, world, i, j, 10, 400, 2, 6, 25);
		addGen(ReimaginedBlocks.unstableDust, Blocks.dirt, random, world, i, j, 10, 400, 2, 7, 20);
		
		addGen(ReimaginedBlocks.industrialLoam, Blocks.stone, random, world, i, j, 10, 300, 2, 15, 5);
		addGen(ReimaginedBlocks.industrialLoam, Blocks.sand, random, world, i, j, 10, 400, 2, 6, 5);
		addGen(ReimaginedBlocks.industrialLoam, Blocks.dirt, random, world, i, j, 10, 400, 2, 7, 5);
	}

	private void GenerateNether(World world, int i, int j, Random random) {
		addGen(ReimaginedBlocks.unstableDust, Blocks.netherrack, random, world, i, j, 4, 121, 2, 20, 2);
		
	}

}
