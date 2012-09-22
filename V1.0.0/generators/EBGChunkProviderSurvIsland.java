package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGChunkProviderSurvIsland implements IChunkProvider
{
    private Random endRNG;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    public NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    private World endWorld;
    private double[] densities;
    private MapGenBase caveGenerator = new EBGMapGenCaves();
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    private BiomeGenBase[] biomesForGeneration;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;
    int[][] field_40395_h = new int[32][32];

    public EBGChunkProviderSurvIsland(World var1, long var2)
    {
        this.endWorld = var1;
        this.endRNG = new Random(var2);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);
    }

    public void func_40380_a(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
    {
        byte var5 = 2;
        int var6 = var5 + 1;
        byte var7 = 33;
        int var8 = var5 + 1;
        this.densities = this.func_40379_a(this.densities, var1 * var5, 0, var2 * var5, var6, var7, var8);

        for (int var9 = 0; var9 < var5; ++var9)
        {
            for (int var10 = 0; var10 < var5; ++var10)
            {
                for (int var11 = 0; var11 < 32; ++var11)
                {
                    double var12 = 0.25D;
                    double var14 = this.densities[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
                    double var16 = this.densities[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
                    double var18 = this.densities[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
                    double var20 = this.densities[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
                    double var22 = (this.densities[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
                    double var24 = (this.densities[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
                    double var26 = (this.densities[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
                    double var28 = (this.densities[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

                    for (int var30 = 0; var30 < 4; ++var30)
                    {
                        double var31 = 0.125D;
                        double var33 = var14;
                        double var35 = var16;
                        double var37 = (var18 - var14) * var31;
                        double var39 = (var20 - var16) * var31;

                        for (int var41 = 0; var41 < 8; ++var41)
                        {
                            int var42 = var41 + var9 * 8 << 11 | 0 + var10 * 8 << 7 | var11 * 4 + var30;
                            short var43 = 128;
                            double var44 = 0.125D;
                            double var46 = var33;
                            double var48 = (var35 - var33) * var44;

                            for (int var50 = 0; var50 < 8; ++var50)
                            {
                                int var51 = 0;

                                if (var46 > 0.0D)
                                {
                                    var51 = Block.stone.blockID;
                                }
                                else if (var11 * 4 + var30 < 63)
                                {
                                    if (var11 * 4 + var30 < 55)
                                    {
                                        var51 = Block.stone.blockID;
                                    }
                                    else
                                    {
                                        var51 = Block.waterStill.blockID;
                                    }
                                }

                                var3[var42] = (byte)var51;
                                var42 += var43;
                                var46 += var48;
                            }

                            var33 += var37;
                            var35 += var39;
                        }

                        var14 += var22;
                        var16 += var24;
                        var18 += var26;
                        var20 += var28;
                    }
                }
            }
        }
    }

    public void func_40381_b(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
    {
        byte var5 = 64;

        for (int var6 = 0; var6 < 16; ++var6)
        {
            for (int var7 = 0; var7 < 16; ++var7)
            {
                byte var8 = 1;
                int var9 = -1;
                byte var10 = (byte)Block.sand.blockID;
                byte var11 = (byte)Block.sand.blockID;

                for (int var12 = 127; var12 >= 0; --var12)
                {
                    int var13 = (var7 * 16 + var6) * 128 + var12;

                    if (var12 <= 0 + this.endRNG.nextInt(5))
                    {
                        var3[var13] = (byte)Block.bedrock.blockID;
                    }
                    else
                    {
                        byte var14 = var3[var13];

                        if (var14 == 0)
                        {
                            var9 = -1;
                        }
                        else if (var14 == Block.stone.blockID)
                        {
                            if (var9 == -1)
                            {
                                if (var8 <= 0)
                                {
                                    var10 = (byte)Block.sand.blockID;
                                    var11 = (byte)Block.sand.blockID;
                                }

                                if (var12 >= var5 - 10 && var12 <= var5 + 6)
                                {
                                    var10 = (byte)Block.sand.blockID;
                                    var11 = (byte)Block.sand.blockID;
                                }

                                var9 = var8;

                                if (var12 >= 0)
                                {
                                    var3[var13] = var10;
                                }
                                else
                                {
                                    var3[var13] = var11;
                                }
                            }
                            else if (var9 > 0 && var9 < 8)
                            {
                                ++var9;

                                if (var9 > 0 && var9 < 5)
                                {
                                    var3[var13] = var11;
                                }
                                else
                                {
                                    var11 = (byte)Block.sandStone.blockID;
                                    var3[var13] = var11;
                                }
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
        this.endRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte[32768];
        this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
        this.func_40380_a(var1, var2, var3, this.biomesForGeneration);
        this.func_40381_b(var1, var2, var3, this.biomesForGeneration);
        this.caveGenerator.generate(this, this.endWorld, var1, var2, var3);
        this.strongholdGenerator.generate(this, this.endWorld, var1, var2, var3);
        Chunk var4 = new Chunk(this.endWorld, var3, var1, var2);
        byte[] var5 = var4.getBiomeArray();

        for (int var6 = 0; var6 < var5.length; ++var6)
        {
            var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
        }

        var4.generateSkylightMap();
        return var4;
    }

    private double[] func_40379_a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        if (var1 == null)
        {
            var1 = new double[var5 * var6 * var7];
        }

        double var8 = 684.412D;
        double var10 = 684.412D;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, var2, var4, var5, var7, 2.242D, 2.242D, 0.5D);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, var2, var4, var5, var7, 800.0D, 800.0D, 0.5D);
        var8 *= 2.0D;
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, var2, var3, var4, var5, var6, var7, var8, var10, var8);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, var2, var3, var4, var5, var6, var7, var8, var10, var8);
        int var12 = 0;
        int var13 = 0;

        for (int var14 = 0; var14 < var5; ++var14)
        {
            for (int var15 = 0; var15 < var7; ++var15)
            {
                double var16 = (this.noiseData4[var13] + 256.0D) / 512.0D;

                if (var16 > 1.0D)
                {
                    var16 = 1.0D;
                }

                double var18 = this.noiseData5[var13] / 8000.0D;

                if (var18 < 0.0D)
                {
                    var18 = -var18 * 0.3D;
                }

                var18 = var18 * 3.0D - 2.0D;
                float var20 = (float)(var14 + var2 - 0) / 0.5F;
                float var21 = (float)(var15 + var4 - 0) / 0.5F;
                float var22 = 100.0F - MathHelper.sqrt_float(var20 * var20 + var21 * var21) * 8.0F;

                if (var22 > 80.0F)
                {
                    var22 = 80.0F;
                }

                if (var22 < -100.0F)
                {
                    var22 = -100.0F;
                }

                if (var18 > 1.0D)
                {
                    var18 = 1.0D;
                }

                var18 /= 8.0D;
                var18 = 0.0D;

                if (var16 < 0.0D)
                {
                    var16 = 0.0D;
                }

                var16 += 0.5D;
                var18 = var18 * (double)var6 / 16.0D;
                ++var13;
                double var23 = (double)var6 / 2.0D;

                for (int var25 = 0; var25 < var6; ++var25)
                {
                    double var26 = 0.0D;
                    double var28 = ((double)var25 - var23) * 8.0D / var16;

                    if (var28 < 0.0D)
                    {
                        var28 *= -1.0D;
                    }

                    double var30 = this.noiseData2[var12] / 512.0D;
                    double var32 = this.noiseData3[var12] / 512.0D;
                    double var34 = (this.noiseData1[var12] / 10.0D + 1.0D) / 2.0D;

                    if (var34 < 0.0D)
                    {
                        var26 = var30;
                    }
                    else if (var34 > 1.0D)
                    {
                        var26 = var32;
                    }
                    else
                    {
                        var26 = var30 + (var32 - var30) * var34;
                    }

                    var26 -= 8.0D;
                    var26 += (double)var22;
                    byte var36 = 2;
                    double var37;

                    if (var25 > var6 / 2 - var36)
                    {
                        var37 = (double)((float)(var25 - (var6 / 2 - var36)) / 64.0F);

                        if (var37 < 0.0D)
                        {
                            var37 = 0.0D;
                        }

                        if (var37 > 1.0D)
                        {
                            var37 = 1.0D;
                        }

                        var26 = var26 * (1.0D - var37) + -1500.0D * var37;
                    }

                    var36 = 8;

                    if (var25 < var36)
                    {
                        var37 = (double)((float)(var36 - var25) / ((float)var36 - 1.0F));
                        var26 = var26 * (1.0D - var37) + -30.0D * var37;
                    }

                    var1[var12] = var26;
                    ++var12;
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
        BiomeGenBase var6 = this.endWorld.getBiomeGenForCoords(var4 + 16, var5 + 16);
        this.strongholdGenerator.generateStructuresInChunk(this.endWorld, this.endRNG, var2, var3);
        int var7;
        int var8;

        if (var2 == 0 && var3 == 0)
        {
            var7 = -5 + this.endRNG.nextInt(10);
            var8 = -5 + this.endRNG.nextInt(10);

            if (!(new EBGGenDungeons2(1)).generate(this.endWorld, this.endRNG, var7, 55, var8))
            {
                ;
            }

            var7 = -7 + this.endRNG.nextInt(15);
            var8 = -7 + this.endRNG.nextInt(15);

            if (!(new EBGGenDungeons2(2)).generate(this.endWorld, this.endRNG, var7, 40, var8))
            {
                ;
            }

            var7 = -10 + this.endRNG.nextInt(20);
            var8 = -10 + this.endRNG.nextInt(20);

            if (!(new EBGGenDungeons2(3)).generate(this.endWorld, this.endRNG, var7, 25, var8))
            {
                ;
            }

            var7 = -15 + this.endRNG.nextInt(30);
            var8 = -15 + this.endRNG.nextInt(30);

            if (!(new EBGGenDungeons2(4)).generate(this.endWorld, this.endRNG, var7, 10, var8))
            {
                ;
            }

            (new EBGGenSurvivalChest(1)).generate(this.endWorld, this.endRNG, 0, this.endWorld.getHeightValue(0, 0), 0);
        }

        int var9;
        int var10;

        for (var7 = 0; var7 < 12; ++var7)
        {
            var8 = var4 + this.endRNG.nextInt(16) + 8;
            var9 = this.endRNG.nextInt(128);
            var10 = var5 + this.endRNG.nextInt(16) + 8;

            if (!(new EBGGenDungeons(0)).generate(this.endWorld, this.endRNG, var8, var9, var10))
            {
                ;
            }
        }

        for (var7 = 0; var7 < 15; ++var7)
        {
            var8 = var4 + this.endRNG.nextInt(16) + 8;
            var9 = this.endRNG.nextInt(128);
            var10 = var5 + this.endRNG.nextInt(16) + 8;
            (new EBGGenClay(32)).generate(this.endWorld, this.endRNG, var8, var9, var10);
        }

        var6.decorate(this.endWorld, this.endWorld.rand, var4, var5);
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
        BiomeGenBase var5 = this.endWorld.getBiomeGenForCoords(var2, var4);
        return var5 == null ? null : var5.getSpawnableList(var1);
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World var1, String var2, int var3, int var4, int var5)
    {
        return "Stronghold".equals(var2) && this.strongholdGenerator != null ? this.strongholdGenerator.getNearestInstance(var1, var3, var4, var5) : null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }
}
