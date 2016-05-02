package me.chocoaa.paintball.Listeners;

import me.chocoaa.paintball.ArenaManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

/**
 * Created by Chocoaa on 01/05/2016.
 */
public class ArmorRemove implements Listener {

    @EventHandler
    public void onPlayerClick(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player)) return;
        Player p = (Player) e.getWhoClicked();

        if (ArenaManager.getInstance().getArena(p) != null) {
            if (e.getSlotType() == InventoryType.SlotType.ARMOR) {
                e.setCancelled(true);
            }
        }
    }


}
