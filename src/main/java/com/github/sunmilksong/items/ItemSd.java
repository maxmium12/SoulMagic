package com.github.sunmilksong.items;

import com.github.sunmilksong.Main;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.IHasModel;
import com.github.sunmilksong.util.Reference;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSd extends ItemSeeds implements IHasModel {


    private final Block Iplants;
    private final Block blockTypeBlockID;

    public ItemSd(String name, Block plants, Block plantingBlock) {
        super(plants, plantingBlock);
        this.Iplants = plants;
        this.blockTypeBlockID = plantingBlock;

        this.setUnlocalizedName(Reference.MOD_ID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);

    }


    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        Block plantingBlock = worldIn.getBlockState(pos).getBlock();
        System.out.println(Iplants);
        if (Iplants.getRegistryName().toString().equalsIgnoreCase("soulmagic:soul_crop") && plantingBlock == Blocks.DIAMOND_BLOCK) {
            ItemStack itemstack = player.getHeldItem(hand);

            if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, itemstack) && worldIn.isAirBlock(pos.up())) {
                worldIn.setBlockState(pos.up(), this.Iplants.getDefaultState());


                if (player instanceof EntityPlayerMP) {
                    CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos.up(), itemstack);
                }
                itemstack.shrink(1);
                return EnumActionResult.SUCCESS;

            } else {
                return EnumActionResult.FAIL;
            }
        }

        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return this.Iplants.getDefaultState();
    }

    //注册
    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");

    }
}