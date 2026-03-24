package org.pillowfillow.strangeThingsPlusPlus;

import net.fabricmc.api.ModInitializer;
import org.pillowfillow.strangeThingsPlusPlus.registry.ModBlocks;

public class StrangeThingsPlusPlus implements ModInitializer {
    public static final String MOD_ID = "strange-things-plus-plus";

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
    }
}
