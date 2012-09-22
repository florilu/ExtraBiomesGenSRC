package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.biomes.*;
import net.minecraft.src.blocks.*;
import net.minecraft.src.Block;

public class mod_EBGMain extends BaseMod
{

public static Block Basalt = new Basalt(253,0).setHardness(3.0F).setLightValue(0.0F).setBlockName("Basalt").setCreativeTab(CreativeTabs.tabBlock);
public static Block CrackedSand = (new CrackedSand(254, 0)).setHardness(1.0F).setLightValue(0.0F).setBlockName("Cracked Sand").setCreativeTab(CreativeTabs.tabBlock);
public static Block AcaciaWood = new AcaciaWood(255, 0).setHardness(2.0F).setBlockName("Acacia Wood").setCreativeTab(CreativeTabs.tabBlock);
public static Block AcaciaLeaf = new AcaciaLeaf(202, 0).setHardness(0.2F).setLightOpacity(1).setBlockName("Acacia Leaf").setCreativeTab(CreativeTabs.tabDeco);
public static Block AcaciaSapling = new AcaciaSapling(201, 15).setHardness(0.0F).setBlockName("Acacia Sapling").setCreativeTab(CreativeTabs.tabDeco);
public static Block AcaciaPlanks = (new AcaciaPlanks(200, 0)).setHardness(2.0F).setBlockName("Acacia Planks").setCreativeTab(CreativeTabs.tabBlock);
public static Block PineWood = (new PineWood(250, 0)).setHardness(2.0F).setBlockName("Pine Wood").setCreativeTab(CreativeTabs.tabBlock);
public static Block RedwoodLeaf = (new RedwoodLeaf(251, 132)).setHardness(0.2F).setLightOpacity(1).setBlockName("Redwoodleaf").setCreativeTab(CreativeTabs.tabDeco).setRequiresSelfNotify();

public static int AcaciaAbove = ModLoader.addOverride("/terrain.png", "/textures/blocks/AcaciaAbove.png");
public static int AcaciaBelow = ModLoader.addOverride("/terrain.png", "/textures/blocks/AcaciaBelow.png");
public static int AcaciaSide = ModLoader.addOverride("/terrain.png", "/textures/blocks/acaciawood.png");
public static int PineSide = ModLoader.addOverride("/terrain.png", "/textures/blocks/PineSide.png");

public static BiomeGenBase newdesert = (new NewDesert(220)).setColor(13786898).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.3F).setBiomeName("Desert");
public static BiomeGenBase foresthills = (new ForestHills(221)).setColor(353825).setTemperatureRainfall(0.7F, 0.8F).setMinMaxHeight(0.6F, 1.9F).setBiomeName("Forest Mountains");
public static BiomeGenBase newforest = (new NewForest(222)).setColor(353825).setTemperatureRainfall(0.7F, 0.8F).setBiomeName("Forest");
public static BiomeGenBase redwoods = (new Redwoods(224)).setColor(353825).setTemperatureRainfall(0.7F, 0.8F).setMinMaxHeight(0.3F, 0.4F).setBiomeName("Redwoods");
public static BiomeGenBase redwoodhills = (new Redwoods(225)).setColor(353825).setTemperatureRainfall(0.7F, 0.8F).setMinMaxHeight(0.4F, 0.8F).setBiomeName("Redwoodhills");
public static BiomeGenBase primeval = (new Primeval(200)).setColor(5470985).setBiomeName("Primeval Forest").setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.3F);
public static BiomeGenBase endbiome = (new EndBiome(201)).setColor(8421631).setBiomeName("Endbiome").setDisableRain();
public static BiomeGenBase epicmountains = (new EpicMountains(202)).setColor(5470985).setBiomeName("Epic Mountains").setTemperatureRainfall(0.9F, 0.9F).setMinMaxHeight(0.0F, 20.0F);
public static BiomeGenBase glacier = (new Glacier(203)).setColor(747097).setBiomeName("Glacier").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.1F, 0.1F); //Smooth
public static BiomeGenBase glacierhills = (new Glacier(204)).setColor(747097).setBiomeName("Glacier").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.1F, 2.0F);
public static BiomeGenBase lakeland = (new Lakeland(205)).setColor(5470985).setBiomeName("Lakelands").setTemperatureRainfall(0.8F, 1.0F).setMinMaxHeight(-0.3F, 0.1F);
public static BiomeGenBase meadow = (new Meadow(206)).setColor(5470985).setBiomeName("Meadow").setTemperatureRainfall(1.0F, 1.0F).setMinMaxHeight(0.1F, 0.2F);
public static BiomeGenBase mixed = (new Mixed(207)).setColor(353825).setBiomeName("Mixed Forest").setTemperatureRainfall(0.9F, 0.7F).setMinMaxHeight(0.2F, 0.4F);
public static BiomeGenBase mixedSnow = (new MixedSnow(208)).setColor(747097).setBiomeName("Snowy Mixed Forest").setTemperatureRainfall(0.1F, 0.7F).setMinMaxHeight(0.2F, 0.4F);
public static BiomeGenBase oasis = (new Oasis(209)).setColor(16421912).setBiomeName("Oasis").setTemperatureRainfall(0.9F, 1.0F).setMinMaxHeight(-0.1F, 0.3F);
public static BiomeGenBase sandyHills = (new SandyHills(210)).setColor(13786898).setBiomeName("Sandy Hills").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 2.0F);
public static BiomeGenBase savanna = (new Savanna(211)).setColor(13786898).setBiomeName("Savanna").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
public static BiomeGenBase table = (new Table(212)).setColor(353825).setBiomeName("Table Mountains").setTemperatureRainfall(0.8F, 1.0F).setMinMaxHeight(3.0F, 3.0F);
public static BiomeGenBase firelands = (new Firelands(213)).setColor(13786898).setBiomeName("Firelands").setDisableRain().setTemperatureRainfall(1.0F, 0.0F).setMinMaxHeight(0.3F, 0.4F);
public static BiomeGenBase volcano = (new Volcano(214)).setColor(13786898).setBiomeName("Volcano").setDisableRain().setTemperatureRainfall(1.0F, 0.0F).setMinMaxHeight(0.4F, 0.8F);
public static BiomeGenBase wasteland = (new Wasteland(215)).setColor(13786898).setBiomeName("Wasteland").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.3F);
public static BiomeGenBase mountains = (new Mountains(216)).setColor(747097).setBiomeName("Mountains").setTemperatureRainfall(0.9F, 1.0F).setMinMaxHeight(0.4F, 0.5F);
public static BiomeGenBase coveredmountains = (new CoveredMountains(223)).setColor(747097).setBiomeName("Covered Mountains").setTemperatureRainfall(0.0F, 0.8F).setMinMaxHeight(1.5F, 2.0F);
public static BiomeGenBase littlemountains = (new LittleMountains(224)).setColor(353825).setBiomeName("Little Mountains").setTemperatureRainfall(0.7F, 0.8F).setMinMaxHeight(0.8F, 2.0F);
public static BiomeGenBase littlemountainsgreen = (new LittleMountainsGreen(225)).setColor(747097).setBiomeName("Little Mountains Green").setTemperatureRainfall(0.7F, 0.8F).setMinMaxHeight(0.4F, 0.5F);

