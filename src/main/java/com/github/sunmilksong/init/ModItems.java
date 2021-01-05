package com.github.sunmilksong.init;

import com.github.sunmilksong.items.ItemSd;
import com.github.sunmilksong.items.ItemSk;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final Item SOUL = new ItemSk("soul");

    public static final Item SOUL_SEED = new ItemSd("soul_seed", ModBlocks.SOUL_CROP, Blocks.DIAMOND_BLOCK);

}
