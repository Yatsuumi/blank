package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CMD_Broadcast implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length >= 1) {
				String message = "";
				for (int i = 0; i < args.length; i++) {
					
				message += " " + args[i];
				}
				Bukkit.broadcastMessage("§b§lBlank §7» §f" + message);
		}
		return false;
	}

}
