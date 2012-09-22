package net.minecraft.src.blocks;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material; 
import net.minecraft.src.*;

public class Basalt extends Block
{
	public Basalt (int i, int j)
    {
        super(i,j,Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return mod_EBGMain.Basalt.blockID;               
    }

    public Block setHardness(float par1)
    {
        this.blockHardness = par1;

        if (this.blockResistance < par1 * 5.0F)
        {
            this.blockResistance = par1 * 5.0F;
        }

        return this;
    }

}