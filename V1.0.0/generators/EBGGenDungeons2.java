package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGGenDungeons2 extends WorldGenerator
{
    public int dungeonType;

    public EBGGenDungeons2(int var1)
    {
        this.dungeonType = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        byte var6 = 3;
        int var7 = var2.nextInt(2) + 2;
        int var8 = var2.nextInt(2) + 2;
        boolean var9 = false;
        int var12;

        for (int var10 = var3 - var7 - 1; var10 <= var3 + var7 + 1; ++var10)
        {
            for (int var11 = var4 + var6; var11 >= var4 - 1; --var11)
            {
                for (var12 = var5 - var8 - 1; var12 <= var5 + var8 + 1; ++var12)
                {
                    if (var10 != var3 - var7 - 1 && var11 != var4 - 1 && var12 != var5 - var8 - 1 && var10 != var3 + var7 + 1 && var11 != var4 + var6 + 1 && var12 != var5 + var8 + 1)
                    {
                        var1.setBlockWithNotify(var10, var11, var12, 0);
                    }
                    else if (this.dungeonType == 4)
                    {
                        if (var2.nextInt(2) == 0)
                        {
                            var1.setBlockAndMetadataWithNotify(var10, var11, var12, Block.silverfish.blockID, 1);
                        }
                        else
                        {
                            var1.setBlockWithNotify(var10, var11, var12, Block.cobblestoneMossy.blockID);
                        }
                    }
                    else if (var2.nextInt(4) != 0)
                    {
                        var1.setBlockWithNotify(var10, var11, var12, Block.cobblestoneMossy.blockID);
                    }
                    else
                    {
                        var1.setBlockWithNotify(var10, var11, var12, Block.cobblestone.blockID);
                    }
                }
            }
        }

        var1.setBlockWithNotify(var3, var4 + 1, var5, Block.chest.blockID);
        TileEntityChest var14 = (TileEntityChest)var1.getBlockTileEntity(var3, var4 + 1, var5);
        byte var15 = 20;

        for (var12 = 0; var12 < var15; ++var12)
        {
            ItemStack var13 = this.getChestList(var12, var2, var1);

            if (var14 != null && var13 != null)
            {
                var14.setInventorySlotContents(var12, var13);
            }
        }

        for (var12 = 0; var12 < 2; ++var12)
        {
            if (var12 == 1)
            {
                var12 = 2;
            }

            var1.setBlockWithNotify(var3, var4 + var12, var5, Block.mobSpawner.blockID);
            TileEntityMobSpawner var16 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4 + var12, var5);

            if (var16 != null)
            {
                var16.setMobID(this.pickMobSpawner(var2));
            }
            else
            {
                System.err.println("Failed to fetch mob spawner entity at (" + var3 + ", " + var4 + ", " + var5 + ")");
            }
        }

        return true;
    }

    private String pickMobSpawner(Random var1)
    {
        return this.dungeonType == 1 ? "Skeleton" : (this.dungeonType == 2 ? "CaveSpider" : (this.dungeonType == 3 ? "Zombie" : (this.dungeonType == 4 ? "Silverfish" : (this.dungeonType == 5 ? "Skeleton" : (this.dungeonType == 6 ? "Zombie" : (this.dungeonType == 7 ? "CaveSpider" : "Zombie"))))));
    }

    private ItemStack getChestList(int var1, Random var2, World var3)
    {
        return this.dungeonType == 1 ? (var1 == 0 ? new ItemStack(Item.appleRed, 4) : (var1 == 1 ? new ItemStack(Block.planks, 6) : (var1 == 2 ? new ItemStack(Item.seeds, 6) : null))) : (this.dungeonType == 2 ? (var1 == 0 ? new ItemStack(Item.monsterPlacer, 2, 93) : (var1 == 1 ? new ItemStack(Block.cactus) : (var1 == 2 ? new ItemStack(Item.reed) : (var1 == 3 ? new ItemStack(Block.mushroomBrown, 2) : (var1 == 4 ? new ItemStack(Block.mushroomRed, 2) : (var1 == 5 ? new ItemStack(Item.seeds, 6) : null)))))) : (this.dungeonType == 3 ? (var1 == 0 ? new ItemStack(Item.monsterPlacer, 2, 90) : (var1 == 1 ? new ItemStack(Item.monsterPlacer, 2, 92) : (var1 == 2 ? new ItemStack(Block.sapling, 1, 1) : (var1 == 3 ? new ItemStack(Block.sapling, 1, 2) : (var1 == 4 ? new ItemStack(Item.melonSeeds) : (var1 == 5 ? new ItemStack(Block.vine) : (var1 == 6 ? new ItemStack(Block.plantYellow, 5) : (var1 == 7 ? new ItemStack(Block.plantRed, 5) : (var1 == 8 ? new ItemStack(Block.waterlily, 10) : null))))))))) : (this.dungeonType == 4 ? (var1 == 0 ? new ItemStack(Item.monsterPlacer, 2, 120) : (var1 == 1 ? new ItemStack(Item.monsterPlacer, 2, 95) : (var1 == 2 ? new ItemStack(Item.monsterPlacer, 2, 98) : (var1 == 3 ? new ItemStack(Block.sapling, 1, 3) : (var1 == 4 ? new ItemStack(Item.dyePowder, 1, 3) : (var1 == 5 ? new ItemStack(Block.blockSnow, 2) : (var1 == 6 ? new ItemStack(Item.pumpkinSeeds) : (var1 == 7 ? new ItemStack(Block.mycelium) : (var1 == 8 ? new ItemStack(Item.enderPearl, 6) : null))))))))) : (this.dungeonType == 5 ? (var1 == 0 ? new ItemStack(Item.monsterPlacer, 2, 93) : (var1 == 1 ? new ItemStack(Block.cactus) : (var1 == 2 ? new ItemStack(Item.reed) : (var1 == 3 ? new ItemStack(Block.mushroomBrown, 2) : (var1 == 4 ? new ItemStack(Block.mushroomRed, 2) : (var1 == 5 ? new ItemStack(Block.sand, 64) : null)))))) : (this.dungeonType == 6 ? (var1 == 0 ? new ItemStack(Item.monsterPlacer, 2, 90) : (var1 == 1 ? new ItemStack(Item.monsterPlacer, 2, 92) : (var1 == 2 ? new ItemStack(Block.sapling, 1, 1) : (var1 == 3 ? new ItemStack(Block.sapling, 1, 2) : (var1 == 4 ? new ItemStack(Item.melonSeeds) : (var1 == 5 ? new ItemStack(Block.vine) : (var1 == 6 ? new ItemStack(Block.sand, 64) : (var1 == 7 ? new ItemStack(Block.waterlily, 10) : null)))))))) : (this.dungeonType == 7 ? (var1 == 0 ? new ItemStack(Item.monsterPlacer, 2, 120) : (var1 == 1 ? new ItemStack(Item.monsterPlacer, 2, 95) : (var1 == 2 ? new ItemStack(Item.monsterPlacer, 2, 98) : (var1 == 3 ? new ItemStack(Block.sapling, 1, 3) : (var1 == 4 ? new ItemStack(Item.dyePowder, 1, 3) : (var1 == 5 ? new ItemStack(Block.blockSnow, 2) : (var1 == 6 ? new ItemStack(Item.pumpkinSeeds) : (var1 == 7 ? new ItemStack(Block.mycelium) : (var1 == 8 ? new ItemStack(Block.sand, 64) : null))))))))) : null))))));
    }
}
