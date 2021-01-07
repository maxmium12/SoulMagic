package com.github.sunmilksong.blocks;


import com.github.sunmilksong.Main;

import com.github.sunmilksong.api.NoItemBlock;
import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;

import com.github.sunmilksong.util.IHasModel;
import com.github.sunmilksong.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

import net.minecraft.item.Item;

import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;

import javax.annotation.Nonnull;

@NoItemBlock
public class BlockCrop extends BlockCrops implements IHasModel, IGrowable {

    public BlockCrop(String name) {

        super();

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);//未本地化名
        this.setRegistryName(name);//注册名
        this.setCreativeTab((CreativeTabs) null);
        this.setSoundType(SoundType.PLANT);//声音

        ModBlocks.BLOCKS.add(this);

    }


    private boolean isPlantingBlock(Block plantingBlock) {

        return plantingBlock == Blocks.DIAMOND_BLOCK;//返回方块
    }

    //创建种子
    @Nonnull
    @Override
    protected Item getSeed() {
        return ModItems.SOUL_SEED;
    }

    //创建作物掉落
    @Nonnull
    @Override
    protected Item getCrop() {
        return ModItems.SOUL;
    }

    //种植的方块
    @Override
    protected boolean canSustainBush(IBlockState state) {
        {
            return state.getBlock() == Blocks.DIAMOND_BLOCK;
        }
    }

    //判断是否可以将作物块放置在目标块上
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        Block plantingBlock = worldIn.getBlockState(pos.down()).getBlock();

        return isPlantingBlock(plantingBlock);//返回isPlantingBlock设定的目标块
    }


    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        IBlockState plantingBlock = worldIn.getBlockState(pos.down());
        if (state.getBlock().getRegistryName().toString().equals("soulmagic:soul_crop") && plantingBlock.getBlock() == Blocks.DIAMOND_BLOCK) {
            return true;
        }
        return super.canBlockStay(worldIn, pos, state);
    }

    //注册
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
