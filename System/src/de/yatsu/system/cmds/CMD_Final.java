package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Final implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Player p = (Player) sender;
			if(sender instanceof Player) {
				p.sendMessage("Final");
				p.setHealth(20);
			}
		} else {
			if(args.length == 1) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(sender instanceof Player) {
					target.sendMessage("Final");
					target.setHealth(20);
					p.sendMessage("Final gesendet");
				}
			}
		}
		return false;
	}

}
