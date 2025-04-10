package com.Dank3.CoffeeMod.item;

import com.Dank3.CoffeeMod.CoffeeMod;
import com.Dank3.CoffeeMod.block.ModBlocks;
import com.mojang.blaze3d.platform.Monitor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.lang.reflect.Parameter;
import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CoffeeMod.MOD_ID);


    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB = CREATIVE_MODE_TAB.register("bismuth_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.dankscoffeemod.bismuth_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.RAW_BISMUTH);
                        //CUSTOM ITEMS
                        output.accept(ModItems.CHISEL);
                        // FOOD
                        output.accept(ModItems.RADISH);
                        // FUEL
                        output.accept(ModItems.STARLIGHT_ASHES);
                        output.accept(ModItems.FROSTFIRE_ICE);
                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB = CREATIVE_MODE_TAB.register("bismuth_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(CoffeeMod.MOD_ID, "bismuth_items_tab"))  // determines the order of the tab
                    .title(Component.translatable("creativetab.dankscoffeemod.bismuth_blocks"))                      // will be placed after ITEMS
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK);
                        output.accept(ModBlocks.BISMUTH_ORE);
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                    }).build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
