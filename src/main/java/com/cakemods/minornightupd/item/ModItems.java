package com.cakemods.minornightupd.item;

import com.cakemods.minornightupd.MinNightUpd;
import com.cakemods.minornightupd.block.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MinNightUpd.MODID);

    // REGISTERING ITEMS
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(addToModTab()));
    public static final RegistryObject<Item> LUMIN = ITEMS.register("lumin",
            () -> new Item(addToModTab()));

    public static final RegistryObject<Item> OMELET = ITEMS.register("omelet",
            () -> new Item(addToModTab().food(Foods.OMELET)));
    public static final RegistryObject<Item> OMELATTE = ITEMS.register("omelatte",
            () -> new Item(addToModTab().food(Foods.OMELATTE)));


    public static final RegistryObject<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(Tiers.COPPER_TIER, 5, 3.5f, addToModTab()));
    public static final RegistryObject<PickaxeItem> EXAMPLE_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(Tiers.COPPER_TIER, 4, 3.5f, addToModTab()));
    public static final RegistryObject<ShovelItem> EXAMPLE_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(Tiers.COPPER_TIER, 3, 3.5f, addToModTab()));
    public static final RegistryObject<AxeItem> EXAMPLE_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(Tiers.COPPER_TIER, 7, 3.5f, addToModTab()));
    public static final RegistryObject<HoeItem> EXAMPLE_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(Tiers.COPPER_TIER, 1, 3.5f, addToModTab()));


    // HELPING FUNCTION FOR UNIVERSAL ITEM PROPS
    public static Item.Properties addToModTab() {
        return new Item.Properties().tab(MinNightUpd.MNU_TAB);
    }


    // TIERS ...FOR ALL TOOLS?
    public static class Tiers {
        public static final Tier COPPER_TIER = new ForgeTier(
                2,
                800,
                1.5f,
                3,
                350,
                null,
                () -> Ingredient.of(Items.COPPER_INGOT));
    }


    // FOOD REGISTERING COMMAND EXTENSIONS
    public static class Foods {
        public static final FoodProperties OMELET = new FoodProperties.Builder()
                .nutrition(6) // 3 MEATSTICKS
                .saturationMod(0.4f) // IDK
                .meat()
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20, 3), 1.0f)
                .build();

        public static final FoodProperties OMELATTE = new FoodProperties.Builder()
                .nutrition(8) // 4 MEATSTICKS
                .saturationMod(0.6f) // IDK
                .meat()
                .fast()
                .alwaysEat()
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20, 3), 1.0f)
                .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 200, 4), 1.0f)
                .build();
    }
}