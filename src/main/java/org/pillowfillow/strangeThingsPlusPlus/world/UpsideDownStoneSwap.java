package org.pillowfillow.strangeThingsPlusPlus.world;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.pillowfillow.strangeThingsPlusPlus.registry.ModBlocks;

public final class UpsideDownStoneSwap {
    private static final RegistryKey<World> UPSIDE_DOWN_WORLD_KEY = RegistryKey.of(
            RegistryKeys.WORLD,
            Identifier.of("strangerthings", "upside_down")
    );

    private UpsideDownStoneSwap() {
    }

    public static void swapChunk(ServerWorld world, WorldChunk chunk) {
        if (world.getRegistryKey() != UPSIDE_DOWN_WORLD_KEY) {
            return;
        }

        ChunkPos chunkPos = chunk.getPos();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockState warpedStone = ModBlocks.WARPED_STONE.getDefaultState();

        for (int x = chunkPos.getStartX(); x <= chunkPos.getEndX(); x++) {
            for (int z = chunkPos.getStartZ(); z <= chunkPos.getEndZ(); z++) {
                for (int y = world.getBottomY(); y < world.getTopY(); y++) {
                    mutable.set(x, y, z);
                    if (chunk.getBlockState(mutable).isOf(Blocks.STONE)) {
                        chunk.setBlockState(mutable, warpedStone, false);
                    }
                }
            }
        }
    }
}
