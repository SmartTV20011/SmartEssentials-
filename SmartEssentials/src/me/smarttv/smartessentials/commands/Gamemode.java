package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.gamemode") || sender.hasPermission("smartessentials.gamemode.all")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. Usage: /gamemode <gamemode> [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too little arguments. Usage: /gamemode <gamemode> <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.gamemode")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (args[0].equalsIgnoreCase("survival") ||
						args[0].equalsIgnoreCase("s") ||
						args[0].equalsIgnoreCase("0") ||
						args[0].equalsIgnoreCase("creative") ||
						args[0].equalsIgnoreCase("c") ||
						args[0].equalsIgnoreCase("1") ||
						args[0].equalsIgnoreCase("adventure") ||
						args[0].equalsIgnoreCase("a") ||
						args[0].equalsIgnoreCase("2") ||
						args[0].equalsIgnoreCase("spectator") ||
						args[0].equalsIgnoreCase("sp") ||
						args[0].equalsIgnoreCase("3")) {
						if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
							if (sender.hasPermission("smartessentials.gamemode.survival") || sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.SURVIVAL) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are already in survival mode.");
								}else{
									player.setGameMode(GameMode.SURVIVAL);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your gamemode was set to survival.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}
						if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
							if (sender.hasPermission("smartessentials.gamemode.creative") || sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.CREATIVE) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are already in creative mode.");
								}else{
									player.setGameMode(GameMode.CREATIVE);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your gamemode was set to creative.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}
						if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
							if (sender.hasPermission("smartessentials.gamemode.adventure") || sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.ADVENTURE) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are already in adventure mode.");
								}else{
									player.setGameMode(GameMode.ADVENTURE);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your gamemode was set to adventure.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}
						if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
							if (sender.hasPermission("smartessentials.gamemode.spectator") || sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.SPECTATOR) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You are already in spectator mode.");
								}else{
									player.setGameMode(GameMode.SPECTATOR);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 Your gamemode was set to spectator.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}	
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid sub command.");
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to change your gamemode. Usage: /gamemode <gamemode> <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 2) {
			if (sender.hasPermission("smartessentials.gamemode") || sender.hasPermission("smartessentials.gamemode.all")) {
				Player player = Bukkit.getPlayer(args[1]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[1] + " is not a valid player.");
				}else{
					if (args[0].equalsIgnoreCase("survival") ||
						args[0].equalsIgnoreCase("s") ||
						args[0].equalsIgnoreCase("0") ||
						args[0].equalsIgnoreCase("creative") ||
						args[0].equalsIgnoreCase("c") ||
						args[0].equalsIgnoreCase("1") ||
						args[0].equalsIgnoreCase("adventure") ||
						args[0].equalsIgnoreCase("a") ||
						args[0].equalsIgnoreCase("2") ||
						args[0].equalsIgnoreCase("spectator") ||
						args[0].equalsIgnoreCase("sp") ||
						args[0].equalsIgnoreCase("3")) {
						if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("0")) {
							if (sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.SURVIVAL) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + " is already in survival mode.");
								}else{
									player.setGameMode(GameMode.SURVIVAL);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You set " + player.getName() + "'s gamemode to survival.");
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " set your gamemode to survival.");
									
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}
						if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("1")) {
							if (sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.CREATIVE) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + " is already in creative mode.");
								}else{
									player.setGameMode(GameMode.CREATIVE);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You set " + player.getName() + "'s gamemode to creative.");
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " set your gamemode to creative.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}
						if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("2")) {
							if (sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.ADVENTURE) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + " is already in adventure mode.");
								}else{
									player.setGameMode(GameMode.ADVENTURE);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You set " + player.getName() + "'s gamemode to adventure.");
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " set your gamemode to adventure.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}
						if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("3")) {
							if (sender.hasPermission("smartessentials.gamemode.all")) {
								if ((player).getGameMode() == GameMode.SPECTATOR) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + " is already in spectator mode.");
								}else{
									player.setGameMode(GameMode.SPECTATOR);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You set " + player.getName() + "'s gamemode to spectator.");
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " set your gamemode to spectator.");
								}
							}else{
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
							}
						}	
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid sub command.");
					}
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length > 2) {
			if (sender.hasPermission("smartessentials.gamemode") || sender.hasPermission("smartessentials.gamemode.all")) {
				if (sender instanceof Player) {
					if (sender.hasPermission("smartessentials.gamemode.other")) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /gamemode <gamemode> [player]");
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /gamemode <gamemode>");
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /gamemode <gamemode> <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
	return false;
	}
}
