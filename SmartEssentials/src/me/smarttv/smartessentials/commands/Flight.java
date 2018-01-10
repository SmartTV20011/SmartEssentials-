package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Flight implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (sender.hasPermission("smartessentials.fly") || sender.hasPermission("smartessentials.fly.other")) {
					if (player.getAllowFlight()) {
						player.setAllowFlight(false);
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your flight has been disabled.");
					}else{
						player.setAllowFlight(true);
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your flight has been enabled.");
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too little arguments. Usage: /fly <player>");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.fly.other")) {
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c " + args[0] + " is not a valid player.");
				}else{
					if (player == sender) {
						player = (Player) sender;
							if (sender.hasPermission("smartessentials.fly") || sender.hasPermission("smartessentials.fly.other")) {
								if (player.getAllowFlight()) {
									player.setAllowFlight(false);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your flight has been disabled.");
								}else{
									player.setAllowFlight(true);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your flight has been enabled.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}	
					}else{
						if (player.getAllowFlight()) {
							player.setAllowFlight(false);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You have disabled flight for " + player.getName() + ".");
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your flight has been disabled.");
						}else{
							player.setAllowFlight(true);
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You have enabled flight for " + player.getName() + ".");
							player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your flight has been enabled.");
						}
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.fly")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to toggle your own flight mode.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.fly.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /fly [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /fly <player>");
				}	
			}else{
				if (sender.hasPermission("smartessentials.fly")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§c Too many arguments. Usage: /fly");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		return false;
	}
}
