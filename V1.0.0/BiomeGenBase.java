package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.generators.*;
import net.minecraft.src.biomes.*;

public abstract class BiomeGenBase
{
    /** An array of all the biomes, indexed by biome id. */
    public static final BiomeGenBase[] biomeList = new BiomeGenBase[256];
    public static final BiomeGenBase ocean = (new EBGBiomeDefault(0)).setColor(112).setBiomeName("Ocean").setMinMaxHeight(-0.8F, 0.5F).setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase plains = (new EBGBiomeDefault(1)).setColor(9286496).setBiomeName("Plains").setTemperatureRainfall(1.0F, 0.6F).setMinMaxHeight(0.3F, 0.2F);
    public static final BiomeGenBase desert = (new EBGBiomeDefault(2)).setColor(16421912).setBiomeName("Desert").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.2F, 0.7F);
    public static final BiomeGenBase extremeHills = (new EBGBiomeDefault(3)).setColor(6316128).setBiomeName("Extreme Hills").setMinMaxHeight(0.2F, 1.3F).setTemperatureRainfall(1.0F, 0.6F);
    public static final BiomeGenBase forest = (new EBGBiomeDefault(4)).setColor(353825).setBiomeName("Forest").func_76733_a(5159473).setTemperatureRainfall(1.0F, 0.6F).setMinMaxHeight(0.2F, 0.7F);
    public static final BiomeGenBase taiga = (new EBGBiomeDefault(5)).setColor(747097).setBiomeName("Taiga").func_76733_a(5159473).setEnableSnow().setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.2F, 0.7F);
    public static final BiomeGenBase swampland = (new EBGBiomeDefault(6)).setColor(522674).setBiomeName("Swampland").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.3F).setTemperatureRainfall(0.8F, 0.9F).setDisableBeach();
    public static final BiomeGenBase river = (new EBGBiomeDefault(7)).setColor(255).setBiomeName("River").setMinMaxHeight(-0.8F, 0.0F).setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase hell = (new BiomeGenHell(8)).setColor(16711680).setBiomeName("Hell").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);

    /** Is the biome used for sky world. */
    public static final BiomeGenBase sky = (new BiomeGenEnd(9)).setColor(8421631).setBiomeName("Sky").setDisableRain();
    public static final BiomeGenBase frozenOcean = (new BiomeGenOcean(10)).setColor(9474208).setBiomeName("FrozenOcean").setEnableSnow().setMinMaxHeight(-1.0F, 0.5F).setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase frozenRiver = (new BiomeGenRiver(11)).setColor(10526975).setBiomeName("FrozenRiver").setEnableSnow().setMinMaxHeight(-0.8F, 0.0F).setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase icePlains = (new EBGBiomeDefault(12)).setColor(16777215).setBiomeName("Ice Plains").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase iceMountains = (new EBGBiomeDefault(13)).setColor(10526880).setBiomeName("Ice Mountains").setEnableSnow().setMinMaxHeight(0.2F, 1.2F).setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase mushroomIsland = (new EBGBiomeDefault(14)).setColor(16711935).setBiomeName("MushroomIsland").setTemperatureRainfall(0.9F, 1.0F).setMinMaxHeight(0.2F, 1.0F).setDisableBeach();
    public static final BiomeGenBase mushroomIslandShore = (new EBGBiomeDefault(15)).setColor(10486015).setBiomeName("MushroomIslandShore").setTemperatureRainfall(0.9F, 1.0F).setMinMaxHeight(-1.0F, 0.1F).setDisableBeach();

    /** Beach biome. */
    public static final BiomeGenBase beach = (new EBGBiomeDefault(16)).setColor(16440917).setBiomeName("Beach").setTemperatureRainfall(0.8F, 0.4F).setMinMaxHeight(0.0F, 0.1F);

    /** Desert Hills biome. */
    public static final BiomeGenBase desertHills = (new EBGBiomeDefault(17)).setColor(13786898).setBiomeName("DesertHills").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.2F, 1.0F);

    /** Forest Hills biome. */
    public static final BiomeGenBase forestHills = (new EBGBiomeDefault(18)).setColor(2250012).setBiomeName("ForestHills").func_76733_a(5159473).setTemperatureRainfall(1.0F, 0.6F).setMinMaxHeight(0.2F, 1.0F);

    /** Taiga Hills biome. */
    public static final BiomeGenBase taigaHills = (new EBGBiomeDefault(19)).setColor(1456435).setBiomeName("TaigaHills").setEnableSnow().func_76733_a(5159473).setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.2F, 1.0F);

    /** Extreme Hills Edge biome. */
    public static final BiomeGenBase extremeHillsEdge = (new EBGBiomeDefault(20)).setColor(7501978).setBiomeName("Extreme Hills Edge").setMinMaxHeight(0.2F, 0.9F).setTemperatureRainfall(1.0F, 0.6F);

    /** Jungle biome identifier */
    public static final BiomeGenBase jungle = (new EBGBiomeDefault(21)).setColor(5470985).setBiomeName("Jungle").func_76733_a(5470985).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.0F, 0.4F).setDisableBeach();
    public static final BiomeGenBase jungleHills = (new EBGBiomeDefault(22)).setColor(2900485).setBiomeName("JungleHills").func_76733_a(5470985).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(1.8F, 0.2F).setDisableBeach();
    public static final BiomeGenBase BETAjungle = (new EBGBiomeBeta(29, 4, true, true, false)).setColor(353825).setBiomeName("Jungle").setTemperatureRainfall(1.0F, 0.8F);
    public static final BiomeGenBase BETArainforest = (new EBGBiomeBeta(30, 0, true, true, false)).setColor(353825).setBiomeName("Rainforest").setTemperatureRainfall(1.0F, 0.8F);
    public static final BiomeGenBase BETAswampland = (new EBGBiomeBeta(31, 3, true, false, false)).setColor(353825).setBiomeName("Swampland").setTemperatureRainfall(0.7F, 0.8F);
    public static final BiomeGenBase BETAseasonalForest = (new EBGBiomeBeta(32, 3, true, false, false)).setColor(353825).setBiomeName("SeasonalForest").setTemperatureRainfall(0.9F, 0.6F);
    public static final BiomeGenBase BETAforest = (new EBGBiomeBeta(33, 1, true, false, false)).setColor(353825).setBiomeName("Forest").setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase BETAsavanna = (new EBGBiomeBeta(34, 3, false, false, false)).setColor(353825).setBiomeName("Savanna").setTemperatureRainfall(1.0F, 0.4F);
    public static final BiomeGenBase BETAshrubland = (new EBGBiomeBeta(35, 3, false, false, false)).setColor(353825).setBiomeName("Shrubland").setTemperatureRainfall(0.9F, 0.6F);
    public static final BiomeGenBase BETAtaiga = (new EBGBiomeBeta(36, 2, true, false, false)).setColor(353825).setBiomeName("Taiga").setEnableSnow().setTemperatureRainfall(0.05F, 0.8F);
    public static final BiomeGenBase BETAdesert = (new EBGBiomeBeta(37, 3, false, false, true)).setColor(353825).setBiomeName("Desert").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
    public static final BiomeGenBase BETAplains = (new EBGBiomeBeta(38, 3, false, false, false)).setColor(353825).setBiomeName("Plains").setTemperatureRainfall(0.8F, 0.5F);
    public static final BiomeGenBase BETAtundra = (new EBGBiomeBeta(39, 3, false, false, false)).setColor(353825).setBiomeName("Tundra").setEnableSnow().setTemperatureRainfall(0.6F, 0.6F);
    public static final BiomeGenBase ALPHArainforest = (new EBGBiomeAlpha(40, 5, 1, 2, 1, true, false)).setColor(353825).setBiomeName("Rainforest").setTemperatureRainfall(1.0F, 0.8F);
    public static final BiomeGenBase ALPHAswampland = (new EBGBiomeAlpha(41, 5, 1, 2, 1, true, false)).setColor(353825).setBiomeName("Swampland").setTemperatureRainfall(0.7F, 0.8F);
    public static final BiomeGenBase ALPHAseasonalForest = (new EBGBiomeAlpha(42, 2, 1, 2, 1, true, false)).setColor(353825).setBiomeName("SeasonalForest").setTemperatureRainfall(0.9F, 0.6F);
    public static final BiomeGenBase ALPHAforest = (new EBGBiomeAlpha(43, 5, 1, 2, 1, true, false)).setColor(353825).setBiomeName("Forest").setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase ALPHAsavanna = (new EBGBiomeAlpha(44, 0, 1, 2, 1, false, false)).setColor(353825).setBiomeName("Savanna").setTemperatureRainfall(1.0F, 0.3F);
    public static final BiomeGenBase ALPHAshrubland = (new EBGBiomeAlpha(45, 0, 1, 2, 1, false, false)).setColor(353825).setBiomeName("Shrubland").setTemperatureRainfall(0.9F, 0.6F);
    public static final BiomeGenBase ALPHAtaiga = (new EBGBiomeAlpha(46, 2, 1, 2, 1, true, false)).setColor(353825).setBiomeName("Taiga").setEnableSnow().setTemperatureRainfall(0.05F, 0.8F);
    public static final BiomeGenBase ALPHAdesert = (new EBGBiomeAlpha(47, -20, 0, 0, 0, false, true)).setColor(353825).setBiomeName("Desert").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
    public static final BiomeGenBase ALPHAplains = (new EBGBiomeAlpha(48, -20, 1, 2, 5, false, false)).setColor(353825).setBiomeName("Plains").setTemperatureRainfall(0.8F, 0.5F);
    public static final BiomeGenBase ALPHAtundra = (new EBGBiomeAlpha(49, -20, 0, 0, 0, false, false)).setColor(353825).setBiomeName("Tundra").setTemperatureRainfall(0.6F, 0.6F);
    public static final BiomeGenBase EBGBiomeSisland = (new EBGBiomeSisland(50)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase EBGBiomeSskyland = (new EBGBiomeSskyland(52)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase EBGBiomeMcaves = (new EBGBiomeCaves(86)).setColor(353825).setBiomeName("Mushroom Caves").setTemperatureRainfall(0.9F, 0.7F);
    public static final BiomeGenBase swampriver = (new EBGBiomeDefault(90)).setColor(255).setBiomeName("SwampRiver").setMinMaxHeight(-0.8F, 0.0F);
    public static final BiomeGenBase jungleriver = (new EBGBiomeDefault(91)).setColor(255).setBiomeName("JungleRiver").setMinMaxHeight(-0.8F, 0.0F);
    public static final BiomeGenBase desertriver = (new EBGBiomeDefault(92)).setColor(255).setBiomeName("DesertRiver").setMinMaxHeight(-0.8F, 0.0F).setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
    public static final BiomeGenBase ColdHills = (new EBGBiomeGold(100, 1, 1)).setColor(255).setBiomeName("COLD_HILLS").setDisableBeach().setMountainHeight(75).EnableSnowMountains().setMinMaxHeight(1.7F, 2.0F);
    public static final BiomeGenBase ColdHillBorder = (new EBGBiomeGold(101, 1, 2)).setColor(255).setBiomeName("COLD_HILLSBORDER").setDisableBeach().setMountainHeight(80).EnableSnowMountains().setMinMaxHeight(1.4F, 1.3F);
    public static final BiomeGenBase ColdForest1 = (new EBGBiomeGold(102, 1, 3)).setColor(255).setBiomeName("COLD_FOREST1").setDisableBeach().setMinMaxHeight(1.2F, 0.7F);
    public static final BiomeGenBase ColdForest2 = (new EBGBiomeGold(103, 1, 3)).setColor(255).setBiomeName("COLD_FOREST2").setDisableBeach().setMinMaxHeight(1.2F, 0.7F);
    public static final BiomeGenBase ColdForest3 = (new EBGBiomeGold(104, 1, 4)).setColor(255).setBiomeName("COLD_FOREST3").setDisableBeach().setMinMaxHeight(1.2F, 0.7F);
    public static final BiomeGenBase ColdPlain = (new EBGBiomeGold(105, 1, 5)).setColor(255).setBiomeName("COLD_PLAIN").setDisableBeach().setMinMaxHeight(0.0F, 0.2F);
    public static final BiomeGenBase ColdBorder = (new EBGBiomeGold(106, 1, 6)).setColor(255).setBiomeName("COLD_BORDER").setDisableBeach().setMinMaxHeight(0.1F, 0.2F);
    public static final BiomeGenBase DesertHill = (new EBGBiomeGold(115, 2, 1)).setColor(255).setBiomeName("DESERT_HILLS").setDisableRain().setMinMaxHeight(1.1F, 1.2F).setTemperatureRainfall(2.0F, 0.0F).setDisableBeach();
    public static final BiomeGenBase DesertFlat = (new EBGBiomeGold(116, 2, 2)).setColor(255).setBiomeName("DESERT_FLAT").setDisableRain().setMinMaxHeight(1.1F, 0.2F).setTemperatureRainfall(2.0F, 0.0F).setDisableBeach();
    public static final BiomeGenBase DesertLakes = (new EBGBiomeGold(117, 2, 1)).setColor(255).setBiomeName("DESERT_LAKES").setDisableRain().setMinMaxHeight(-0.2F, 1.0F).setTemperatureRainfall(2.0F, 0.0F).setDisableBeach();
    public static final BiomeGenBase DesertSavanna = (new EBGBiomeGold(118, 2, 3)).setColor(255).setBiomeName("DESERT_SAVANNA").setDisableRain().setMinMaxHeight(0.8F, 0.4F).setTemperatureRainfall(1.0F, 0.4F).setDisableBeach();
    public static final BiomeGenBase DesertOasis = (new EBGBiomeGold(119, 2, 4)).setColor(255).setBiomeName("DESERT_OASIS").setDisableRain().EnableOasis().setMinMaxHeight(0.0F, 0.2F).setTemperatureRainfall(1.0F, 0.8F).setDisableBeach();
    public static final BiomeGenBase DesertOasisBorder = (new EBGBiomeGold(120, 2, 1)).setColor(255).setBiomeName("DESERT_OASISBORDER").setDisableRain().EnableOasis().setMinMaxHeight(1.3F, 0.6F).setTemperatureRainfall(1.0F, 0.8F).setDisableBeach();
    public static final BiomeGenBase DesertBorder = (new EBGBiomeGold(121, 2, 5)).setColor(255).setBiomeName("DESERT_BORDER").setDisableRain().setMinMaxHeight(0.5F, 0.3F).setTemperatureRainfall(1.0F, 0.5F).setDisableBeach();
    public static final BiomeGenBase DesertLakeBorder = (new EBGBiomeGold(122, 2, 1)).setColor(255).setBiomeName("DESERT_LAKEBORDER").setDisableRain().setMinMaxHeight(1.3F, 0.8F).setTemperatureRainfall(2.0F, 0.0F).setDisableBeach();
    public static final BiomeGenBase SnowPineHills = (new EBGBiomeGold(130, 3, 0)).setColor(255).setBiomeName("SNOW_PINE_HILLS").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.4F, 1.6F);
    public static final BiomeGenBase SnowPineValley = (new EBGBiomeGold(131, 3, 1)).setColor(255).setBiomeName("SNOW_PINE_VALLEY").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.3F, 0.3F);
    public static final BiomeGenBase SnowPineForest = (new EBGBiomeGold(132, 3, 2)).setColor(255).setBiomeName("SNOW_PINE_FOREST").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.4F, 0.8F);
    public static final BiomeGenBase SnowPineLakes = (new EBGBiomeGold(133, 3, 2)).setColor(255).setBiomeName("SNOW_PINE_LAKES").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.1F, 0.4F);
    public static final BiomeGenBase SnowOakHills = (new EBGBiomeGold(134, 3, 3)).setColor(255).setBiomeName("SNOW_OAK_HILLS").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.4F, 1.6F);
    public static final BiomeGenBase SnowOakValley = (new EBGBiomeGold(135, 3, 4)).setColor(255).setBiomeName("SNOW_OAK_VALLEY").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.3F, 0.3F);
    public static final BiomeGenBase SnowOakForest = (new EBGBiomeGold(136, 3, 5)).setColor(255).setBiomeName("SNOW_OAK_FOREST").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.4F, 0.8F);
    public static final BiomeGenBase SnowOakLakes = (new EBGBiomeGold(137, 3, 5)).setColor(255).setBiomeName("SNOW_OAK_LAKES").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.1F, 0.4F);
    public static final BiomeGenBase SnowTundraHills = (new EBGBiomeGold(138, 3, 6)).setColor(255).setBiomeName("SNOW_TUNDRA_HILLS").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.4F, 1.6F);
    public static final BiomeGenBase SnowTundraValley = (new EBGBiomeGold(139, 3, 6)).setColor(255).setBiomeName("SNOW_TUNDRA_VALLEY").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.3F, 0.3F);
    public static final BiomeGenBase SnowTundraLakes = (new EBGBiomeGold(140, 3, 6)).setColor(255).setBiomeName("SNOW_TUNDRA_LAKES").setEnableSnow().setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.1F, 0.4F);
    public static final BiomeGenBase SnowBorder = (new EBGBiomeGold(141, 3, 7)).setColor(255).setBiomeName("SNOW_BORDER").setMinMaxHeight(0.0F, 0.0F).setMinMaxHeight(0.3F, 0.3F);
    public static final BiomeGenBase GOLDexJungle1 = (new EBGBiomeGold(140, 2, 2)).setColor(255).setBiomeName("Jungle").setDisableBeach().setMinMaxHeight(-0.4F, 1.8F);
    public static final BiomeGenBase GOLDexJungleb = (new EBGBiomeGold(149, 2, 2)).setColor(255).setBiomeName("Jungle").setDisableBeach().setMinMaxHeight(0.2F, 0.1F).setTemperatureRainfall(1.0F, 0.6F);
    public static final BiomeGenBase GOLDtropocean1 = (new EBGBiomeGold(150, 3, 3)).setColor(255).setBiomeName("Ocean").setEnableSand().setMinMaxHeight(-0.7F, 0.0F);
    public static final BiomeGenBase GOLDtropocean2 = (new EBGBiomeGold(151, 3, 3)).setColor(255).setBiomeName("Island").setEnableSand().setMinMaxHeight(0.4F, 2.0F);
    public static final BiomeGenBase GOLDtropocean3 = (new EBGBiomeGold(152, 3, 3)).setColor(255).setBiomeName("Island").setEnableSand().setMinMaxHeight(0.3F, 0.8F);
    public static final BiomeGenBase GOLDtropoceanb = (new EBGBiomeGold(159, 3, 3)).setColor(255).setBiomeName("Shore").setEnableSand().setMinMaxHeight(0.2F, 0.4F);
    public String biomeName;
    public int color;

    /** The block expected to be on the top of this biome */
    public byte topBlock;

    /** The block to fill spots in when not on the top */
    public byte fillerBlock;
    public int field_76754_C;

    /** The minimum height of this biome. Default 0.1. */
    public float minHeight;

    /** The maximum height of this biome. Default 0.3. */
    public float maxHeight;

    /** The temperature of this biome. */
    public float temperature;

    /** The rainfall in this biome. */
    public float rainfall;

    /** Color tint applied to water depending on biome */
    public int waterColorMultiplier;

    /** The biome decorator. */
    public BiomeDecorator theBiomeDecorator;

    /**
     * Holds the classes of IMobs (hostile mobs) that can be spawned in the biome.
     */
    public List spawnableMonsterList;

    /**
     * Holds the classes of any creature that can be spawned in the biome as friendly creature.
     */
    public List spawnableCreatureList;

    /**
     * Holds the classes of any aquatic creature that can be spawned in the water of the biome.
     */
    public List spawnableWaterCreatureList;

    /** Set to true if snow is enabled for this biome. */
    public boolean enableSnow;

    /**
     * Is true (default) if the biome support rain (desert and nether can't have rain)
     */
    public boolean enableRain;

    /** The id number to this biome, and its index in the biomeList array. */
    public final int biomeID;
    public WorldGenTrees worldGeneratorTrees;

    /** The big tree generator. */
    public WorldGenBigTree worldGeneratorBigTree;
    public WorldGenForest worldGeneratorForest;
    public WorldGenSwamp worldGeneratorSwamp;
    public boolean enableGravel;
    public boolean enableSand;
    public boolean enablebeach;
    public boolean snowMountains;
    public int setMountainHeight;
    public boolean enableoasis;

    public BiomeGenBase(int par1)
    {
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.field_76754_C = 5169201;
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
        this.temperature = 0.5F;
        this.rainfall = 0.5F;
        this.waterColorMultiplier = 16777215;
        this.spawnableMonsterList = new ArrayList();
        this.spawnableCreatureList = new ArrayList();
        this.spawnableWaterCreatureList = new ArrayList();
        this.enableRain = true;
        this.worldGeneratorTrees = new WorldGenTrees(false);
        this.worldGeneratorBigTree = new WorldGenBigTree(false);
        this.worldGeneratorForest = new WorldGenForest(false);
        this.worldGeneratorSwamp = new WorldGenSwamp();
        this.biomeID = par1;
        this.enablebeach = true;
        this.enableoasis = false;
        this.enableGravel = false;
        this.enableSand = false;
        this.setMountainHeight = 128;
        biomeList[par1] = this;
        this.theBiomeDecorator = this.createBiomeDecorator();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    public BiomeDecorator createBiomeDecorator()
    {
        return new BiomeDecorator(this);
    }

    /**
     * Sets the temperature and rainfall of this biome.
     */
    public BiomeGenBase setTemperatureRainfall(float par1, float par2)
    {
        if (par1 > 0.1F && par1 < 0.2F)
        {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        else
        {
            this.temperature = par1;
            this.rainfall = par2;
            return this;
        }
    }

    /**
     * Sets the minimum and maximum height of this biome. Seems to go from -2.0 to 2.0.
     */
    public BiomeGenBase setMinMaxHeight(float par1, float par2)
    {
        this.minHeight = par1;
        this.maxHeight = par2;
        return this;
    }

    public BiomeGenBase setMountainHeight(int var1)
    {
        this.setMountainHeight = var1;
        return this;
    }

    public BiomeGenBase EnableOasis()
    {
        this.enableoasis = true;
        return this;
    }

    public BiomeGenBase setEnableGravel()
    {
        this.enableGravel = true;
        return this;
    }

    public BiomeGenBase setEnableSand()
    {
        this.enableSand = true;
        return this;
    }

    public BiomeGenBase setDisableBeach()
    {
        this.enablebeach = false;
        return this;
    }

    public BiomeGenBase EnableSnowMountains()
    {
        this.snowMountains = true;
        return this;
    }

    /**
     * Disable the rain for the biome.
     */
    public BiomeGenBase setDisableRain()
    {
        this.enableRain = false;
        return this;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        return new WorldGenTallGrass(Block.tallGrass.blockID, 1);
    }

    /**
     * sets enableSnow to true during biome initialization. returns BiomeGenBase.
     */
    public BiomeGenBase setEnableSnow()
    {
        this.enableSnow = true;
        return this;
    }

    public BiomeGenBase setBiomeName(String par1Str)
    {
        this.biomeName = par1Str;
        return this;
    }

    public BiomeGenBase func_76733_a(int par1)
    {
        this.field_76754_C = par1;
        return this;
    }

    public BiomeGenBase setColor(int par1)
    {
        this.color = par1;
        return this;
    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float par1)
    {
        par1 /= 3.0F;

        if (par1 < -1.0F)
        {
            par1 = -1.0F;
        }

        if (par1 > 1.0F)
        {
            par1 = 1.0F;
        }

        return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
    }

    /**
     * Returns the correspondent list of the EnumCreatureType informed.
     */
    public List getSpawnableList(EnumCreatureType par1EnumCreatureType)
    {
        return par1EnumCreatureType == EnumCreatureType.monster ? this.spawnableMonsterList : (par1EnumCreatureType == EnumCreatureType.creature ? this.spawnableCreatureList : (par1EnumCreatureType == EnumCreatureType.waterCreature ? this.spawnableWaterCreatureList : null));
    }

    /**
     * Returns true if the biome have snowfall instead a normal rain.
     */
    public boolean getEnableSnow()
    {
        return this.enableSnow;
    }

    /**
     * Return true if the biome supports lightning bolt spawn, either by have the bolts enabled and have rain enabled.
     */
    public boolean canSpawnLightningBolt()
    {
        return this.enableSnow ? false : this.enableRain;
    }

    /**
     * Checks to see if the rainfall level of the biome is extremely high
     */
    public boolean isHighHumidity()
    {
        return this.rainfall > 0.85F;
    }

    /**
     * returns the chance a creature has to spawn.
     */
    public float getSpawningChance()
    {
        return 0.1F;
    }

    /**
     * Gets an integer representation of this biome's rainfall
     */
    public final int getIntRainfall()
    {
        return (int)(this.rainfall * 65536.0F);
    }

    /**
     * Gets an integer representation of this biome's temperature
     */
    public final int getIntTemperature()
    {
        return (int)(this.temperature * 65536.0F);
    }

    /**
     * Gets a floating point representation of this biome's rainfall
     */
    public final float getFloatRainfall()
    {
        return this.rainfall;
    }

    /**
     * Gets a floating point representation of this biome's temperature
     */
    public final float getFloatTemperature()
    {
        return this.temperature;
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        this.theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
        double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
        return ColorizerGrass.getGrassColor(var1, var3);
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
        double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
        return ColorizerFoliage.getFoliageColor(var1, var3);
    }
}
