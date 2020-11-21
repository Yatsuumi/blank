package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Event implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Bukkit.broadcastMessage("§b§lBlank §7» §c§lACHTUNG! §6Es findet ein Event statt!");
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		} else {
			if(args.length == 1) {
				if(sender instanceof Player) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						Bukkit.broadcastMessage("§b§lBlank §7» §6" + target.getDisplayName() + " §6hat das Event gewonnen!");
					}
				}  else {
					sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
				}
			}
		}
		return false;
	}

}
