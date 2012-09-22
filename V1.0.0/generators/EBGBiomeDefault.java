package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGBiomeDefault extends BiomeGenBase
{
    public int biomeIDfordeco;

    public EBGBiomeDefault(int var1)
    {
        super(var1);
        this.biomeIDfordeco = var1;

        if (this.biomeIDfordeco == 0)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = 2;
            this.theBiomeDecorator.yellowFlowersPerChunk = 1;
            this.theBiomeDecorator.redFlowersPerChunk = 3;
            this.theBiomeDecorator.grassPerChunk = 3;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
        }

        if (this.biomeIDfordeco == 1)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = -2;
            this.theBiomeDecorator.yellowFlowersPerChunk = 2;
            this.theBiomeDecorator.redFlowersPerChunk = 1;
            this.theBiomeDecorator.grassPerChunk = 8;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
        }

        if (this.biomeIDfordeco == 2 || this.biomeIDfordeco == 17 || this.biomeIDfordeco == 39 || this.biomeIDfordeco == 92)
        {
            this.spawnableCreatureList.clear();
            this.topBlock = (byte)Block.sand.blockID;
            this.fillerBlock = (byte)Block.sand.blockID;
            this.theBiomeDecorator.deadBushPerChunk = 2;
            this.theBiomeDecorator.cactiPerChunk = 10;
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = -20;

            if (this.biomeIDfordeco == 17)
            {
                this.theBiomeDecorator.minTreesPerChunk = 0;
            }

            this.theBiomeDecorator.yellowFlowersPerChunk = 0;
            this.theBiomeDecorator.redFlowersPerChunk = 0;
            this.theBiomeDecorator.grassPerChunk = 0;
            this.theBiomeDecorator.reedsPerChunk = 20;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
        }

        if (this.biomeIDfordeco == 3 || this.biomeIDfordeco == 20)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = 0;
            this.theBiomeDecorator.yellowFlowersPerChunk = 3;
            this.theBiomeDecorator.redFlowersPerChunk = 5;
            this.theBiomeDecorator.grassPerChunk = 5;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 4, 4, 4));
        }

        if (this.biomeIDfordeco == 4 || this.biomeIDfordeco == 18)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = 5;
            this.theBiomeDecorator.yellowFlowersPerChunk = 1;
            this.theBiomeDecorator.redFlowersPerChunk = 1;
            this.theBiomeDecorator.grassPerChunk = 2;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        }

        if (this.biomeIDfordeco == 5 || this.biomeIDfordeco == 19)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = 5;
            this.theBiomeDecorator.yellowFlowersPerChunk = 0;
            this.theBiomeDecorator.redFlowersPerChunk = 0;
            this.theBiomeDecorator.grassPerChunk = 1;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        }

        if (this.biomeIDfordeco == 6 || this.biomeIDfordeco == 37 || this.biomeIDfordeco == 90)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = 5;
            this.theBiomeDecorator.yellowFlowersPerChunk = 0;
            this.theBiomeDecorator.redFlowersPerChunk = 0;
            this.theBiomeDecorator.grassPerChunk = 6;
            this.theBiomeDecorator.reedsPerChunk = 40;
            this.theBiomeDecorator.redMushroomsPerChunk = 3;
            this.theBiomeDecorator.brownMushroomsPerChunk = 4;

            if (this.biomeIDfordeco != 90)
            {
                this.theBiomeDecorator.waterlilyPerChunk = 4;
            }

            this.theBiomeDecorator.deadBushPerChunk = 1;
            this.waterColorMultiplier = 8240159;
        }

        if (this.biomeIDfordeco == 12 || this.biomeIDfordeco == 13)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = -20;
            this.theBiomeDecorator.yellowFlowersPerChunk = 0;
            this.theBiomeDecorator.redFlowersPerChunk = 0;
            this.theBiomeDecorator.grassPerChunk = 0;
            this.theBiomeDecorator.reedsPerChunk = 0;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
        }

        if (this.biomeIDfordeco == 14 || this.biomeIDfordeco == 15)
        {
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = -20;
            this.theBiomeDecorator.yellowFlowersPerChunk = -20;
            this.theBiomeDecorator.redFlowersPerChunk = -20;
            this.theBiomeDecorator.grassPerChunk = 0;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 3;
            this.theBiomeDecorator.brownMushroomsPerChunk = 2;
            this.theBiomeDecorator.bigMushroomsPerChunk = 1;
            this.topBlock = (byte)Block.mycelium.blockID;
            this.spawnableMonsterList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableWaterCreatureList.clear();
            this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
        }

        if (this.biomeIDfordeco == 16)
        {
            this.spawnableCreatureList.clear();
            this.topBlock = (byte)Block.sand.blockID;
            this.fillerBlock = (byte)Block.sand.blockID;
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.minTreesPerChunk = -20;
            this.theBiomeDecorator.yellowFlowersPerChunk = 0;
            this.theBiomeDecorator.redFlowersPerChunk = 0;
            this.theBiomeDecorator.grassPerChunk = 0;
            this.theBiomeDecorator.reedsPerChunk = 20;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;
        }

        if (this.biomeIDfordeco == 21 || this.biomeIDfordeco == 22 || this.biomeIDfordeco == 38 || this.biomeIDfordeco == 91)
        {
            this.theBiomeDecorator.mayrandtrees = false;
            this.theBiomeDecorator.treesPerChunk = 50;
            this.theBiomeDecorator.yellowFlowersPerChunk = 3;
            this.theBiomeDecorator.redFlowersPerChunk = 5;
            this.theBiomeDecorator.grassPerChunk = 25;
            this.theBiomeDecorator.reedsPerChunk = 10;
            this.theBiomeDecorator.redMushroomsPerChunk = 0;
            this.theBiomeDecorator.brownMushroomsPerChunk = 0;

            if (this.biomeIDfordeco != 91)
            {
                this.theBiomeDecorator.waterlilyPerChunk = 2;
            }

            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
            this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
            this.waterColorMultiplier = 8240159;
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return (WorldGenerator)(this.biomeIDfordeco != 0 && this.biomeIDfordeco != 4 && this.biomeIDfordeco != 18 && this.biomeIDfordeco != 7 && this.biomeIDfordeco != 20 ? (this.biomeIDfordeco != 5 && this.biomeIDfordeco != 19 && this.biomeIDfordeco != 12 && this.biomeIDfordeco != 13 ? (this.biomeIDfordeco == 6 ? new EBGGenSwamp(var1.nextInt(6) + 5) : (this.biomeIDfordeco != 21 && this.biomeIDfordeco != 22 ? this.worldGeneratorTrees : (var1.nextInt(10) == 0 ? new EBGGenBigTreeSized(15, 0) : (var1.nextInt(3) == 0 ? new WorldGenShrub(3, 0) : (var1.nextInt(2) == 0 ? (var1.nextInt(40) == 0 ? new WorldGenHugeTrees(false, 60 + var1.nextInt(5), 3, 3) : new WorldGenHugeTrees(false, 20 + var1.nextInt(15), 3, 3)) : new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true)))))) : (var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false))) : (var1.nextInt(5) == 0 ? this.worldGeneratorForest : (var1.nextInt(7) == 0 ? new EBGGenBigTreeSized(15, 0) : this.worldGeneratorTrees)));
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        return this.biomeIDfordeco != 21 && this.biomeIDfordeco != 22 && this.biomeIDfordeco != 6 && this.biomeIDfordeco != 37 ? new WorldGenTallGrass(Block.tallGrass.blockID, 1) : (var1.nextInt(4) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 2) : new WorldGenTallGrass(Block.tallGrass.blockID, 1));
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        super.decorate(var1, var2, var3, var4);
        int var6;
        int var7;
        int var9;

        if (this.biomeIDfordeco != 21 && this.biomeIDfordeco != 22)
        {
            if (this.biomeIDfordeco == 3 || this.biomeIDfordeco == 20)
            {
                int var11 = 3 + var2.nextInt(6);

                for (var6 = 0; var6 < var11; ++var6)
                {
                    var7 = var3 + var2.nextInt(16);
                    int var12 = var2.nextInt(28) + 4;
                    var9 = var4 + var2.nextInt(16);
                    int var10 = var1.getBlockId(var7, var12, var9);

                    if (var10 == Block.stone.blockID)
                    {
                        var1.setBlock(var7, var12, var9, Block.oreEmerald.blockID);
                    }
                }
            }
        }
        else
        {
            WorldGenVines var5 = new WorldGenVines();

            for (var6 = 0; var6 < 50; ++var6)
            {
                var7 = var3 + var2.nextInt(16) + 8;
                byte var8 = 64;
                var9 = var4 + var2.nextInt(16) + 8;
                var5.generate(var1, var2, var7, var8, var9);
            }
        }
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.biomeIDfordeco != 5 && this.biomeIDfordeco != 19 && this.biomeIDfordeco != 12 && this.biomeIDfordeco != 13)
        {
            if (this.biomeIDfordeco != 21 && this.biomeIDfordeco != 22 && this.biomeIDfordeco != 6)
            {
                double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
                double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
                return ColorizerGrass.getGrassColor(var1, var3);
            }
            else
            {
                return 8240159;
            }
        }
        else
        {
            return ColorizerGrass.getGrassColor(0.6000000238418579D, 0.6000000238418579D);
        }
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        if (this.biomeIDfordeco != 5 && this.biomeIDfordeco != 19 && this.biomeIDfordeco != 12 && this.biomeIDfordeco != 13)
        {
            if (this.biomeIDfordeco != 21 && this.biomeIDfordeco != 22 && this.biomeIDfordeco != 6)
            {
                double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
                double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
                return ColorizerFoliage.getFoliageColor(var1, var3);
            }
            else
            {
                return 6921755;
            }
        }
        else
        {
            return ColorizerFoliage.getFoliageColor(0.6000000238418579D, 0.6000000238418579D);
        }
    }
}
