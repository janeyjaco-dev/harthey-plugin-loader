package com.amyq.hartheyContent.loader.plugin.util.items;

public class ItemStack {
    private final Item item;
    public ItemStack(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public static ItemStack of(Item item) {
        return new ItemStack(item);
    }

    public static ItemStack empty() {
        return new ItemStack(null);
    }
}
