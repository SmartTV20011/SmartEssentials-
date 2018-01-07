package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hat implements CommandExecutor {
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.hat.own") || sender.hasPermission("smartessentials.hat.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if ((player).getInventory().getItemInHand().getType() == Material.AIR || (player).getInventory().getItemInHand().getType() == null)
		            {
		              sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You're not holding anything in your hand to put on your head.");
		            }
		            else if ((player).getInventory().getHelmet() != null)
		            {
		              ItemStack hat = (player).getInventory().getHelmet();
		              (player).getInventory().setHelmet((player).getInventory().getItemInHand());
		              (player).getInventory().remove((player).getInventory().getItemInHand());
		              (player).getInventory().addItem(new ItemStack[] { hat });
		              sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The block in your hand has been put on your head.");
		            }
		            else if ((player).getInventory().getHelmet() == null)
		            {
		              (player).getInventory().setHelmet((player).getInventory().getItemInHand());
		              (player).getInventory().remove((player).getInventory().getItemInHand());
		              sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The block in your hand has been put in your head.");
		            }
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to use this command. Usage: /hat <player> <block>");
				}
			}else{
				sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.hat.other")) {
				if (sender instanceof Player) {
					Player player = (Player) Bukkit.getServer().getPlayer(args[0]);
					Player sender1 = (Player) sender;
					if (player == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
					}else{
						if ((sender1).getInventory().getItemInHand().getType() == Material.AIR || (sender1).getInventory().getItemInHand().getType() == null) {
							sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 You're not holding anything to put on " + player.getName() + "'s head.");
						}else{
							if ((player).getInventory().getHelmet() != null)
				            {
				              ItemStack hat = (player).getInventory().getHelmet();
				              (player).getInventory().setHelmet((sender1).getInventory().getItemInHand());
				              (sender1).getInventory().remove((sender1).getInventory().getItemInHand());
				              (player).getInventory().addItem(new ItemStack[] { hat });
				              sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 The block in your hand has been put on " + player.getName() + "'s head.");
				              player.sendMessage("§8[§b§lSmart§a§lEssentials§8]§7 " + sender.getName() + " has put a block on your head.");
				            }
				            else if ((player).getInventory().getHelmet() == null)
				            {
				              (player).getInventory().setHelmet((sender1).getInventory().getItemInHand());
				              (sender1).getInventory().remove((sender1).getInventory().getItemInHand());
				            }
						}
					}
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You must be a player to use this command.");
				}
			}else{
				if (sender.hasPermission("smartessentials.hat.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to put a block on your own head.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		/*if (args.length == 2) {
			if (sender.hasPermission("smartessentials.hat.other")) {
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[0] + " is not a valid player.");
				}else{
					Material item = Material.getMaterial(args[1]);
					ItemStack stack = item.
					if (item == null) {
						sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 " + args[1] + " is not a valid block.");
					}else{
						if (player.getInventory().getHelmet() == null) {
							ItemStack hat = (player).getInventory().getHelmet();
							(player).getInventory().setHelmet(item);
						}
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.hat.own")) {
					sender.sendMessage("");
				}else{
					sender.sendMessage("");
				}
			}
		}*/
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.hat.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 Too many arguments. Usage: /hat [player]");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You need to be a player to use this command.");
				}
				
			}else{
				if (sender.hasPermission("smartessentials.hat.own")) {
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You only have permission to put a block on your own head.");
				}else{
					sender.sendMessage("§8[§b§lSmart§a§lEssentials§8]§4 You don't have permission to use this command.");
				}
			}
		}
		return false;
	}
}
