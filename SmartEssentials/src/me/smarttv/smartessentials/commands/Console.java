package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Console implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.console")) {
				
			}
		}
		if (args.length > 0) {
			if (sender.hasPermission("smartessentials.console")) {
				StringBuilder input = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					input.append(args[i]);
					input.append(" ");
				}
				String com = input.toString();
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), com);
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Command dispatched: " + com);
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		return false;
	}
}


// getServer().dispatchCommand(getServer().getConsoleSender(), "game start");
