package com.github.sunmilksong.blocks;

import com.github.sunmilksong.Main;
import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.IHasModel;
import com.github.sunmilksong.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

import net.minecraft.block.state.IBlockState;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

import net.minecraft.world.World;

import javax.annotation.Nonnull;

import java.util.Objects;

import java.util.Random;

public class BlockOre extends Block implements IHasModel {

    public BlockOre(String name, Material material) {

        super(Material.ROCK, MapColor.STONE);

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        setSoundType(SoundType.STONE);//声音
        setHardness(2.5F);//硬度
        setHarvestLevel("pickaxe", 2);//工具和挖掘等级


        ModBlocks.BLOCKS.add(this);
    }

    //挖掘掉落
    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.SOUL;
    }

    //物品掉落数量
    @Override
    public int quantityDropped(Random random) {
        return 3;
    }

    //鼠标中键选取
    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this);
    }

    //注册
    @Override
    public void registerModels() {

        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
