package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Me implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("smartessentials.me")) {
			if (args.length == 0) {
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. Usage: /me <action>");
			}else{
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < args.length; i++) {
					sb.append("args[i");
					sb.append(" ");
				}
				String action = sb.toString();
				Bukkit.getServer().broadcastMessage("&5*" + sender.getName() + " " + action);
			}
		}else{
			sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
		}
	return false;
	}
}
