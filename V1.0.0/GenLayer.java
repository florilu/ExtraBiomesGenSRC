package net.minecraft.src;

import net.minecraft.src.generators.*;

public abstract class GenLayer
{
    /** seed from World#getWorldSeed that is used in the LCG prng */
    private long worldGenSeed;

    /** parent GenLayer that was provided via the constructor */
    protected GenLayer parent;

    /**
     * final part of the LCG prng that uses the chunk X, Z coords along with the other two seeds to generate
     * pseudorandom numbers
     */
    private long chunkSeed;

    /** base seed to the LCG prng provided via the constructor */
    private long baseSeed;

    /**
     * the first array item is a linked list of the bioms, the second is the zoom function, the third is the same as the
     * first.
     */
    public static GenLayer[] initializeAllBiomeGenerators(long par0, WorldType par2WorldType)
    {
        byte var4;
        GenLayer var5;
        GenLayerFuzzyZoom var9;
        GenLayerAddIsland var10;
        GenLayerZoom var11;

        if (par2WorldType == WorldType.BWGGOLD)
        {
        	EBGLayerIsland var15 = new EBGLayerIsland(1L);
            var9 = new GenLayerFuzzyZoom(2000L, var15);
            var10 = new GenLayerAddIsland(1L, var9);
            var11 = new GenLayerZoom(2001L, var10);
            var10 = new GenLayerAddIsland(2L, var11);
            EBGLayerArea var26 = new EBGLayerArea(2L, var10);
            var11 = new GenLayerZoom(2002L, var26);
            var10 = new GenLayerAddIsland(3L, var11);
            var11 = new GenLayerZoom(2003L, var10);
            var10 = new GenLayerAddIsland(4L, var11);
            EBGLayerAddIsland var29 = new EBGLayerAddIsland(200L, var10);
            var4 = 4;
            var5 = GenLayerZoom.func_75915_a(1000L, var29, 0);
            EBGLayerBiome var19 = new EBGLayerBiome(200L, var5, par2WorldType);
            var5 = GenLayerZoom.func_75915_a(1000L, var19, 2);
            EBGLayerHills var23 = new EBGLayerHills(1000L, var5);
            Object var21 = new EBGLayerBorder(1000L, var23);

            for (int var25 = 0; var25 < var4; ++var25)
            {
                var21 = new GenLayerZoom((long)(1000 + var25), (GenLayer)var21);

                if (var25 == 0)
                {
                    var21 = new GenLayerAddIsland(3L, (GenLayer)var21);
                }
            }

            GenLayerVoronoiZoom var28 = new GenLayerVoronoiZoom(10L, (GenLayer)var21);
            ((GenLayer)var21).initWorldGenSeed(par0);
            var28.initWorldGenSeed(par0);
            return new GenLayer[] {(GenLayer)var21, var28};
        }
        else
        {
            GenLayerIsland var3 = new GenLayerIsland(1L);
            var9 = new GenLayerFuzzyZoom(2000L, var3);
            var10 = new GenLayerAddIsland(1L, var9);
            var11 = new GenLayerZoom(2001L, var10);
            var10 = new GenLayerAddIsland(2L, var11);
            GenLayerAddSnow var12 = new GenLayerAddSnow(2L, var10);
            var11 = new GenLayerZoom(2002L, var12);
            var10 = new GenLayerAddIsland(3L, var11);
            var11 = new GenLayerZoom(2003L, var10);
            var10 = new GenLayerAddIsland(4L, var11);
            GenLayerAddMushroomIsland var18 = new GenLayerAddMushroomIsland(5L, var10);
            var4 = 4;

            if (par2WorldType == WorldType.LARGE_BIOMES)
            {
                var4 = 6;
            }

            var5 = GenLayerZoom.func_75915_a(1000L, var18, 0);
            GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var5);
            var5 = GenLayerZoom.func_75915_a(1000L, var13, var4 + 2);
            GenLayerRiver var14 = new GenLayerRiver(1L, var5);
            GenLayerSmooth var17 = new GenLayerSmooth(1000L, var14);
            GenLayer var6 = GenLayerZoom.func_75915_a(1000L, var18, 0);
            GenLayerBiome var16 = new GenLayerBiome(200L, var6, par2WorldType);
            var6 = GenLayerZoom.func_75915_a(1000L, var16, 2);
            Object var20 = new GenLayerHills(1000L, var6);

            for (int var7 = 0; var7 < var4; ++var7)
            {
                var20 = new GenLayerZoom((long)(1000 + var7), (GenLayer)var20);

                if (var7 == 0)
                {
                    var20 = new GenLayerAddIsland(3L, (GenLayer)var20);
                }
            }

            GenLayerSmooth var22 = new GenLayerSmooth(1000L, (GenLayer)var20);
            EBGLayerRiverMix var27 = new EBGLayerRiverMix(100L, var22, var17);
            EBGLayerRiverMix var24 = (EBGLayerRiverMix)((EBGLayerRiverMix)var27);
            GenLayerVoronoiZoom var8 = new GenLayerVoronoiZoom(10L, var27);
            var27.initWorldGenSeed(par0);
            var8.initWorldGenSeed(par0);
            return new GenLayer[] {var27, var8, var24};
        }
    }

    public GenLayer(long par1)
    {
        this.baseSeed = par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    public void initWorldGenSeed(long par1)
    {
        this.worldGenSeed = par1;

        if (this.parent != null)
        {
            this.parent.initWorldGenSeed(par1);
        }

        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }

    /**
     * Initialize layer's current chunkSeed based on the local worldGenSeed and the (x,z) chunk coordinates.
     */
    public void initChunkSeed(long par1, long par3)
    {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par3;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par3;
    }

    /**
     * returns a LCG pseudo random number from [0, x). Args: int x
     */
    protected int nextInt(int par1)
    {
        int var2 = (int)((this.chunkSeed >> 24) % (long)par1);

        if (var2 < 0)
        {
            var2 += par1;
        }

        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return var2;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public abstract int[] getInts(int var1, int var2, int var3, int var4);
}
