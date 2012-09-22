package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGVillageTower extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public EBGVillageTower(ComponentVillageStartPiece var1, int var2, Random var3, StructureBoundingBox var4, int var5)
    {
        super(var1, var2);
        this.coordBaseMode = var5;
        this.boundingBox = var4;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent var1, List var2, Random var3) {}

    public static EBGVillageTower findValidPlacement(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(var3, var4, var5, 0, 0, 0, 4, 10, 4, var6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(var1, var8) == null ? new EBGVillageTower(var0, var7, var2, var8, var6) : null;
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

        this.fillWithBlocks(var1, var3, 0, 0, 0, 2, 10, 2, 0, 0, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 2, 0, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 0, 1, 1, 0, 1, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 2, 19, 2, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 0, 19, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 2, 1, 0, 2, 19, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 2, 0, 19, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 2, 1, 2, 2, 19, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 3, 0, 2, 3, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 8, 0, 2, 8, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 13, 0, 2, 13, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 18, 0, 2, 18, 2, Block.wood.blockID, Block.wood.blockID, false);
        this.placeDoorAtCurrentPosition(var1, var3, var2, 1, 1, 0, this.getMetadataWithOffset(Block.doorWood.blockID, 1));
        this.fillWithBlocks(var1, var3, -1, 19, -1, 3, 20, 3, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 20, 0, 2, 20, 2, 0, 0, false);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, -1, 21, -1, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 3, 21, -1, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, -1, 21, 3, var3);
        this.placeBlockAtCurrentPosition(var1, Block.torchWood.blockID, 0, 3, 21, 3, var3);
        int var4;

        for (var4 = 1; var4 <= 19; ++var4)
        {
            this.placeBlockAtCurrentPosition(var1, Block.ladder.blockID, this.getMetadataWithOffset(Block.ladder.blockID, 4), 1, var4, 1, var3);
        }

        for (var4 = 0; var4 < 3; ++var4)
        {
            for (int var5 = 0; var5 < 3; ++var5)
            {
                this.fillCurrentPositionBlocksDownwards(var1, Block.planks.blockID, 0, var5, -1, var4, var3);
            }
        }

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
