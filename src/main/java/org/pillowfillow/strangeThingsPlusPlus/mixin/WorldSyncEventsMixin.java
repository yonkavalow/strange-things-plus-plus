package org.pillowfillow.strangeThingsPlusPlus.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.chunk.WorldChunk;
import org.pillowfillow.strangeThingsPlusPlus.registry.ModBlocks;
import org.pillowfillow.strangeThingsPlusPlus.world.UpsideDownStoneSwap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "org.swirly.strangerthings.event.WorldSyncEvents")
public abstract class WorldSyncEventsMixin {
    @Inject(method = "toUpsideDownState", at = @At("RETURN"), cancellable = true)
    private static void strangeThingsPlusPlus$mapStoneToWarpedStone(
            BlockState state,
            CallbackInfoReturnable<BlockState> cir
    ) {
        if (state.isOf(Blocks.STONE)) {
            cir.setReturnValue(ModBlocks.WARPED_STONE.getDefaultState());
        }
    }

    @Inject(method = "forcePrepareChunkSurface", at = @At("RETURN"))
    private static void strangeThingsPlusPlus$swapAllStoneInPreparedChunks(
            ServerWorld world,
            WorldChunk chunk,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (!cir.getReturnValueZ()) {
            return;
        }

        UpsideDownStoneSwap.swapChunk(world, chunk);
    }
}
