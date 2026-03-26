package com.amyq.hartheyContent.loader.plugin.util;

import java.util.HashMap;
import java.util.Map;

public class Registry<T, R, E extends RegistryItem> {

    // Internal registry storage
    private final Map<E, Boolean> registry = new HashMap<>();

    // Allow internal creation of new Registry instances
    protected Registry() {}

    public void freeze(RegistryKey<E> key) {
        // TODO: freeze logic
    }

    public T register(T t, RegistryEntry<E> entry) {
        registry.put(entry.getItem(), true);
        return t;
    }

    /**
     * Returns a new Registry instance containing a copy of this registry's entries.
     * This is the non-static, abstracted version of the static registry.
     */
    public Registry<T, R, E> getAbstractedRegistry() {
        Registry<T, R, E> copy = new Registry<>();
        copy.registry.putAll(this.registry);
        return copy;
    }
}