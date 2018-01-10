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

public class Tptoggle implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				if (sender.hasPermission("smartessentials.tptoggle.other") || sender.hasPermission("smartessentials.tptoggle")) {
					Player player = (Player) sender;
					UUID id = player.getUniqueId();
					File playerFile = main.inst().getPlayerFile(id);
					FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
						if (playerData.getBoolean("teleportation-disabled") == true) {
							playerData.set("teleportation-disabled", false);
							try {
					            playerData.save(playerFile);
					        } catch (IOException e) {
					            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
					            e.printStackTrace();
					        }
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your teleportation is now enabled.");
						}else{
							playerData.set("teleportation-disabled", true);
							try {
					            playerData.save(playerFile);
					        } catch (IOException e) {
					            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
					            e.printStackTrace();
					        }
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your teleportation is now disabled.");
						}
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
					}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /tptoggle <player>");
			}
			
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.tptoggle.other")) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
				}else{
					UUID id = player.getUniqueId();
					File playerFile = main.inst().getPlayerFile(id);
					FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
						if (playerData.getBoolean("teleportation-disabled") == true) {
							playerData.set("teleportation-disabled", false);
							try {
					            playerData.save(playerFile);
					        } catch (IOException e) {
					            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
					            e.printStackTrace();
					        }
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your teleportation is now enabled.");
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You enabled teleportation for " + player.getName() + ".");
						}else{
							playerData.set("teleportation-disabled", true);
							try {
					            playerData.save(playerFile);
					        } catch (IOException e) {
					            Bukkit.getServer().getLogger().severe("Could not save " + player.getName() + "'s data file!");
					            e.printStackTrace();
					        }
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your teleportation is now disabled.");
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You disabled teleportation for " + player.getName() + ".");
						}
					}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length > 1) {
			
		}
	return false;
	}
}
