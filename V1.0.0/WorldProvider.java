package net.minecraft.src;

import net.minecraft.src.generators.*;

public abstract class WorldProvider
{
    /** world object being used */
    public World worldObj;
    public WorldType terrainType;

    /** World chunk manager being used to generate chunks */
    public WorldChunkManager worldChunkMgr;

    /**
     * States whether the Hell world provider is used(true) or if the normal world provider is used(false)
     */
    public boolean isHellWorld = false;

    /**
     * A boolean that tells if a world does not have a sky. Used in calculating weather and skylight
     */
    public boolean hasNoSky = false;

    /** Light to brightness conversion table */
    public float[] lightBrightnessTable = new float[16];

    /** 0 for normal world -1 for hell */
    public int worldType = 0;

    /** Array for sunrise/sunset colors (RGBA) */
    private float[] colorsSunriseSunset = new float[4];

    /**
     * associate an existing world with a World provider, and setup its lightbrightness table
     */
    public final void registerWorld(World par1World)
    {
        this.worldObj = par1World;
        this.terrainType = par1World.getWorldInfo().getTerrainType();

        if (this.terrainType == WorldType.BWGCAVE)
        {
            this.hasNoSky = true;
        }

        this.registerWorldChunkManager();
        this.generateLightBrightnessTable();
    }

