package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGBiomeBeta extends BiomeGenBase
{
    public boolean isRainForest;
    public int TreeTypes;
    public int biomeIDforcolor;

    public EBGBiomeBeta(int var1, int var2, boolean var3, boolean var4, boolean var5)
    {
        super(var1);
        this.TreeTypes = var2;
        this.biomeIDforcolor = var1;

        if (var4)
        {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }

        if (var3)
        {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        }

        if (var5)
        {
            this.spawnableCreatureList.clear();
            this.topBlock = (byte)Block.sand.blockID;
            this.fillerBlock = (byte)Block.sand.blockID;
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return (WorldGenerator)(this.TreeTypes == 0 ? (var1.nextInt(3) == 0 ? this.worldGeneratorBigTree : new EBGGenTrees()) : (this.TreeTypes == 1 ? (var1.nextInt(5) == 0 ? this.worldGeneratorForest : (var1.nextInt(3) == 0 ? this.worldGeneratorBigTree : new EBGGenTrees())) : (this.TreeTypes == 2 ? (var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false)) : (this.TreeTypes == 4 ? (var1.nextInt(10) == 0 ? new EBGGenBigTreeSized(15, 0) : (var1.nextInt(3) == 0 ? new WorldGenShrub(3, 0) : (var1.nextInt(2) == 0 ? (var1.nextInt(40) == 0 ? new WorldGenHugeTrees(false, 60 + var1.nextInt(5), 3, 3) : new WorldGenHugeTrees(false, 20 + var1.nextInt(15), 3, 3)) : new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true)))) : (var1.nextInt(10) == 0 ? this.worldGeneratorBigTree : new EBGGenTrees())))));
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.biomeIDforcolor != 39 && this.biomeIDforcolor != 36)
        {
            if (this.biomeIDforcolor == 37)
            {
                return ColorizerFoliage.getFoliageColor(1.0D, 0.4000000059604645D);
            }
            else
            {
                double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
                double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
                return ColorizerGrass.getGrassColor(var1, var3);
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
        if (this.biomeIDforcolor != 39 && this.biomeIDforcolor != 36)
        {
            if (this.biomeIDforcolor == 37)
            {
                return ColorizerFoliage.getFoliageColor(1.0D, 0.4000000059604645D);
            }
            else
            {
                double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
                double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
                return ColorizerFoliage.getFoliageColor(var1, var3);
            }
        }
        else
        {
            return ColorizerFoliage.getFoliageColor(0.6000000238418579D, 0.6000000238418579D);
        }
    }
}
