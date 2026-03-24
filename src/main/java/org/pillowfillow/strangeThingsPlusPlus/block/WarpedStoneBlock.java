package org.pillowfillow.strangeThingsPlusPlus.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class WarpedStoneBlock extends Block {
    public WarpedStoneBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (random.nextInt(5) != 0) {
            return;
        }

        double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.6;
        double y = pos.getY() + 1.02;
        double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.6;
        world.addParticle(ParticleTypes.ENCHANT, x, y, z, 0.0, 0.02, 0.0);
    }
}
