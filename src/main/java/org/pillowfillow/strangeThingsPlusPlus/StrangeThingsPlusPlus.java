package org.pillowfillow.strangeThingsPlusPlus;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import org.pillowfillow.strangeThingsPlusPlus.registry.ModBlocks;
import org.pillowfillow.strangeThingsPlusPlus.world.UpsideDownStoneSwap;

public class StrangeThingsPlusPlus implements ModInitializer {
    public static final String MOD_ID = "strange-things-plus-plus";

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ServerChunkEvents.CHUNK_LOAD.register(UpsideDownStoneSwap::swapChunk);
    }
}
