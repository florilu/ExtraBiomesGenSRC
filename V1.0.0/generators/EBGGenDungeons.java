package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGGenDungeons extends WorldGenerator
{
    public int dungeonType;

    public EBGGenDungeons(int var1)
    {
        this.dungeonType = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        byte var6 = 3;
        int var7 = var2.nextInt(2) + 2;
        int var8 = var2.nextInt(2) + 2;
        int var9 = 0;
        byte var10 = 10;
        int var11;
        int var12;
        int var13;

        for (var11 = var3 - var7 - 1; var11 <= var3 + var7 + 1; ++var11)
        {
            for (var12 = var4 - 1; var12 <= var4 + var6 + 1; ++var12)
            {
                for (var13 = var5 - var8 - 1; var13 <= var5 + var8 + 1; ++var13)
                {
                    Material var14 = var1.getBlockMaterial(var11, var12, var13);

                    if (var12 == var4 - 1 && !var14.isSolid())
                    {
                        return false;
                    }

                    if (var12 == var4 + var6 + 1 && !var14.isSolid())
                    {
                        return false;
                    }

                    if ((var11 == var3 - var7 - 1 || var11 == var3 + var7 + 1 || var13 == var5 - var8 - 1 || var13 == var5 + var8 + 1) && var12 == var4 && var1.isAirBlock(var11, var12, var13) && var1.isAirBlock(var11, var12 + 1, var13))
                    {
                        ++var9;
                    }
                }
            }
        }

        if (var9 >= 1 && var9 <= 5)
        {
            for (var11 = var3 - var7 - 1; var11 <= var3 + var7 + 1; ++var11)
            {
                for (var12 = var4 + var6; var12 >= var4 - 1; --var12)
                {
                    for (var13 = var5 - var8 - 1; var13 <= var5 + var8 + 1; ++var13)
                    {
                        if (var11 != var3 - var7 - 1 && var12 != var4 - 1 && var13 != var5 - var8 - 1 && var11 != var3 + var7 + 1 && var12 != var4 + var6 + 1 && var13 != var5 + var8 + 1)
                        {
                            var1.setBlockWithNotify(var11, var12, var13, 0);
                        }
                        else if (var12 >= 0 && !var1.getBlockMaterial(var11, var12 - 1, var13).isSolid())
                        {
                            var1.setBlockWithNotify(var11, var12, var13, 0);
                        }
                        else if (var1.getBlockMaterial(var11, var12, var13).isSolid())
                        {
                            if (var12 == var4 - 1 && var2.nextInt(4) != 0)
                            {
                                var1.setBlockWithNotify(var11, var12, var13, Block.cobblestoneMossy.blockID);
                            }
                            else
                            {
                                var1.setBlockWithNotify(var11, var12, var13, Block.cobblestone.blockID);
                            }
                        }
                    }
                }
            }

            var11 = 0;

            while (var11 < 2)
            {
                var12 = 0;

                while (true)
                {
                    if (var12 < 3)
                    {
                        label212:
                        {
                            var13 = var3 + var2.nextInt(var7 * 2 + 1) - var7;
                            int var15 = var5 + var2.nextInt(var8 * 2 + 1) - var8;

                            if (var1.isAirBlock(var13, var4, var15))
                            {
                                int var16 = 0;

                                if (var1.getBlockMaterial(var13 - 1, var4, var15).isSolid())
                                {
                                    ++var16;
                                }

                                if (var1.getBlockMaterial(var13 + 1, var4, var15).isSolid())
                                {
                                    ++var16;
                                }

                                if (var1.getBlockMaterial(var13, var4, var15 - 1).isSolid())
                                {
                                    ++var16;
                                }

                                if (var1.getBlockMaterial(var13, var4, var15 + 1).isSolid())
                                {
                                    ++var16;
                                }

                                if (var16 == 1)
                                {
                                    var1.setBlockWithNotify(var13, var4, var15, Block.chest.blockID);
                                    TileEntityChest var17 = (TileEntityChest)var1.getBlockTileEntity(var13, var4, var15);

                                    if (var17 != null)
                                    {
                                        for (int var18 = 0; var18 < var10; ++var18)
                                        {
                                            ItemStack var19 = this.pickCheckLootItem(var2);

                                            if (var19 != null)
                                            {
                                                var17.setInventorySlotContents(var2.nextInt(var17.getSizeInventory()), var19);
                                            }
                                        }
                                    }

                                    break label212;
                                }
                            }

                            ++var12;
                            continue;
                        }
                    }

                    ++var11;
                    break;
                }
            }

            var1.setBlockWithNotify(var3, var4, var5, Block.mobSpawner.blockID);
            TileEntityMobSpawner var20 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4, var5);

            if (var20 != null)
            {
                var20.setMobID(this.pickMobSpawner(var2));
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + var3 + ", " + var4 + ", " + var5 + ")");
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    private ItemStack pickCheckLootItem(Random var1)
    {
        int var2 = var1.nextInt(11);
        return var2 == 0 ? new ItemStack(Item.saddle) : (var2 == 1 && var1.nextInt(5) == 0 ? new ItemStack(Item.expBottle, var1.nextInt(4) + 1) : (var2 == 2 && var1.nextInt(4) == 0 ? new ItemStack(Item.itemsList[Item.record13.shiftedIndex + var1.nextInt(10)]) : (var2 == 3 ? new ItemStack(Item.appleGold, var1.nextInt(3) + 1) : (var2 == 4 ? new ItemStack(Item.gunpowder, var1.nextInt(8) + 1) : (var2 == 5 ? new ItemStack(Item.helmetChain) : (var2 == 6 ? new ItemStack(Item.plateChain) : (var2 == 7 ? new ItemStack(Item.legsChain) : (var2 == 8 ? new ItemStack(Item.bootsChain) : (var2 == 9 ? new ItemStack(Item.appleRed, var1.nextInt(5) + 1) : (var2 == 10 ? new ItemStack(Item.dyePowder, var1.nextInt(6) + 1, 3) : null))))))))));
    }

    private String pickMobSpawner(Random var1)
    {
        int var2 = var1.nextInt(6);
        return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : (var2 == 4 ? "CaveSpider" : (var2 == 5 ? "Creeper" : "")))));
    }
}
