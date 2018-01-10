package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kill implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.kill") || sender.hasPermission("smartessentials.kill.override")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /kill <player>");
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.kill") || sender.hasPermission("smartessentials.kill.override")) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
				}else{
					if (player.hasPermission("smartessentials.kill.exempt")) {
						if (sender.hasPermission("smartessentials.kill.override")) {
							player.setHealth(0.00D);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§e§o Override§7 You killed " + player.getName() + ".");
						}else{
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c You cannot kill this player.");
						}
					}else{
						player.setHealth(0.00D);
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You killed " + player.getName() + ".");
					}
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.kill") || sender.hasPermission("smartessentials.kill.override")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. /kill <player>");
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
	return false;
	}
}
