package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sudo implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0 || args.length == 1) {
			if (sender.hasPermission("smartessentials.sudo.command")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. Usage: /sudo <player> <[<command> | c:<message>]>");
			}else{
				if (sender.hasPermission("smartessentials.sudo.chat")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. Usage: /sudo <player> <[c:<message>]>");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (args[1].startsWith("c:")) {
				if (sender.hasPermission("smartessentials.sudo.chat") || sender.hasPermission("smartessentials.sudo.command")) {
					Player player = Bukkit.getPlayer(args[0]);
					if (player == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
					}else{
						StringBuilder command1 = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
							command1.append(args[i]);
							command1.append(" ");
						}
						String com = command1.toString();
						com = com.replace("c:", "");
						player.chat(com);
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}else{
				if (sender.hasPermission("smartessentials.sudo.command")) {
					Player player = Bukkit.getPlayer(args[0]);
					if (player == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
					}else{
						StringBuilder command1 = new StringBuilder();
						for (int i = 1; i < args.length; i++) {
							command1.append(args[i]);
							command1.append(" ");
						}
						String com = command1.toString();
						Bukkit.getServer().dispatchCommand(player, com);
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
	return false;
	}
}
