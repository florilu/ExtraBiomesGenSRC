package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGGenCaveMushroom extends WorldGenerator
{
    private int mushroomType = -1;

    public EBGGenCaveMushroom(int var1)
    {
        super(true);
        this.mushroomType = var1;
    }

    public EBGGenCaveMushroom()
    {
        super(false);
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6 = var2.nextInt(2);

        if (this.mushroomType >= 0)
        {
            var6 = this.mushroomType;
        }

        int var7 = var2.nextInt(3) + 4;
        int var8 = var1.getBlockId(var3, var4 - 1, var5);

        if (var8 != Block.dirt.blockID && var8 != Block.grass.blockID && var8 != Block.mycelium.blockID)
        {
            return false;
        }
        else
        {
            int var9;
            int var10;

            for (var9 = 0; var9 <= 6; ++var9)
            {
                var10 = var1.getBlockId(var3, var4 + var9, var5);

                if (var10 != 0)
                {
                    return false;
                }
            }

            var9 = var4 + var7;

            if (var6 == 1)
            {
                var9 = var4 + var7 - 3;
            }

            int var11;

            for (var10 = var9; var10 <= var4 + var7; ++var10)
            {
                var11 = 1;

                if (var10 < var4 + var7)
                {
                    ++var11;
                }

                if (var6 == 0)
                {
                    var11 = 3;
                }

                for (int var12 = var3 - var11; var12 <= var3 + var11; ++var12)
                {
                    for (int var13 = var5 - var11; var13 <= var5 + var11; ++var13)
                    {
                        int var14 = 5;

                        if (var12 == var3 - var11)
                        {
                            --var14;
                        }

                        if (var12 == var3 + var11)
                        {
                            ++var14;
                        }

                        if (var13 == var5 - var11)
                        {
                            var14 -= 3;
                        }

                        if (var13 == var5 + var11)
                        {
                            var14 += 3;
                        }

                        if (var6 == 0 || var10 < var4 + var7)
                        {
                            if ((var12 == var3 - var11 || var12 == var3 + var11) && (var13 == var5 - var11 || var13 == var5 + var11))
                            {
                                continue;
                            }

                            if (var12 == var3 - (var11 - 1) && var13 == var5 - var11)
                            {
                                var14 = 1;
                            }

                            if (var12 == var3 - var11 && var13 == var5 - (var11 - 1))
                            {
                                var14 = 1;
                            }

                            if (var12 == var3 + (var11 - 1) && var13 == var5 - var11)
                            {
                                var14 = 3;
                            }

                            if (var12 == var3 + var11 && var13 == var5 - (var11 - 1))
                            {
                                var14 = 3;
                            }

                            if (var12 == var3 - (var11 - 1) && var13 == var5 + var11)
                            {
                                var14 = 7;
                            }

                            if (var12 == var3 - var11 && var13 == var5 + (var11 - 1))
                            {
                                var14 = 7;
                            }

                            if (var12 == var3 + (var11 - 1) && var13 == var5 + var11)
                            {
                                var14 = 9;
                            }

                            if (var12 == var3 + var11 && var13 == var5 + (var11 - 1))
                            {
                                var14 = 9;
                            }
                        }

                        if (var14 == 5 && var10 < var4 + var7)
                        {
                            var14 = 0;
                        }

                        if ((var14 != 0 || var4 >= var4 + var7 - 1) && !Block.opaqueCubeLookup[var1.getBlockId(var12, var10, var13)])
                        {
                            this.setBlockAndMetadata(var1, var12, var10, var13, Block.mushroomCapBrown.blockID + var6, var14);
                        }
                    }
                }
            }

            for (var10 = 0; var10 < var7; ++var10)
            {
                var11 = var1.getBlockId(var3, var4 + var10, var5);

                if (!Block.opaqueCubeLookup[var11])
                {
                    this.setBlockAndMetadata(var1, var3, var4 + var10, var5, Block.mushroomCapBrown.blockID + var6, 10);
                }
            }

            return true;
        }
    }
}
