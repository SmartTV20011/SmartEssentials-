package me.smarttv.smartessentials.commands;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.smarttv.smartessentials.main;

public class God implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.god") || sender.hasPermission("smartessentials.god.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					UUID id = player.getUniqueId();
					File playerFile = main.inst().getPlayerFile(id);
					FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
					if (playerData.getBoolean("god") == true) {
						playerData.set("god", false);
						try {
				            playerData.save(playerFile);
				        } catch (IOException e) {
				            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
				            e.printStackTrace();
				        }
						player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are no longer in god mode.");
					}else{
						playerData.set("god", true);
						try {
				            playerData.save(playerFile);
				        } catch (IOException e) {
				            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
				            e.printStackTrace();
				        }
						player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are now in god mode.");
					}
					
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /god <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.god.other")) {
				Player player = Bukkit.getPlayer(args[0]);
						if (player == null) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
						}else{
							UUID id = player.getUniqueId();
							File playerFile = main.inst().getPlayerFile(id);
							FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
							if (playerData.getBoolean("god") == true) {
								playerData.set("god", false);
								try {
						            playerData.save(playerFile);
						        } catch (IOException e) {
						            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
						            e.printStackTrace();
						        }
								if (player == sender) {
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are no longer in god mode.");
								}else{
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are no longer in god mode.");
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You removed god mode from " + player.getName() + ".");
								}
							}else{
								playerData.set("god", true);
								try {
						            playerData.save(playerFile);
						        } catch (IOException e) {
						            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
						            e.printStackTrace();
						        }
								if (player == sender) {
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are now in god mode.");
								}else{
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are now in god mode.");
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You gave " + player.getName() + " god mode.");
								}
							}
						}	
			}else{
				if (sender.hasPermission("smartessentials.god")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to give yourself god mode.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (sender instanceof Player) {
				if (sender.hasPermission("smartessentials.god.other")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /god [player]");
				}else{
					if (sender.hasPermission("smartessentials.god")) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /god");
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
					}
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /god <player>");
			}
		}
	return false;
	}

}
