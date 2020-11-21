package de.yatsu.system.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Infos implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				p.sendMessage("§b§lBlank §7» §fInfos:");
				p.sendMessage("");
				p.sendMessage("§8Commands:");
				p.sendMessage("§7Verwendung: §a/fly oder /fly <Spieler>");
				p.sendMessage("§7Verwendung: §a/gm <Gamemode> oder /gm <Gamemode> <Spieler>");
				p.sendMessage("§7Verwendung: §a/heal oder /heal <Spieler>");
				p.sendMessage("§7Verwendung: §a/teleport <Spieler>");
				p.sendMessage("§7Verwendung: §a/teleporthere <Spieler>");
				p.sendMessage("§7Verwendung: §a/setspawn");
				p.sendMessage("§7Verwendung: §a/spawn");
				p.sendMessage("§7Verwendung: §a/list");
				p.sendMessage("§7Verwendung: §a/kits");
				p.sendMessage("§7Verwendung: §a/kit oder /kit <Name>");
				p.sendMessage("§7Verwendung: §a/murder oder /murder <Spieler>");
				p.sendMessage("§7Verwendung: §a/suicide");
				p.sendMessage("§7Verwendung: §a/event oder /event <Spieler>");
				p.sendMessage("§7Verwendung: §a/arena set");
				p.sendMessage("§7Verwendung: §a/arena");
				p.sendMessage("§7Verwendung: §a/clearchat oder /clearchat own");
				p.sendMessage("§7Verwendung: §a/killall");
				p.sendMessage("§7Verwendung: §a/vanish oder /vanish <Spieler>");
				p.sendMessage("§7Verwendung: §a/health (1-10)");
				p.sendMessage("§7Verwendung: §a/buehne set");
				p.sendMessage("§7Verwendung: §a/buehne");
				p.sendMessage("§7Verwendung: §a/invsee <Spieler>");
				p.sendMessage("§7Verwendung: §a/ec oder /ec <Spieler>");
				p.sendMessage("§7Verwendung: §a/msg <Spieler> <Nachricht>");
				p.sendMessage("§7Verwendung: §a/broadcast <Nachricht>");
				p.sendMessage("§7Verwendung: §a/back");
				p.sendMessage("§7Verwendung: §a/kick <Spieler>");
				p.sendMessage("§7Verwendung: §a/tpall oder /tpall  <Spieler>");
				p.sendMessage("§7Verwendung: §a/serverinfo");
				p.sendMessage("§7Verwendung: §a/spectate <Spieler>");
				p.sendMessage("§7Verwendung: §a/speed oder /speed <Spieler>");
				p.sendMessage("§7Verwendung: §a/op <Spieler>");
				p.sendMessage("§7Verwendung: §a/deop <Spieler>");
				p.sendMessage("§7Verwendung: §a/clear oder /clear <Spieler>");
				p.sendMessage("§7Verwendung: §a/ping oder /ping <Spieler>");
				p.sendMessage("");
				p.sendMessage("§8Kits:");
				p.sendMessage("§aKit §0Black");
				p.sendMessage("§aKit §fWhite");
				p.sendMessage("");
				p.sendMessage("§8Chats:");
				p.sendMessage("§aNormal");
				p.sendMessage("§aNon-RP / Verwendung: @nonrp");
			}
		}
		return false;
	}

}
