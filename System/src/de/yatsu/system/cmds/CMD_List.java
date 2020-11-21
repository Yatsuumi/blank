package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_List implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Player p = (Player) sender;
			for(Player ps : Bukkit.getOnlinePlayers()) {
				if(ps != p) {
					p.sendMessage("§b§lBlank §7» §fSpieler, die derzeit online sind:");
					p.sendMessage("§b§lBlank §7» §fDu (" + p.getDisplayName() + ") §fund " + ps.getDisplayName());
				}
			}
		}
		return false;
	}

}
