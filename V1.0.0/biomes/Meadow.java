package net.minecraft.src.biomes;

import java.util.List;
import net.minecraft.src.*;
import java.util.Random;

public class Meadow extends BiomeGenBase
{
    public Meadow(int par1)
    {
        super(par1);
        spawnableCreatureList.add(new SpawnListEntry(net.minecraft.src.EntityCow.class, 5, 4, 4));
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = 5;
        this.theBiomeDecorator.redFlowersPerChunk = 5;
        this.theBiomeDecorator.yellowFlowersPerChunk = 5;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        if (par1Random.nextInt(100) == 0)
        {
            return worldGeneratorForest;
        }

        if (par1Random.nextInt(10000) == 0)
        {
            return worldGeneratorBigTree;
        }
        else
        {
            return worldGeneratorTrees;
        }
    }
}
