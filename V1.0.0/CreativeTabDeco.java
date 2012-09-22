package net.minecraft.src;

import net.minecraft.src.blocks.*;

final class CreativeTabDeco extends CreativeTabs
{
	public CreativeTabDeco(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex()
    {
        return Block.plantRed.blockID;
    }
}
