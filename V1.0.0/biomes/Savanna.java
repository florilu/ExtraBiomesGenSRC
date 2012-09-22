package net.minecraft.src.biomes;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class Savanna extends BiomeGenBase
{
    public Savanna(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        this.theBiomeDecorator.grassPerChunk = 4;
        //this.theBiomeDecorator.acaciaperchunk = 10;
        this.theBiomeDecorator.treesPerChunk = -999;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        if (par1Random.nextInt(5) == 0)
        {
            return worldGeneratorForest;
        }
        
        else
        {
            return worldGeneratorTrees;
        }
    }
}
