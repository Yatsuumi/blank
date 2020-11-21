package de.yatsu.system.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveMessage implements Listener {
	@EventHandler
	public void onLeave(PlayerQuitEvent quit) {
		Player p = quit.getPlayer();
		Bukkit.broadcastMessage("§b§lBlank §7» §fBis bald, " + p.getDisplayName() + "§f!");
	}
	
}
