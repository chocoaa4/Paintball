package me.chocoaa.paintball.cmds;

import org.bukkit.entity.Player;

/**
 * Created by Chocoaa on 27/04/2016.
 */
public abstract class SubCommand {

    /**
    * create command <id>
     *     delete <id>
    * setLocation <id> <redspawn | bluespawn>
    * Listeners
     * Scoreboard suggestion
     * Lobby Signs suggestion
     * Classes and Kits
     * Stats
     * Specation
     * Arena Join Message
     * Permissions
     **/

    public abstract void onCommand(Player p, String[] args);

    public abstract String name();

    public abstract String info();

    public abstract String[] aliases();

}
