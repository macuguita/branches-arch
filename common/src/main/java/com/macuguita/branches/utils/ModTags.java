package com.macuguita.branches.utils;

import com.macuguita.branches.Branches;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public class Blocks {

        public static final TagKey<Block> BRANCHES = createTag("branches");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Branches.MOD_ID, name));
        }
    }

    public class Items {

        public static final TagKey<Item> BRANCHES = createTag("branches");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Branches.MOD_ID, name));
        }
    }
}
