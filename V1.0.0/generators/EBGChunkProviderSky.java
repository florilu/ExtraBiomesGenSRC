package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGChunkProviderSky implements IChunkProvider
{
    private Random rand;
    private EBGNoiseGeneratorOctaves field_912_k;
    private EBGNoiseGeneratorOctaves field_911_l;
    private EBGNoiseGeneratorOctaves field_910_m;
    private EBGNoiseGeneratorOctaves field_909_n;
    private EBGNoiseGeneratorOctaves field_908_o;
    public EBGNoiseGeneratorOctaves field_922_a;
    public EBGNoiseGeneratorOctaves field_921_b;
    public EBGNoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private double[] field_4180_q;
    private double[] sandNoise = new double[256];
    private double[] gravelNoise = new double[256];
    private double[] stoneNoise = new double[256];
    private MapGenBase field_902_u = new EBGMapGenCaves();
    private BiomeGenBase[] biomesForGeneration;
    double[] field_4185_d;
    double[] field_4184_e;
    double[] field_4183_f;
    double[] field_4182_g;
    double[] field_4181_h;
    int[][] field_914_i = new int[32][32];
    private double[] generatedTemperatures;

    public EBGChunkProviderSky(World var1, long var2, boolean var4)
    {
        this.worldObj = var1;
        this.rand = new Random(var2);
        this.field_912_k = new EBGNoiseGeneratorOctaves(this.rand, 16);
        this.field_911_l = new EBGNoiseGeneratorOctaves(this.rand, 16);
        this.field_910_m = new EBGNoiseGeneratorOctaves(this.rand, 8);
        this.field_909_n = new EBGNoiseGeneratorOctaves(this.rand, 4);
        this.field_908_o = new EBGNoiseGeneratorOctaves(this.rand, 4);
        this.field_922_a = new EBGNoiseGeneratorOctaves(this.rand, 10);
        this.field_921_b = new EBGNoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new EBGNoiseGeneratorOctaves(this.rand, 8);
    }

    public void generateTerrain(int var1, int var2, byte[] var3, BiomeGenBase[] var4, double[] var5)
    {
        byte var6 = 2;
        int var7 = var6 + 1;
        byte var8 = 33;
        int var9 = var6 + 1;
        this.field_4180_q = this.func_4061_a(this.field_4180_q, var1 * var6, 0, var2 * var6, var7, var8, var9);

        for (int var10 = 0; var10 < var6; ++var10)
        {
            for (int var11 = 0; var11 < var6; ++var11)
            {
                for (int var12 = 0; var12 < 32; ++var12)
                {
                    double var13 = 0.25D;
                    double var15 = this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var17 = this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var19 = this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var21 = this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var23 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
                    double var25 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
                    double var27 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
                    double var29 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

                    for (int var31 = 0; var31 < 4; ++var31)
                    {
                        double var32 = 0.125D;
                        double var34 = var15;
                        double var36 = var17;
                        double var38 = (var19 - var15) * var32;
                        double var40 = (var21 - var17) * var32;

                        for (int var42 = 0; var42 < 8; ++var42)
                        {
                            int var43 = var42 + var10 * 8 << 11 | 0 + var11 * 8 << 7 | var12 * 4 + var31;
                            short var44 = 128;
                            double var45 = 0.125D;
                            double var47 = var34;
                            double var49 = (var36 - var34) * var45;

                            for (int var51 = 0; var51 < 8; ++var51)
                            {
                                int var52 = 0;

                                if (var47 > 0.0D)
                                {
                                    var52 = Block.stone.blockID;
                                }

                                var3[var43] = (byte)var52;
                                var43 += var44;
                                var47 += var49;
                            }

                            var34 += var38;
                            var36 += var40;
                        }

                        var15 += var23;
                        var17 += var25;
                        var19 += var27;
                        var21 += var29;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
    {
        byte var5 = 64;
        double var6 = 0.03125D;
        this.sandNoise = this.field_909_n.generateNoiseOctaves(this.sandNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6, var6, 1.0D);
        this.gravelNoise = this.field_909_n.generateNoiseOctaves(this.gravelNoise, (double)(var1 * 16), 109.0134D, (double)(var2 * 16), 16, 1, 16, var6, 1.0D, var6);
        this.stoneNoise = this.field_908_o.generateNoiseOctaves(this.stoneNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

        for (int var8 = 0; var8 < 16; ++var8)
        {
            for (int var9 = 0; var9 < 16; ++var9)
            {
                BiomeGenBase var10 = var4[var8 + var9 * 16];
                boolean var11 = this.sandNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 0.0D;
                boolean var12 = this.gravelNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 3.0D;
                int var13 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int var14 = -1;
                byte var15 = var10.topBlock;
                byte var16 = var10.fillerBlock;

                for (int var17 = 127; var17 >= 0; --var17)
                {
                    int var18 = (var9 * 16 + var8) * 128 + var17;
                    byte var19 = var3[var18];

                    if (var19 == 0)
                    {
                        var14 = -1;
                    }
                    else if (var19 == Block.stone.blockID)
                    {
                        if (var14 == -1)
                        {
                            if (var13 <= 0)
                            {
                                var15 = var10.topBlock;
                                var16 = var10.fillerBlock;
                            }
                            else if (var17 >= var5 - 4 && var17 <= var5 + 1)
                            {
                                var15 = var10.topBlock;
                                var16 = var10.fillerBlock;
                            }

                            var3[var18] = var15;
                            var14 = var13;
                        }
                        else if (var14 > 0)
                        {
                            --var14;
                            var3[var18] = var16;

                            if (var14 == 0 && var16 == Block.sand.blockID)
                            {
                                var14 = this.rand.nextInt(4);
                                var16 = (byte)Block.sandStone.blockID;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int var1, int var2)
    {
        return this.provideChunk(var1, var2);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int var1, int var2)
    {
        this.rand.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte[32768];
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
        double[] var4 = this.worldObj.getWorldChunkManager().temperature;
        this.generateTerrain(var1, var2, var3, this.biomesForGeneration, var4);
        this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
        this.field_902_u.generate(this, this.worldObj, var1, var2, var3);
        Chunk var5 = new Chunk(this.worldObj, var3, var1, var2);
        byte[] var6 = var5.getBiomeArray();

        for (int var7 = 0; var7 < var6.length; ++var7)
        {
            var6[var7] = (byte)this.biomesForGeneration[var7].biomeID;
        }

        var5.generateSkylightMap();
        return var5;
    }

    private double[] func_4061_a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        if (var1 == null)
        {
            var1 = new double[var5 * var6 * var7];
        }

        double var8 = 684.412D;
        double var10 = 684.412D;
        double[] var12 = this.worldObj.getWorldChunkManager().temperature;
        double[] var13 = this.worldObj.getWorldChunkManager().humidity;
        this.field_4182_g = this.field_922_a.generateNoiseOctaves(this.field_4182_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.field_4181_h = this.field_921_b.generateNoiseOctaves(this.field_4181_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        var8 *= 2.0D;
        this.field_4185_d = this.field_910_m.generateNoiseOctaves(this.field_4185_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
        this.field_4184_e = this.field_912_k.generateNoiseOctaves(this.field_4184_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        this.field_4183_f = this.field_911_l.generateNoiseOctaves(this.field_4183_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        int var14 = 0;
        int var15 = 0;
        int var16 = 16 / var5;

        for (int var17 = 0; var17 < var5; ++var17)
        {
            int var18 = var17 * var16 + var16 / 2;

            for (int var19 = 0; var19 < var7; ++var19)
            {
                int var20 = var19 * var16 + var16 / 2;
                double var21 = var12[var18 * 16 + var20];
                double var23 = var13[var18 * 16 + var20] * var21;
                double var25 = 1.0D - var23;
                var25 *= var25;
                var25 *= var25;
                var25 = 1.0D - var25;
                double var27 = (this.field_4182_g[var15] + 256.0D) / 512.0D;
                var27 *= var25;

                if (var27 > 1.0D)
                {
                    var27 = 1.0D;
                }

                double var29 = this.field_4181_h[var15] / 8000.0D;

                if (var29 < 0.0D)
                {
                    var29 = -var29 * 0.3D;
                }

                var29 = var29 * 3.0D - 2.0D;

                if (var29 > 1.0D)
                {
                    var29 = 1.0D;
                }

                var29 /= 8.0D;
                var29 = 0.0D;

                if (var27 < 0.0D)
                {
                    var27 = 0.0D;
                }

                var27 += 0.5D;
                var29 = var29 * (double)var6 / 16.0D;
                ++var15;
                double var31 = (double)var6 / 2.0D;

                for (int var33 = 0; var33 < var6; ++var33)
                {
                    double var34 = 0.0D;
                    double var36 = ((double)var33 - var31) * 8.0D / var27;

                    if (var36 < 0.0D)
                    {
                        var36 *= -1.0D;
                    }

                    double var38 = this.field_4184_e[var14] / 512.0D;
                    double var40 = this.field_4183_f[var14] / 512.0D;
                    double var42 = (this.field_4185_d[var14] / 10.0D + 1.0D) / 2.0D;

                    if (var42 < 0.0D)
                    {
                        var34 = var38;
                    }
                    else if (var42 > 1.0D)
                    {
                        var34 = var40;
                    }
                    else
                    {
                        var34 = var38 + (var40 - var38) * var42;
                    }

                    var34 -= 8.0D;
                    byte var44 = 32;
                    double var45;

                    if (var33 > var6 - var44)
                    {
                        var45 = (double)((float)(var33 - (var6 - var44)) / ((float)var44 - 1.0F));
                        var34 = var34 * (1.0D - var45) + -30.0D * var45;
                    }

                    var44 = 8;

                    if (var33 < var44)
                    {
                        var45 = (double)((float)(var44 - var33) / ((float)var44 - 1.0F));
                        var34 = var34 * (1.0D - var45) + -30.0D * var45;
                    }

                    var1[var14] = var34;
                    ++var14;
                }
            }
        }

        return var1;
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int var1, int var2)
    {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider var1, int var2, int var3)
    {
        BlockSand.fallInstantly = true;
        int var4 = var2 * 16;
        int var5 = var3 * 16;
        BiomeGenBase var6 = this.worldObj.getWorldChunkManager().getBiomeGenAt(var4 + 16, var5 + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.getSeed());
        double var11 = 0.25D;
        int var13;
        int var14;
        int var15;

        if (this.rand.nextInt(4) == 0)
        {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(128);
            var15 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
        }

        if (this.rand.nextInt(5) == 0)
        {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var15 = var5 + this.rand.nextInt(16) + 8;

            if (var14 < 63 || this.rand.nextInt(10) == 0)
            {
                (new WorldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
            }
        }

        int var16;

        for (var13 = 0; var13 < 8; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16) + 8;
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16) + 8;

            if (!(new WorldGenDungeons()).generate(this.worldObj, this.rand, var14, var15, var16))
            {
                ;
            }
        }

        for (var13 = 0; var13 < 15; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16) + 8;
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16) + 8;
            (new EBGGenClay(32)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 20; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.dirt.blockID, 32)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 10; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.gravel.blockID, 32)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 20; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreCoal.blockID, 16)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 20; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(64);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreIron.blockID, 8)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 3; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(52);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreGold.blockID, 8)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 10; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(32);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreRedstone.blockID, 7)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 1; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(16) + 16;
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreDiamond.blockID, 7)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 6; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(16) + 16;
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreEmerald.blockID, 1)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        for (var13 = 0; var13 < 1; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(16) + this.rand.nextInt(16);
            var16 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.oreLapis.blockID, 6)).generate(this.worldObj, this.rand, var14, var15, var16);
        }

        var11 = 0.5D;
        var13 = (int)((this.mobSpawnerNoise.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.rand.nextDouble() * 4.0D + 4.0D) / 3.0D);
        var14 = 0;

        if (this.rand.nextInt(10) == 0)
        {
            ++var14;
        }

        if (var6 == BiomeGenBase.BETAforest)
        {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.BETAjungle)
        {
            var14 += var13 + 10;
        }

        if (var6 == BiomeGenBase.BETAseasonalForest)
        {
            var14 += var13 + 2;
        }

        if (var6 == BiomeGenBase.BETAtaiga)
        {
            var14 += var13 + 5;
        }

        if (var6 == BiomeGenBase.BETAdesert)
        {
            var14 -= 20;
        }

        if (var6 == BiomeGenBase.BETAtundra)
        {
            var14 -= 20;
        }

        if (var6 == BiomeGenBase.BETAplains)
        {
            var14 -= 20;
        }

        int var17;

        for (var15 = 0; var15 < var14; ++var15)
        {
            var16 = var4 + this.rand.nextInt(16) + 8;
            var17 = var5 + this.rand.nextInt(16) + 8;
            WorldGenerator var18 = var6.getRandomWorldGenForTrees(this.rand);
            var18.setScale(1.0D, 1.0D, 1.0D);
            var18.generate(this.worldObj, this.rand, var16, this.worldObj.getHeightValue(var16, var17), var17);
        }

        byte var28 = 0;

        if (var6 == BiomeGenBase.BETAforest)
        {
            var28 = 2;
        }

        if (var6 == BiomeGenBase.BETAseasonalForest)
        {
            var28 = 4;
        }

        if (var6 == BiomeGenBase.BETAtaiga)
        {
            var28 = 2;
        }

        if (var6 == BiomeGenBase.BETAplains)
        {
            var28 = 3;
        }

        int var19;
        int var26;

        for (var16 = 0; var16 < var28; ++var16)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.plantYellow.blockID)).generate(this.worldObj, this.rand, var17, var26, var19);
        }

        byte var27 = 0;

        if (var6 == BiomeGenBase.BETAforest)
        {
            var27 = 2;
        }

        if (var6 == BiomeGenBase.BETAjungle)
        {
            var27 = 10;
        }

        if (var6 == BiomeGenBase.BETAseasonalForest)
        {
            var27 = 2;
        }

        if (var6 == BiomeGenBase.BETAtaiga)
        {
            var27 = 1;
        }

        if (var6 == BiomeGenBase.BETAplains)
        {
            var27 = 10;
        }

        int var21;
        int var20;

        for (var17 = 0; var17 < var27; ++var17)
        {
            byte var25 = 1;

            if (var6 == BiomeGenBase.BETAjungle && this.rand.nextInt(3) != 0)
            {
                var25 = 2;
            }

            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(128);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenTallGrass(Block.tallGrass.blockID, var25)).generate(this.worldObj, this.rand, var19, var20, var21);
        }

        var27 = 0;

        if (var6 == BiomeGenBase.BETAdesert)
        {
            var27 = 2;
        }

        for (var17 = 0; var17 < var27; ++var17)
        {
            var26 = var4 + this.rand.nextInt(16) + 8;
            var19 = this.rand.nextInt(128);
            var20 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.deadBush.blockID)).generate(this.worldObj, this.rand, var26, var19, var20);
        }

        if (this.rand.nextInt(2) == 0)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.plantRed.blockID)).generate(this.worldObj, this.rand, var17, var26, var19);
        }

        if (this.rand.nextInt(4) == 0)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.worldObj, this.rand, var17, var26, var19);
        }

        if (this.rand.nextInt(8) == 0)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.worldObj, this.rand, var17, var26, var19);
        }

        for (var17 = 0; var17 < 20; ++var17)
        {
            var26 = var4 + this.rand.nextInt(16) + 8;
            var19 = this.rand.nextInt(128);
            var20 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenReed()).generate(this.worldObj, this.rand, var26, var19, var20);
        }

        if (this.rand.nextInt(25) == 0)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenPumpkin()).generate(this.worldObj, this.rand, var17, var26, var19);
        }

        if (this.rand.nextInt(25) == 0)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new EBGGenMelon()).generate(this.worldObj, this.rand, var17, var26, var19);
        }

        var17 = 0;

        if (var6 == BiomeGenBase.BETAdesert)
        {
            var17 += 10;
        }

        for (var26 = 0; var26 < var17; ++var26)
        {
            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(128);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenCactus()).generate(this.worldObj, this.rand, var19, var20, var21);
        }

        for (var26 = 0; var26 < 50; ++var26)
        {
            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
        }

        for (var26 = 0; var26 < 20; ++var26)
        {
            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
        }

        SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
        this.generatedTemperatures = this.worldObj.getWorldChunkManager().getColdTemperatures(this.generatedTemperatures, var4 + 8, var5 + 8, 16, 16);

        for (var26 = var4 + 8; var26 < var4 + 8 + 16; ++var26)
        {
            for (var19 = var5 + 8; var19 < var5 + 8 + 16; ++var19)
            {
                var20 = var26 - (var4 + 8);
                var21 = var19 - (var5 + 8);
                int var22 = this.worldObj.getPrecipitationHeight(var26, var19);
                double var23 = this.generatedTemperatures[var20 * 16 + var21] - (double)(var22 - 64) / 64.0D * 0.3D;

                if (var23 < 0.5D && var22 > 0 && var22 < 128 && this.worldObj.isAirBlock(var26, var22, var19))
                {
                    if (this.worldObj.getBlockMaterial(var26, var22 - 1, var19).blocksMovement() && this.worldObj.getBlockMaterial(var26, var22 - 1, var19) != Material.ice)
                    {
                        this.worldObj.setBlockWithNotify(var26, var22, var19, Block.snow.blockID);
                    }
                    else if (this.worldObj.getBlockMaterial(var26, var22 - 1, var19) == Material.water)
                    {
                        this.worldObj.setBlockWithNotify(var26, var22 - 1, var19, Block.ice.blockID);
                    }
                }
            }
        }

        BlockSand.fallInstantly = false;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean var1, IProgressUpdate var2)
    {
        return true;
    }

    /**
     * Unloads the 100 oldest chunks from memory, due to a bug with chunkSet.add() never being called it thinks the list
     * is always empty and will not remove any chunks.
     */
    public boolean unload100OldestChunks()
    {
        return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "RandomLevelSource";
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3, int var4)
    {
        BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(var2, var4);
        return var5 == null ? null : var5.getSpawnableList(var1);
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World var1, String var2, int var3, int var4, int var5)
    {
        return null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }
}
