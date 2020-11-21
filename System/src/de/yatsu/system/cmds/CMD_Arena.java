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

public class CMD_Arena implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				if(args[0].equalsIgnoreCase("set")) {
					if(p.hasPermission("blank.arena.set,")) {
					File file = new File("plugins//Blank//arena.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					cfg.set("Arena.X", p.getLocation().getX());
					cfg.set("Arena.Y", p.getLocation().getY());
					cfg.set("Arena.Z", p.getLocation().getZ());
					cfg.set("Arena.Yaw", p.getLocation().getYaw());
					cfg.set("Arena.Pitch", p.getLocation().getPitch());
					cfg.set("Arena.WorldName", p.getWorld().getName());
					try {
						cfg.save(file);
						p.sendMessage("§b§lBlank §7» §fDu hast die Arena gesetzt.");
					} catch (IOException e) {
						p.sendMessage("Error!");
					}
					}
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		} else {
			if(args.length == 0) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
					File file = new File("plugins//Blank//arena.yml");
					YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
					String w = cfg.getString("Arena.WorldName");
					double x = cfg.getDouble("Arena.X");
					double y = cfg.getDouble("Arena.Y");
					double z = cfg.getDouble("Arena.Z");
					double yaw = cfg.getDouble("Arena.Yaw");
					double pitch = cfg.getDouble("Arena.Pitch");
					Location loc = new Location(Bukkit.getWorld(w), x, y, z);
					loc.setYaw((float)yaw);
					loc.setPitch((float)pitch);
					p.teleport(loc);
					p.sendMessage("§b§lBlank §7» §fDu wurdest zur Arena teleportiert. §c§lKämpfe um dein Überleben!");
				} else {
					sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
				}
			}
		}
		return false;
	}

}
