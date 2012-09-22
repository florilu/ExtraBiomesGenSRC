package net.minecraft.src.biomes;

import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.structures.Pyramid;
import net.minecraft.src.trees.*;

public class Redwoods extends BiomeGenBase
{
    public Redwoods(int par1)
    {
        super(par1);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        this.theBiomeDecorator.bigpineperchunk = 3;
        this.theBiomeDecorator.grassPerChunk = 10;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.redFlowersPerChunk = 10;
        this.theBiomeDecorator.yellowFlowersPerChunk = 10;
    }
   
}
