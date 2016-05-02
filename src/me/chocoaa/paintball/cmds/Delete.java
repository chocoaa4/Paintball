package me.chocoaa.paintball.cmds;

import me.chocoaa.paintball.Arena;
import me.chocoaa.paintball.ArenaManager;
import me.chocoaa.paintball.MessageManager;
import me.chocoaa.paintball.SettingsManager;
import org.bukkit.entity.Player;

/**
 * Created by AhmedAbdulai on 30/04/2016.
 */
public class Delete extends SubCommand {
    @Override
    public void onCommand(Player p, String[] args) {
        if (args.length == 0) {
            MessageManager.getInstance().severe(p, "You must specify an arena number!");
            return;
        }
        int id = 10;
        // any number

        try { id = Integer.parseInt(args[0]; }
        catch (Exception e) {
            MessageManager.getInstance().severe(p, args[0] + " is not a valid number!");
            return;
        }
        Arena a = ArenaManager.getInstance().getArena(id);

        if (a == null) {
            MessageManager.getInstance().severe(p, "There is no arena with ID " + id + "!");
            return;
        }

        if (a.isStarted()) {
            MessageManager.getInstance().severe(p, "Arena " + id + " is in game!");
            return;
        }
        SettingsManager.getInstance().set(id + "", null);
        //TODO: Stop all games and broadcast!
        ArenaManager.getInstance().setup();


    }

    @Override
    public String name() {
        return "delete";
    }

    @Override
    public String info() {
        return "Delete and arena.";
    }

    @Override
    public String[] aliases() {
        return new String[] { "d" };
    }
}
