package net.minecraft.src.trees;
import java.util.Random;
import java.io.PrintStream;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.biomes.*;
import net.minecraft.src.*;
import net.minecraft.src.blocks.*;

import net.minecraft.src.WorldGenerator;
 
public class WorldGenAcaciaTree extends WorldGenerator
{
   public WorldGenAcaciaTree()
   {
     
   }
   
   public boolean generate(World world, Random rand, int x, int y, int z)
   {
      if(world.getBlockId(x, y, z)!= Block.grass.blockID || world.getBlockId(x, y + 1, z)!= 0)
      {
         return false;
      }
                int wood = mod_EBGMain.AcaciaWood.blockID;
                int leaf = mod_EBGMain.AcaciaLeaf.blockID;
                world.setBlockWithNotify(x, y, z, wood);
                world.setBlockWithNotify(x, y + 1, z, wood);
                world.setBlockWithNotify(x, y + 2, z, wood);
                world.setBlockWithNotify(x, y + 3, z, wood);
                world.setBlockWithNotify(x, y + 4, z, wood);
                world.setBlockWithNotify(x, y + 5, z, wood);
                world.setBlockWithNotify(x, y + 6, z, wood);
                world.setBlockWithNotify(x, y + 7, z, wood);
                world.setBlockWithNotify(x, y + 8, z, wood);
                world.setBlockWithNotify(x, y + 9, z, wood);
                world.setBlockWithNotify(x + 1, y + 9, z - 1, wood);
                world.setBlockWithNotify(x + 2, y + 9, z - 2, wood);
                world.setBlockWithNotify(x + 2, y + 10, z - 2,  wood);
                world.setBlockWithNotify(x + 3, y + 11, z - 3, wood);
                world.setBlockWithNotify(x + 3, y + 12, z - 4, wood);
                world.setBlockWithNotify(x + 4, y + 12, z - 3, wood);
                world.setBlockWithNotify(x - 1, y + 9, z, wood);
                world.setBlockWithNotify(x - 1, y + 10, z, wood);
                world.setBlockWithNotify(x - 2, y + 10, z - 1, wood);
                world.setBlockWithNotify(x - 2, y + 11, z - 2, wood);
                world.setBlockWithNotify(x - 3, y + 11, z - 3, wood);
                world.setBlockWithNotify(x - 2, y + 12, z - 4, wood);
                world.setBlockWithNotify(x - 4, y + 12, z - 4, wood);
                world.setBlockWithNotify(x - 2, y + 13, z - 5, wood);
                
                
                
                
                
                
                
                
                
                return true;
   }
}