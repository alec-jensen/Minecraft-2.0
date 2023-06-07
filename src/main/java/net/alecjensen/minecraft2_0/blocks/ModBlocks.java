package net.alecjensen.minecraft2_0.blocks;

import net.alecjensen.minecraft2_0.Minecraft2_0;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TITANIUM_ORE = registerBlock("titanium_ore",
            new Block(FabricBlockSettings.of(Material.METAL).strength(16.0f).requiresTool()), ItemGroups.NATURAL);

    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
               new Block(FabricBlockSettings.of(Material.METAL).strength(16.0f).requiresTool()), ItemGroups.BUILDING_BLOCKS);

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);

        return Registry.register(Registries.BLOCK, new Identifier(Minecraft2_0.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Minecraft2_0.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

        return item;
    }

    public static void registerModBlocks() {
        Minecraft2_0.LOGGER.info("Registering mod blocks...");
    }
}
