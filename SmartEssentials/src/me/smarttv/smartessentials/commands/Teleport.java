package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.teleport.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. /tp <player> [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. /tp <player> <player>");
				}
			}else{
				if (sender.hasPermission("smartessentials.teleport.self")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. /tp <player>");
				}
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.teleport.self") || sender.hasPermission("smartessentials.telport.other")) {
				if (sender instanceof Player) {
					Player target = Bukkit.getPlayer(args[0]);
					Player player = (Player) sender;
					if (target == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
					}else{
						if (target.hasPermission("smartessentials.teleport.disabled")) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " has teleportation disabled.");
						}else{
							(player).teleport(target);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Teleported to " + target.getName() + ".");
						}
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to teleport to another player. Usage: /tp <player> <target>");
				}
			}else{
				sender.sendMessage("");
			}
		}
		if (args.length == 2) {
			if (sender.hasPermission("smartessentials.teleport.other")) {
				Player target = Bukkit.getPlayer(args[1]);
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("");
				}else{
					if (target == null) {
						sender.sendMessage("");
					}else{
						if (target.hasPermission("smartessentials.teleport.disabled")) {
							sender.sendMessage("");
						}else{
							(player).teleport(target);
							sender.sendMessage("");
						}
					}
				}
			}
		}
		if (args.length == 3) {
			if (sender.hasPermission("smartessentials.teleport.coordinates")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					player.teleport(new Location(player.getWorld(), args[0], args[1], args[2]));
				}else{
					sender.sendMessage("");
				}
			}else{
				sender.sendMessage("");
			}
		}
	return false;
	}
}
