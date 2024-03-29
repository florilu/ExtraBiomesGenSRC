package net.minecraft.src;

import java.util.Random;

public class MapGenBase
{
    /** The number of Chunks to gen-check in any given direction. */
    protected int range = 8;

    /** The RNG used by the MapGen classes. */
    protected Random rand = new Random();

    /** This world object. */
    protected World worldObj;

    public void generate(IChunkProvider par1IChunkProvider, World par2World, int par3, int par4, byte[] par5ArrayOfByte)
    {
        int var6 = this.range;
        this.worldObj = par2World;
        this.rand.setSeed(this.worldObj.getSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;

        for (int var11 = par3 - var6; var11 <= par3 + var6; ++var11)
        {
            for (int var12 = par4 - var6; var12 <= par4 + var6; ++var12)
            {
                this.rand.setSeed((long)var11 * var7 + (long)var12 * var9 ^ this.worldObj.getSeed());
                this.recursiveGenerate(this.worldObj, var11, var12, par3, par4, par5ArrayOfByte);
            }
        }
    }

    /**
     * Recursively called by generate() (generate) and optionally by itself.
     */
    protected void recursiveGenerate(World par1World, int par2, int par3, int par4, int par5, byte[] par6ArrayOfByte) {}
}
