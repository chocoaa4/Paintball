package me.chocoaa.paintball.Listeners;

import me.chocoaa.paintball.ArenaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Chocoaa on 01/05/2016.
 */
public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (ArenaManager.getInstance().getArena(e.getEntity()) == null)
            ArenaManager.getInstance().getArena(e.getEntity()).addDeath(e.getEntity());
            ArenaManager.getInstance().getArena(e.getEntity()).removePlayer(e.getEntity());

    }
}
