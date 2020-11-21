package de.yatsu.system.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EffectEvent2 implements Listener {
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		Action action = event.getAction();
	     if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
	    	 if(player.getItemInHand().getType() == Material.WOOD_SWORD) {
	    		 player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 120000, 1));
	    	 }
	    	 if(player.getItemInHand().getType() == Material.IRON_AXE) {
	    		 player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 120000, 1));
	    	 }
		     if (player.getItemInHand().getType() == Material.COAL) {
		         player.removePotionEffect(PotionEffectType.INVISIBILITY);
		         player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		         player.setCustomNameVisible(true);
	         }
	     }
	}

}
