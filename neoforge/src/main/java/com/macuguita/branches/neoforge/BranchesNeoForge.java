package com.macuguita.branches.neoforge;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

import com.macuguita.branches.Branches;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Branches.MOD_ID)
public final class BranchesNeoForge {
    public BranchesNeoForge(IEventBus modEventBus) {
        // Run our common setup.
        Branches.init();
        assert modEventBus != null;
        modEventBus.addListener(this::commonSetup);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        Branches.commonSetup();
    }
}
