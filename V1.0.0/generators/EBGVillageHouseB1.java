package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGVillageHouseB1 extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public EBGVillageHouseB1(ComponentVillageStartPiece var1, int var2, Random var3, StructureBoundingBox var4, int var5)
    {
        super(var1, var2);
        this.coordBaseMode = var5;
        this.boundingBox = var4;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent var1, List var2, Random var3) {}

    public static EBGVillageHouseB1 findValidPlacement(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(var3, var4, var5, 0, 0, 0, 9, 9, 9, var6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(var1, var8) == null ? new EBGVillageHouseB1(var0, var7, var2, var8, var6) : null;
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

        this.fillWithBlocks(var1, var3, 0, 0, 0, 8, 8, 8, 0, 0, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 8, 0, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 0, 1, 7, 0, 7, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 0, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 0, 4, 8, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 0, 8, 3, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 0, 1, 3, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 3, 1, 0, 3, 3, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 5, 0, 3, 5, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 1, 0, 7, 1, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 3, 0, 7, 3, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 5, 0, 7, 5, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 2, 3, 0, var3);
        this.placeDoorAtCurrentPosition(var1, var3, var2, 2, 1, 0, this.getMetadataWithOffset(Block.doorWood.blockID, 1));
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 5, 2, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 6, 2, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 7, 2, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 3, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 3, 7, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 5, 7, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 5, 6, 0, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 6, 6, 0, var3);
        this.fillWithBlocks(var1, var3, 0, 1, 8, 0, 3, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 1, 8, 4, 8, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 8, 8, 3, 8, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 8, 3, 1, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 3, 8, 3, 3, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 5, 8, 3, 5, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 1, 8, 7, 1, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 3, 8, 7, 3, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 5, 8, 7, 5, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 1, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 2, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 3, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 5, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 6, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 7, 2, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 2, 6, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 3, 6, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 3, 7, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.cobblestone.blockID, 0, 5, 7, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 5, 6, 8, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 6, 6, 8, var3);
        this.fillWithBlocks(var1, var3, 0, 1, 4, 0, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 4, 8, 3, 4, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 1, 0, 1, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 3, 1, 0, 3, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 5, 0, 1, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 3, 5, 0, 3, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 0, 2, 1, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 2, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 0, 2, 3, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 0, 2, 5, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 0, 2, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 0, 2, 7, var3);
        this.fillWithBlocks(var1, var3, 8, 1, 1, 8, 1, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 3, 1, 8, 3, 3, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 1, 5, 8, 1, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 3, 5, 8, 3, 7, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 8, 2, 1, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 8, 2, 2, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 8, 2, 3, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 8, 2, 5, var3);
        this.placeBlockAtCurrentPosition(var1, Block.thinGlass.blockID, 0, 8, 2, 6, var3);
        this.placeBlockAtCurrentPosition(var1, Block.planks.blockID, 0, 8, 2, 7, var3);
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
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 4, 2, 1, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 1, 2, 4, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 7, 2, 4, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 4, 2, 7, var3);

        if (this.getBlockIdAtCurrentPosition(var1, 2, 0, -1, var3) == 0 && this.getBlockIdAtCurrentPosition(var1, 2, -1, -1, var3) != 0)
        {
            this.placeBlockAtCurrentPosition(var1, Block.stairCompactCobblestone.blockID, this.getMetadataWithOffset(Block.stairCompactCobblestone.blockID, 3), 2, 0, -1, var3);
        }

        for (var6 = 0; var6 < 9; ++var6)
        {
            for (var7 = 0; var7 < 9; ++var7)
            {
                this.clearCurrentPositionBlocksUpwards(var1, var7, 9, var6, var3);
                this.fillCurrentPositionBlocksDownwards(var1, Block.cobblestone.blockID, 0, var7, -1, var6, var3);
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
