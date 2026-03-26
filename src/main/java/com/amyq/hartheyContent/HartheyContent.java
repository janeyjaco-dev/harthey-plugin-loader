package com.amyq.hartheyContent;

import com.amyq.hartheyContent.content.AmysDecorPlugin;
import com.amyq.hartheyContent.content.CharterPlugin;
import com.amyq.hartheyContent.loader.HartheyPlugin;
import com.amyq.hartheyContent.loader.plugin.HartheyContext;
import com.amyq.hartheyContent.loader.plugin.commands.HPLCommand;
import com.amyq.hartheyContent.loader.plugin.context.ShutdownReason;
import com.amyq.hartheyContent.loader.plugin.context.StartUpReason;
import com.amyq.hartheyContent.loader.plugin.v2.PluginLoader;
import io.papermc.paper.datapack.Datapack;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public final class HartheyContent extends JavaPlugin {

    private final List<HartheyPlugin> plugins = new ArrayList<>();

    @Override
    public void onLoad() {
        // Register all HartheyPlugin implementations here
        registerPlugins();
    }

    @Override
    public void onEnable() {
        HartheyContext ctx = buildContext(ShutdownReason.NONE, StartUpReason.ENABLE);
        PluginLoader.loadPlugins(ctx, plugins.toArray(new HartheyPlugin[0]));
        Objects.requireNonNull(getCommand("hpl")).setExecutor(new HPLCommand(this));
    }

    @Override
    public void onDisable() {
        HartheyContext ctx = buildContext(ShutdownReason.DISABLE, StartUpReason.NONE);
        for (HartheyPlugin plugin : plugins) {
            PluginLoader.unload(plugin, ctx);
        }
    }

    private void registerPlugins() {
        // Example:
        // plugins.add(new MyFirstHartheyPlugin());
        // plugins.add(new AnotherHartheyPlugin());
        plugins.add(new CharterPlugin());
        plugins.add(new AmysDecorPlugin());
    }

    public List<HartheyPlugin> getPlugins() {
        return plugins;
    }

    private HartheyContext buildContext(ShutdownReason shutdownReason, StartUpReason startUpReason) {
        var server = getServer();

        Collection<? extends Player> online = server.getOnlinePlayers();
        List<Player> onlinePlayers = new ArrayList<>(online);
        List<Player> operators = onlinePlayers.stream()
                .filter(Player::isOp)
                .collect(Collectors.toList());
        List<Player> nonOperators = onlinePlayers.stream()
                .filter(p -> !p.isOp())
                .collect(Collectors.toList());
        List<Player> spectators = onlinePlayers.stream()
                .filter(p -> p.getGameMode() == GameMode.SPECTATOR)
                .collect(Collectors.toList());

        // Paper does not expose offline players as Player instances directly; keep this empty for now
        List<Player> offlinePlayers = List.of();

        List<World> worlds = server.getWorlds();
        List<World> loadedWorlds = new ArrayList<>(worlds);
        List<World> unloadedWorlds = List.of(); // Bukkit does not expose unloaded worlds

        List<Datapack> datapacks = new ArrayList<>(server.getDatapackManager().getPacks());

        return HartheyContext.of(
                shutdownReason,
                startUpReason,
                new ArrayList<>(onlinePlayers),   // players
                operators,
                nonOperators,
                spectators,
                onlinePlayers,
                offlinePlayers,
                worlds,
                loadedWorlds,
                unloadedWorlds,
                datapacks
        );
    }
}