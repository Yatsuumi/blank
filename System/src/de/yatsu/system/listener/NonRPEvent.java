package de.yatsu.system.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class NonRPEvent implements Listener {
	public static String prefix = "§6Non-RP Chat §7»";
	@EventHandler
	public void onChat(AsyncPlayerChatEvent chat) {
		Player p = chat.getPlayer();
		if(chat.getMessage().startsWith("@nonrp")) {
			String msg = chat.getMessage();
			for(Player on : Bukkit.getOnlinePlayers()) {
				chat.setCancelled(true);
				on.sendMessage(prefix + " " + "§5" + p.getName() + " §7>§f" + msg.replaceAll("@nonrp", "§8"));
			}
		}
	}
}
