package me.chocoaa.paintball;


import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;


/**
 * Created by Chocoaa on 30/04/2016.
 */
public class SettingsManager {

    private SettingsManager() { }

    private static SettingsManager instance = new SettingsManager();

    public static SettingsManager getInstance() {
        return instance;

    }

    private FileConfiguration arenas;
    private File afile;
    private Plugin p;

    public void setup(Plugin p) {

        this.p = p;
        if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();

        afile = new File(p.getDataFolder(), "arenas.yml");

         boolean n = false;
        if (n) set("ids", new ArrayList<String>());


        if (!afile.exists()) {
            try { afile.createNewFile(); n = true; }
            catch (Exception e) {e.printStackTrace(); }

        }

        arenas = YamlConfiguration.loadConfiguration(afile);

    }




    public <T> T get(String path) {
        return (T) arenas.get(path);
    }





    public void set(String path, Object value) {
        arenas.set(path, value);
         save();
    }

    public ConfigurationSection createConfigurationSection(String path) {
        ConfigurationSection s = arenas.createSection(path);
        save();
        return s;
    }







    private void save() {
        try { arenas.save(afile); }
        catch (Exception e ) {e.printStackTrace(); }

    }

    public Plugin getPlugin() {
        return p;

    }

}

