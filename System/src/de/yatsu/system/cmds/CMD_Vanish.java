package de.yatsu.system.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CMD_Vanish implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 0) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				ItemStack cmd_block = new ItemStack(Material.COMMAND);
				ItemMeta itemmeta = cmd_block.getItemMeta();
				itemmeta.setDisplayName("§4Deactivator");
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1200000000, 1));
				p.setCustomNameVisible(false);
				cmd_block.setItemMeta(itemmeta);
				p.getInventory().setItem(0, cmd_block);
				p.hidePlayer(p);
				p.sendMessage("§b§lBlank §7» §fDu bist nun im Vanish!");
			} else {
				sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
			}
			
			} else {
				if(args.length == 1) {
					if(sender instanceof Player) {
						Player p = (Player) sender;
						Player target = (Bukkit.getPlayer(args[0]));
						ItemStack cmd_block = new ItemStack(Material.COMMAND);
						ItemMeta itemmeta = cmd_block.getItemMeta();
						itemmeta.setDisplayName("§4Deactivator");
						if(target != null) {
							target.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1200000000, 1));
							target.setCustomNameVisible(false);
							cmd_block.setItemMeta(itemmeta);
							target.getInventory().setItem(0, cmd_block);
							p.hidePlayer(target);
							p.sendMessage("§b§lBlank §7» §fDu hast " + target.getDisplayName() + " in den Vanish-Mode versetzt.");
							target.sendMessage("§b§lBlank §7» §fDu bist nun im Vanish!");
						}
					} else {
						sender.sendMessage("§b§lBlank §7» §fDu bist kein Spieler!");
					}
				}
			}
		return false;
	}

}
