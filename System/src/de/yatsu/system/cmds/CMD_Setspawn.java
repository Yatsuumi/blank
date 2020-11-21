package de.yatsu.system.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Setspawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				File file = new File("plugins//Blank//spawn.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				cfg.set("Spawn.X", p.getLocation().getX());
				cfg.set("Spawn.Y", p.getLocation().getY());
				cfg.set("Spawn.Z", p.getLocation().getZ());
				cfg.set("Spawn.Yaw", p.getLocation().getYaw());
				cfg.set("Spawn.Pitch", p.getLocation().getPitch());
				cfg.set("Spawn.WorldName", p.getWorld().getName());
				try {
					cfg.save(file);
					p.sendMessage("§b§lBlank §7» §fDu hast den Spawn gesetzt.");
				} catch (IOException e) {
					p.sendMessage("Error!");
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		}
		return false;
	}

}
