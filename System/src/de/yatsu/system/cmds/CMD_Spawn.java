package de.yatsu.system.cmds;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.yatsu.system.main.Main;

public class CMD_Spawn implements CommandExecutor {

	/*
	private Timer timer;
	private int i;
	


	public CMD_Spawn() {
		timer = new Timer();
	}
	*/
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				File file = new File("plugins//Blank//spawn.yml");
				YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				String w = cfg.getString("Spawn.WorldName");
				double x = cfg.getDouble("Spawn.X");
				double y = cfg.getDouble("Spawn.Y");
				double z = cfg.getDouble("Spawn.Z");
				double yaw = cfg.getDouble("Spawn.Yaw");
				double pitch = cfg.getDouble("Spawn.Pitch");
				Location loc = new Location(Bukkit.getWorld(w), x, y, z);
				loc.setYaw((float)yaw);
				loc.setPitch((float)pitch);
				
				if(!p.hasPermission("blank.spawn.instant")) {
					p.sendMessage("Du wirst in 3 Sekunden Teleportiert!");
					Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
						
						@Override
						public void run() {
							
							if(p != null) {
								p.teleport(loc);
							}
						}
					}, 20*3);
					
					
					
					
					
					
					/*
					setI(3);		
					timer.scheduleAtFixedRate(new TimerTask() {
						
					Warte xd
						@Override
						public void run() {
							setI(getI() - 1);
							p.sendMessage("§cNoch §e" + getI() + " Sekunden §cwarten"); 
							if(getI() == 0) {
								p.teleport(loc);
								p.sendMessage("§b§lBlank §7» §fDu wurdest erfolgreich zum Spawn teleportiert."); //Hab da schon angefangen, mit Timer iwie. diesdas.
							}
						}
					}, 0, 3000); 
					*/
				}else {
					p.teleport(loc);
				}
				

			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		}
		return false;
	}
	/*
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	*/

}
