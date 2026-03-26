package com.amyq.hartheyContent.loader.plugin.v2;

import com.amyq.hartheyContent.loader.HartheyPlugin;
import com.amyq.hartheyContent.loader.plugin.HartheyContext;

public class PluginLoader {
    public static void load(HartheyPlugin plugin, HartheyContext ctx) {
        plugin.onStartup(ctx);
        plugin.onReload(ctx);
        plugin.onEnable(ctx);
        plugin.onWorldLoad(ctx);
    }

    public static void unload(HartheyPlugin plugin, HartheyContext ctx) {
        plugin.onWorldUnload(ctx);
        plugin.onReload(ctx);
        plugin.onDisable(ctx);
    }

    public static void reload(HartheyPlugin plugin, HartheyContext ctx) {
        plugin.onReload(ctx);
    }

    public static void loadPlugins(HartheyContext ctx, HartheyPlugin... plugins) {
        for (HartheyPlugin plugin : plugins) {
            plugin.load(ctx);
        }
    }


}
