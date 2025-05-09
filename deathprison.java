package com.example.deathprison;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DeathPrison extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PrisonListener(this), this);
        this.getCommand("setprison").setExecutor(new PrisonCommand(this));
    }

    public void teleportToPrison(Player player) {
        Location prisonLocation = getConfig().getLocation("prisonLocation");
        if (prisonLocation != null) {
            player.teleport(prisonLocation);
        }
    }

    public void teleportBackToWorld(Player player) {
        // Teleport player back after a certain duration
        new BukkitRunnable() {
            @Override
            public void run() {
                player.teleport(player.getWorld().getSpawnLocation());
            }
        }.runTaskLater(this, 1200L); // Teleport after 60 seconds (1200 ticks)
    }
}
