package de.yatsu.system.cmds;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMD_Buehne implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				if(args[0].equalsIgnoreCase("set")) {
					Player p = (Player) sender;
					File file = new File("plugins//Blank//buehne.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Buehne.X", p.getLocation().getX());
					cfg.set("Buehne.Y", p.getLocation().getY());
					cfg.set("Buehne.Z", p.getLocation().getZ());
					cfg.set("Buehne.Yaw", p.getLocation().getYaw());
					cfg.set("Buehne.Pitch", p.getLocation().getPitch());
					cfg.set("Buehne.WorldName", p.getWorld().getName());
					try {
						cfg.save(file);
						p.sendMessage("§b§lBlank §7» §fDu hast die Bühne gesetzt.");
					} catch (IOException e) {
						p.sendMessage("Error!");
					}
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		} else {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					File file = new File("plugins//Blank//buehne.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					String w = cfg.getString("Buehne.WorldName");
					double x = cfg.getDouble("Buehne.X");
					double y = cfg.getDouble("Buehne.Y");
					double z = cfg.getDouble("Buehne.Z");
					double yaw = cfg.getDouble("Buehne.Yaw");
					double pitch = cfg.getDouble("Buehne.Pitch");
					Location loc = new Location(Bukkit.getWorld(w), x, y, z);
					loc.setYaw((float)yaw);
					loc.setPitch((float)pitch);
					p.teleport(loc);
					p.sendMessage("§b§lBlank §7» §fDu wurdest zur §5§lBühne §fteleportiert.");
				} else {
					sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
				}
			}
		}
		return false;
	}

}