public mod_EBGMain()
{    

    ModLoader.registerBlock(Basalt);
    ModLoader.registerBlock(CrackedSand);
    ModLoader.registerBlock(AcaciaWood);
    ModLoader.registerBlock(AcaciaLeaf);
    ModLoader.registerBlock(AcaciaSapling);
    ModLoader.registerBlock(AcaciaPlanks);
    ModLoader.registerBlock(PineWood);
    ModLoader.registerBlock(RedwoodLeaf);
    
    CrackedSand.blockIndexInTexture = ModLoader.addOverride("/terrain.png","/textures/blocks/crackedsand.png");
    AcaciaPlanks.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/textures/blocks/acaciaplanks.png");
    AcaciaLeaf.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/textures/blocks/acacialeaf.png");
    AcaciaSapling.blockIndexInTexture = ModLoader.addOverride("/terrain.png", "/textures/blocks/acaciasapling.png");
    Basalt.blockIndexInTexture = ModLoader.addOverride("/terrain.png","/textures/blocks/basalt.png");

    ModLoader.addName(Basalt, "Basalt");
    ModLoader.addName(CrackedSand, "Cracked Sand");
    ModLoader.addName(AcaciaWood, "WIP");
    ModLoader.addName(AcaciaLeaf, "WIP");
    ModLoader.addName(AcaciaSapling, "WIP");
    ModLoader.addName(AcaciaPlanks, "WIP");
    ModLoader.addName(PineWood, "Pine Wood EBG");
    ModLoader.addName(RedwoodLeaf, "Redwoodleaf");
    
}               

public String getVersion()
    {
        return "1.3.2";
    }
  
        public void load()
        {
        	;
        }

} 