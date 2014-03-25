package com.plugin.test;

import java.io.File;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
     
public final class Main extends JavaPlugin {
    
    FileConfiguration config;
    File Races = new File ("plugins" + File.separator + "Races" + File.separator + "config.yml");
    
    @Override
    public void onEnable(){
        
        FileConfiguration config;
 
        if(!new File(getDataFolder(), "config.yml").exists()){
            // saveResource(String filePath, boolean replaceIfExists)
            saveResource("config.yml", false);
            getLogger().info("Generating a new config for you.");
        }
        else{
            config = getConfig();
            getLogger().info("Config found. Using it.");
        }
    }
    
    @Override
    public void onDisable(){
        //
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        CommandSender player = sender;
        if(cmd.getName().equalsIgnoreCase("race"))
        {
            switch (args.length)
            {
                case (0):
                {
                    player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list}");
                    break;
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
                        break;
                        }
                        case ("get"):
                        {   
                            if (player.hasPermission("race.get"))
                            {
                                player.sendMessage(ChatColor.RED + "Usage: /race get [player]");
                            }
                            else
                            {   
                                player.sendMessage(ChatColor.RED + "You do not have permission");
                                return false;
                            }
                            break;
                        }
                        case ("set"):
                        {
                            if (player.hasPermission("race.set"))
                            {
                                player.sendMessage(ChatColor.RED + "Usage: /race set [player] [race]");
                            }
                            else
                            {   
                                player.sendMessage(ChatColor.RED + "You do not have permission");
                                return false;
                            }
                            break;
                        }
                        default:
                        {
                            player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list} [player] [race]");
                            break;
                        }
                    }    
                    break;                
                }
                case (2):
                {
                    switch (args[0])
                    {
                        case ("get"):
                        {
                            if (player.hasPermission("race.get"))
                            {
                                player.sendMessage(ChatColor.RED + "Code to get a player's race goes here!!!");
                            }
                            else
                            {   
                                player.sendMessage(ChatColor.RED + "You do not have permission");
                                return false;
                            }
                            break;
                        }
                        case ("set"):
                        {
                            if (player.hasPermission("race.set"))
                            {
                                player.sendMessage(ChatColor.RED + "Usage: /race set " + args[1] + " [race]");
                            }
                            else
                            {   
                                player.sendMessage(ChatColor.RED + "You do not have permission");
                                return false;
                            }
                            break;
                        }
                        default:
                        {
                            player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list}");
                            break;
                        }
                    }
                    break;
                }
                case (3):
                {
                    switch (args[0])
                    {
                        case ("set"):
                        {
                            if (player.hasPermission("race.set"))
                            {
                                player.sendMessage(ChatColor.RED + "Code to set a player's race goes here!!!");
                            }
                            else
                            {   
                                player.sendMessage(ChatColor.RED + "You do not have permission");
                                return false;
                            }
                            break;
                        }
                        default:
                        {
                            player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list}");
                            break;
                        }
                    }
                    break;
                }
                default:
                {
                    player.sendMessage(ChatColor.RED + "Usage: /race {get/set/list}");
                    break;
                }
            }
        }
        return false;
    }
}
