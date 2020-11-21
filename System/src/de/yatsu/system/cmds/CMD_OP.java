package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_OP implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null) {
				if(target.isOp()) {
					sender.sendMessage("§b§lBlank §7» §fDieser Spieler hat bereits Operatorrechte.");
				} else {
				target.setOp(true);
				sender.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " Operatorrechte erteilt.");
				target.sendMessage("§b§lBlank §7» §fDu hast Operatorrechte erteilt bekommen.");
			}
			}
		}
		return false;
	}

}
