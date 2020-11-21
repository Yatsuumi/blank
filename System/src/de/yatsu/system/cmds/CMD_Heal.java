package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Heal implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			p.setHealth(20);
			p.setFoodLevel(20);
			p.sendMessage("§b§lBlank §7» §fErfolgreich geheilt!");
			p.sendMessage("§b§lBlank §7» §fErfolgreich gefüttert!");
		} else {
			sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
		}
	} else {
		if(args.length == 1) {
			Player target = Bukkit.getPlayer(args[0]);
			Player p = (Player) sender;
			if(target != null) {
				if(sender instanceof Player) {
					target.setHealth(20);
					target.setFoodLevel(20);
					target.sendMessage("§b§lBlank §7» §fErfolgreich geheilt!");
					target.sendMessage("§b§lBlank §7» §fErfolgreich gefüttert!");
					p.sendMessage("§b§lBlank §7» §f" + target.getDisplayName() + " erfolgreich geheilt!");
					p.sendMessage("§b§lBlank §7» §f" + target.getDisplayName() + " erfolgreich gefüttert!");
				}
			}
		}
	}
		return false;
	}

}
