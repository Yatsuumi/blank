package de.yatsu.system.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Navigator implements Listener {

	private final String GUI_NAME = "§a§lNavigator";

	public void openGUI(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9 * 1, GUI_NAME);

		inv.setItem(2, new ItemStack(Material.EMERALD));
		inv.setItem(4, new ItemStack(Material.SULPHUR));
		inv.setItem(6, new ItemStack(Material.IRON_SWORD));
		p.openInventory(inv);
	}

	@EventHandler
	public void NavigatorOpening(PlayerInteractEvent event) {
		try {
			if (event.getItem().getType() != Material.BEDROCK)
				return;
			if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR)
				openGUI(event.getPlayer());
		} catch (Exception e) {
			e.getSuppressed();
		}
	}

	@EventHandler
	public void NavigatorClick(InventoryClickEvent event) {
		try {

			Location buehne = new Location(Bukkit.getWorld("Buehne"), 1, 8, 55);
			buehne.setYaw((float) 180);
			buehne.setPitch((float) 5);
			Location spawn = new Location(Bukkit.getWorld("Spawn"), 29, 4, 453);
			spawn.setYaw((float) 0);
			spawn.setPitch((float) 2);
			Location arena = new Location(Bukkit.getWorld("Arena"), 67, 9, 168);
			arena.setYaw((float) 90);
			arena.setPitch((float) 0);
			if (!(event.getWhoClicked() instanceof Player))
				return;
			Player p = (Player) event.getWhoClicked();
			if (event.getClickedInventory().getTitle().equals(GUI_NAME)) {
				event.setCancelled(true);
				switch (event.getCurrentItem().getType()) {
				case EMERALD:
					p.teleport(buehne);
					p.sendMessage("§b§lBlank §7» §fDu wurdest zur §5§lBühne §fteleportiert.");
					p.closeInventory();
					break;
				case SULPHUR:
					p.teleport(spawn);
					p.sendMessage("§b§lBlank §7» §fDu wurdest zum Spawn teleportiert.");
					p.closeInventory();
					break;
				case IRON_SWORD:
					p.teleport(arena);
					p.sendMessage("§b§lBlank §7» §fDu wurdest zur Arena teleportiert. §c§lKämpfe um dein Überleben!");
					p.closeInventory();
					break;
				default:
					p.sendMessage("§b§lBlank §7» §fDu hast einen leeren Slot angeklickt!");
					p.closeInventory();
					break;
				}
			}
		} catch (Exception e) {
		}
	}
}
