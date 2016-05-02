package me.chocoaa.paintball.Listeners;

import me.chocoaa.paintball.ArenaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

/**
 * Created by Chocoaa on 01/05/2016.
 */
public class PlayerLooseHunger implements Listener {

    @EventHandler
    public void onPlayerLoseHunger(FoodLevelChangeEvent e) {
        if (!(e.getEntity() instanceof Player))
            return;
        if (ArenaManager.getInstance().getArena(((Player)e.getEntity())) != null) e.setCancelled(true);

    }

}
