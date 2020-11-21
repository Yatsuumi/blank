package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_GM implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("0")) {
					p.setGameMode(GameMode.SURVIVAL);
					p.sendMessage("§b§lBlank §7» §fDu bist nun im Survival-Mode.");
				}
				if(args[0].equalsIgnoreCase("1")) {
					p.setGameMode(GameMode.CREATIVE);
					p.sendMessage("§b§lBlank §7» §fDu bist nun im Creative-Mode.");
				}
				if(args[0].equalsIgnoreCase("2")) {
					p.setGameMode(GameMode.ADVENTURE);
					p.sendMessage("§b§lBlank §7» §fDu bist nun im Adventure-Mode.");
				}
				if(args[0].equalsIgnoreCase("3")) {
					p.setGameMode(GameMode.SPECTATOR);
					p.sendMessage("§b§lBlank §7» §fDu bist nun im Spectator-Mode.");
				}
			} else {
				if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[1]);
					if(target != null) {
						if(args[0].equalsIgnoreCase("0")) {
							target.setGameMode(GameMode.SURVIVAL);
							target.sendMessage("»§b§lBlank §7» §fDu bist nun im Survival-Mode.");
							p.sendMessage("§b§lBlank §7» §fDer Spieler " + target.getDisplayName() + " wurde erfolgreich in den Survival-Mode versetzt.");
						}
						if(args[0].equalsIgnoreCase("1")) {
							target.setGameMode(GameMode.CREATIVE);
							target.sendMessage("§b§lBlank §7» §fDu bist nun im Creative-Mode.");
							p.sendMessage("§b§lBlank §7» §fDer Spieler " + target.getDisplayName() + " wurde erfolgreich in den Creative-Mode versetzt.");
						}
						if(args[0].equalsIgnoreCase("2")) {
							target.setGameMode(GameMode.ADVENTURE);
							target.sendMessage("§b§lBlank §7» §fDu bist nun im Adventure-Mode.");
							p.sendMessage("§b§lBlank §7» §fDer Spieler " + target.getDisplayName() + " wurde erfolgreich in den Adventure-Mode versetzt.");
						}
						if(args[0].equalsIgnoreCase("3")) {
							target.setGameMode(GameMode.SPECTATOR);
							target.sendMessage("§b§lBlank §7» §fDu bist nun im Spectator-Mode.");
							p.sendMessage("§b§lBlank §7» §fDer Spieler " + target.getDisplayName() + " wurde erfolgreich in den Spectator-Mode versetzt.");
					}
				}
			}
		}
	} else {
		sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
	}
		return false;

}
	
}

