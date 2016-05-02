package me.chocoaa.paintball.Listeners;

import me.chocoaa.paintball.ArenaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Created by AhmedAbdulai on 01/05/2016.
 */
public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e ) {
        if (ArenaManager.getInstance().getArena(e.getPlayer()) != null) e.setCancelled(true);
    }
}
