package net.minecraft.src;

import net.minecraft.src.biomes.*;
import net.minecraft.src.generators.*;

public class GenLayerBiome extends GenLayer
{
    public static BiomeGenBase[] biomeArray = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.jungle};
    
    
    /** this sets all the biomes that are allowed to appear in the overworld */
    private BiomeGenBase[] allowedBiomes;

    public GenLayerBiome(long par1, GenLayer par3GenLayer, WorldType par4WorldType)
    {
        super(par1);
        this.allowedBiomes = biomeArray;
        this.parent = par3GenLayer;

        if (par4WorldType == WorldType.DEFAULT_1_1)
        {
            this.allowedBiomes = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga};
        }
        if (par4WorldType == WorldType.EBG)
        {
        	this.allowedBiomes = new BiomeGenBase[] {mod_EBGMain.primeval, mod_EBGMain.endbiome, mod_EBGMain.epicmountains, mod_EBGMain.glacier, mod_EBGMain.lakeland, mod_EBGMain.meadow, mod_EBGMain.mixed, mod_EBGMain.mixedSnow, mod_EBGMain.sandyHills, mod_EBGMain.savanna, mod_EBGMain.table, mod_EBGMain.firelands, mod_EBGMain.wasteland, mod_EBGMain.newdesert, mod_EBGMain.mountains, mod_EBGMain.newforest, mod_EBGMain.redwoods, mod_EBGMain.littlemountainsgreen};
        }
        if (par4WorldType == WorldType.TEST)
        {
        	this.allowedBiomes = new BiomeGenBase[] {mod_EBGMain.littlemountainsgreen};
        }
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int par1, int par2, int par3, int par4)
    {
        int[] var5 = this.parent.getInts(par1, par2, par3, par4);
        int[] var6 = IntCache.getIntCache(par3 * par4);

        for (int var7 = 0; var7 < par4; ++var7)
        {
            for (int var8 = 0; var8 < par3; ++var8)
            {
                this.initChunkSeed((long)(var8 + par1), (long)(var7 + par2));
                int var9 = var5[var8 + var7 * par3];

                if (var9 == 0)
                {
                    var6[var8 + var7 * par3] = 0;
                }
                else if (var9 == BiomeGenBase.mushroomIsland.biomeID)
                {
                    var6[var8 + var7 * par3] = var9;
                }
                else if (var9 == 1)
                {
                    var6[var8 + var7 * par3] = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;
                }
                else
                {
                    int var10 = this.allowedBiomes[this.nextInt(this.allowedBiomes.length)].biomeID;

                    if (var10 == BiomeGenBase.taiga.biomeID)
                    {
                        var6[var8 + var7 * par3] = var10;
                    }
                    else
                    {
                        var6[var8 + var7 * par3] = BiomeGenBase.icePlains.biomeID;
                    }
                }
            }
        }

        return var6;
    }
}
