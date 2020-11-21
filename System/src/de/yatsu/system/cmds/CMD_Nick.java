package de.yatsu.system.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Nick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			Player p = (Player) sender;
			String nick = "";
			String unnick = p.getCustomName();
			if(sender instanceof Player) {
				if(!args[1].equalsIgnoreCase("off")) {
					for (int i = 0; i < args.length; i++) {
						nick += args[i] + " ";
						}
					p.setDisplayName(nick);
					p.sendMessage("§b§lBlank §7» §fDu hast dich genickt (" + nick + ").");
				} else {
					p.setDisplayName(unnick);
					p.sendMessage("§b§lBlank §7» §fDu hast dich entnickt (" + unnick + ").");
				}
			}
		}
		return false;
	}

}
