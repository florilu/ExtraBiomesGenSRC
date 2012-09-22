package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.generators.*;

public class WorldChunkManager
{
    private GenLayer genBiomes;

    /** A GenLayer containing the indices into BiomeGenBase.biomeList[] */
    private GenLayer biomeIndexLayer;

    /** The BiomeCache object for this world. */
    private BiomeCache biomeCache;

    /** A list of biomes that the player can spawn in. */
    private List biomesToSpawnIn;
    public WorldType terrainType;
    private EBGNoiseGeneratorOctaves2 field_4194_e;
    private EBGNoiseGeneratorOctaves2 field_4193_f;
    private EBGNoiseGeneratorOctaves2 field_4192_g;
    public double[] temperature;
    public double[] humidity;
    public double[] field_4196_c;
    private int[] biomeLookupTable;

    protected WorldChunkManager()
    {
        this.biomeLookupTable = new int[4096];
        this.biomeCache = new BiomeCache(this);
        this.biomesToSpawnIn = new ArrayList();
        this.biomesToSpawnIn.add(BiomeGenBase.forest);
        this.biomesToSpawnIn.add(BiomeGenBase.plains);
        this.biomesToSpawnIn.add(BiomeGenBase.forestHills);
    }

    public WorldChunkManager(long par1, WorldType par3WorldType)
    {
        this();
        this.terrainType = par3WorldType;
        this.generateBiomeLookup(par3WorldType);
        this.field_4194_e = new EBGNoiseGeneratorOctaves2(new Random(par1 * 9871L), 4);
        this.field_4193_f = new EBGNoiseGeneratorOctaves2(new Random(par1 * 39811L), 4);
        this.field_4192_g = new EBGNoiseGeneratorOctaves2(new Random(par1 * 543321L), 2);
        GenLayer[] var4 = GenLayer.initializeAllBiomeGenerators(par1, par3WorldType);
        this.genBiomes = var4[0];
        this.biomeIndexLayer = var4[1];
    }

    public WorldChunkManager(World par1World)
    {
        this(par1World.getSeed(), par1World.getWorldInfo().getTerrainType());
    }

