package de.yatsu.system.cmds;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMD_Health implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args[0].equalsIgnoreCase("1")) {
					p.setMaxHealth(2);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(2);
				}
				if(args[0].equalsIgnoreCase("2")) {
					p.setMaxHealth(4);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(4);
				}
				if(args[0].equalsIgnoreCase("3")) {
					p.setMaxHealth(6);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(6);
				}
				if(args[0].equalsIgnoreCase("4")) {
					p.setMaxHealth(8);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(8);
				}
				if(args[0].equalsIgnoreCase("5")) {
					p.setMaxHealth(10);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(10);
				}
				if(args[0].equalsIgnoreCase("6")) {
					p.setMaxHealth(12);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(12);
				}
				if(args[0].equalsIgnoreCase("7")) {
					p.setMaxHealth(14);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(14);
				}
				if(args[0].equalsIgnoreCase("8")) {
					p.setMaxHealth(16);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(16);
				}
				if(args[0].equalsIgnoreCase("9")) {
					p.setMaxHealth(18);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(18);
				}
				if(args[0].equalsIgnoreCase("10")) {
					p.setMaxHealth(20);
					p.playSound(p.getLocation(), Sound.BLAZE_HIT, 1, 1);
					p.setHealth(20);
				}
			}
		}
		return false;
	}

}
