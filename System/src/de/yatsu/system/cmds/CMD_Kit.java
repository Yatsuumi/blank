package de.yatsu.system.cmds;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CMD_Kit implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				ItemStack black = new ItemStack(Material.WOOD_SWORD);
				ItemStack white = new ItemStack(Material.IRON_AXE);
				ItemStack black1 = new ItemStack(Material.BOW);
				ItemStack white1 = new ItemStack(Material.FISHING_ROD);
				ItemStack arrows = new ItemStack(Material.ARROW, 64);
				ItemStack pearls = new ItemStack(Material.ENDER_PEARL, 16);
				ItemStack coal = new ItemStack(Material.COAL);
				ItemMeta itemmeta = coal.getItemMeta();
				if(args[0].equalsIgnoreCase("black")) {
					p.getInventory().addItem(black);
					coal.setItemMeta(itemmeta);
					p.getInventory().addItem(coal);
					p.getInventory().addItem(black1);
				}
				if(args[0].equalsIgnoreCase("white")) {
					p.getInventory().addItem(white);
					coal.setItemMeta(itemmeta);
					p.getInventory().addItem(coal);
					p.getInventory().addItem(white1);
				}
				if(args[0].equalsIgnoreCase("arrows")) {
					p.getInventory().addItem(arrows);
				}
				if(args[0].equalsIgnoreCase("pearls")) {
					p.getInventory().addItem(pearls);
				}
				if(args[0].equalsIgnoreCase("list")) {
					p.sendMessage("§b§lBlank §7» §fKits: black, white, arrows, pearls");
				}
			}
		} else {
			if(args.length == 0) {
				Player p = (Player) sender;
				p.sendMessage("§b§lBlank §7» §fKits: black, white, arrows, pearls");
			}
		}
		return false;
	}

}
