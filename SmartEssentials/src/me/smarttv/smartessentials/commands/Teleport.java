package me.smarttv.smartessentials.commands;

import java.io.File;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.smarttv.smartessentials.main;

public class Teleport implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.teleport.other") || sender.hasPermission("smartessentials.teleport.override")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. /tp <player> [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. /tp <player> <player>");
				}
			}else{
				if (sender.hasPermission("smartessentials.teleport")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. /tp <player>");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.teleport") || sender.hasPermission("smartessentials.telport.other") || sender.hasPermission("smartessentials.teleport.override")) {
				if (sender instanceof Player) {
					Player target = Bukkit.getPlayer(args[0]);
					Player player = (Player) sender;
					if (target == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
					}else{
						UUID id = target.getUniqueId();
						File playerFile = main.inst().getPlayerFile(id);
						FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
						if(playerData.getBoolean("teleportation-disabled") == true) {
							if (sender.hasPermission("smartessentials.teleport.override")) {
								(player).teleport(target);
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§e§o Override§7 Teleported to " + target.getName() + ".");
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c That player has teleportation disabled.");
							}
							
						}else{
							(player).teleport(target);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Teleported to " + target.getName() + ".");
						}
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /tp <player> <targetplayer>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 2) {
			if (sender.hasPermission("smartessentials.teleport.other") || sender.hasPermission("smartessentials.teleport.override")) {
				Player target = Bukkit.getPlayer(args[1]);
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					if (target == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " and " + args[1] + " are not valid players.");
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
					}
				}else{
					if (target == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[1] + " is not a valid player.");
					}else{
						UUID id = target.getUniqueId();
						File playerFile = main.inst().getPlayerFile(id);
						FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
						if (playerData.getBoolean("teleportation-disabled") == true) {
							if (sender.hasPermission("smartessentials.teleport.override")) {
									(player).teleport(target);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§e§o Override§7 Teleported " + player.getName() + " to " + target.getName() + ".");
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c That player has teleportation disabled.");
							}
						}else{
							if (!player.hasPermission("smartessentials.teleport.exempt")) {
								(player).teleport(target);
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Teleported " + player.getName() + " to " + target.getName() + ".");
							}else{
								if (sender.hasPermission("smartessentials.teleport.override")) {
									(player).teleport(target);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§e§o Override§7 Teleported " + player.getName() + " to " + target.getName() + ".");
								}
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c That player is exempt from being teleported.");
							}
						}
					}
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length > 2) {
			if (sender instanceof Player) {
				if (sender.hasPermission("smartessentials.teleport.other") || sender.hasPermission("smartessentials.teleport.override")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /tp [player] <targetplayer>");
				}else{
					if (sender.hasPermission("smartessentials.teleport")) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /tp <player>");
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
					}
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /tp <player> <targetplayer>");
			}
		}
	return false;
	}
}
