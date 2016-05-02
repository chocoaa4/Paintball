package me.chocoaa.paintball.cmds;

import me.chocoaa.paintball.ArenaManager;
import me.chocoaa.paintball.MessageManager;
import me.chocoaa.paintball.SettingsManager;
import org.bukkit.entity.Player;

/**
 * Created by Chocoaa on 30/04/2016.
 */
public class Create extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        int id = ArenaManager.getInstance().getArenas().size() + 1;

        SettingsManager.getInstance().createConfigurationSection(id + "");
        MessageManager.getInstance().good(p, "Created Arena " + "!");



    }

    @Override
    public String name() {
        return "create";
    }

    @Override
    public String info() {
        return "Create and arena.";
    }

    @Override
    public String[] aliases() {
        return new String[] { "c" };
    }
}
