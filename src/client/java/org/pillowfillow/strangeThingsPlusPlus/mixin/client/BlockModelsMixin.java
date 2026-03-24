package org.pillowfillow.strangeThingsPlusPlus.mixin.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.block.BlockModels;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.pillowfillow.strangeThingsPlusPlus.registry.ModBlocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(BlockModels.class)
public abstract class BlockModelsMixin {
    @Shadow
    private Map<BlockState, BakedModel> models;

    private static final RegistryKey<World> UPSIDE_DOWN_WORLD_KEY = RegistryKey.of(
            RegistryKeys.WORLD,
            Identifier.of("strangerthings", "upside_down")
    );

    @Inject(method = "getModel", at = @At("HEAD"), cancellable = true)
    private void strangeThingsPlusPlus$useWarpedStoneModelInUpsideDown(
            BlockState state,
            CallbackInfoReturnable<BakedModel> cir
    ) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null || client.world.getRegistryKey() != UPSIDE_DOWN_WORLD_KEY || !state.isOf(Blocks.STONE)) {
            return;
        }

        cir.setReturnValue(this.models.get(ModBlocks.WARPED_STONE.getDefaultState()));
    }
}
