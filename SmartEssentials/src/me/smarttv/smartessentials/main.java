package me.smarttv.smartessentials;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.smarttv.smartessentials.commands.Broadcast;
import me.smarttv.smartessentials.commands.Console;
import me.smarttv.smartessentials.commands.Feed;
import me.smarttv.smartessentials.commands.Flight;
import me.smarttv.smartessentials.commands.Gamemode;
import me.smarttv.smartessentials.commands.Getip;
import me.smarttv.smartessentials.commands.God;
import me.smarttv.smartessentials.commands.Hat;
import me.smarttv.smartessentials.commands.Heal;
import me.smarttv.smartessentials.commands.Kill;
import me.smarttv.smartessentials.commands.Me;
import me.smarttv.smartessentials.commands.Repair;
import me.smarttv.smartessentials.commands.SmartEssentials;
import me.smarttv.smartessentials.commands.Sudo;
import me.smarttv.smartessentials.events.GodListener;

public class main extends JavaPlugin implements Listener{
	
	private static main instance;
	
	public static main inst() {
	  return instance;
	}
    /* Dev Notes/copies
     
	§8[§b§lSmart§a§lEssentials§8]§7
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	
	return false;
	}
	
	Commands to add:
	getip
	
	
	*/
	
	@Override
	public void onEnable() {
		getLogger().info("has been enabled!");
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
		getCommand("smartessentials").setExecutor(new SmartEssentials());
		getCommand("flight").setExecutor(new Flight()); //Add logging commands, and players fly list
		getCommand("heal").setExecutor(new Heal()); //Add cooldowns
		getCommand("feed").setExecutor(new Feed()); //Add cooldowns
		getCommand("repair").setExecutor(new Repair()); //Fixall feature and repairing of enchanted permission
		getCommand("console").setExecutor(new Console()); //Add result feature
		getCommand("hat").setExecutor(new Hat()); //custom item
		getCommand("getip").setExecutor(new Getip());//add checking your own ip
		getCommand("sudo").setExecutor(new Sudo());//add blacklist
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("broadcast").setExecutor(new Broadcast());
		getCommand("god").setExecutor(new God());
		getCommand("me").setExecutor(new Me());
		getCommand("kill").setExecutor(new Kill());
		new GodListener(this);
	}

	@Override
	public void onDisable() {
		getLogger().info("has been disabled.");
	}
	
	
}
