package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGGenRuin1 extends WorldGenerator
{
    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var3;
        int var7 = var4 - 3;
        int var8 = var5;
        byte var9 = 3;
        byte var10 = 3;
        byte var11 = 3;
        int var12;
        int var13;
        int var14;

        for (var12 = var3 - var9 - 1; var12 <= var6 + var9 + 1; ++var12)
        {
            for (var13 = var7 - 1; var13 <= var7 + var11 + 1; ++var13)
            {
                for (var14 = var8 - var10 - 1; var14 <= var8 + var10 + 1; ++var14)
                {
                    if (var1.getBlockId(var12, var13, var14) == Block.waterMoving.blockID || var1.getBlockId(var12, var13, var14) == Block.waterStill.blockID)
                    {
                        return true;
                    }
                }
            }
        }

        for (var12 = var6 - var9 - 1; var12 <= var6 + var9 + 1; ++var12)
        {
            for (var13 = var7 - 1; var13 <= var7 + var11 + 1; ++var13)
            {
                for (var14 = var8 - var10 - 1; var14 <= var8 + var10 + 1; ++var14)
                {
                    if (var12 != var6 - var9 - 1 && var13 != var7 - 1 && var14 != var8 - var10 - 1 && var12 != var6 + var9 + 1 && var13 != var7 + var11 + 1 && var14 != var8 + var10 + 1)
                    {
                        if (var13 == var7 && var2.nextInt(4) == 0)
                        {
                            if (var1.getBlockMaterial(var12, var13 - 1, var14).isSolid())
                            {
                                if (var2.nextInt(4) == 0)
                                {
                                    if (var2.nextInt(2) == 0)
                                    {
                                        var1.setBlockWithNotify(var12, var13, var14, Block.chest.blockID);
                                        TileEntityChest var15 = (TileEntityChest)var1.getBlockTileEntity(var12, var13, var14);

                                        for (int var16 = 0; var16 <= 7; ++var16)
                                        {
                                            ItemStack var17 = this.pickCheckLootItem(var2);
                                            var15.setInventorySlotContents(var2.nextInt(var15.getSizeInventory()), var17);
                                        }
                                    }
                                    else if (var2.nextInt(2) == 0)
                                    {
                                        var1.setBlockWithNotify(var12, var13, var14, Block.stoneOvenIdle.blockID);
                                    }
                                    else
                                    {
                                        var1.setBlockWithNotify(var12, var13, var14, Block.workbench.blockID);
                                    }
                                }
                                else if (var2.nextInt(3) == 0)
                                {
                                    var1.setBlockWithNotify(var12, var13, var14, Block.cobblestone.blockID);
                                }
                                else
                                {
                                    var1.setBlockWithNotify(var12, var13, var14, Block.cobblestoneMossy.blockID);
                                }
                            }
                        }
                        else
                        {
                            var1.setBlockWithNotify(var12, var13, var14, 0);
                        }
                    }
                    else if (var13 >= 0 && var13 <= var11 && !var1.getBlockMaterial(var12, var13 - 1, var14).isSolid())
                    {
                        var1.setBlockWithNotify(var12, var13, var14, 0);
                    }
                    else if (var1.getBlockMaterial(var12, var13 - var2.nextInt(2), var14).isSolid())
                    {
                        if (var2.nextInt(4) == 0)
                        {
                            var1.setBlockWithNotify(var12, var13, var14, Block.cobblestone.blockID);
                        }
                        else if (var2.nextInt(3) == 0 && var13 == var7 - 1)
                        {
                            var1.setBlockWithNotify(var12, var13, var14, Block.grass.blockID);
                        }
                        else
                        {
                            var1.setBlockWithNotify(var12, var13, var14, Block.cobblestoneMossy.blockID);
                        }
                    }
                }
            }
        }

        return true;
    }

    private ItemStack pickCheckLootItem(Random var1)
    {
        int var2 = var1.nextInt(11);
        return var2 == 0 ? new ItemStack(Item.saddle) : (var2 == 1 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var2 == 2 ? new ItemStack(Item.bread) : (var2 == 3 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var2 == 4 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var2 == 5 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var2 == 6 ? new ItemStack(Item.bucketEmpty) : (var2 == 7 && var1.nextInt(100) == 0 ? new ItemStack(Item.appleGold) : (var2 == 8 && var1.nextInt(2) == 0 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var2 == 9 && var1.nextInt(10) == 0 ? new ItemStack(Item.itemsList[Item.record13.shiftedIndex + var1.nextInt(2)]) : (var2 == 10 ? new ItemStack(Item.dyePowder, 1, 3) : null))))))))));
    }

    private String pickMobSpawner(Random var1)
    {
        int var2 = var1.nextInt(4);
        return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : "")));
    }
}
