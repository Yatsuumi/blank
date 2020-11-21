package de.yatsu.system.cmds;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Back implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Location loc = p.getKiller().getLocation();
				p.teleport(loc);
				p.sendMessage("Du bist nun an dem Ort, wo du gestorben bist.");
			}
		}
		return false;
	}

}
