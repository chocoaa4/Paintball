package me.chocoaa.paintball;

import me.chocoaa.paintball.Listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Chocoaa on 27/04/2016.
 */
public class Paintball extends JavaPlugin {

    public void onEnable() {

        SettingsManager.getInstance().setup(this);

        ArenaManager.getInstance().setup();

        CommandManager cm = new CommandManager();
        cm.setup();
        getCommand("paintball").setExecutor(cm);

        Bukkit.getServer().getPluginManager().registerEvents(new ArmorRemove(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new BlockBreak(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new LobbySign(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerDamage(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerAttack(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeath(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeave(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerLooseHunger(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new SnowballListeners(), this );
        Bukkit.getServer().getPluginManager().registerEvents(new PaintballJoin(), this);
    }

    public void onDisable() {
        for (Arena a : ArenaManager.getInstance().getArenas()) {
            a.stop(null);

        }


    }



}
