package me.chocoaa.paintball;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * Created by Chocoaa on 28/04/2016.
 */
public class MessageManager {

    private MessageManager() {  }

    private static MessageManager instance = new MessageManager();

    public static MessageManager getInstance() {
        return instance;
    }

    private String prefix = org.bukkit.ChatColor.GREEN + "[" + org.bukkit.ChatColor.BLUE + "Paintball" + org.bukkit.ChatColor.GREEN + "]" ;

    public void severe(CommandSender s, String msg) {
        msg(s, ChatColor.YELLOW, msg);
    }

    public void info(CommandSender s, String msg) {
        msg(s, ChatColor.RED, msg);
    }
    public void good(CommandSender s, String msg) {
        // if commands run successfully then send a message
        msg(s, ChatColor.GREEN, msg);
    }



    private void msg (CommandSender s, ChatColor color, String msg) {
        s.sendMessage(prefix + color + msg);
    }
}
