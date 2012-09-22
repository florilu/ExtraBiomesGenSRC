package net.minecraft.src.generators;

import java.util.Random;
import net.minecraft.src.*;

public class EBGBiomeSisland extends BiomeGenBase
{
    public EBGBiomeSisland(int var1)
    {
        super(var1);
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 40, 2, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 32, 2, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 36, 2, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 42, 2, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 32, 2, 5));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 2, 1, 5));
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        super.decorate(var1, var2, var3, var4);
        int var5 = 3 + var2.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int var7 = var3 + var2.nextInt(16);
            int var8 = var2.nextInt(28) + 4;
            int var9 = var4 + var2.nextInt(16);
            int var10 = var1.getBlockId(var7, var8, var9);

            if (var10 == Block.stone.blockID)
            {
                var1.setBlock(var7, var8, var9, Block.oreEmerald.blockID);
            }
        }
    }
}
