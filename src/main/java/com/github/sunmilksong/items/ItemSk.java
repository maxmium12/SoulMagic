package com.github.sunmilksong.items;

import com.github.sunmilksong.Main;
import com.github.sunmilksong.init.ModItems;
import com.github.sunmilksong.util.IHasModel;
import com.github.sunmilksong.util.Reference;

import net.minecraft.creativetab.CreativeTabs;

import net.minecraft.item.Item;

public class ItemSk extends Item implements IHasModel {

    public ItemSk(String name) {
        super();

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.MATERIALS);

        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
