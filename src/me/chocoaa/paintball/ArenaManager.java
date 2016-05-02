package me.chocoaa.paintball;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Created by Chocoaa on 27/04/2016.
 */
public class ArenaManager {

    public enum Team {RED, BLUE}

    private ArenaManager() {  }

    private static ArenaManager instance = new ArenaManager();

    public static ArenaManager getInstance() {
        return instance;
    }

    private ArrayList<Arena> arenas = new ArrayList<Arena>();

    public void setup() {
        // load config
        try {
            for (int i : SettingsManager.getInstance().<List<Integer>>get("ids")) {
                arenas.add(new Arena(i));
            }
        }
        catch (Exception ignored) { }
    }

    public ArrayList<Arena> getArenas() {
        return arenas;
    }

    public Arena getArena(int id) {
        for (Arena a : arenas) {
            if (a.getID() == id) return a;
        }
        return null;
    }
    public Arena getArena(Player p) {
        for (Arena a : arenas) {
            if (a.containsPLayer(p)) return a;

        }
        return null;

    }
    /**
     * ids:
     * -1
     *  arena 1 :
     *  redspawn :
     *  world
     *  x:
     *  y:
     *  z:
     *  bluespawn
     *  world:
     *  x:
     *  y:
     *  z:
     */








    /**
     *  key: id
     *  redspawn
     *  bluespwan
     */


}
