package me.smarttv.smartessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (sender.hasPermission("smartessentials.heal.own") || sender.hasPermission("smartessentials.heal.other")) {
				if (sender instanceof Player) {
					Player player = (Player) sender;
					if (player.getHealth() == 20 && player.getFoodLevel() == 20) {
						sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 You are already healed.");
					}else{
						if (player.getHealth() < 20 && player.getFoodLevel() < 20) {
							player.setHealth(20);
							player.setFoodLevel(20);
							sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your health and food level has been replenished.");
						}else{
							if (player.getHealth() < 20) {
								player.setHealth(20);
								sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your health has been replenished.");
							}else{
								if (player.getFoodLevel() < 20) {
									player.setFoodLevel(20);
									sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your food level has been replenished.");
								}else{
									return false;
								}
							}
						}
					}
				}else{
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 You must be a player to use this command.");
				}
			}else{
				sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 You don't have permission to use this command.");
			}
		}
		if (args.length == 1) {
			if (sender.hasPermission("smartessentials.heal.other")) {
				Player player = Bukkit.getServer().getPlayer(args[0]);
				if (player == null) {
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 " + args[0] + " is not a valid player.");
				}else{
					if (player == sender) {
						if (sender instanceof Player) {
							player = (Player) sender;
							if (player.getHealth() == 20 && player.getFoodLevel() == 20) {
								sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 You are already healed.");
							}else{
								if (player.getHealth() < 20 && player.getFoodLevel() < 20) {
									player.setHealth(20);
									player.setFoodLevel(20);
									sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your health and food level has been replenished.");
								}else{
									if (player.getHealth() < 20) {
										player.setHealth(20);
										sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your health has been replenished.");
									}else{
										if (player.getFoodLevel() < 20) {
											player.setFoodLevel(20);
											sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your food level has been replenished.");
										}else{
											return false;
										}
									}
								}
							}
						}else{
							sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 You must be a player to use this command.");
						}
					}else{
						if (player.getHealth() == 20 && player.getFoodLevel() == 20) {
							sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 " + player.getName() + " is already healed.");
						}else{
							if (player.getHealth() < 20 && player.getFoodLevel() < 20) {
								player.setHealth(20);
								player.setFoodLevel(20);
								sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 " + player.getName() + "'s health and food level have been replenished.");
								player.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your health and food level has been replenished by " + sender.getName() + ".");
							}else{
								if (player.getHealth() < 20) {
									player.setHealth(20);
									sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 " + player.getName() + "'s health has been replenished.");
									player.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your health has been replenished by " + sender.getName() + ".");
								}else{
									if (player.getFoodLevel() < 20) {
										player.setFoodLevel(20);
										sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 " + player.getName() + "'s food level has been replenished.");
										player.sendMessage("�8[�b�lSmart�a�lEssentials�8]�7 Your food level has been replenished by " + sender.getName() + ".");
									}else{
										return false;
									}
								}
							}
						}
					}
				}
			}else{
				if (sender.hasPermission("smartessentials.heal.own")){
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 You can only heal yourself.");
				}else{
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 You don't have permission to use this command.");
				}
			}
		}
		if (args.length > 1) {
			if (sender.hasPermission("smartessentials.heal.other")) {
				if (sender instanceof Player) {
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 Too many arguments. Usage: /heal [player]");	
				}else{
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 Too many arguments. Usage: /heal <player>");
				}
			}else{
				if (sender.hasPermission("smartessentials.heal.own")) {
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 Too many arguments. Usage: /heal");
				}else{
					sender.sendMessage("�8[�b�lSmart�a�lEssentials�8]�4 You don't have permission to use this command.");
				}
			}
		}
		return false;
	}
}
