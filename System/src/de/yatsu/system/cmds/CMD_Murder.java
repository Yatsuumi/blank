package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Murder implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					target.setHealth(0);
					p.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " ermordet.");
					target.sendMessage("§b§lBlank §7» §fDu wurdest von " + p.getDisplayName() + " ermordet.");
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		} else {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					p.setHealth(0);
					p.sendMessage("§b§lBlank §7» §fDu hast Selbstmord begangen.");
				} else {
					sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
				}
			}
		}
		return false;
	}

}
