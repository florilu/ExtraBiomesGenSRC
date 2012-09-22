package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGGenSurvivalChest extends WorldGenerator
{
    private int getChestType;
    protected WorldInfo worldInfo;

    public EBGGenSurvivalChest(int var1)
    {
        this.getChestType = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        var1.setBlockWithNotify(var3, var4, var5, Block.chest.blockID);
        TileEntityChest var6 = (TileEntityChest)var1.getBlockTileEntity(var3, var4, var5);
        byte var7 = 20;
        int var8 = var2.nextInt(2);

        for (int var9 = 0; var9 < var7; ++var9)
        {
            ItemStack var10 = this.getChestList(var9, var8, var2, var1);

            if (var6 != null && var10 != null)
            {
                var6.setInventorySlotContents(var9, var10);
            }
        }

        return true;
    }

    private ItemStack getChestList(int var1, int var2, Random var3, World var4)
    {
        if (this.getChestType == 1)
        {
            if (var1 == 0)
            {
                return new ItemStack(Block.sapling);
            }
            else if (var1 == 1)
            {
                return new ItemStack(Block.dirt, 7);
            }
            else if (var1 == 2)
            {
                return new ItemStack(Block.grass);
            }
            else
            {
                if (var2 == 0)
                {
                    if (var1 == 3)
                    {
                        return new ItemStack(Block.planks, 7);
                    }

                    if (var1 == 4)
                    {
                        return new ItemStack(Item.stick, 5);
                    }

                    if (var1 == 5)
                    {
                        return new ItemStack(Item.silk, 2);
                    }
                }
                else
                {
                    if (var1 == 3)
                    {
                        return new ItemStack(Block.planks, 7);
                    }

                    if (var1 == 4)
                    {
                        return new ItemStack(Item.stick, 4);
                    }

                    if (var1 == 5)
                    {
                        return new ItemStack(Item.seeds, 6);
                    }
                }

                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
