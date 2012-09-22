package net.minecraft.src.generators;

import java.util.List;
import java.util.Random;
import net.minecraft.src.*;

public class EBGVillageFarm2 extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public EBGVillageFarm2(ComponentVillageStartPiece var1, int var2, Random var3, StructureBoundingBox var4, int var5)
    {
        super(var1, var2);
        this.coordBaseMode = var5;
        this.boundingBox = var4;
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent var1, List var2, Random var3) {}

    public static EBGVillageFarm2 findValidPlacement(ComponentVillageStartPiece var0, List var1, Random var2, int var3, int var4, int var5, int var6, int var7)
    {
        StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
        return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(var1, var8) == null ? new EBGVillageFarm2(var0, var7, var2, var8, var6) : null;
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

            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 4 - 1, 0);
        }

        this.fillWithBlocks(var1, var3, 0, 0, 0, 12, 3, 8, 0, 0, false);
        this.fillWithBlocks(var1, var3, 1, 0, 1, 2, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 0, 1, 5, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(var1, var3, 7, 0, 1, 8, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(var1, var3, 10, 0, 1, 11, 0, 7, Block.tilledField.blockID, Block.tilledField.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 1, 0, 8, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 3, 0, 0, 3, 0, 8, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 0, 0, 7, 0, 8, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 9, 0, 0, 9, 0, 8, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 11, 0, 0, 12, 0, 8, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 12, 0, 0, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 0, 8, 12, 0, 8, Block.dirt.blockID, Block.dirt.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 0, 0, 0, 0, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 6, 0, 0, 6, 0, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 12, 0, 0, 12, 0, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 0, 0, 11, 0, 0, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 0, 8, 11, 0, 8, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(var1, var3, 0, 1, 0, 0, 1, 8, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 6, 1, 0, 6, 1, 8, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 12, 1, 0, 12, 1, 8, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 0, 11, 1, 0, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 8, 11, 1, 8, Block.fence.blockID, Block.fence.blockID, false);
        this.fillWithBlocks(var1, var3, 2, 0, 1, 2, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        this.fillWithBlocks(var1, var3, 4, 0, 1, 4, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        this.fillWithBlocks(var1, var3, 8, 0, 1, 8, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        this.fillWithBlocks(var1, var3, 10, 0, 1, 10, 0, 7, Block.waterMoving.blockID, Block.waterMoving.blockID, false);
        this.fillWithBlocks(var1, var3, 1, 1, 1, 1, 1, 7, Block.reed.blockID, Block.reed.blockID, false);
        this.fillWithBlocks(var1, var3, 3, 1, 1, 3, 1, 7, Block.reed.blockID, Block.reed.blockID, false);
        this.fillWithBlocks(var1, var3, 5, 1, 1, 5, 1, 7, Block.reed.blockID, Block.reed.blockID, false);
        this.fillWithBlocks(var1, var3, 7, 1, 1, 7, 1, 7, Block.reed.blockID, Block.reed.blockID, false);
        this.fillWithBlocks(var1, var3, 9, 1, 1, 9, 1, 7, Block.reed.blockID, Block.reed.blockID, false);
        this.fillWithBlocks(var1, var3, 11, 1, 1, 11, 1, 7, Block.reed.blockID, Block.reed.blockID, false);

        for (int var4 = 0; var4 < 9; ++var4)
        {
            for (int var5 = 0; var5 < 13; ++var5)
            {
                this.clearCurrentPositionBlocksUpwards(var1, var5, 4, var4, var3);
                this.fillCurrentPositionBlocksDownwards(var1, Block.cobblestone.blockID, 0, var5, -1, var4, var3);
            }
        }

        return true;
    }
}
