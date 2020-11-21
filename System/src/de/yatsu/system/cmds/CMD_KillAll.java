package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class CMD_KillAll implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			Player p = (Player) sender;
			for(Entity en : p.getWorld().getEntities()) {
			if(!(en instanceof Player)) {
				en.remove();
			}
			}
            sender.sendMessage("§b§lBlank §7» §fDu hast erfolgreich alle Entities getötet!");
            Bukkit.broadcastMessage("§b§lBlank §7» §fEs wurden alle Entities getötet!");
		}
		return false;
	}

}
