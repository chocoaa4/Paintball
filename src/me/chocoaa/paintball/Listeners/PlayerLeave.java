package me.chocoaa.paintball.Listeners;

import me.chocoaa.paintball.Arena;
import me.chocoaa.paintball.ArenaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by AhmedAbdulai on 01/05/2016.
 */
public class PlayerLeave implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Arena a = ArenaManager.getInstance().getArena(e.getPlayer());
        if (a == null) return;
        a.removePlayer(e.getPlayer());
    }
}
