package com.example.deathprison;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;

public class PrisonListener implements Listener {
    private final DeathPrison plugin;

    public PrisonListener(DeathPrison plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        plugin.teleportToPrison(player);
        plugin.teleportBackToWorld(player);
    }
}
