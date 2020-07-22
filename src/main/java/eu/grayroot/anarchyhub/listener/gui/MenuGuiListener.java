package eu.grayroot.anarchyhub.listener.gui;

import eu.grayroot.anarchyhub.Main;
import eu.grayroot.anarchyhub.gui.Gui;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuGuiListener implements Listener {

	@EventHandler
	public void PlayerClickItem(PlayerInteractEvent event) {
		Player player = (Player) event.getPlayer();
		if (player.getItemInHand() != null) {
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
				if (player.getItemInHand().hasItemMeta() && player.getItemInHand().getItemMeta().hasDisplayName()) {
					ItemStack item = event.getItem();
					ItemMeta itemMeta = item.getItemMeta();
					if (item.getType() == Material.SKULL_ITEM && itemMeta.getDisplayName().equalsIgnoreCase("§bLiens")) {
						event.setCancelled(true);
						Gui.socialLinks(player);
					} else if (item.getType() == Material.CHEST && itemMeta.getDisplayName().equalsIgnoreCase("§bMenu")) {
						event.setCancelled(true);
						Gui.menuGUI(player);
					}
				}
			}
		}
	}

	@EventHandler
	public void PlayerGuiClickItem(InventoryClickEvent e) {
		if(e.getWhoClicked().getType() == EntityType.PLAYER) {
			Player player = (Player) e.getWhoClicked();
			if(e.getInventory().getName() == "§8[§bMenu§8]") {
				e.setCancelled(true);
				if(e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName());
				ItemStack clickedItem = e.getCurrentItem();
				if(clickedItem != null && clickedItem.getType() != Material.AIR && clickedItem.getItemMeta() != null);
				ItemMeta clickedItemMeta = clickedItem.getItemMeta();
				if(clickedItem.getType() == Material.WATER_BUCKET && clickedItemMeta.getDisplayName() == "§a§lSKYBLOCK") {
					Main.getInstance().sendPlayerToServer(player, "skyblock");
				} else if(clickedItem.getType() == Material.MELON_BLOCK && clickedItemMeta.getDisplayName() == "§e§lFARMRUN") {
					Main.getInstance().sendPlayerToServer(player, "farmrun");
				} else if(clickedItem.getType() == Material.IRON_FENCE && clickedItemMeta.getDisplayName() == "§c§lPRISON") {
					Main.getInstance().sendPlayerToServer(player, "prison");
				} else if(clickedItem.getType() == Material.DIAMOND_SWORD && clickedItemMeta.getDisplayName() == "§b§lFACTION") {
					Main.getInstance().sendPlayerToServer(player, "faction");
				} else if(clickedItem.getType() == Material.ARROW && clickedItemMeta.getDisplayName() == "§5§lOITB") {
					Main.getInstance().sendPlayerToServer(player, "oitb");
				}
			} else if(e.getInventory().getName() == "§8[§bRéseaux Sociaux§8]") {
				e.setCancelled(true);
				if(e.getCurrentItem() != null);
				ItemStack clickedItem = e.getCurrentItem();
				if(clickedItem.getItemMeta() != null);
				ItemMeta clickedItemMeta = clickedItem.getItemMeta();
				if(clickedItemMeta.getDisplayName() == "§9Discord") {
					Bukkit.getServer().dispatchCommand(
					        Bukkit.getConsoleSender(),
					        "tellraw " + player.getName() + 
					        " {text:\"" + "§8[§b!§8] §b» §fClique ici pour rejoindre le §9Discord §fdu serveur !" + "\",clickEvent:{action:open_url,value:\"" +
					        "https://discord.gg/PZAS3ft" + "\"}}");
				} else if(clickedItemMeta.getDisplayName() == "§aSite Internet") {
					Bukkit.getServer().dispatchCommand(
					        Bukkit.getConsoleSender(),
					        "tellraw " + player.getName() + 
					        " {text:\"" + "§8[§b!§8] §b» §fClique ici pour ouvrir le §aSite web §fdu serveur !" + "\",clickEvent:{action:open_url,value:\"" +
					        "https://anarchynetwork.eu" + "\"}}");
				} else if(clickedItemMeta.getDisplayName() == "§cYoutube") {
					Bukkit.getServer().dispatchCommand(
					        Bukkit.getConsoleSender(),
					        "tellraw " + player.getName() + 
					        " {text:\"" + "§8[§b!§8] §b» §fClique ici pour t'abonner à la chaine §cYoutube §f!" + "\",clickEvent:{action:open_url,value:\"" +
					        "https://www.youtube.com/channel/UCznTB41twvU5u0ZjYi4pm2w?sub_confirmation=1" + "\"}}");
				} else if(clickedItemMeta.getDisplayName() == "§5Twitch") {
					Bukkit.getServer().dispatchCommand(
					        Bukkit.getConsoleSender(),
					        "tellraw " + player.getName() + 
					        " {text:\"" + "§8[§b!§8] §b» §fClique ici pour suivre la chaine §5Twitch §f!" + "\",clickEvent:{action:open_url,value:\"" +
					        "https://www.twitch.tv/tdk_dev" + "\"}}");
				}
			}
		}
	}

}
