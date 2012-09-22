package net.minecraft.src.trees;

import java.util.Random;
import net.minecraft.src.*;
import net.minecraft.src.blocks.*;

public class BigPineTree extends WorldGenerator
{
	int leaf = mod_EBGMain.RedwoodLeaf.blockID;
	
	
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
            int x2;
            int y2; 
            int z2;
            
            //Stamm
            for (x = 1; x <= 2; ++x)
            {
            	for (y = 1; y <= 33; ++y)
            	{
            		for (z = 1; z <= 2; ++z)
            		{
            			par1World.setBlockAndMetadata(par1 + x, par2 + y - 4, par3 + z, Block.wood.blockID, 1);
            		}
            	}
            }
            //Blätter Ring 1
            for (x = 1; x <= 4; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 10; ++z)
            		{
            			for (x2 = 1; x2 <= 10; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 4; ++z2)
                        		{
                            		par1World.setBlock(par1 + x + 2, par2 + y + 21,  par3 + z - 4, leaf);
                        			par1World.setBlock(par1 + x - 4, par2 + y + 21,  par3 + z - 4, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 4, par2 + y2 + 21,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 4, par2 + y2 + 21,  par3 + z2 - 4, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 2
            for (x = 1; x <= 3; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 8; ++z)
            		{
            			for (x2 = 1; x2 <= 8; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 3; ++z2)
                        		{
                            		par1World.setBlock(par1 + x + 2, par2 + y + 22,  par3 + z - 3, leaf);
                        			par1World.setBlock(par1 + x - 3, par2 + y + 22,  par3 + z - 3, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 3, par2 + y2 + 22,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 3, par2 + y2 + 22,  par3 + z2 - 3, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 3
            for (x = 1; x <= 2; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 6; ++z)
            		{
            			for (x2 = 1; x2 <= 6; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 2; ++z2)
                        		{
                            		par1World.setBlock(par1 + x + 2, par2 + y + 23,  par3 + z - 2, leaf);
                        			par1World.setBlock(par1 + x - 2, par2 + y + 23,  par3 + z - 2, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 2, par2 + y2 + 23,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 2, par2 + y2 + 23,  par3 + z2 - 2, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 4
            for (x = 1; x <= 1; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 4; ++z)
            		{
            			for (x2 = 1; x2 <= 4; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 1; ++z2)
                        		{
                            		par1World.setBlock(par1 + x + 2, par2 + y + 24,  par3 + z - 1, leaf);
                        			par1World.setBlock(par1 + x - 1, par2 + y + 24,  par3 + z - 1, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 1, par2 + y2 + 24,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 1, par2 + y2 + 24,  par3 + z2 - 1, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 5
            for (x = 1; x <= 3; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 8; ++z)
            		{
            			for (x2 = 1; x2 <= 8; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 3; ++z2)
                        		{
                        			par1World.setBlock(par1 + x + 2, par2 + y + 25,  par3 + z - 3, leaf);
                        			par1World.setBlock(par1 + x - 3, par2 + y + 25,  par3 + z - 3, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 3, par2 + y2 + 25,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 3, par2 + y2 + 25,  par3 + z2 - 3, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 6
            for (x = 1; x <= 2; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 6; ++z)
            		{
            			for (x2 = 1; x2 <= 6; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 2; ++z2)
                        		{
                        			par1World.setBlock(par1 + x + 2, par2 + y + 26,  par3 + z - 2, leaf);
                        			par1World.setBlock(par1 + x - 2, par2 + y + 26,  par3 + z - 2, leaf);
       
                        			par1World.setBlock(par1 + x2 - 2, par2 + y2 + 26,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 2, par2 + y2 + 26,  par3 + z2 - 2, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 7
            for (x = 1; x <= 1; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 4; ++z)
            		{
            			for (x2 = 1; x2 <= 4; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 1; ++z2)
                        		{
                        			par1World.setBlock(par1 + x + 2, par2 + y + 27,  par3 + z - 1, leaf);
                        			par1World.setBlock(par1 + x - 1, par2 + y + 27,  par3 + z - 1, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 1, par2 + y2 + 27,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 1, par2 + y2 + 27,  par3 + z2 - 1, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
          //Blätter Ring 8
            for (x = 1; x <= 2; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 6; ++z)
            		{
            			for (x2 = 1; x2 <= 6; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 2; ++z2)
                        		{
                        			par1World.setBlock(par1 + x + 2, par2 + y + 28,  par3 + z - 2, leaf);
                        			par1World.setBlock(par1 + x - 2, par2 + y + 28,  par3 + z - 2, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 2, par2 + y2 + 28,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 2, par2 + y2 + 28,  par3 + z2 - 2, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Blätter Ring 9
            for (x = 1; x <= 1; ++x)
            {
            	for (y = 0; y <= 0; ++y)
            	{
            		for (z = 1; z <= 4; ++z)
            		{
            			for (x2 = 1; x2 <= 4; ++x2)
                        {
                        	for (y2 = 0; y2 <= 0; ++y2)
                        	{
                        		for (z2 = 1; z2 <= 1; ++z2)
                        		{
                        			par1World.setBlock(par1 + x + 2, par2 + y + 29,  par3 + z - 1, leaf);
                        			par1World.setBlock(par1 + x - 1, par2 + y + 29,  par3 + z - 1, leaf);
                        			
                        			par1World.setBlock(par1 + x2 - 1, par2 + y2 + 29,  par3 + z2 + 2, leaf);
                        			par1World.setBlock(par1 + x2 - 1, par2 + y2 + 29,  par3 + z2 - 1, leaf);
                        		}
                        	}
                        }
            		}
            	}
            }
            //Oben
            for (x = 1; x <= 2; ++x)
            {
            	for (y = 1; y <= 1; ++y)
            	{
            		for (z = 1; z <= 2; ++z)
            		{
            			par1World.setBlock(par1 + x, par2 + y + 29, par3 + z, leaf);
            		}
            	}
            }


            return true;
        }
    }
}
