package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.src.generators.*;

public class StructureVillagePieces
{
    public static ArrayList getStructureVillageWeightedPieceList(Random par0Random, int par1)
    {
        ArrayList var2 = new ArrayList();
        var2.add(new StructureVillagePieceWeight(EBGVillageFarm1.class, 6, 1));
        var2.add(new StructureVillagePieceWeight(EBGVillageFarm2.class, 9, MathHelper.getRandomIntegerInRange(par0Random, 0, 1)));
        var2.add(new StructureVillagePieceWeight(EBGVillageFarm3.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2, 4)));
        var2.add(new StructureVillagePieceWeight(EBGVillageHouseB1.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 3, 5)));
        var2.add(new StructureVillagePieceWeight(EBGVillageBarn.class, 20, 1));
        var2.add(new StructureVillagePieceWeight(EBGVillageTower.class, 20, 1));
        var2.add(new StructureVillagePieceWeight(EBGVillageMine.class, 20, 1));
        Iterator var3 = var2.iterator();

        while (var3.hasNext())
        {
            if (((StructureVillagePieceWeight)var3.next()).villagePiecesLimit == 0)
            {
                var3.remove();
            }
        }

        return var2;
    }

    private static int func_75079_a(List par0List)
    {
        boolean var1 = false;
        int var2 = 0;
        StructureVillagePieceWeight var3;

        for (Iterator var4 = par0List.iterator(); var4.hasNext(); var2 += var3.villagePieceWeight)
        {
            var3 = (StructureVillagePieceWeight)var4.next();

            if (var3.villagePiecesLimit > 0 && var3.villagePiecesSpawned < var3.villagePiecesLimit)
            {
                var1 = true;
            }
        }

        return var1 ? var2 : -1;
    }

    private static ComponentVillage func_75083_a(ComponentVillageStartPiece par0ComponentVillageStartPiece, StructureVillagePieceWeight par1StructureVillagePieceWeight, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8)
    {
        Class var9 = par1StructureVillagePieceWeight.villagePieceClass;
        Object var10 = null;

        if (var9 == EBGVillageFarm1.class)
        {
            var10 = EBGVillageFarm1.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageFarm2.class)
        {
            var10 = EBGVillageFarm2.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageFarm3.class)
        {
            var10 = EBGVillageFarm3.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageHouseB1.class)
        {
            var10 = EBGVillageHouseB1.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageBarn.class)
        {
            var10 = EBGVillageBarn.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageTower.class)
        {
            var10 = EBGVillageTower.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageMine.class)
        {
            var10 = EBGVillageMine.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (var9 == EBGVillageChurch.class)
        {
            var10 = EBGVillageChurch.findValidPlacement(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }

        return (ComponentVillage)var10;
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static ComponentVillage getNextVillageComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        int var8 = func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

        if (var8 <= 0)
        {
            return null;
        }
        else
        {
            int var9 = 0;

            while (var9 < 5)
            {
                ++var9;
                int var10 = par2Random.nextInt(var8);
                Iterator var11 = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

                while (var11.hasNext())
                {
                    StructureVillagePieceWeight var12 = (StructureVillagePieceWeight)var11.next();
                    var10 -= var12.villagePieceWeight;

                    if (var10 < 0)
                    {
                        if (!var12.canSpawnMoreVillagePiecesOfType(par7) || var12 == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        ComponentVillage var13 = func_75083_a(par0ComponentVillageStartPiece, var12, par1List, par2Random, par3, par4, par5, par6, par7);

                        if (var13 != null)
                        {
                            ++var12.villagePiecesSpawned;
                            par0ComponentVillageStartPiece.structVillagePieceWeight = var12;

                            if (!var12.canSpawnMoreVillagePieces())
                            {
                                par0ComponentVillageStartPiece.structureVillageWeightedPieceList.remove(var12);
                            }

                            return var13;
                        }
                    }
                }
            }

            StructureBoundingBox var14 = ComponentVillageTorch.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (var14 != null)
            {
                return new ComponentVillageTorch(par0ComponentVillageStartPiece, par7, par2Random, var14, par6);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static StructureComponent getNextVillageStructureComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 50)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            ComponentVillage var8 = getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

            if (var8 != null)
            {
                int var9 = (var8.boundingBox.minX + var8.boundingBox.maxX) / 2;
                int var10 = (var8.boundingBox.minZ + var8.boundingBox.maxZ) / 2;
                int var11 = var8.boundingBox.maxX - var8.boundingBox.minX;
                int var12 = var8.boundingBox.maxZ - var8.boundingBox.minZ;
                int var13 = var11 > var12 ? var11 : var12;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(var9, var10, var13 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    par1List.add(var8);
                    par0ComponentVillageStartPiece.field_74932_i.add(var8);
                    return var8;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    private static StructureComponent getNextComponentVillagePath(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 3 + par0ComponentVillageStartPiece.terrainType)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox var8 = ComponentVillagePathGen.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (var8 != null && var8.minY > 10)
            {
                ComponentVillagePathGen var9 = new ComponentVillagePathGen(par0ComponentVillageStartPiece, par7, par2Random, var8, par6);
                int var10 = (var9.boundingBox.minX + var9.boundingBox.maxX) / 2;
                int var11 = (var9.boundingBox.minZ + var9.boundingBox.maxZ) / 2;
                int var12 = var9.boundingBox.maxX - var9.boundingBox.minX;
                int var13 = var9.boundingBox.maxZ - var9.boundingBox.minZ;
                int var14 = var12 > var13 ? var12 : var13;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(var10, var11, var14 / 2 + 4, MapGenVillage.villageSpawnBiomes))
                {
                    par1List.add(var9);
                    par0ComponentVillageStartPiece.field_74930_j.add(var9);
                    return var9;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned
     */
    static StructureComponent getNextStructureComponent(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextVillageStructureComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static StructureComponent getNextStructureComponentVillagePath(ComponentVillageStartPiece par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}
