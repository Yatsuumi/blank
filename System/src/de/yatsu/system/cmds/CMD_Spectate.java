package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CMD_Spectate implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				Player target = Bukkit.getPlayer(args[0]);
				ItemStack i = new ItemStack(Material.CARROT_STICK);
				if(target != null) {
					p.teleport(target);
					p.setGameMode(GameMode.CREATIVE);
					p.getInventory().setItem(1, i);
					p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 120000, 1));
					p.sendMessage("§b§lBlank §7» §fDu spectatest nun " + target.getDisplayName() + ".");
				}
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
		}
		return false;
	}

}
