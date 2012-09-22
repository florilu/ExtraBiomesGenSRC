package net.minecraft.src.blocks;

import java.util.Random;

import net.minecraft.src.*;

public class AcaciaSapling extends BlockFlower
{
	public AcaciaSapling (int i, int j)
    {
        super(i,j,Material.rock);
    }

    public int idDropped(int i, Random random)
    {
        return mod_EBGMain.AcaciaSapling.blockID;               
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