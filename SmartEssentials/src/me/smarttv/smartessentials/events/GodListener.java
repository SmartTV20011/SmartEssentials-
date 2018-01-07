package me.smarttv.smartessentials.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import me.smarttv.smartessentials.main;

public class GodListener implements Listener {
	
		  public GodListener(main plugin) {
		    plugin.getServer().getPluginManager().registerEvents(this, plugin);
		  }
		  
		  @EventHandler
		  public void OnEntityDamage(EntityDamageEvent event)
		  {
		    if ((event.getEntity() instanceof Player))
		    {
		      Player player = (Player)event.getEntity();
		      if (player.hasPermission("smartessentials.is.in.god.mode")) {
		        event.setCancelled(true);
		      }
		    }
		  }
	
}
