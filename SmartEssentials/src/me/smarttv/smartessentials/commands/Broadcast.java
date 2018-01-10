package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.smarttv.smartessentials.main;

public class Broadcast implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.server.broadcast")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /broadcast <message>");
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length > 0) {
			if (sender.hasPermission("smartessentials.server.broadcast")) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					sb.append(args[i]);
					sb.append(" ");
				}
				String broadcast = sb.toString();
				broadcast = ChatColor.translateAlternateColorCodes('&', broadcast);
				String prefix;
				prefix = ChatColor.translateAlternateColorCodes('&', main.inst().getConfig().getString("broadcast-prefix"));
				Bukkit.getServer().broadcastMessage(prefix + broadcast);
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
	return false;
	}
}
