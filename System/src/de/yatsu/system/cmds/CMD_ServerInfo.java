package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_ServerInfo implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				String s = p.getServer().getServerName();
				String v = Bukkit.getVersion();
				p.sendMessage("§b§lBlank §7» §fDu spielst auf " + s + " auf der Version " + v + ".");
			}
		}
		return false;
	}
	
}
