package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Fly implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
			if(p.getAllowFlight()) {
				p.setAllowFlight(false);
				p.setFlying(false);
				p.sendMessage("§b§lBlank §7» §fDu kannst nun nicht mehr fliegen.");
			} else {
				p.setAllowFlight(true);
				p.setFlying(true);
				p.sendMessage("§b§lBlank §7» §fDu kannst nun fliegen.");
				}
			} else {
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
					if(target.getAllowFlight()) {
						target.setAllowFlight(false);
						target.setFlying(false);
						target.sendMessage("§b§lBlank §7» §fDu kannst nun nicht mehr fliegen.");
						p.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " den Flugmodus geraubt.");
					} else {
						target.setAllowFlight(true);
						target.setFlying(true);
						target.sendMessage("§b§lBlank §7» §fDu kannst nun fliegen.");
						p.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " in den Flugmodus versetzt.");
					}
					}
				}
			}
		} else {
			sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
		}
		return false;
	}

}