    /**
     * Creates the light to brightness table
     */
    protected void generateLightBrightnessTable()
    {
        float var1 = 0.0F;

        for (int var2 = 0; var2 <= 15; ++var2)
        {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }

    /**
     * creates a new world chunk manager for WorldProvider
     */
    protected void registerWorldChunkManager()
    {
        if (this.worldObj.getWorldInfo().getTerrainType() == WorldType.FLAT)
        {
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.plains, 0.5F, 0.5F);
        }
        else if (this.worldObj.getWorldInfo().getTerrainType() == WorldType.BWGSISL)
        {
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.EBGBiomeSisland, 0.5F, 0.5F);
        }
        else if (this.worldObj.getWorldInfo().getTerrainType() == WorldType.BWGSSKY)
        {
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.EBGBiomeSskyland, 0.5F, 0.5F);
        }
        else if (this.worldObj.getWorldInfo().getTerrainType() == WorldType.BWGCAVE)
        {
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.EBGBiomeMcaves, 0.5F, 0.5F);
        }
        else
        {
            this.worldChunkMgr = this.terrainType.getChunkManager(this.worldObj);
        }
    }

    /**
     * Returns the chunk provider back for the world provider
     */
    public IChunkProvider getChunkProvider()
    {
        return (IChunkProvider)(this.terrainType == WorldType.FLAT ? new ChunkProviderFlat(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled()) : (this.terrainType == WorldType.BWGBETA ? new EBGChunkProviderBeta(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled()) : (this.terrainType == WorldType.BWGSKYL ? new EBGChunkProviderSky(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled()) : (this.terrainType == WorldType.BWGALPH ? new EBGChunkProviderAlpha(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled()) : (this.terrainType == WorldType.BWGGOLD ? new EBGChunkProviderGold(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled()) : (this.terrainType == WorldType.BWGSISL ? new EBGChunkProviderSurvIsland(this.worldObj, this.worldObj.getSeed()) : (this.terrainType == WorldType.BWGSSKY ? new EBGChunkProviderSurvSkyland(this.worldObj, this.worldObj.getSeed()) : (this.terrainType == WorldType.BWGCAVE ? new EBGChunkProviderCave(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled()) : this.terrainType.getChunkGenerator(this.worldObj)))))))));
    }

    public boolean canCoordinateBeSpawn(int var1, int var2, int var3)
    {
        int var4 = this.worldObj.getFirstUncoveredBlock(var1, var2);
        return var3 == 1 ? var4 == Block.sand.blockID : var4 == Block.grass.blockID;
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
        int var4 = (int)(par1 % 24000L);
        float var5 = ((float)var4 + par3) / 24000.0F - 0.25F;

        if (var5 < 0.0F)
        {
            ++var5;
        }

        if (var5 > 1.0F)
        {
            --var5;
        }

        if (this.terrainType == WorldType.BWGCAVE)
        {
            var5 = 0.4F;
        }

        float var6 = var5;
        var5 = 1.0F - (float)((Math.cos((double)var5 * Math.PI) + 1.0D) / 2.0D);
        var5 = var6 + (var5 - var6) / 3.0F;
        return var5;
    }

    public int getMoonPhase(long par1, float par3)
    {
        return (int)(par1 / 24000L) % 8;
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return this.terrainType != WorldType.BWGCAVE;
    }

    /**
     * Returns array with sunrise/sunset colors
     */
    public float[] calcSunriseSunsetColors(float par1, float par2)
    {
        float var3 = 0.4F;
        float var4 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) - 0.0F;
        float var5 = -0.0F;

        if (var4 >= var5 - var3 && var4 <= var5 + var3)
        {
            float var6 = (var4 - var5) / var3 * 0.5F + 0.5F;
            float var7 = 1.0F - (1.0F - MathHelper.sin(var6 * (float)Math.PI)) * 0.99F;
            var7 *= var7;
            this.colorsSunriseSunset[0] = var6 * 0.3F + 0.7F;
            this.colorsSunriseSunset[1] = var6 * var6 * 0.7F + 0.2F;
            this.colorsSunriseSunset[2] = var6 * var6 * 0.0F + 0.2F;
            this.colorsSunriseSunset[3] = var7;
            return this.colorsSunriseSunset;
        }
        else
        {
            return null;
        }
    }

    /**
     * Return Vec3D with biome specific fog color
     */
    public Vec3 getFogColor(float par1, float par2)
    {
        float var3 = MathHelper.cos(par1 * (float)Math.PI * 2.0F) * 2.0F + 0.5F;

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }

        if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }

        float var4 = 0.7529412F;
        float var5 = 0.84705883F;
        float var6 = 1.0F;
        var4 *= var3 * 0.94F + 0.06F;
        var5 *= var3 * 0.94F + 0.06F;
        var6 *= var3 * 0.91F + 0.09F;
        return this.terrainType == WorldType.BWGCAVE ? Vec3.getVec3Pool().getVecFromPool(0.0D, 0.0D, 0.0D) : Vec3.getVec3Pool().getVecFromPool((double)var4, (double)var5, (double)var6);
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return true;
    }

    public static WorldProvider getProviderForDimension(int par0)
    {
        return (WorldProvider)(par0 == -1 ? new WorldProviderHell() : (par0 == 0 ? new WorldProviderSurface() : (par0 == 1 ? new WorldProviderEnd() : null)));
    }

    /**
     * the y level at which clouds are rendered.
     */
    public float getCloudHeight()
    {
        return this.terrainType != WorldType.BWGSSKY && this.terrainType != WorldType.BWGSKYL ? (this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH ? (this.terrainType == WorldType.BWGCAVE ? 200.0F : 128.0F) : 107.0F) : 3.0F;
    }

    public boolean isSkyColored()
    {
        return true;
    }

    /**
     * Gets the hard-coded portal location to use when entering this dimension
     */
    public ChunkCoordinates getEntrancePortalLocation()
    {
        return null;
    }

    public int getAverageGroundLevel()
    {
        return this.terrainType == WorldType.BWGCAVE ? 10 : this.terrainType.getSeaLevel(this.worldObj);
    }

    public int getSpawnType()
    {
        return this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH ? (this.terrainType != WorldType.BWGSISL && this.terrainType != WorldType.BWGSSKY && this.terrainType != WorldType.BWGSICE ? 0 : 2) : 1;
    }

    /**
     * returns true if this dimension is supposed to display void particles and pull in the far plane based on the
     * user's Y offset.
     */
    public boolean getWorldHasVoidParticles()
    {
        return this.terrainType.hasVoidParticles(this.hasNoSky);
    }

    /**
     * Returns a double value representing the Y value relative to the top of the map at which void fog is at its
     * maximum. The default factor of 0.03125 relative to 256, for example, means the void fog will be at its maximum at
     * (256*0.03125), or 8.
     */
    public double getVoidFogYFactor()
    {
        return this.terrainType != WorldType.FLAT && this.terrainType != WorldType.BWGSKYL && this.terrainType != WorldType.BWGSSKY && this.terrainType != WorldType.BWGBETA && this.terrainType != WorldType.BWGALPH ? this.terrainType.voidFadeMagnitude() : 1.0D;
    }

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    public boolean doesXZShowFog(int par1, int par2)
    {
        return false;
    }

    public abstract String func_80007_l();
}
