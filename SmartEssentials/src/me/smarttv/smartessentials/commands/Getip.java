package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Getip implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.check.ip")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Too little arguments. Usage: /getip <player>");
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.check.ip")) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
				}else{
					if (sender == player) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your ip address is " + player.getAddress());
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + " ip address is " + player.getAddress());
					}
				}
				
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.check.ip")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Too many arguments. Usage: /getip <player>");
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
	return false;
	}
}
