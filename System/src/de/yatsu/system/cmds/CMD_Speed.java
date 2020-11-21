package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Speed implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args[0].equalsIgnoreCase("1")) {
				p.setFlySpeed(0.2F);
				p.setWalkSpeed(0.2F);
				p.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 1.");
			}
			if(args[0].equalsIgnoreCase("2")) {
				p.setFlySpeed(0.4F);
				p.setWalkSpeed(0.4F);
				p.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 2.");
			}
			if(args[0].equalsIgnoreCase("3")) {
				p.setFlySpeed(0.6F);
				p.setWalkSpeed(0.6F);
				p.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 3.");
			}
			if(args[0].equalsIgnoreCase("4")) {
				p.setFlySpeed(0.8F);
				p.setWalkSpeed(0.8F);
				p.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 4.");
			}
			if(args[0].equalsIgnoreCase("5")) {
				p.setFlySpeed(1F);
				p.setWalkSpeed(1F);
				p.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 5.");
			}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		} else {
			if(args.length == 2) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(args[0].equalsIgnoreCase("1")) {
							target.setFlySpeed(0.2F);
							target.setWalkSpeed(0.2F);
							target.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 1.");
							p.sendMessage("§b§lBlank §7» §f " + target.getDisplayName() + "läuft nun mit Speed 1.");
						}
						if(args[0].equalsIgnoreCase("2")) {
							target.setFlySpeed(0.4F);
							target.setWalkSpeed(0.4F);
							target.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 2.");
							p.sendMessage("§b§lBlank §7» §f " + target.getDisplayName() + "läuft nun mit Speed 2.");
						}
						if(args[0].equalsIgnoreCase("3")) {
							target.setFlySpeed(0.6F);
							target.setWalkSpeed(0.6F);
							target.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 3.");
							p.sendMessage("§b§lBlank §7» §f " + target.getDisplayName() + "läuft nun mit Speed 3.");
						}
						if(args[0].equalsIgnoreCase("4")) {
							target.setFlySpeed(0.8F);
							target.setWalkSpeed(0.8F);
							target.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 4.");
							p.sendMessage("§b§lBlank §7» §f " + target.getDisplayName() + "läuft nun mit Speed 4.");
						}
						if(args[0].equalsIgnoreCase("5")) {
							target.setFlySpeed(1);
							target.setWalkSpeed(1);
							target.sendMessage("§b§lBlank §7» §fDu läufst nun mit Speed 5.");
							p.sendMessage("§b§lBlank §7» §f " + target.getDisplayName() + "läuft nun mit Speed 5.");
						}
					}
					
				} else {
					sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
				}
			}
		}
		return false;
	}

}
