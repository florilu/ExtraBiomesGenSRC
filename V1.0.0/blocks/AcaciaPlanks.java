package net.minecraft.src.blocks;

import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.Block;

public class AcaciaPlanks extends Block
{
    public AcaciaPlanks (int i, int j)
    {
        super(i,j,Material.wood);
    }

    public int idDropped(int i, Random random)
    {
        return mod_EBGMain.AcaciaPlanks.blockID;               
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