package de.yatsu.system.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Protection implements Listener {
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		Player p = event.getPlayer();
		if(p.hasPermission("blank.bypass")) {
		} else {
			event.setCancelled(true);
			
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		Player p = event.getPlayer();
		if(p.hasPermission("blank.bypass")) {
			
		} else {
			event.setCancelled(true);
		}
	}
	@EventHandler
	public void onFallDmg(EntityDamageEvent event) {
		if(event.getCause() == DamageCause.FALL) {
			event.setCancelled(true);
			event.getEntity().setFallDistance(0);
		}
	}
	@EventHandler
	public void onExplosion(EntityExplodeEvent event) {
		event.blockList().clear();
	}
	@EventHandler
	public void onWeatherChange(WeatherChangeEvent event) {
		event.setCancelled(true);
	}
	@EventHandler
	public void onPunch(EntityDamageByEntityEvent event) {
		Player p = (Player) event.getEntity();
		if (event.getDamager() instanceof Player) {
			p.setHealth(20);
		}
	}

}
