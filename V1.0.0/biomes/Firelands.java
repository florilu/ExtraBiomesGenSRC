package net.minecraft.src.biomes;

import java.util.List;
import net.minecraft.src.*;
import java.util.Random;
import net.minecraft.src.blocks.*;

public class Firelands extends BiomeGenBase
{
    public Firelands(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        topBlock = (byte)mod_EBGMain.Basalt.blockID;
        fillerBlock = (byte)mod_EBGMain.Basalt.blockID;
        this.theBiomeDecorator.treesPerChunk = -999;
    }
    
}
