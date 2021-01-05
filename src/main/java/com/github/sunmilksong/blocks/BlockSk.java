package com.github.sunmilksong.blocks;

import com.github.sunmilksong.Main;

import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;

import com.github.sunmilksong.util.IHasModel;
import com.github.sunmilksong.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import net.minecraft.util.BlockRenderLayer;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


import java.util.Objects;

public class BlockSk extends Block implements IHasModel {

    public BlockSk(String name, Material material) {

        super(material);


        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);


        ModBlocks.BLOCKS.add(this);

        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(Objects.requireNonNull(this.getRegistryName())));


    }


    /**
     * {@link #isOpaqueCube(IBlockState)}是否为透视方块
     */
    @Override
    public boolean isOpaqueCube(IBlockState state) {

        return false;
    }


    /**
     * 材质中含有半透明或者透明材质
     * 需要覆写Block父类中的 {@link #getBlockLayer()}函数
     * 该函数只能在客户端上运行，需要在函数前加上{@link @SideOnly(Side.CLIENT)}的注解
     * 该函数的返回值是一种叫做BlockRenderLayer的Minecraft自带类型
     * <p>
     * {@link BlockRenderLayer.CUTOUT_MIPPED}
     * 为类似树叶这样材质仅覆盖方块的一部分的方块
     * {@link BlockRenderLayer.CUTOUT}
     * 为材质中有光线可以透过部分的方块
     * {@link BlockRenderLayer.TRANSLUCENT}
     * 为材质中有半透明部分(光线可以透过一部分)的方块
     */
    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {

        return BlockRenderLayer.CUTOUT_MIPPED;
    }


    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}


