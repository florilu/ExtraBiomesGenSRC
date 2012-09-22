package net.minecraft.src.structures;

import java.util.Random;
import net.minecraft.src.*;

public class Test extends WorldGenerator
{
	
    public boolean generate(World par1World, Random par2Random, int par1, int par2, int par3)
    {
        while (par1World.isAirBlock (par1, par2, par3) && par2 > 5)
        {
            --par2;
        }

        int var6 = par1World.getBlockId(par1, par2, par3);

        if (var6 != Block.grass.blockID && var6 != Block.stone.blockID)
        {
            return false;
        }
        else
        {
            int x;
            int y;
            int z;
            
            for (x = 1; x <= 2; ++x)
            {
            	for (y = 1; y <= 3; ++y)
            	{
            		for (z = 1; z <= 3; ++z)
            		{
            			for (int a = 1; a <= 4; ++a)
            			{
            				for (int b = 1; b <= 1; ++b)
            				{
            					for (int c = 1; c <= 7; ++c)
            					{
            						if (var6 == Block.stone.blockID)
                        			{
                        				par1World.setBlock(par1 + x * 3, par2 + y, par3 + z * 3, Block.obsidian.blockID);
                        				par1World.setBlock(par1 + a + 2, par2 + b + 3, par3 + c + 2, Block.cobblestone.blockID);
                        				System.out.println("Generiert");
                        			}
            					}
            				}
            			}
            		}
            	}
            }


            return true;
        }
    }
}
