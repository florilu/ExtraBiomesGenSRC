package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGBiomeGold extends BiomeGenBase
{
    private int idbiome;
    private int idtype;
    private int idgold;

    public EBGBiomeGold(int var1, int var2, int var3)
    {
        super(var1);
        this.idbiome = var1;
        this.idtype = var3;
        this.idgold = var2;

        if (this.idgold == 1)
        {
            this.theBiomeDecorator.reedsPerChunk = 0;

            if (this.idtype == 1)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 4;
                this.theBiomeDecorator.maxTreeHeight = 80;
                this.spawnableCreatureList.clear();
            }

            if (this.idtype == 2)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 4;
                this.theBiomeDecorator.maxTreeHeight = 85;
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.yellowFlowersPerChunk = 1;
                this.theBiomeDecorator.redFlowersPerChunk = 2;
                this.theBiomeDecorator.grassPerChunk = 3;
            }

            if (this.idtype == 3)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 10;
                this.theBiomeDecorator.yellowFlowersPerChunk = 1;
                this.theBiomeDecorator.redFlowersPerChunk = 2;
                this.theBiomeDecorator.grassPerChunk = 4;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
            }

            if (this.idtype == 4)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 10;
                this.theBiomeDecorator.yellowFlowersPerChunk = 1;
                this.theBiomeDecorator.redFlowersPerChunk = 2;
                this.theBiomeDecorator.grassPerChunk = 4;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
            }

            if (this.idtype == 5)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = -1;
                this.theBiomeDecorator.yellowFlowersPerChunk = 2;
                this.theBiomeDecorator.redFlowersPerChunk = 3;
                this.theBiomeDecorator.grassPerChunk = 9;
            }

            if (this.idtype == 6)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 5;
                this.theBiomeDecorator.yellowFlowersPerChunk = 1;
                this.theBiomeDecorator.redFlowersPerChunk = 2;
                this.theBiomeDecorator.grassPerChunk = 3;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
            }
        }

        if (this.idgold == 2)
        {
            if (this.idtype == 1 || this.idtype == 2)
            {
                this.topBlock = (byte)Block.sand.blockID;
                this.fillerBlock = (byte)Block.sand.blockID;
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = -20;
                this.theBiomeDecorator.deadBushPerChunk = 1;
                this.theBiomeDecorator.cactiPerChunk = 7;
            }

            if (this.idtype == 3)
            {
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 2;
                this.theBiomeDecorator.grassPerChunk = 3;
            }

            if (this.idtype == 4)
            {
                this.topBlock = (byte)Block.sand.blockID;
                this.fillerBlock = (byte)Block.sand.blockID;
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 6;
                this.theBiomeDecorator.yellowFlowersPerChunk = 3;
                this.theBiomeDecorator.redFlowersPerChunk = 3;
                this.theBiomeDecorator.grassPerChunk = 5;
                this.theBiomeDecorator.reedsPerChunk = 40;
            }

            if (this.idtype == 5)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.minTreesPerChunk = 4;
                this.theBiomeDecorator.yellowFlowersPerChunk = 1;
                this.theBiomeDecorator.redFlowersPerChunk = 1;
                this.theBiomeDecorator.grassPerChunk = 3;
            }
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        if (this.idgold == 1)
        {
            if (this.idtype == 1)
            {
                if (var1.nextInt(3) == 0)
                {
                    return new EBGGenSnowTree1(5 + var1.nextInt(4), 3);
                }

                return new EBGGenSnowTree2(false, 5 + var1.nextInt(4), 1 + var1.nextInt(2), 0 + var1.nextInt(2));
            }

            if (this.idtype == 2)
            {
                if (var1.nextInt(3) == 0)
                {
                    return new EBGGenSnowTree1(5 + var1.nextInt(4), 3);
                }

                return new EBGGenSnowTree2(false, 5 + var1.nextInt(4), 1 + var1.nextInt(2), 0 + var1.nextInt(2));
            }

            if (this.idtype == 3)
            {
                if (var1.nextInt(5) == 0)
                {
                    return new EBGGenSnowTree3(false, 15 + var1.nextInt(10), 4 + var1.nextInt(2), 3);
                }

                if (var1.nextInt(2) == 0)
                {
                    return new EBGGenSnowTree1(8 + var1.nextInt(5), 3);
                }

                if (var1.nextInt(2) == 0)
                {
                    return new EBGGenSnowTree2(false, 8 + var1.nextInt(8), 4 + var1.nextInt(2), 3);
                }

                if (var1.nextInt(5) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.idtype == 4)
            {
                if (var1.nextInt(4) == 0)
                {
                    return new EBGGenSnowTree3(false, 15 + var1.nextInt(10), 4 + var1.nextInt(2), 3);
                }

                if (var1.nextInt(3) == 0)
                {
                    return new EBGGenSnowTree1(8 + var1.nextInt(5), 3);
                }

                if (var1.nextInt(3) == 0)
                {
                    return new EBGGenSnowTree2(false, 8 + var1.nextInt(8), 4 + var1.nextInt(2), 3);
                }

                if (var1.nextInt(10) == 0)
                {
                    return new EBGGenBigTreeSized(13, 0);
                }

                if (var1.nextInt(5) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.idtype == 5)
            {
                if (var1.nextInt(5) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.idtype == 6)
            {
                if (var1.nextInt(8) == 0)
                {
                    return new EBGGenBigTreeSized(13, 0);
                }

                if (var1.nextInt(3) == 0)
                {
                    return new EBGGenSnowTree2(false, 5 + var1.nextInt(5), 1 + var1.nextInt(2), 1 + var1.nextInt(3));
                }

                if (var1.nextInt(5) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }
        }

        return (WorldGenerator)(this.idgold == 2 && this.idtype == 4 ? (var1.nextInt(5) == 0 ? new EBGGenBigTreeSized(12, 0) : (var1.nextInt(5) == 0 ? this.worldGeneratorForest : this.worldGeneratorTrees)) : this.worldGeneratorTrees);
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.idgold == 1)
        {
            return 5294652;
        }
        else
        {
            double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
            return ColorizerGrass.getGrassColor(var1, var3);
        }
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        if (this.idgold == 1)
        {
            return 3318302;
        }
        else
        {
            double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
            return ColorizerFoliage.getFoliageColor(var1, var3);
        }
    }
}
