package com.amyq.hartheyContent.loader;

import com.amyq.hartheyContent.loader.plugin.HartheyContext;
import io.papermc.paper.datapack.Datapack;

import java.util.List;

public interface HartheyPlugin {
    void onStartup(HartheyContext ctx);
    void onDisable(HartheyContext ctx);
    void onEnable(HartheyContext ctx);
    void onWorldLoad(HartheyContext ctx);
    void onWorldUnload(HartheyContext ctx);
    void onReload(HartheyContext ctx);
    String getName();
    default void load(HartheyContext ctx) {
        onStartup(ctx);
        onReload(ctx);
        onEnable(ctx);
        onWorldLoad(ctx);
        onWorldUnload(ctx);
    }
    List<Datapack> getDatapacks();
}
