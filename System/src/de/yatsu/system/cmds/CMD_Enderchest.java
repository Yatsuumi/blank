package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CMD_Enderchest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(p.hasPermission("blank.ec.others")) {
				Player target = Bukkit.getPlayer(args[0]);
				Inventory targetEc = target.getEnderChest();
				if(target != null) {
					p.openInventory(targetEc);
					p.sendMessage("§b§lBlank §7» §fDu hast die Enderchest von " + target.getDisplayName() + " geöffnet.");
				}
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		} else {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					Inventory pEc = p.getEnderChest();
					p.openInventory(pEc);
					p.sendMessage("§b§lBlank §7» §fDu hast die Enderchest von dir geöffnet.");
				} else {
					sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
				}
			}
		}
		return false;
	}

}
