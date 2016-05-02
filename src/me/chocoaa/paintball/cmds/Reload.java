package me.chocoaa.paintball.cmds;

import me.chocoaa.paintball.ArenaManager;
import me.chocoaa.paintball.MessageManager;
import org.bukkit.entity.Player;

/**
 * Created by Chocoaa on 02/05/2016.
 */
public class Reload extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        ArenaManager.getInstance().setup();
        MessageManager.getInstance().good(p, "Reloaded!");

    }

    @Override
    public String name() {
        return "reload";
    }

    @Override
    public String info() {
        return "Reload arenas.";
    }

    @Override
    public String[] aliases() {
        return new String[] { "r" };
    }
}
