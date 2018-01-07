package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.feed.own") || sender.hasPermission("smartessentials.feed.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (player.getFoodLevel() == 20) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your food level is already fully replenished.");
					}else{
						player.setFoodLevel(20);
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your food level has been replenished.");
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to feed yourself. Usage: /feed <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.feed.other")) {
				Player player = (Player) Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
				}else{
					if (player == sender) {
						player = (Player) sender;
						if (player.getFoodLevel() == 20) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your food level is already fully replenished.");
						}else{
							player.setFoodLevel(20);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your food level has been replenished.");
						}
					}else{
						if (player.getFoodLevel() == 20) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + "'s food level is already fully replenished.");
						}else{
							player.setFoodLevel(20);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + "'s food level has been replenished.");
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your food level has been replenished by " + sender.getName() + ".");
						}
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.feed.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to feed yourself.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.feed.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /feed [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /feed <player>");
				}
			}else{
				if (sender.hasPermission("smartessentials.feed.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /feed");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		return false;
	}
}
