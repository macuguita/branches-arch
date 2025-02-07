package com.macuguita.branches.compat;

import com.macuguita.branches.Branches;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;

public class ModCompat {
    public static void init() {
        EveryCompatAPI.registerModule(new WoodGood(Branches.MOD_ID, "br"));
        Branches.LOGGER.info("Registered module for EveryCompat");
    }
}