    public double[] getColdTemperatures(double[] var1, int var2, int var3, int var4, int var5)
    {
        if (var1 == null || var1.length < var4 * var5)
        {
            var1 = new double[var4 * var5];
        }

        var1 = this.field_4194_e.func_4112_a(var1, (double)var2, (double)var3, var4, var5, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var2, (double)var3, var4, var5, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for (int var7 = 0; var7 < var4; ++var7)
        {
            for (int var8 = 0; var8 < var5; ++var8)
            {
                double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
                double var11 = 0.01D;
                double var13 = 1.0D - var11;
                double var15 = (var1[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
                var15 = 1.0D - (1.0D - var15) * (1.0D - var15);

                if (var15 < 0.0D)
                {
                    var15 = 0.0D;
                }

                if (var15 > 1.0D)
                {
                    var15 = 1.0D;
                }

                var1[var6] = var15;
                ++var6;
            }
        }

        return var1;
    }

    public double[] getDesertHum(double[] var1, int var2, int var3, int var4, int var5)
    {
        if (var1 == null || var1.length < var4 * var5)
        {
            var1 = new double[var4 * var5];
        }

        var1 = this.field_4193_f.func_4112_a(var1, (double)var2, (double)var3, var4, var5, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var2, (double)var3, var4, var5, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for (int var7 = 0; var7 < var4; ++var7)
        {
            for (int var8 = 0; var8 < var5; ++var8)
            {
                double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
                double var11 = 0.01D;
                double var13 = 1.0D - var11;
                double var15 = (var1[var6] * 0.15D + 0.5D) * var13 + var9 * var11;
                var15 = 1.0D - (1.0D - var15) * (1.0D - var15);

                if (var15 < 0.0D)
                {
                    var15 = 0.0D;
                }

                if (var15 > 1.0D)
                {
                    var15 = 1.0D;
                }

                var1[var6] = var15;
                ++var6;
            }
        }

        return var1;
    }

    public int[] getBiomesGens(int var1, int var2, int var3, int var4)
    {
        int[] var5 = new int[var3 * var4];
        this.temperature = this.field_4194_e.func_4112_a(this.temperature, (double)var1, (double)var2, var3, var3, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
        this.humidity = this.field_4193_f.func_4112_a(this.humidity, (double)var1, (double)var2, var3, var3, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
        this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var1, (double)var2, var3, var3, 0.25D, 0.25D, 0.5882352941176471D);
        int var6 = 0;

        for (int var7 = 0; var7 < var3; ++var7)
        {
            for (int var8 = 0; var8 < var4; ++var8)
            {
                double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
                double var11 = 0.01D;
                double var13 = 1.0D - var11;
                double var15 = (this.temperature[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
                var11 = 0.002D;
                var13 = 1.0D - var11;
                double var17 = (this.humidity[var6] * 0.15D + 0.5D) * var13 + var9 * var11;
                var15 = 1.0D - (1.0D - var15) * (1.0D - var15);

                if (var15 < 0.0D)
                {
                    var15 = 0.0D;
                }

                if (var17 < 0.0D)
                {
                    var17 = 0.0D;
                }

                if (var15 > 1.0D)
                {
                    var15 = 1.0D;
                }

                if (var17 > 1.0D)
                {
                    var17 = 1.0D;
                }

                this.temperature[var6] = var15;
                this.humidity[var6] = var17;
                var5[var6++] = this.getBiomeFromLookup(var15, var17);
            }
        }

        return var5;
    }

    public int getBiomeFromLookup(double var1, double var3)
    {
        int var5 = (int)(var1 * 63.0D);
        int var6 = (int)(var3 * 63.0D);
        return this.biomeLookupTable[var5 + var6 * 64];
    }

    public void generateBiomeLookup(WorldType var1)
    {
        int var2;
        int var3;

        if (var1 == WorldType.BWGBETA)
        {
            for (var2 = 0; var2 < 64; ++var2)
            {
                for (var3 = 0; var3 < 64; ++var3)
                {
                    this.biomeLookupTable[var2 + var3 * 64] = this.getBiomeBETA((float)var2 / 63.0F, (float)var3 / 63.0F);
                }
            }
        }
        else if (var1 == WorldType.BWGALPH)
        {
            for (var2 = 0; var2 < 64; ++var2)
            {
                for (var3 = 0; var3 < 64; ++var3)
                {
                    this.biomeLookupTable[var2 + var3 * 64] = this.getBiomeALPHA((float)var2 / 63.0F, (float)var3 / 63.0F);
                }
            }
        }
        else
        {
            for (var2 = 0; var2 < 64; ++var2)
            {
                for (var3 = 0; var3 < 64; ++var3)
                {
                    this.biomeLookupTable[var2 + var3 * 64] = this.getBiomeSKY((float)var2 / 63.0F, (float)var3 / 63.0F);
                }
            }
        }
    }

    public int getBiomeBETA(float var1, float var2)
    {
        var2 *= var1;
        return var1 < 0.1F ? BiomeGenBase.BETAtundra.biomeID : (var2 < 0.2F ? (var1 < 0.5F ? BiomeGenBase.BETAtundra.biomeID : (var1 < 0.95F ? BiomeGenBase.BETAsavanna.biomeID : BiomeGenBase.BETAdesert.biomeID)) : (var2 > 0.5F && var1 < 0.7F ? BiomeGenBase.BETAswampland.biomeID : (var1 < 0.5F ? BiomeGenBase.BETAtaiga.biomeID : (var1 < 0.97F ? (var2 < 0.35F ? BiomeGenBase.BETAshrubland.biomeID : BiomeGenBase.BETAforest.biomeID) : (var2 < 0.45F ? BiomeGenBase.BETAplains.biomeID : (var2 < 0.9F ? BiomeGenBase.BETAseasonalForest.biomeID : BiomeGenBase.BETArainforest.biomeID))))));
    }

    public int getBiomeSKY(float var1, float var2)
    {
        var2 *= var1;
        return var1 < 0.1F ? BiomeGenBase.BETAtundra.biomeID : (var2 < 0.2F ? (var1 < 0.5F ? BiomeGenBase.BETAtundra.biomeID : (var1 < 0.95F ? BiomeGenBase.BETAsavanna.biomeID : BiomeGenBase.BETAdesert.biomeID)) : (var2 > 0.5F && var1 < 0.7F ? BiomeGenBase.BETAswampland.biomeID : (var1 < 0.5F ? BiomeGenBase.BETAtaiga.biomeID : (var1 < 0.97F ? (var2 < 0.35F ? BiomeGenBase.BETAshrubland.biomeID : BiomeGenBase.BETAforest.biomeID) : (var2 < 0.45F ? BiomeGenBase.BETAplains.biomeID : (var2 < 0.7F ? BiomeGenBase.BETAseasonalForest.biomeID : BiomeGenBase.BETAjungle.biomeID))))));
    }

    public int getBiomeALPHA(float var1, float var2)
    {
        var2 *= var1;
        return var1 < 0.1F ? BiomeGenBase.ALPHAtundra.biomeID : (var2 < 0.2F ? (var1 < 0.5F ? BiomeGenBase.ALPHAtundra.biomeID : (var1 < 0.95F ? BiomeGenBase.ALPHAsavanna.biomeID : BiomeGenBase.ALPHAdesert.biomeID)) : (var2 > 0.5F && var1 < 0.7F ? BiomeGenBase.ALPHAswampland.biomeID : (var1 < 0.5F ? BiomeGenBase.ALPHAtaiga.biomeID : (var1 < 0.97F ? (var2 < 0.35F ? BiomeGenBase.ALPHAshrubland.biomeID : BiomeGenBase.ALPHAforest.biomeID) : (var2 < 0.45F ? BiomeGenBase.ALPHAplains.biomeID : (var2 < 0.9F ? BiomeGenBase.ALPHAseasonalForest.biomeID : BiomeGenBase.ALPHArainforest.biomeID))))));
    }

    /**
     * Gets the list of valid biomes for the player to spawn in.
     */
    public List getBiomesToSpawnIn()
    {
        return this.biomesToSpawnIn;
    }

    /**
     * Returns the BiomeGenBase related to the x, z position on the world.
     */
    public BiomeGenBase getBiomeGenAt(int par1, int par2)
    {
        return this.biomeCache.getBiomeGenAt(par1, par2);
    }

    /**
     * Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
     */
    public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] var6;

        if (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH && this.terrainType != WorldType.BWGSKYL)
        {
            var6 = this.biomeIndexLayer.getInts(par2, par3, par4, par5);
        }
        else
        {
            var6 = this.getBiomesGens(par2, par3, par4, par5);
        }

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            float var8 = (float)BiomeGenBase.biomeList[var6[var7]].getIntRainfall() / 65536.0F;

            if (var8 > 1.0F)
            {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }

    /**
     * Return an adjusted version of a given temperature based on the y height
     */
    public float getTemperatureAtHeight(float par1, int par2)
    {
        return par1;
    }

    /**
     * Returns a list of temperatures to use for the specified blocks.  Args: listToReuse, x, y, width, length
     */
    public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5)
        {
            par1ArrayOfFloat = new float[par4 * par5];
        }

        int[] var6;

        if (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH && this.terrainType != WorldType.BWGSKYL)
        {
            var6 = this.biomeIndexLayer.getInts(par2, par3, par4, par5);
        }
        else
        {
            var6 = this.getBiomesGens(par2, par3, par4, par5);
        }

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            float var8 = (float)BiomeGenBase.biomeList[var6[var7]].getIntTemperature() / 65536.0F;

            if (var8 > 1.0F)
            {
                var8 = 1.0F;
            }

            par1ArrayOfFloat[var7] = var8;
        }

        return par1ArrayOfFloat;
    }

    /**
     * Returns an array of biomes for the location input.
     */
    public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        int[] var6;

        if (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH && this.terrainType != WorldType.BWGSKYL)
        {
            var6 = this.genBiomes.getInts(par2, par3, par4, par5);
        }
        else
        {
            var6 = this.getBiomesGens(par2, par3, par4, par5);
        }

        for (int var7 = 0; var7 < par4 * par5; ++var7)
        {
            par1ArrayOfBiomeGenBase[var7] = BiomeGenBase.biomeList[var6[var7]];
        }

        return par1ArrayOfBiomeGenBase;
    }

    /**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5)
    {
        return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
    }

    /**
     * Return a list of biomes for the specified blocks. Args: listToReuse, x, y, width, length, cacheFlag (if false,
     * don't check biomeCache to avoid infinite loop in BiomeCacheBlock)
     */
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0)
        {
            BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        else
        {
            int[] var7;

            if (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH && this.terrainType != WorldType.BWGSKYL)
            {
                var7 = this.biomeIndexLayer.getInts(par2, par3, par4, par5);
            }
            else
            {
                var7 = this.getBiomesGens(par2, par3, par4, par5);
            }

            for (int var8 = 0; var8 < par4 * par5; ++var8)
            {
                par1ArrayOfBiomeGenBase[var8] = BiomeGenBase.biomeList[var7[var8]];
            }

            return par1ArrayOfBiomeGenBase;
        }
    }

    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    public boolean areBiomesViable(int par1, int par2, int par3, List par4List)
    {
        int var5 = par1 - par3 >> 2;
        int var6 = par2 - par3 >> 2;
        int var7 = par1 + par3 >> 2;
        int var8 = par2 + par3 >> 2;
        int var9 = var7 - var5 + 1;
        int var10 = var8 - var6 + 1;

        if (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH && this.terrainType != WorldType.BWGSKYL)
        {
            int[] var11 = this.genBiomes.getInts(var5, var6, var9, var10);

            for (int var12 = 0; var12 < var9 * var10; ++var12)
            {
                BiomeGenBase var13 = BiomeGenBase.biomeList[var11[var12]];

                if (!par4List.contains(var13))
                {
                    return false;
                }
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Finds a valid position within a range, that is in one of the listed biomes. Searches {par1,par2} +-par3 blocks.
     * Strongly favors positive y positions.
     */
    public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random)
    {
        int var6 = par1 - par3 >> 2;
        int var7 = par2 - par3 >> 2;
        int var8 = par1 + par3 >> 2;
        int var9 = par2 + par3 >> 2;
        int var10 = var8 - var6 + 1;
        int var11 = var9 - var7 + 1;

        if (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH && this.terrainType != WorldType.BWGSKYL)
        {
            int[] var12 = this.genBiomes.getInts(var6, var7, var10, var11);
            ChunkPosition var13 = null;
            int var14 = 0;

            for (int var15 = 0; var15 < var12.length; ++var15)
            {
                int var16 = var6 + var15 % var10 << 2;
                int var17 = var7 + var15 / var10 << 2;
                BiomeGenBase var18 = BiomeGenBase.biomeList[var12[var15]];

                if (par4List.contains(var18) && (var13 == null || par5Random.nextInt(var14 + 1) == 0))
                {
                    var13 = new ChunkPosition(var16, 0, var17);
                    ++var14;
                }
            }

            return var13;
        }
        else
        {
            return null;
        }
    }

    /**
     * Calls the WorldChunkManager's biomeCache.cleanupCache()
     */
    public void cleanupCache()
    {
        this.biomeCache.cleanupCache();
    }
}
