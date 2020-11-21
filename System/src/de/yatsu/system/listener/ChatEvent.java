package de.yatsu.system.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener{
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
                String message = ChatColor.translateAlternateColorCodes('&', event.getMessage());
		if(p.isOp()) {
			event.setFormat("§4" + p.getName() + " §7» §r" + message);
		}else {
			event.setFormat("§7" + p.getName() + " §7» §r" + message);
		}
	}

}