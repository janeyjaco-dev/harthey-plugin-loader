package com.amyq.hartheyContent.loader.plugin.util;

public class RegistryEntry<T extends RegistryItem> {
    private final T item;
    private final RegistryKey<T> key;

    public RegistryEntry(T item, RegistryKey<T> key) {
        this.item = item;
        this.key = key;
    }

    public T getItem() {
        return item;
    }

    public RegistryKey<T> getKey() {
        return key;
    }
}
