package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Kick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length >= 2) {
			Player p = (Player) sender;
			Player target = Bukkit.getPlayer(args[0]);
			String reason = args[1];
			for (int i = 2; i < args.length; i++) {
			reason += " " + args[i];
			}
			
			if(sender instanceof Player) {
				target.kickPlayer("§4§l" + reason);
				p.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " für " + reason + " gekickt.");
			}
		}
		return false;
	}

}
