package com.github.sunmilksong.util.handlers;

import com.github.sunmilksong.api.NoItemBlock;
import com.github.sunmilksong.init.ModBlocks;
import com.github.sunmilksong.init.ModItems;

import com.github.sunmilksong.util.IHasModel;

import net.minecraft.block.Block;

import net.minecraft.item.Item;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraftforge.event.RegistryEvent;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.stream.Collectors;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
        event.getRegistry().registerAll(ModBlocks.BLOCKS.stream()
                .filter(block -> !block.getClass().isAnnotationPresent(NoItemBlock.class))
                .map(block -> new ItemBlock(block).setRegistryName(block.getRegistryName()))
                .toArray(Item[]::new));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }


    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent Event) {

        for (Item item : ModItems.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();


            }
        }
    }
}