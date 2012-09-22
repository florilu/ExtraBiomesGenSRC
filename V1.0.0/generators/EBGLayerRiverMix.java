package net.minecraft.src.generators;

import net.minecraft.src.*;

public class EBGLayerRiverMix extends GenLayer
{
    private GenLayer field_35512_b;
    private GenLayer field_35513_c;

    public EBGLayerRiverMix(long var1, GenLayer var3, GenLayer var4)
    {
        super(var1);
        this.field_35512_b = var3;
        this.field_35513_c = var4;
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    public void initWorldGenSeed(long var1)
    {
        this.field_35512_b.initWorldGenSeed(var1);
        this.field_35513_c.initWorldGenSeed(var1);
        super.initWorldGenSeed(var1);
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int var1, int var2, int var3, int var4)
    {
        int[] var5 = this.field_35512_b.getInts(var1, var2, var3, var4);
        int[] var6 = this.field_35513_c.getInts(var1, var2, var3, var4);
        int[] var7 = IntCache.getIntCache(var3 * var4);

        for (int var8 = 0; var8 < var3 * var4; ++var8)
        {
            if (var5[var8] == BiomeGenBase.ocean.biomeID)
            {
                var7[var8] = var5[var8];
            }
            else if (var6[var8] >= 0)
            {
                if (var5[var8] != BiomeGenBase.icePlains.biomeID && var5[var8] != BiomeGenBase.taiga.biomeID && var5[var8] != BiomeGenBase.iceMountains.biomeID)
                {
                    if (var5[var8] != BiomeGenBase.jungle.biomeID && var5[var8] != BiomeGenBase.jungleHills.biomeID)
                    {
                        if (var5[var8] != BiomeGenBase.desert.biomeID && var5[var8] != BiomeGenBase.desertHills.biomeID)
                        {
                            if (var5[var8] == BiomeGenBase.swampland.biomeID)
                            {
                                var7[var8] = BiomeGenBase.swampriver.biomeID;
                            }
                            else if (var5[var8] != BiomeGenBase.mushroomIsland.biomeID && var5[var8] != BiomeGenBase.mushroomIslandShore.biomeID)
                            {
                                var7[var8] = var6[var8];
                            }
                            else
                            {
                                var7[var8] = BiomeGenBase.mushroomIslandShore.biomeID;
                            }
                        }
                        else
                        {
                            var7[var8] = BiomeGenBase.desertriver.biomeID;
                        }
                    }
                    else
                    {
                        var7[var8] = BiomeGenBase.jungleriver.biomeID;
                    }
                }
                else
                {
                    var7[var8] = BiomeGenBase.frozenRiver.biomeID;
                }
            }
            else
            {
                var7[var8] = var5[var8];
            }
        }

        return var7;
    }
}
