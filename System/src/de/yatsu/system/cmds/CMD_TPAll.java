package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_TPAll implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				for(Player ps : Bukkit.getOnlinePlayers()) {
					if(ps != p) {
						ps.teleport(p);
						p.sendMessage("§b§lBlank §7» §fDu hast alle Spieler zu dir teleportiert!");
						ps.sendMessage("§b§lBlank §7» §fDu wurdest zu " + p.getDisplayName() + " teleportiert.");
					}
				}
			}
		} else {
			if(args.length == 1) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					Player target = Bukkit.getPlayer(args[0]);
					for(Player ps : Bukkit.getOnlinePlayers()) {
						if(ps != p) {
							ps.teleport(target);
							target.sendMessage("§b§lBlank §7» §fAlle Spieler wurden zu dir teleportiert!");
							ps.sendMessage("§b§lBlank §7» §fDu wurdest zu " + target.getDisplayName() + " teleportiert.");
							p.sendMessage("§b§lBlank §7» §fDu hast alle Spieler zu " + target.getDisplayName() + " teleportiert.");
						}
					}
				}
			}
		}
		return false;
	}

}
