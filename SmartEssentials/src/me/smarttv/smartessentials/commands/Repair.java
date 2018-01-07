package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Repair implements CommandExecutor {
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.repair.own") || sender.hasPermission("smartessentials.repair.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (player.getInventory().getItemInHand().getType() == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You cannot repair that item.");
					}else{
						if (player.getInventory().getItemInHand().getType() == org.bukkit.Material.AIR) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You're not holding anything to repair.");
						}else{
							if (player.getItemInHand().getDurability() == 0) {
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item that you are holding is already fully repaired..");
							}else{
								player.getItemInHand().setDurability((short) 0);
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item in your hand has been repaired.");
							}
						}
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to repair the items in your hand. Usage: /repair <player>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.repair.other")) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
				}else{
					if (player == sender) {
						player = (Player) sender;
						if (player.getInventory().getItemInHand().getType() == null) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You cannot repair that item.");
						}else{
							if (player.getInventory().getItemInHand().getType() == org.bukkit.Material.AIR) {
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You're not holding anything to repair.");
							}else{
								if (player.getItemInHand().getDurability() == 0) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item in your hand is already fully repaired.");
								}else{
									player.getItemInHand().setDurability((short) 0);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item in your hand has been repaired.");
								}
							}
						}
					}else{
						if (player.getInventory().getItemInHand().getType() == null) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item that " + player.getName() + " is holding cannot be repaired.");
						}else{
							if (player.getInventory().getItemInHand().getType() == org.bukkit.Material.AIR) {
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + player.getName() + " is not holding anything to be repaired.");
							}else{
								if (player.getItemInHand().getDurability() == 0) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item that " + player.getName() + " is holding is already fully repaired.");
								}else{
									player.getItemInHand().setDurability((short) 0);
									player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item in your hand has been repaired by " + sender.getName() + ".");
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item in " + player.getName() + "'s hand has been repaired.");
								}
							}
						}
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.repair.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to repair your own items.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		/*if (args.length == 2) {
			if (sender.hasPermission("smartessentials.repair.other")) {
				Player player = Bukkit.getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
				}else{
					int slot = Integer.parseInt(args[1]);
					if (slot >= 0 || slot < 46) {
						if (player.getInventory().getItem(slot).getType() == null) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[1] + " is null.");
						}else{
							if (player.getInventory().getItem(slot).getType() == Material.AIR) {
								sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + args[1] + " is an empty inventory slot.");
							}else{
								if (player.getInventory().getItem(slot).getDurability() == 0) {
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The item in this slot is already fully repaired.");
								}else{
									player.getInventory().getItem(slot).setDurability((short) 0);
									sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You have repaired " + player.getName() + "'s " + player.getInventory().getItem(slot).getType() + ".");
								}
							}
						}
					}else{
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[1] + " is not a valid inventory slot. Try 0-45 or 9-45.");
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.repair.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to repair your own items.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}*/
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.repair.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /repair [player]");
				}
			}else{
				if (sender.hasPermission("smartessentials.repair.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /repair <player>");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		return false;
	}
}
