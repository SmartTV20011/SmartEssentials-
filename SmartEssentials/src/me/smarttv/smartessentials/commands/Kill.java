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
			if (sender.hasPermission("smartessentials.kill.other")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Too little arguments. Usage: /kill <player> or /suicide");
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.kill.other")) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
				}else{
					player.setHealth(0.00D);
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You killed " + player.getName() + ".");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.kill.other")) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. /kill <player>");
			}
		}
	return false;
	}
}
