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
			if (sender.hasPermission("smartessentials.feed") || sender.hasPermission("smartessentials.feed.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (player.getFoodLevel() == 20) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your hunger bar is already fully replenished.");
					}else{
						player.setFoodLevel(20);
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your hunger bar has been replenished.");
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /feed <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.feed")) {
				Player player = (Player) Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
				}else{
					if (player == sender) {
						player = (Player) sender;
						if (player.getFoodLevel() == 20) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Your hunger bar is already fully replenished.");
						}else{
							player.setFoodLevel(20);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your hunger bar has been replenished.");
						}
					}else{
						if (player.getFoodLevel() == 20) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + "'s hunger is already fully replenished.");
						}else{
							player.setFoodLevel(20);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + "'s hunger has been replenished.");
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your hunger bar has been replenished.");
						}
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.feed")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to feed yourself.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.feed.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /feed [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /feed <player>");
				}
			}else{
				if (sender.hasPermission("smartessentials.feed")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /feed");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		return false;
	}
}
