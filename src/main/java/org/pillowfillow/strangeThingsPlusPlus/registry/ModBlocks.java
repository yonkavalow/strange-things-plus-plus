package org.pillowfillow.strangeThingsPlusPlus.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import org.pillowfillow.strangeThingsPlusPlus.StrangeThingsPlusPlus;
import org.pillowfillow.strangeThingsPlusPlus.block.WarpedStoneBlock;

public final class ModBlocks {
    public static final Block WARPED_STONE = registerBlock(
            "warped_stone",
            new WarpedStoneBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.DARK_AQUA)
                    .strength(4.0f, 12.0f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .luminance(state -> 10)
                    .requiresTool()
                    .ticksRandomly()
                    .pistonBehavior(PistonBehavior.BLOCK))
    );

    private ModBlocks() {
    }

    public static void registerModBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(WARPED_STONE));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StrangeThingsPlusPlus.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(StrangeThingsPlusPlus.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }
}
