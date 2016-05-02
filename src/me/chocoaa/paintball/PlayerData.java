package me.chocoaa.paintball;

import net.minecraft.server.v1_9_R1.PlayerInventory;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;

/**
 * Created by AhmedAbdulai on 01/05/2016.
 */
public class PlayerData {

    private String player;
    private ArenaManager.Team team;
    private PlayerInventory inv;
    private Location loc;
    private ItemStack[] contents, armorContents;

    public PlayerData(String player, ArenaManager.Team team, ItemStack[] itemStacks, ItemStack[] contents, Location loc) {
        this.player = player;
        this.team = team;
        this.contents = contents;
        this.armorContents = armorContents;
        this.loc = loc;

    }


    public String getPlayerName() {
        return player;

    }

    public ArenaManager.Team getTeam() {
        return team;
    }

    public ItemStack[] getContents() {
        return contents;
    }

    public ItemStack[] getArmorContents() {
        return armorContents;
    }

    public PlayerInventory getInventory() {
        return inv;

    }

    public Location getLocation() {
        return loc;
    }


}
