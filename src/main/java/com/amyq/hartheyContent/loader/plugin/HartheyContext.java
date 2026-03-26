package com.amyq.hartheyContent.loader.plugin;

import com.amyq.hartheyContent.loader.plugin.context.ShutdownReason;
import com.amyq.hartheyContent.loader.plugin.context.StartUpReason;
import io.papermc.paper.datapack.Datapack;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class HartheyContext {
    private final ShutdownReason shutdownReason;
    private final StartUpReason startUpReason;
    private final List<Player> players;
    private final List<Player> operators;
    private final List<Player> nonOperators;
    private final List<Player> spectators;
    private final List<Player> onlinePlayers;
    private final List<Player> offlinePlayers;
    private final List<World> worlds;
    private final List<World> loadedWorlds;
    private final List<World> unloadedWorlds;
    private final List<Datapack> datapacks;

    public HartheyContext(ShutdownReason shutdownReason, StartUpReason startUpReason, List<Player> players, List<Player> operators, List<Player> nonOperators, List<Player> spectators, List<Player> onlinePlayers, List<Player> offlinePlayers, List<World> worlds, List<World> loadedWorlds, List<World> unloadedWorlds, List<Datapack> datapacks) {
        this.shutdownReason = shutdownReason;
        this.startUpReason = startUpReason;
        this.players = players;
        this.operators = operators;
        this.nonOperators = nonOperators;
        this.spectators = spectators;
        this.onlinePlayers = onlinePlayers;
        this.offlinePlayers = offlinePlayers;
        this.worlds = worlds;
        this.loadedWorlds = loadedWorlds;
        this.unloadedWorlds = unloadedWorlds;
        this.datapacks = datapacks;
    }

    public ShutdownReason getShutdownReason() {
        return shutdownReason;
    }

    public StartUpReason getStartUpReason() {
        return startUpReason;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Player> getOperators() {
        return operators;
    }

    public boolean isReload() {
        return startUpReason == StartUpReason.RELOAD;
    }

    public List<Player> getNonOperators() {
        return nonOperators;
    }

    public List<Player> getSpectators() {
        return spectators;
    }

    public List<Player> getOnlinePlayers() {
        return onlinePlayers;
    }

    public List<Player> getOfflinePlayers() {
        return offlinePlayers;
    }

    public List<World> getWorlds() {
        return worlds;
    }

    public List<World> getLoadedWorlds() {
        return loadedWorlds;
    }

    public List<World> getUnloadedWorlds() {
        return unloadedWorlds;
    }

    public List<Datapack> getDatapacks() {
        return datapacks;
    }

    public static HartheyContext empty() {
        return new HartheyContext(null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static HartheyContext of(ShutdownReason shutdownReason, StartUpReason startUpReason, List<Player> players, List<Player> operators, List<Player> nonOperators, List<Player> spectators, List<Player> onlinePlayers, List<Player> offlinePlayers, List<World> worlds, List<World> loadedWorlds, List<World> unloadedWorlds, List<Datapack> datapacks) {
        return new HartheyContext(shutdownReason, startUpReason, players, operators, nonOperators, spectators, onlinePlayers, offlinePlayers, worlds, loadedWorlds, unloadedWorlds, datapacks);
    }

    public static HartheyContext of(ShutdownReason shutdownReason, StartUpReason startUpReason) {
        return new HartheyContext(shutdownReason, startUpReason, null, null, null, null, null, null, null, null, null, null);
    }
}
