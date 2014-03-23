package com.plugin.test;
     
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
     
public final class Main extends JavaPlugin {

    public void onEnable(){
        getLogger().info("Disabled!");
    }
 
    public void onDisable(){
        getLogger().info("Enabled!");
    }
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        CommandSender player = sender;
        if(cmd.getName().equalsIgnoreCase("race"))
        {
            switch (args.length)
            {
                case (0):
                {
                    player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list}");
                }
                case (1):
                {
                    switch (args[0])
                    {
                        case ("list"):
                        {
                            player.sendMessage("Races:");
                            player.sendMessage(" - Human");
                            player.sendMessage(" - Elf");
                            player.sendMessage(" - Dwarf");
                            player.sendMessage(" - Orc");
                            player.sendMessage(" - (Later on) Gnome");
                        }
                        case ("get"):
                            player.sendMessage(ChatColor.RED + "Usage: /race get [player]");
                        case ("set"):
                            player.sendMessage(ChatColor.RED + "Usage: /race set [player] [race]");
                        default:
                            player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list} [player] [race]");
                    }
                }
            }
        }
        return false;
    }
}
