package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Clear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Player p = (Player) sender;
			if(sender instanceof Player) {
				p.getInventory().clear();
				p.sendMessage("§b§lBlank §7» §fDein Inventar wurde gecleart.");
			}
		} else {
			if(args.length == 1) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(sender instanceof Player) {
					if(target != null) {
						if(p.hasPermission("blank.clear.others")) {
						target.getInventory().clear();
						target.sendMessage("§b§lBlank §7» §fDein Inventar wurde von " + p.getDisplayName() + " §fgecleart.");
						p.sendMessage("§b§lBlank §7» §fDu hast das Inventar von " + target.getDisplayName() + " §fgecleart.");
					}
				}
				}
			}
		}
		return false;
	}

}
