package com.macuguita.branches;
import eu.midnightdust.lib.config.MidnightConfig;
public class ModConfig extends MidnightConfig {
    public static final String TEXT = "text";
    public static final String NUMBERS = "numbers";
    public static final String SLIDERS = "sliders";
    public static final String LISTS = "lists";
    public static final String FILES = "files";
    @Entry
    public static boolean showInVanillaItemGroups = true;
}