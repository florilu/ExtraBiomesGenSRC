package net.minecraft.src;

import net.minecraft.src.generators.*;
import net.minecraft.src.worldtypes.*;

public class WorldType
{
    /** List of world types. */
    public static final WorldType[] worldTypes = new WorldType[32];

    /** Default world type. */
    public static final WorldType DEFAULT = (new WorldType(0, "default", 1)).setVersioned();

    /** Flat world type. */
    public static final WorldType FLAT = new WorldType(1, "flat");

    /** Large Biome world Type. */
    public static final WorldType LARGE_BIOMES = new WorldType(2, "largeBiomes");

    /** Default (1.1) world type. */
    public static final WorldType DEFAULT_1_1 = (new WorldType(8, "default_1_1", 0)).setCanBeCreated(false);
    public static final WorldType BWGBETA = new WorldType(4, "Beta").setCanBeCreated(false);
    public static final WorldType BWGALPH = new WorldType(5, "Alpha").setCanBeCreated(false);
    public static final WorldType BWGGOLD = (new WorldType(6, "Gold")).setCanBeCreated(false);
    public static final WorldType BWGSISL = new WorldType(10, "Survival Island").setCanBeCreated(false);
    public static final WorldType BWGSSKY = new WorldType(11, "Survival Skyland").setCanBeCreated(false);
    public static final WorldType BWGSICE = (new WorldType(12, "Survival Iceland")).setCanBeCreated(false);
    public static final WorldType BWGSDES = (new WorldType(13, "Survival Desert")).setCanBeCreated(false);
    public static final WorldType BWGSKYL = new WorldType(14, "Sky Dimension").setCanBeCreated(false);
    public static final WorldType BWGCAVE = new WorldType(15, "Cave Dimension").setCanBeCreated(false);
    public static final WorldType BWGSHAR = (new WorldType(16, "Hardcore World")).setCanBeCreated(false);
    public static final WorldType EBG = (new WorldType(17, "ExtraBiomesGen"));
    public static final WorldType TEST = (new WorldType(18, "Test")).setCanBeCreated(true);

    /** 'default' or 'flat' */
    private final String worldType;

    /** The int version of the ChunkProvider that generated this world. */
    private final int generatorVersion;

    /**
     * Whether this world type can be generated. Normally true; set to false for out-of-date generator versions.
     */
    private boolean canBeCreated;

    /** Whether this WorldType has a version or not. */
    private boolean isWorldTypeVersioned;

    public WorldType(int par1, String par2Str)
    {
        this(par1, par2Str, 0);
    }

    public WorldType(int par1, String par2Str, int par3)
    {
        this.worldType = par2Str;
        this.generatorVersion = par3;
        this.canBeCreated = true;
        worldTypes[par1] = this;
    }

    public String getWorldTypeName()
    {
        return this.worldType;
    }

    /**
     * Gets the translation key for the name of this world type.
     */
    public String getTranslateName()
    {
        return this.worldType != "Beta" && this.worldType != "Alpha" && this.worldType != "Survival Island" && this.worldType != "Survival Skyland" && this.worldType != "Sky Dimension" && this.worldType != "ExtraBiomesGen" && this.worldType != "Cave Dimension" ? "generator." + this.worldType : this.worldType;
    }

    /**
     * Returns generatorVersion.
     */
    public int getGeneratorVersion()
    {
        return this.generatorVersion;
    }

    public WorldType getWorldTypeForGeneratorVersion(int par1)
    {
        return this == DEFAULT && par1 == 0 ? DEFAULT_1_1 : this;
    }

    /**
     * Sets canBeCreated to the provided value, and returns this.
     */
    private WorldType setCanBeCreated(boolean par1)
    {
        this.canBeCreated = par1;
        return this;
    }

    /**
     * Gets whether this WorldType can be used to generate a new world.
     */
    public boolean getCanBeCreated()
    {
        return this.canBeCreated;
    }

    /**
     * Flags this world type as having an associated version.
     */
    private WorldType setVersioned()
    {
        this.isWorldTypeVersioned = true;
        return this;
    }

    /**
     * Returns true if this world Type has a version associated with it.
     */
    public boolean isVersioned()
    {
        return this.isWorldTypeVersioned;
    }

    public static WorldType parseWorldType(String par0Str)
    {
        WorldType[] var1 = worldTypes;
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            WorldType var4 = var1[var3];

            if (var4 != null && var4.worldType.equalsIgnoreCase(par0Str))
            {
                return var4;
            }
        }

        return null;
    }

    public WorldChunkManager getChunkManager(World var1)
    {
        return (WorldChunkManager)(this == FLAT ? new WorldChunkManagerHell(BiomeGenBase.plains, 0.5F, 0.5F) : new WorldChunkManager(var1));
    }

    public IChunkProvider getChunkGenerator(World var1)
    {
        return (IChunkProvider)(this == FLAT ? new ChunkProviderFlat(var1, var1.getSeed(), var1.getWorldInfo().isMapFeaturesEnabled()) : new ChunkProviderGenerate(var1, var1.getSeed(), var1.getWorldInfo().isMapFeaturesEnabled()));
    }

    public int getSeaLevel(World var1)
    {
        return this != FLAT ? 64 : 4;
    }

    public boolean hasVoidParticles(boolean var1)
    {
        return this != FLAT && !var1;
    }

    public double voidFadeMagnitude()
    {
        return this != FLAT ? 0.03125D : 1.0D;
    }
}