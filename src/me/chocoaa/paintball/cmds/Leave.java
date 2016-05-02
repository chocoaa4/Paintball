package me.chocoaa.paintball.cmds;

import me.chocoaa.paintball.Arena;
import me.chocoaa.paintball.ArenaManager;
import me.chocoaa.paintball.MessageManager;
import org.bukkit.entity.Player;

/**
 * Created by Chocoaa on 30/04/2016.
 */
public class Leave extends SubCommand {


    public void onCommand(Player p, String[] args ) {
        Arena a = ArenaManager.getInstance().getArena(p);

        if (a == null) {
            MessageManager.getInstance().severe(p, "You are not in a game!");
            return;
        }

        a.removePlayer(p,false);

    }

    public String name() {
        return "leave";
    }

    public String info() {
        return "leave and arena.";

    }

    public String [] aliases () {
        return new String [] { "l" };

    }


}
