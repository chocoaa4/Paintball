package me.chocoaa.paintball.cmds;

import me.chocoaa.paintball.Arena;
import me.chocoaa.paintball.ArenaManager;
import me.chocoaa.paintball.MessageManager;
import org.bukkit.entity.Player;

/**
 * Created by Chocoaa on 27/04/2016.
 */
public class Join extends SubCommand {

    public void onCommand(Player p, String[] args) {
        if (ArenaManager.getInstance().getArena(p) != null) {
            MessageManager.getInstance().severe(p, "you are already in a game!");
            return;
        }

        if (args.length == 0) {
            MessageManager.getInstance().severe(p, "You must specify an arena ID!");
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

        if (a.isStarted()) {
            MessageManager.getInstance().severe(p, "Arena " + id + " has already started!");
        }
        return;


        a.addPlayer(p);
        // when the player is added there will be a message



    }

    public String name() {
        return "join";
    }

    public String info() {
        return "Join a game.";
    }

    public String[] aliases() {
        return new String[] {  "j"  };
    }
}
