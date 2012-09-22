package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGVillageBarn extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public EBGVillageBarn(ComponentVillageStartPiece var1, int var2, Random var3, StructureBoundingBox var4, int var5)
    {
        super(var1, var2);
        this.coordBaseMode = var5;
        this.boundingBox = var4;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent var1, List var2, Random var3) {}

    public static EBGVillageBarn findValidPlacement(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(var3, var4, var5, 0, 0, 0, 9, 9, 9, var6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(var1, var8) == null ? new EBGVillageBarn(var0, var7, var2, var8, var6) : null;
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

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 8 - 1, 0);
        }

        this.fillWithBlocks(var1, var3, 0, 0, 0, 8, 8, 8, 0, 0, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 8, 0, 8, Block.gravel.blockID, Block.gravel.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 0, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 0, 4, 8, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 0, 8, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 5, 0, 3, 5, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 5, 0, 7, 5, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 2, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 3, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 3, 7, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 5, 7, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 5, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 6, 6, 0, var3);
        this.fillWithBlocks(var1, var3, 0, 1, 8, 0, 3, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 8, 4, 8, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 8, 8, 3, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 5, 8, 3, 5, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 5, 8, 7, 5, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 2, 6, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 3, 6, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 3, 7, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 5, 7, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 5, 6, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 6, 6, 8, var3);
        this.fillWithBlocks(var1, var3, 0, 1, 4, 0, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 4, 8, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 0, 0, 4, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 0, 8, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 4, 8, 8, 4, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 4, 0, 8, 4, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 5, 1, 1, 5, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 2, 6, 1, 2, 6, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 3, 7, 1, 3, 7, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 8, 1, 4, 8, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 7, 1, 5, 7, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 6, 6, 1, 6, 6, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 7, 5, 1, 7, 5, 7, Block.planks.blockID, Block.planks.blockID, false);
        int var4 = this.getMetadataWithOffset(Block.stairCompactPlanks.blockID, 1);
        int var5 = this.getMetadataWithOffset(Block.stairCompactPlanks.blockID, 0);
        int var6;
        int var7;

        for (var6 = -1; var6 <= 9; ++var6)
        {
            for (var7 = -1; var7 <= 3; ++var7)
            {
                this.placeBlockAtCurrentPosition(var1, Block.stairCompactPlanks.blockID, var4, 8 - var7, 5 + var7, var6, var3);
                this.placeBlockAtCurrentPosition(var1, Block.stairCompactPlanks.blockID, var5, var7, 5 + var7, var6, var3);
            }
        }

        this.fillWithBlocks(var1, var3, 4, 8, -1, 4, 8, 9, Block.planks.blockID, Block.planks.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.workbench.blockID, 0, 4, 1, 4, var3);
        this.placeBlockAtCurrentPosition(var1, Block.stoneOvenIdle.blockID, this.getMetadataWithOffset(Block.stoneOvenIdle.blockID, 0), 4, 1, 3, var3);
        this.placeBlockAtCurrentPosition(var1, Block.stoneOvenIdle.blockID, this.getMetadataWithOffset(Block.stoneOvenIdle.blockID, 0), 4, 1, 5, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 4, 2, 1, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 1, 2, 4, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 7, 2, 4, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 4, 2, 7, var3);

        for (var6 = 0; var6 < 9; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.clearCurrentPositionBlocksUpwards(var1, var7, 9, var6, var3);
                this.fillCurrentPositionBlocksDownwards(var1, Block.gravel.blockID, 0, var7, -1, var6, var3);
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
        return 0;
    }
}
