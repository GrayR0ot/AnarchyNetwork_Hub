package eu.grayroot.anarchyhub.listener;

import eu.grayroot.anarchyhub.Main;
import eu.grayroot.anarchyhub.utils.ItemBuilder;
import eu.grayroot.anarchyhub.utils.PackageSender;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

	@EventHandler
	public void connect(PlayerJoinEvent e) {
		e.setJoinMessage(null);
		Player player = e.getPlayer();
		Configuration config = Main.getInstance().getConfig();
		Location spawn = new Location(Bukkit.getWorld(config.getString("spawn.world")), config.getDouble("spawn.x"), config.getDouble("spawn.y"), config.getDouble("spawn.z"), (float)config.getDouble("spawn.yaw"), (float)config.getDouble("spawn.pitch"));
		player.teleport(spawn);
		player.setHealth(20);
		player.setFoodLevel(20);
		player.getInventory().clear();

		PackageSender.sendHeaderAndFooter(player, "§6§l» §e§lPLAY.ANARCHYNETWORK.EU §6§l«\n§7Découvrez nos jeux §eexclusifs §7!\n§a", "§b\n§7Notre discord: §bhttps://discord.gg/PZAS3ft");
		PackageSender.sendTitle(player, "§eBon retour", "§esur notre Serveur !", 1, 3, 1);

		ItemStack Links = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§bLiens")
				.setSkull("http://textures.minecraft.net/texture/b3840ca69af4fbbec5db7567d3a7021a255e83076d27f06b33cdb0425f2a6b8d").setHidenItemFlags().toItemStack();
		player.getInventory().setItem(3, Links);

		ItemStack Menu = new ItemBuilder(Material.CHEST,1).setName("§bMenu").setHidenItemFlags().toItemStack();
		player.getInventory().setItem(5, Menu);
	}
	
	@EventHandler
	public void disconnect(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		e.setQuitMessage(null);
	}
	
	@EventHandler
    public void onPlayerFall(final PlayerMoveEvent event) {
        final Player player = event.getPlayer();
        final int toY = event.getTo().getBlockY();
        if (toY < 0) {
                player.setFallDistance(0.0f);
                Configuration config = Main.getInstance().getConfig();
                Location spawn = new Location(Bukkit.getWorld(config.getString("spawn.world")), config.getDouble("spawn.x"), config.getDouble("spawn.y"), config.getDouble("spawn.z"), (float)config.getDouble("spawn.yaw"), (float)config.getDouble("spawn.pitch"));
        		player.teleport(spawn);
        }
    }

	@EventHandler
	public void onPickup(PlayerPickupItemEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamage(EntityDamageEvent e) {
		if(e.getEntity() instanceof Player) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamageBlock(BlockDamageEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onFertilize(SignChangeEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void armorStand(PlayerArmorStandManipulateEvent e) {
		if(!e.getPlayer().isOp()) {
			e.setCancelled(true);
		}
	}

}
