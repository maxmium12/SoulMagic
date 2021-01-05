package com.github.sunmilksong.init;

import com.github.sunmilksong.blocks.BlockCrop;
import com.github.sunmilksong.blocks.BlockSk;

import com.github.sunmilksong.blocks.BlockOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();


    //普通
    public static final Block SOLID_STATE_SOUL = new BlockSk("solid_state_soul", Material.IRON);



    //矿石
    public static final Block SOUL_ORE = new BlockOre("soul_ore",Material.ROCK);

    //作物
    public static final Block SOUL_CROP = new BlockCrop("soul_crop");
}