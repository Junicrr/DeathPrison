package com.example.deathprison;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrisonCommand implements org.bukkit.command.CommandExecutor {
    private final DeathPrison plugin;

    public PrisonCommand(DeathPrison plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("setprison")) {
                // Set the prison location to the player's current location
                plugin.getConfig().set("prisonLocation", player.getLocation());
                plugin.saveConfig();
                player.sendMessage("Prison location set!");
                return true;
            }
        }
        return false;
    }
}
