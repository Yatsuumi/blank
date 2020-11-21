package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Prefix implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 2) {
			Player p = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);
			String owner = "§4§lOwner §7> §4";
			if(sender instanceof Player) {
				if(args[0].equalsIgnoreCase("Owner")) {
					target.setDisplayName(owner + p.getDisplayName());
					p.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " den Owner-Prefix erteilt.");
				}
			}
		}
		return false;
	}

}
