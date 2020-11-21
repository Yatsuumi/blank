package de.yatsu.system.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
	@EventHandler
	public void onJoin(PlayerJoinEvent join) {
		Player p = join.getPlayer();
		p.sendMessage("§b§lBlank §7» §fWillkommen auf dem Blank-Server!");
	}

}
