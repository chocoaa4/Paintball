package me.chocoaa.paintball.Listeners;

import me.chocoaa.paintball.ArenaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by AhmedAbdulai on 02/05/2016.
 */
public class PlayerDamage implements Listener {

    @EventHandler
    public void onPlayerAttack(EntityDamageByEntityEvent e) {
        if (e.getDamager()instanceof Player) {
            Player p = (Player) e.getDamager();
            if (ArenaManager.getInstance().getArena(p) != null) e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (ArenaManager.getInstance().getArena(p) != null) {
                if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) e.setCancelled(true);
            }
        }

    }
}
