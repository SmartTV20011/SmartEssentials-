package me.smarttv.smartessentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import me.smarttv.smartessentials.main;

public class FileCreation {
	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
        	File yml = new File(player.getUniqueID() + ".yml");
        	yml.createNewFile();
        }
    }
}