package net.minecraft.src.blocks;

import net.minecraft.src.*;

import java.util.Random;
import java.util.List;

public class RedwoodLeaf extends Block
{
	public RedwoodLeaf (int i, int j)
    {
		super(i,j,Material.leaves);
    }
	
    public int getBlockColor()
    {
        double var1 = 0.5D;
        double var3 = 1.0D;
        return ColorizerFoliage.getFoliageColor(var1, var3);
    }
    
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    
    public int getRenderColor(int par1)
    {
        return (par1 & 3) == 5 ? ColorizerFoliage.getFoliageColorRedwood() : ColorizerFoliage.getFoliageColorBasic();
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = par1IBlockAccess.getBlockMetadata(par2, par3, par4);

        if ((var5 & 3) == 5)
        {
            return ColorizerFoliage.getFoliageColorRedwood();
        }
        else
        {
            int var6 = 0;
            int var7 = 0;
            int var8 = 0;

            for (int var9 = -1; var9 <= 1; ++var9)
            {
                for (int var10 = -1; var10 <= 1; ++var10)
                {
                    int var11 = par1IBlockAccess.getBiomeGenForCoords(par2 + var10, par4 + var9).getBiomeFoliageColor();
                    var6 += (var11 & 16711680) >> 16;
                    var7 += (var11 & 65280) >> 8;
                    var8 += var11 & 255;
                }
            }

            return (var6 / 9 & 255) << 16 | (var7 / 9 & 255) << 8 | var8 / 9 & 255;
        }
    }
    
    public int quantityDropped(Random par1Random)
    {
        return par1Random.nextInt(20) == 0 ? 1 : 0;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int i, Random random)
    {
        return mod_EBGMain.RedwoodLeaf.blockID;              
    }
    
    public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6)
    {
        if (!par1World.isRemote && par2EntityPlayer.getCurrentEquippedItem() != null && par2EntityPlayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex)
        {
            this.dropBlockAsItem_do(par1World, par3, par4, par5, new ItemStack(mod_EBGMain.RedwoodLeaf.blockID, 1, par6 & 3));
        }
        else
        {
            super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
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