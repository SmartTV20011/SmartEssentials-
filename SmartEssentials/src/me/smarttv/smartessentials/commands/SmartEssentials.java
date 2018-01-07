package me.smarttv.smartessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import me.smarttv.smartessentials.main;

public class SmartEssentials implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 SmartEssentials is running in version " + main.inst().getDescription().getVersion());
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("reload")) {
				if (sender.hasPermission("smartessentials.config.reload")) {
					main.inst().getConfig().options().copyDefaults(true);
					main.inst().saveDefaultConfig();
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The configuration file has been reloaded succesfully!");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 SmartEssentials is running in version " + main.inst().getDescription().getVersion());
				}
			}
		}
		if (args.length > 1) {
			sender.sendMessage("§8[§b§lSmart§a§Essentials§]§7 SmartEssentials is running in version " + main.inst().getDescription().getVersion());
		}
		return false;
	}

}
