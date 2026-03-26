package com.amyq.hartheyContent.loader.plugin.util;

import com.amyq.hartheyContent.loader.plugin.util.items.Item;
import org.bukkit.inventory.ItemStack;

public class Registries {
    private static final Boolean TRUE = true;
    private static final RegistryItem REGISTRY_ITEM = new RegistryItem() {};
    public static final Registry<Item, Boolean, Item> ITEM = new Registry<>();
    public static final Registry<ItemStack, Boolean, ItemRegistry> ITEM_STACK = new Registry<>();
}
