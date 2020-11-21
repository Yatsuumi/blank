package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_MSG implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length >= 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				String message = "";
				for (int i = 0; i < args.length; i++) {
				message += args[i] + " ";
				}
				if(target != null) {
					target.sendMessage("§b§lBlank §7» §f" + p.getDisplayName() + " > you " + ": " + message);
					p.sendMessage("§b§lBlank §7» §f" + " you > " + target.getDisplayName() + ": " + message);
				}
			}
		}
		return false;
	}

}
