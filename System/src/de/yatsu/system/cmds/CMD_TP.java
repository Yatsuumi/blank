package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_TP implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			if(args.length == 1) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					p.teleport(target);
					p.sendMessage("§b§lBlank §7» §fDu wurdest zu " + target.getDisplayName() + " teleportiert.");
					target.sendMessage("§b§lBlank §7» §f" + p.getDisplayName() + " hat sich zu dir teleportiert.");
				}
			} else {
				if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);
					Player p = ((Player)sender);
					if(target != null) {
						target.teleport(p);
					}
				}
			}
			
		} else {
			sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
		}
		return false;
	}

}
