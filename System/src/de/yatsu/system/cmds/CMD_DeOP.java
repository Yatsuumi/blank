package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_DeOP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOp()) {
					target.setOp(false);
					sender.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " Operatorrechte entfernt.");
					target.sendMessage("§b§lBlank §7» §fDir wurden deine Operatorrechte entfernt.");
				} else {
					sender.sendMessage("§b§lBlank §7» §fDieser Spieler hat keine Operatorrechte.");
			}
			}
		}
		return false;
	}

}
