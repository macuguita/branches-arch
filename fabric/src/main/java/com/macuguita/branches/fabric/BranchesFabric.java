package com.macuguita.branches.fabric;

import com.macuguita.branches.fabric.compat.WoodGood;
import net.fabricmc.api.ModInitializer;

import com.macuguita.branches.Branches;
import net.fabricmc.loader.api.FabricLoader;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public final class BranchesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup.
        Branches.init();
        if (FabricLoader.getInstance().isModLoaded("everycomp")) {
            try {
                EveryCompatAPI.registerModule(new WoodGood(Branches.MOD_ID, "br"));
                Branches.LOGGER.info("Registered WoodGood module with Every Compat");
            } catch (Exception e) {
                Branches.LOGGER.error("Failed to register WoodGood module with Every Compat", e);
            }
        } else {
            Branches.LOGGER.warn("Every Compat is not loaded. Skipping compatibility module.");
        }
        Branches.commonSetup();
    }
}
