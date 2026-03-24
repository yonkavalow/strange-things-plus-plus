package org.pillowfillow.strangeThingsPlusPlus.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import org.pillowfillow.strangeThingsPlusPlus.registry.ModBlocks;
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
}
