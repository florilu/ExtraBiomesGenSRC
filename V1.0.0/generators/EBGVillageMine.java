package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGVillageMine extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public EBGVillageMine(ComponentVillageStartPiece var1, int var2, Random var3, StructureBoundingBox var4, int var5)
    {
        super(var1, var2);
        this.coordBaseMode = var5;
        this.boundingBox = var4;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent var1, List var2, Random var3) {}

    public static EBGVillageMine findValidPlacement(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(var3, var4, var5, 0, 0, 0, 14, 6, 9, var6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(var1, var8) == null ? new EBGVillageMine(var0, var7, var2, var8, var6) : null;
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

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 6 - 1, 0);
        }

        this.fillWithBlocks(var1, var3, 1, 0, 0, 11, 5, 6, 0, 0, false);
        this.fillWithBlocks(var1, var3, 1, 0, 0, 11, 0, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 0, 1, 1, 6, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 1, 0, 5, 1, 6, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 11, 1, 0, 11, 1, 6, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 1, 0, 11, 1, 0, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 6, 11, 1, 6, Block.fence.blockID, Block.fence.blockID, false);
        this.placeBlockAtCurrentPosition(var1, 0, 0, 5, 1, 3, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 1, 2, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 1, 2, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 5, 2, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 5, 2, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 1, 3, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 1, 3, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 5, 3, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.fence.blockID, 0, 5, 3, 6, var3);
        this.fillWithBlocks(var1, var3, 1, 4, 0, 5, 4, 6, Block.planks.blockID, Block.planks.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.stoneOvenIdle.blockID, this.getMetadataWithOffset(Block.ladder.blockID, 3), 2, 1, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.stoneOvenIdle.blockID, this.getMetadataWithOffset(Block.ladder.blockID, 3), 2, 1, 3, var3);
        this.placeBlockAtCurrentPosition(var1, Block.stoneOvenIdle.blockID, this.getMetadataWithOffset(Block.ladder.blockID, 3), 2, 1, 4, var3);
        int var4;

        for (var4 = 0; var4 < 7; ++var4)
        {
            for (int var5 = 0; var5 < 12; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(var1, var5, 9, var4, var3);
                this.fillCurrentPositionBlocksDownwards(var1, Block.cobblestone.blockID, 0, var5, -1, var4, var3);
            }
        }

        this.fillWithBlocks(var1, var3, 6, -10, 1, 10, 1, 5, 0, 0, false);

        for (var4 = -10; var4 <= 0; ++var4)
        {
            this.placeBlockAtCurrentPosition(var1, Block.ladder.blockID, this.getMetadataWithOffset(Block.ladder.blockID, 5), 6, var4, 3, var3);
        }

        this.spawnVillagers(var1, var3, 2, 1, 2, 1);
        return true;
    }

    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int var1)
    {
        return 3;
    }
}
