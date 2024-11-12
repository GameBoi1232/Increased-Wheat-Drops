package com.increasedwheatdrops;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.Random;

public class HarvestListener {

    public static void register() {
        // Listen for player block breaks
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            // Check if the block is a fully grown wheat crop and if player is not in Creative mode
            if (!player.isCreative() && state.getBlock() == Blocks.WHEAT) {
                CropBlock cropBlock = (CropBlock) state.getBlock();
                if (cropBlock.getAge(state) == 7) { // Fully grown wheat
                    Random rand = new Random();

                    // Generate a random number between 1 and 2 for wheat drops
                    int wheatCount = rand.nextInt(2) + 1; // random between 1 and 2

                    // Drop the generated amount of wheat
                    for (int i = 0; i < wheatCount; i++) {
                        cropBlock.dropStack(world, pos, new ItemStack(Items.WHEAT));
                    }

                    // Optionally, drop wheat seeds
                    cropBlock.dropStack(world, pos, new ItemStack(Items.WHEAT_SEEDS));
                }
            }
        });
    }
}
