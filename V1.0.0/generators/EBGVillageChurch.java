package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGVillageChurch extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public EBGVillageChurch(ComponentVillageStartPiece var1, int var2, Random var3, StructureBoundingBox var4, int var5)
    {
        super(var1, var2);
        this.coordBaseMode = var5;
        this.boundingBox = var4;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent var1, List var2, Random var3) {}

    public static EBGVillageChurch findValidPlacement(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(var3, var4, var5, 0, 0, 0, 4, 9, 10, var6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(var1, var8) == null ? new EBGVillageChurch(var0, var7, var2, var8, var6) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World var1, Random var2, StructureBoundingBox var3)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(var1, var3);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 9 - 1, 0);
        }

        this.fillWithBlocks(var1, var3, 0, 0, 0, 4, 9, 10, 0, 0, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 4, 5, 10, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 5, 0, 4, 8, 4, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 1, 3, 3, 9, 0, 0, false);
        this.fillWithBlocks(var1, var3, 1, 5, 1, 3, 7, 3, 0, 0, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 4, 0, 10, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 0, 1, 3, 0, 9, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 0, 7, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 0, 4, 7, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 4, 0, 7, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 4, 4, 7, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 10, 0, 4, 10, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 10, 4, 4, 10, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 0, 4, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 4, 4, 4, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 10, 4, 4, 10, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 0, 0, 4, 10, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 4, 0, 4, 4, 10, Block.wood.blockID, Block.wood.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 2, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 3, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 2, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 3, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 2, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 3, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 2, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 3, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 3, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 3, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 6, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 4, 6, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 1, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 5, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 7, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 8, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 1, 7, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 3, 7, 0, var3);

        for (int var4 = 0; var4 < 5; ++var4)
        {
            for (int var5 = 0; var5 < 11; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(var1, var5, 9, var4, var3);
                this.fillCurrentPositionBlocksDownwards(var1, Block.cobblestone.blockID, 0, var5, -1, var4, var3);
            }
        }

        this.spawnVillagers(var1, var3, 2, 1, 2, 1);
        return true;
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int var1)
    {
        return 2;
    }
}
