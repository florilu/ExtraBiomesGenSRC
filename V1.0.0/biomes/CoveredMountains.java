package net.minecraft.src.biomes;

import java.util.Random;
import net.minecraft.src.*;

public class CoveredMountains extends BiomeGenBase
{
	public CoveredMountains(int par1)
	{
		super(par1);
		this.spawnableCreatureList.clear();
        this.topBlock = (byte)Block.blockSnow.blockID;
        this.fillerBlock = (byte)Block.stone.blockID;
        this.theBiomeDecorator.treesPerChunk = 3;
	}
}



