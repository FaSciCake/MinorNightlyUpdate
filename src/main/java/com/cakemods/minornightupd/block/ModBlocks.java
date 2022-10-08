package com.cakemods.minornightupd.block;

import com.cakemods.minornightupd.MinNightUpd;
import com.cakemods.minornightupd.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MinNightUpd.MODID);

    // REGISTERING BLOCKS+ITEMS WITH DIFFERENT PROPERTIES
    public static final RegistryObject<Block> LUMIN_ORE = registerBlock("lumin_ore",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .lightLevel((state) -> 1)
                    .sound(SoundType.BASALT)
            ), new Item.Properties().tab(MinNightUpd.MNU_TAB));

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.STONE)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .lightLevel((state) -> 1)
                    .sound(SoundType.BASALT)
            ), new Item.Properties().tab(MinNightUpd.MNU_TAB));


    // HELP FUNCTIONS FOR REGISTERING BLOCKS AND THEIR ITEMS
    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, Item.Properties props) {
        RegistryObject<T> returnBlock = BLOCKS.register(name, block); // REGISTER BLOCK THING
        ModItems.ITEMS.register(name, () -> new BlockItem(returnBlock.get(), props)); // REGISTER BLOCK ITEM
        return returnBlock;
    }
}
