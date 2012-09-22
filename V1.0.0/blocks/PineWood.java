package net.minecraft.src.blocks;

import java.util.Random;

import net.minecraft.src.*;

public class PineWood extends Block
{
	public PineWood (int i, int j)
    {
        super(i,j,Material.wood);
    }
    
    public int idDropped(int i, Random random)
    {
        return mod_EBGMain.PineWood.blockID;               
    }
    
    public int getBlockTextureFromSide(int a)
    {
    	if(a == 0)
    	{
    		return mod_EBGMain.AcaciaBelow;
    	}
    	else if(a == 1)
    	{
    		return mod_EBGMain.AcaciaAbove;
    	}
    	else
    	{
    		return mod_EBGMain.PineSide;
    	}
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