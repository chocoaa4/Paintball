package me.chocoaa.paintball.cmds;

import me.chocoaa.paintball.Arena;
import me.chocoaa.paintball.ArenaManager;
import me.chocoaa.paintball.ArenaManager.Team;
import me.chocoaa.paintball.MessageManager;
import me.chocoaa.paintball.SettingsManager;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/**
 * Created by Chocoaa on 30/04/2016.
 */
public class SetLocation extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        //setlocation <id> <red | blue>

        if (args.length <2) {
            MessageManager.getInstance().severe(p, "You did not specify enough information!");
            return;
        }
        int id = 10;
        // any number

        try { id = Integer.parseInt(args[0]); }
        catch (Exception e) {
            MessageManager.getInstance().severe(p, args[0] + " is not a valid number!");
            return;
        }
        Arena a = ArenaManager.getInstance().getArena(id);

        if (a == null) {
            MessageManager.getInstance().severe(p, "There is no arena with ID " + id + "!");
            return;
        }


        Team team = null;

        try { team = Team.valueOf(args [1]); }
        catch
                (Exception e) {
            MessageManager.getInstance().severe(p, args[1] + " is not a valid team!");
            return;

        }
        ConfigurationSection s = SettingsManager.getInstance().createConfigurationSection(a.getID() + "." + team.toString().toLowerCase() + "spawn" );

        s.set("world", p.getWorld().getName());
        s.set("x", p.getLocation().getX());
        s.set("y", p.getLocation().getY());
        s.set("z", p.getLocation().getZ());

        MessageManager.getInstance().good(p, "Set " + team.toString().toLowerCase() + " spawn!" );

    }

    @Override
    public String name() {
        return "setLocation";
    }

    @Override
    public String info() {
        return "Set a team's spawn";
    }

    @Override
    public String[] aliases() {
        return new String[] { "sl" };
    }
}
