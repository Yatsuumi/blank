package de.yatsu.system.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectEvent implements Listener {
	
	@EventHandler
	public void onPlayerClicks(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    Action action = event.getAction();

	     if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
	         if (player.getItemInHand().getType() == Material.IRON_AXE) {
	             player.sendMessage("§6Die Stärke des §fweißen Kriegers §6fließt durch deinen Körper!");
	             player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120000, 2));
	         } 
	         if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
	             player.sendMessage("§6Die Stärke des §0schwarzen Kriegers §6fließt durch deinen Körper!");
	             player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120000, 2));
	         }
		     if (player.getItemInHand().getType() == Material.COAL) {
		         player.sendMessage("§6Deine Kräfte verlassen dich!");
		         player.removePotionEffect(PotionEffectType.JUMP);
		         player.removePotionEffect(PotionEffectType.SPEED);
	         } 
		     if (player.getItemInHand().getType() == Material.COMMAND) {
		         player.removePotionEffect(PotionEffectType.INVISIBILITY);
		         player.setCustomNameVisible(true);
		         player.sendMessage("§b§lBlank §7» §fDu bist nun wieder sichtbar.");
		         player.getInventory().remove(Material.COMMAND);
		         player.playSound(player.getLocation(), Sound.ANVIL_LAND, 1, 1);
	         }
		    	 if(player.getItemInHand().getType() == Material.CARROT_STICK) {
		    		 player.removePotionEffect(PotionEffectType.INVISIBILITY);
		    		 player.getInventory().remove(Material.CARROT_STICK);
		     }
	     }

	}

}
