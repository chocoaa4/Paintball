package me.chocoaa.paintball.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Chocoaa on 02/05/2016.
 */

// Something cool to have
public class PaintballJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (e.getPlayer().getName().equalsIgnoreCase("Chocoaa")) e.setJoinMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Chocoaa, the creator of Paintball, has joined the game");
    }
}
