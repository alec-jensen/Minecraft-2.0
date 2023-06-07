package net.alecjensen.minecraft2_0.items;

import net.alecjensen.minecraft2_0.Minecraft2_0;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item BEEF_JERKY = registerItem("beef_jerky",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder().meat().hunger(4).saturationModifier(2f).build())
                    .maxCount(128)));

    public static final Item RAW_TITANIUM = registerItem("raw_titanium",
            new Item(new FabricItemSettings()));

    public static final Item TITANIUM_INGOT = registerItem("titanium_ingot",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Minecraft2_0.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, BEEF_JERKY);
        addToItemGroup(ItemGroups.NATURAL, RAW_TITANIUM);
        addToItemGroup(ItemGroups.NATURAL, TITANIUM_INGOT);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Minecraft2_0.LOGGER.info("Registering mod items...");

        addItemsToItemGroup();
    }
}
