package net.minecraft.src.biomes;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.blocks.*;

public class Wasteland extends BiomeGenBase
{
    public Wasteland(int par1)
    {
        super(par1);
        spawnableCreatureList.clear();
        topBlock = (byte)mod_EBGMain.CrackedSand.blockID;
        fillerBlock = (byte)mod_EBGMain.CrackedSand.blockID;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 2;
        this.theBiomeDecorator.reedsPerChunk = 50;
        this.theBiomeDecorator.cactiPerChunk = -999;
    }

}
