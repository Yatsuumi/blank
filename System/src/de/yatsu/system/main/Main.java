package de.yatsu.system.main;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import de.yatsu.system.cmds.CMD_Arena;
import de.yatsu.system.cmds.CMD_Back;
import de.yatsu.system.cmds.CMD_Broadcast;
import de.yatsu.system.cmds.CMD_Buehne;
import de.yatsu.system.cmds.CMD_Clear;
import de.yatsu.system.cmds.CMD_ClearChat;
import de.yatsu.system.cmds.CMD_DeOP;
import de.yatsu.system.cmds.CMD_Enderchest;
import de.yatsu.system.cmds.CMD_Event;
import de.yatsu.system.cmds.CMD_Final;
import de.yatsu.system.cmds.CMD_Fly;
import de.yatsu.system.cmds.CMD_GM;
import de.yatsu.system.cmds.CMD_Heal;
import de.yatsu.system.cmds.CMD_Health;
import de.yatsu.system.cmds.CMD_Infos;
import de.yatsu.system.cmds.CMD_Invsee;
import de.yatsu.system.cmds.CMD_Kick;
import de.yatsu.system.cmds.CMD_KillAll;
import de.yatsu.system.cmds.CMD_Kit;
import de.yatsu.system.cmds.CMD_Kits;
import de.yatsu.system.cmds.CMD_List;
import de.yatsu.system.cmds.CMD_MSG;
import de.yatsu.system.cmds.CMD_Murder;
import de.yatsu.system.cmds.CMD_Nick;
import de.yatsu.system.cmds.CMD_OP;
import de.yatsu.system.cmds.CMD_Ping;
import de.yatsu.system.cmds.CMD_Prefix;
import de.yatsu.system.cmds.CMD_ServerInfo;
import de.yatsu.system.cmds.CMD_Setspawn;
import de.yatsu.system.cmds.CMD_Spawn;
import de.yatsu.system.cmds.CMD_Spectate;
import de.yatsu.system.cmds.CMD_Speed;
import de.yatsu.system.cmds.CMD_Suicide;
import de.yatsu.system.cmds.CMD_TP;
import de.yatsu.system.cmds.CMD_TPAll;
import de.yatsu.system.cmds.CMD_TPHere;
import de.yatsu.system.cmds.CMD_Vanish;
import de.yatsu.system.listener.EffectEvent2;
import de.yatsu.system.listener.ChatEvent;
import de.yatsu.system.listener.EffectEvent;
import de.yatsu.system.listener.JoinMessage;
import de.yatsu.system.listener.LeaveMessage;
import de.yatsu.system.listener.NonRPEvent;
import de.yatsu.system.listener.PhysicsEvent;
import de.yatsu.system.listener.Protection;
import de.yatsu.system.scoreboard.ScoreboardListener;
import de.yatsu.system.utils.Navigator;

public class Main extends JavaPlugin {
	
	private static Main instance;
	private static final String Prefix = "§b§lBlank §8» §7";
	
	public void updateScoreboard() {
		for(Player p : Bukkit.getOnlinePlayers()) {
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
	
	public void onEnable() {
		
		initAll(Bukkit.getPluginManager());
		Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
			public void run() {
				updateScoreboard();
			}
		}, 5, 20);
		
	}	
	
	public static String getPrefix() {
		return Prefix;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
	public void initAll(PluginManager pm) {
		instance = this;
		
		pm.registerEvents(new ChatEvent(), this);
		pm.registerEvents(new JoinMessage(), this);
		pm.registerEvents(new LeaveMessage(), this);
		pm.registerEvents(new NonRPEvent(), this);
		pm.registerEvents(new EffectEvent(), this);
		pm.registerEvents(new EffectEvent2(), this);
		pm.registerEvents(new Navigator(), this);
		pm.registerEvents(new Protection(), this);
		pm.registerEvents(new ScoreboardListener(), this);
		pm.registerEvents(new PhysicsEvent(), this);
		
		getCommand("fly").setExecutor(new CMD_Fly());
		getCommand("gm").setExecutor(new CMD_GM());
		getCommand("heal").setExecutor(new CMD_Heal());
		getCommand("teleport").setExecutor(new CMD_TP());
		getCommand("teleporthere").setExecutor(new CMD_TPHere());
		getCommand("setspawn").setExecutor(new CMD_Setspawn());
		getCommand("spawn").setExecutor(new CMD_Spawn());
		getCommand("infos").setExecutor(new CMD_Infos());
		getCommand("kit").setExecutor(new CMD_Kit());
		getCommand("kits").setExecutor(new CMD_Kits());
		getCommand("murder").setExecutor(new CMD_Murder());
		getCommand("suicide").setExecutor(new CMD_Suicide());
		getCommand("event").setExecutor(new CMD_Event());
		getCommand("arena").setExecutor(new CMD_Arena());
		getCommand("clearchat").setExecutor(new CMD_ClearChat());
		getCommand("killall").setExecutor(new CMD_KillAll());
		getCommand("vanish").setExecutor(new CMD_Vanish());
		getCommand("health").setExecutor(new CMD_Health());
		getCommand("buehne").setExecutor(new CMD_Buehne());
		getCommand("ec").setExecutor(new CMD_Enderchest());
		getCommand("invsee").setExecutor(new CMD_Invsee());
		getCommand("list").setExecutor(new CMD_List());
		getCommand("broadcast").setExecutor(new CMD_Broadcast());
		getCommand("msg").setExecutor(new CMD_MSG());
		getCommand("back").setExecutor(new CMD_Back());
		getCommand("kick").setExecutor(new CMD_Kick());
		getCommand("tpall").setExecutor(new CMD_TPAll());
		getCommand("serverinfo").setExecutor(new CMD_ServerInfo());
		getCommand("spectate").setExecutor(new CMD_Spectate());
		getCommand("speed").setExecutor(new CMD_Speed());
		getCommand("op").setExecutor(new CMD_OP());
		getCommand("deop").setExecutor(new CMD_DeOP());
		getCommand("clear").setExecutor(new CMD_Clear());
		getCommand("ping").setExecutor(new CMD_Ping());
		getCommand("prefix").setExecutor(new CMD_Prefix());
		getCommand("nick").setExecutor(new CMD_Nick());
		getCommand("final").setExecutor(new CMD_Final());
	}

}
