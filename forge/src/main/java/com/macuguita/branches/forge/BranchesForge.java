package com.macuguita.branches.forge;

import com.macuguita.branches.forge.compat.WoodGood;
import dev.architectury.platform.forge.EventBuses;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.macuguita.branches.Branches;

@Mod(Branches.MOD_ID)
public final class BranchesForge {
    public BranchesForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(Branches.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Run our common setup.
        Branches.init();
        if (ModList.get().isLoaded("everycomp")) {
            try {
                EveryCompatAPI.registerModule(new WoodGood(Branches.MOD_ID, "br"));
                Branches.LOGGER.info("Registered WoodGood module with Every Compat");
            } catch (Exception e) {
                Branches.LOGGER.error("Failed to register WoodGood module with Every Compat", e);
            }
        } else {
            Branches.LOGGER.warn("Every Compat is not loaded. Skipping compatibility module.");
        }
    }
}
