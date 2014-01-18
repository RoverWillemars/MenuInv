package me.rangeroverr.menuinv;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MenuInv extends JavaPlugin implements Listener {

	private Menu menu;
	
	public void onEnable() {
		menu = new Menu(this);
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		ItemStack item = e.getPlayer().getItemInHand();
		if(item.getType() == Material.EMERALD){
			menu.show(e.getPlayer());
		}

	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		e.getPlayer().getInventory().setItem(8, new ItemStack(Material.EMERALD, 1));
	}
	
	@EventHandler
	public void onDropItem(PlayerDropItemEvent event) {
		  Player player = event.getPlayer();
		  if (event.getItemDrop().getItemStack().getType() == Material.EMERALD) {
			  player.sendMessage(ChatColor.GRAY + "You can't drop this");
			  event.setCancelled(true);
		  }

	}
	
}