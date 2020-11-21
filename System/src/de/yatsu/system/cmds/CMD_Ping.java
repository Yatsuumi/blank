package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class CMD_Ping implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Player p = (Player) sender;
			if(sender instanceof Player) {
			    int pping = ((CraftPlayer) p).getHandle().ping;
			    p.sendMessage("§b§lBlank §7» §fDein Ping beträgt: " + pping + " ms");
			}
		} else {
			if(args.length == 1) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				if(sender instanceof Player) {
					if(target != null) {
					    int targetping = ((CraftPlayer) target).getHandle().ping;
					    p.sendMessage("§b§lBlank §7» §fDer Ping von " + target.getDisplayName() + " beträgt: " + targetping + " ms");
					}
				}
			}
		}
		return false;
	}

}
