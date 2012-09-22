package net.minecraft.src.biomes;

import java.util.Random;
import net.minecraft.src.*;

public class LittleMountainsGreen extends BiomeGenBase
{
	public LittleMountainsGreen(int par1)
	{
		super(par1);
		this.spawnableCreatureList.clear();
        this.theBiomeDecorator.treesPerChunk = 2;
	}
}



