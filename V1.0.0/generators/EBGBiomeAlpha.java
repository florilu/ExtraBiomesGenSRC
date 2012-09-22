package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGBiomeAlpha extends BiomeGenBase
{
    public boolean isRainForest;

    public EBGBiomeAlpha(int var1, int var2, int var3, int var4, int var5, boolean var6, boolean var7)
    {
        super(var1);
        this.theBiomeDecorator.mayrandtrees = true;
        this.theBiomeDecorator.minTreesPerChunk = var2;
        this.theBiomeDecorator.yellowFlowersPerChunk = var4;
        this.theBiomeDecorator.redFlowersPerChunk = var3;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.theBiomeDecorator.reedsPerChunk = 10;
        this.theBiomeDecorator.redMushroomsPerChunk = 0;
        this.theBiomeDecorator.brownMushroomsPerChunk = 0;

        if (var2 == 6)
        {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }

        if (var6)
        {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        }

        if (var7)
        {
            this.spawnableCreatureList.clear();
            this.topBlock = (byte)Block.sand.blockID;
            this.fillerBlock = (byte)Block.sand.blockID;
            this.theBiomeDecorator.deadBushPerChunk = 2;
            this.theBiomeDecorator.cactiPerChunk = 10;
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(7) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        super.decorate(var1, var2, var3, var4);
        int var5 = 3 + var2.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int var7 = var3 + var2.nextInt(16);
            int var8 = var2.nextInt(28) + 4;
            int var9 = var4 + var2.nextInt(16);
            int var10 = var1.getBlockId(var7, var8, var9);

            if (var10 == Block.stone.blockID)
            {
                var1.setBlock(var7, var8, var9, Block.oreDiamond.blockID);
            }
        }
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        return 11272039;
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        return 5242667;
    }
}
