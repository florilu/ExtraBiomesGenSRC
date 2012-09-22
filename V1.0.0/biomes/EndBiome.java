package net.minecraft.src.biomes;

import java.util.List;
import net.minecraft.src.*;

public class EndBiome extends BiomeGenBase
{
    public EndBiome(int par1)
    {
        super(par1);
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();
        spawnableWaterCreatureList.clear();
        spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityEnderman.class, 10, 4, 4));
        topBlock = (byte)Block.whiteStone.blockID;
        fillerBlock = (byte)Block.whiteStone.blockID;
        this.theBiomeDecorator = new BiomeEndDecorator(this);
    }

}
