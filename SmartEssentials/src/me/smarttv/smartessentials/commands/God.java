package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.smarttv.smartessentials.main;

public class God implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.god.own") || sender.hasPermission("smartessentials.god.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (main.inst().getConfig().getString("permission-removing-command") == null || main.inst().getConfig().getString("permission-adding-command") == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 This command is not configured properly. Message a server admin.");
					}else{
						if (sender.hasPermission("smartessentials.is.in.god.mode")) {
							String command1 = main.inst().getConfig().getString("permissions-removing-command");
							command1 = command1.replace("$PLAYER$", player.getName());
							command1 = command1.replace("$PERMISSION$", "smartessentials.is.in.god.mode");
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command1);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are no longer in god mode.");
						}else{
							String command1 = main.inst().getConfig().getString("permissions-adding-command");
							command1 = command1.replace("$PLAYER$", player.getName());
							command1 = command1.replace("$PERMISSION$", "smartessentials.is.in.god.mode");
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command1);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are now in god mode.");
						}
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to go into god mode. Usage: /god <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.god.other")) {
					Player player = Bukkit.getPlayer(args[0]);
					if (main.inst().getConfig().getString("permission-removing-command") == null || main.inst().getConfig().getString("permission-adding-command") == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 This command is not configured properly. Message a server admin.");
					}else{
						if (player == null) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
						}else{
							if (player.hasPermission("smartessentials.is.in.god.mode")) {
								String command1 = main.inst().getConfig().getString("permissions-removing-command");
								command1 = command1.replace("$PLAYER$", player.getName());
								command1 = command1.replace("$PERMISSION$", "smartessentials.is.in.god.mode");
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command1);
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You removed " + player.getName() + "'s god mode.");
								player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " has removed your god mode.");
							}else{
								String command1 = main.inst().getConfig().getString("permissions-adding-command");
								command1 = command1.replace("$PLAYER$", player.getName());
								command1 = command1.replace("$PERMISSION$", "smartessentials.is.in.god.mode");
								Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command1);
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You gave god mode to " + player.getName() + ".");
								player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " has gave you god mode.");
							}
						}
					}
			}else{
				if (sender.hasPermission("smartessentials.god.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to give yourself god mode.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (sender instanceof Player) {
				if (sender.hasPermission("smartessentials.god.other")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /god [player]");
				}else{
					if (sender.hasPermission("smartessentials.god.own")) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /god");
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
					}
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /god <player>");
			}
		}
	return false;
	}
}
