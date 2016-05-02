package me.chocoaa.paintball;

import org.bukkit.*;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


import java.util.ArrayList;




/**
 * Created by Chocoaa on 27/04/2016.
 */
public class Arena {

    private int id;
    private Location redspawn, bluespawn;
    private boolean started = false;
    private boolean cd = false;
    private ArrayList<PlayerData> players = new ArrayList<PlayerData>();
    private Scoreboard sb;
    private Objective o;
    private Score red, blue;

@SuppressWarnings("deprecation")
    public Arena(int id) {
        this.id = id;

        ConfigurationSection conf = SettingsManager.getInstance().get(id + "");

        this.redspawn = getLocation(conf.getConfigurationSection("redspawn"));
        this.bluespawn = getLocation(conf.getConfigurationSection("bluespawn"));

        sb = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
        o = sb.registerNewObjective("Team Scores", "dummy");
        red = o.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.RED + "Red"));
        blue = o.getScore(Bukkit.getServer().getOfflinePlayer(ChatColor.BLUE + "Blue"));


    }
    private Location getLocation(ConfigurationSection path) {
       return new Location (
                Bukkit.getServer().getWorld(path.getString("world")),
               path.getDouble("x"),
               path.getDouble("y"),
               path.getDouble("z")
       );
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

    public int getID() {
        return id;
    }

    public boolean isStarted() {
        return started;

    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public Location getSpawn(ArenaManager.Team team) {
        switch(team) {
            case RED: return redspawn;
            case BLUE: return bluespawn;
            default: return null;

        }

    }

    public ArenaManager.Team getTeam(Player p) {
        return getData(p).getTeam();

    }

    public void addPlayer(Player p) {
        players.add(new PlayerData(p.getName(), getTeamWithlessPlayers(), p.getInventory().getContents(), p.getInventory().getArmorContents(), p.getLocation()));
        // Inventory
        p.getInventory().clear();
        p.getInventory().addItem(new ItemStack(Material.SNOW_BALL, 1));
        p.getInventory().setHelmet(new Wool(DyeColor.valueOf(getData(p).getTeam().toString())).toItemStack(1));
        // saving data
        // Teleport
        p.teleport(getSpawn(getData(p).getTeam()));
        // Could add coloured armour or wool helmets
        p.setScoreboard(sb);
        p.setGameMode(GameMode.SURVIVAL);
        p.setFlying(false);

        MessageManager.getInstance().info(p, "You have joined arena " + getID() + " and are on the " + org.bukkit.ChatColor.valueOf(getData(p).getTeam().toString()) + getData(p).getTeam().toString().toLowerCase() + org.bukkit.ChatColor.YELLOW + " team!");

        if (players.size() >= 2 && !cd) start();


    }

    public void removePlayer(Player p, boolean lost) {
        PlayerData pd = getData(p);

        p.getInventory().clear();
        for (ItemStack i : pd.getContents()) if (i != null)
        p.getInventory().addItem(i);
        p.getInventory().setArmorContents(pd.getArmorContents());
        p.teleport(pd.getLocation());
        p.setScoreboard(null);
        players.remove(pd);

        if(lost) {
            MessageManager.getInstance().info(p, "You lost te game.");
            msg(p.getName() + " lost the game.");

        }


    }

    public void start() {
        cd = true;
        msg("Game starting in 30 seconds!");


        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(SettingsManager.getInstance().getPlugin(), new Runnable() {
            @Override
            public void run() {
                Arena.this.started = true;
                Arena.this.cd = false;
                // STill inside arena class so we can call arena .this
                // note this wont work in any other class
                msg("Good luck!");


            }
        }, 30 * 20);

    }

    public void stop(Player winner) {
        msg(winner != null ?  winner.getName() + " won the game!" : "The game was ended.");
        for (PlayerData pd : players) {
            Player p = Bukkit.getServer().getPlayer(pd.getPlayerName());
            removePlayer(p, true);

        }

    }
    public void addDeath(Player p) {
        ArenaManager.Team t = getTeam(p);
        if (t == ArenaManager.Team.RED) blue.setScore(blue.getScore() + 1);
        else red.setScore(red.getScore() + 1);


    }
    private void msg(String msg) {
        for (PlayerData pd : players) {
            Player p = Bukkit.getServer().getPlayer(pd.getPlayerName());
            MessageManager.getInstance().info(p, msg);
        }
    }


    private ArenaManager.Team getTeamWithlessPlayers() {
        int red = 0, blue = 0;
        for (PlayerData pd : players) {
            if (pd.getTeam() == ArenaManager.Team.RED) red++;
            else blue++;
        }
        if (red > blue) return ArenaManager.Team.BLUE;
        else return ArenaManager.Team.RED;
    }

    public boolean containsPLayer(Player p) {
        return getData(p) != null;
    }

    private PlayerData getData(Player p) {
        for (PlayerData pd : players) {
            if (pd.getPlayerName().equalsIgnoreCase(p.getName()))
                return pd;
        }
        return null;
    }


}
