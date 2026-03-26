package com.amyq.hartheyContent.loader.plugin.commands;

import com.amyq.hartheyContent.HartheyContent;
import com.amyq.hartheyContent.loader.HartheyPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HPLCommand implements CommandExecutor {

    private final HartheyContent plugin;

    public HPLCommand(HartheyContent plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        var plugins = plugin.getPlugins();

        sender.sendMessage(ChatColor.GOLD + "=== Harthey Plugins ===");

        if (plugins.isEmpty()) {
            sender.sendMessage(ChatColor.RED + "No Harthey plugins are loaded.");
            return true;
        }

        for (HartheyPlugin hp : plugins) {
            sender.sendMessage(ChatColor.YELLOW + " - " + ChatColor.WHITE + hp.getName());
        }

        return true;
    }
}