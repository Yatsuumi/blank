package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class CMD_Invsee implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				Inventory targetInv = target.getInventory();
				if(target != null) {
					p.openInventory(targetInv);
					p.sendMessage("§b§lBlank §7» §fDu hast das Inventar von " + target.getDisplayName() + " geöffnet.");
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		}
		return false;
	}

}
