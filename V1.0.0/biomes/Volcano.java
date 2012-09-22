package net.minecraft.src.biomes;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.blocks.*;

public class Volcano extends BiomeGenBase
{
    public Volcano(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        topBlock = (byte)mod_EBGMain.Basalt.blockID;
        fillerBlock = (byte)Block.lavaMoving.blockID;
        this.theBiomeDecorator.treesPerChunk = -999;
    }
    
}
