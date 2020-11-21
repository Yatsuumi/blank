package de.yatsu.system.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardListener implements Listener {
	
	@EventHandler
	public void onJoinSB(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		int pping = ((CraftPlayer) p).getHandle().ping;
		String ping = Integer.toString(pping);
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("aaa", "bbb");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		obj.setDisplayName("Blank");
		obj.getScore(" ").setScore(5);
		obj.getScore("§c§lWillkommen§7, §5" + p.getDisplayName() + "!").setScore(4);
		obj.getScore(" ").setScore(3);
		obj.getScore("§a§lDein Ping beträgt zurzeit§7:").setScore(2);
		obj.getScore(ping).setScore(1);
		p.setScoreboard(board);
	}

}
