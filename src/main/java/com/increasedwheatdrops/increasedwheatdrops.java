package com.increasedwheatdrops;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;;

public class increasedwheatdrops implements ModInitializer {
    @Override
    public void onInitialize() {
        // Register the wheat harvest event listener
        HarvestListener.register();
        System.out.println("Wheat Harvest Mod Initialized!");
    }
}