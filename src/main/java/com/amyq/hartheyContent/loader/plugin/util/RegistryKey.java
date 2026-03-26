package com.amyq.hartheyContent.loader.plugin.util;

public class RegistryKey<E extends RegistryItem> {
    private final String namespace;
    private final String path;

    public RegistryKey(String namespace, String path) {
        this.namespace = namespace;
        this.path = path;
    }


    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return namespace + ":" + path;
    }

}
