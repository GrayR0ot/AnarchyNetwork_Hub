package eu.grayroot.anarchyhub.gui;

import java.util.ArrayList;

import eu.grayroot.anarchyhub.Main;
import eu.grayroot.anarchyhub.sql.ServerData;
import eu.grayroot.anarchyhub.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui {

	@SuppressWarnings("deprecation")
	public static void menuGUI(Player player) {
		Inventory MenuGuiInv = Bukkit.createInventory(null, 36, "§8[§bMenu§8]");

		/*ItemStack skyblockServer = new ItemStack(Material.WATER_BUCKET);
		ItemMeta skyblockServerMeta = skyblockServer.getItemMeta();
		skyblockServerMeta.setDisplayName("§a§lSKYBLOCK");
		ArrayList<String> skyblockServerLore = new ArrayList<>();
		skyblockServerLore.add("");
		skyblockServerLore.add("§b» §fDescription:");
		skyblockServerLore.add("§fVous débutez sur une §aîle simple§f.");
		skyblockServerLore.add("§fL'objectif sera d'§aagrandir§f et §asurvivre");
		skyblockServerLore.add("§fsur cette île avec vos amis !");
		skyblockServerLore.add("");
		skyblockServerLore.add("§b» §fDernier reset: §615/06/2019 §7(§cSaison 5§7)");
		skyblockServerLore.add("");
		skyblockServerLore.add("§b» §fJoueurs: §b0§7/§c125");
		skyblockServerLore.add("");
		skyblockServerLore.add("§fClique pour rejoindre le serveur §a§lSKYBLOCK§f.");
		skyblockServerMeta.setLore(skyblockServerLore);
		skyblockServer.setItemMeta(skyblockServerMeta);
		MenuGuiInv.setItem(11, skyblockServer);*/

		ItemStack oitbServer = new ItemStack(Material.ARROW);
		ItemMeta oitbServerMeta = oitbServer.getItemMeta();
		oitbServerMeta.setDisplayName("§5§lOITB");
		ArrayList<String> oitbServerLore = new ArrayList<>();
		oitbServerLore.add("");
		oitbServerLore.add("§b» §fDescription:");
		oitbServerLore.add("§fVous débutez avec un stuff basique§f.");
		oitbServerLore.add("§fL'objectif sera d'§5améliorer§f votre stuff");
		oitbServerLore.add("§fafin de dominer en pvp !");
		oitbServerLore.add("");
		oitbServerLore.add("§b» §fDernier reset: §601/04/2020 §7(§cSaison 1§7)");
		oitbServerLore.add("");
		oitbServerLore.add("§b» §fJoueurs: §b" + new ServerData(Main.getInstance().getConnection()).getServerData("OITB").getPlayers() + "§7/§c" + new ServerData(Main.getInstance().getConnection()).getServerData("OITB").getMaxPlayers());
		oitbServerLore.add("");
		oitbServerLore.add("§fClique pour rejoindre le serveur §5§lOITB§f.");
		oitbServerMeta.setLore(oitbServerLore);
		oitbServer.setItemMeta(oitbServerMeta);
		MenuGuiInv.setItem(13, oitbServer);

		ItemStack prisonServer = new ItemStack(Material.IRON_FENCE);
		ItemMeta prisonServerMeta = prisonServer.getItemMeta();
		prisonServerMeta.setDisplayName("§c§lPRISON");
		ArrayList<String> prisonServerLore = new ArrayList<>();
		prisonServerLore.add("");
		prisonServerLore.add("§b» §fDescription:");
		prisonServerLore.add("§fVous êtes un §cprisonnier§f.");
		prisonServerLore.add("§fVous devez vous en §céchapper");
		prisonServerLore.add("§fpour cela, vous §cminez§f et §cévoluez§f dans les rangs");
		prisonServerLore.add("§fafin d'arriver §c§oFree §fet de sortir !");
		prisonServerLore.add("");
		prisonServerLore.add("§b» §fDernier reset: §605/04/2020 §7(§cSaison 1§7)");
		prisonServerLore.add("");
		prisonServerLore.add("§b» §fJoueurs: §b" + new ServerData(Main.getInstance().getConnection()).getServerData("Prison").getPlayers() + "§7/§c" + new ServerData(Main.getInstance().getConnection()).getServerData("Prison").getMaxPlayers());
		prisonServerLore.add("");
		prisonServerLore.add("§fClique pour rejoindre le serveur §c§lPRISON§f.");
		prisonServerMeta.setLore(prisonServerLore);
		prisonServer.setItemMeta(prisonServerMeta);
		MenuGuiInv.setItem(15, prisonServer);

		/*ItemStack factionServer = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta factionServerMeta = factionServer.getItemMeta();
		factionServerMeta.setDisplayName("§b§lFACTION");
		ArrayList<String> factionServerLore = new ArrayList<>();
		factionServerLore.add("");
		factionServerLore.add("§b» §fDescription:");
		factionServerLore.add("§bCréez§f et survivez dans votre §bbase");
		factionServerLore.add("§fune fois prêt, §bpartez au combat§f.");
		factionServerLore.add("§fEt §bpillez vos adversaires§f sur la carte !");
		factionServerLore.add("");
		factionServerLore.add("§b» §fDernier reset: §613/02/2019 §7(§cSaison 1§7)");
		factionServerLore.add("");
		factionServerLore.add("§b» §fJoueurs: §b0§7/§c125");
		factionServerLore.add("");
		factionServerLore.add("§fClique pour rejoindre le serveur §b§lFACTION§f.");
		factionServerMeta.setLore(factionServerLore);
		factionServer.setItemMeta(factionServerMeta);
		MenuGuiInv.setItem(21, factionServer);

		ItemStack farmrunServer = new ItemStack(Material.MELON_BLOCK);
		ItemMeta farmrunServerMeta = farmrunServer.getItemMeta();
		farmrunServerMeta.setDisplayName("§e§lFARMRUN");
		ArrayList<String> farmrunServerLore = new ArrayList<>();
		farmrunServerLore.add("");
		farmrunServerLore.add("§b» §fDescription:");
		farmrunServerLore.add("§fVous commencez avec une §eparcelle§f.");
		farmrunServerLore.add("§fL'objectif sera §ecultiver§f pour §eévoluer");
		farmrunServerLore.add("§fdans les rangs afin d'être le §eplus riche§f !");
		farmrunServerLore.add("");
		farmrunServerLore.add("§b» §fDernier reset: §624/07/2019 §7(§cSaison 6§7)");
		farmrunServerLore.add("");
		farmrunServerLore.add("§b» §fJoueurs: §b0§7/§c125");
		farmrunServerLore.add("");
		farmrunServerLore.add("§fClique pour rejoindre le serveur §e§lFARMRUN§f.");
		farmrunServerMeta.setLore(farmrunServerLore);
		farmrunServer.setItemMeta(farmrunServerMeta);
		MenuGuiInv.setItem(23, farmrunServer);*/

		ItemStack Background = new ItemStack (Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getData());
		for(int i = 0; i < 36; i++) {
			if(MenuGuiInv.getItem(i) == null || MenuGuiInv
					.getItem(i).getType() == Material.AIR) {
				MenuGuiInv.setItem(i, Background);
			}
		}

		player.openInventory(MenuGuiInv);
	}


	@SuppressWarnings("deprecation")
	public static void socialLinks(Player player) {
		Inventory socialLinks = Bukkit.createInventory(null, 27, "§8[§bRéseaux Sociaux§8]");

		ItemStack Discord = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§9Discord")
				.setLore("", "§b» §fRejoignez-nous sur discord !")
				.setSkull("http://textures.minecraft.net/texture/7873c12bffb5251a0b88d5ae75c7247cb39a75ff1a81cbe4c8a39b311ddeda").setHidenItemFlags().toItemStack();
		socialLinks.setItem(10, Discord);

		ItemStack Website = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§aSite Internet")
				.setLore("", "§b» §fDécouvrez notre site web !")
				.setSkull("http://textures.minecraft.net/texture/2347a39499de49e24c892b092569432927decbb7399e11847f3104fdb165b6dc").setHidenItemFlags().toItemStack();
		socialLinks.setItem(12, Website);

		ItemStack Youtube = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§cYoutube")
				.setLore("", "§b» §fNe manquez pas nos vidéos !")
				.setSkull("http://textures.minecraft.net/texture/d2f6c07a326def984e72f772ed645449f5ec96c6ca256499b5d2b84a8dce").setHidenItemFlags().toItemStack();
		socialLinks.setItem(14, Youtube);

		ItemStack Twitch = new ItemBuilder(Material.SKULL_ITEM,1,(short)3).setName("§5Twitch")
				.setLore("", "§b» §fNe manquez pas nos lives !")
				.setSkull("http://textures.minecraft.net/texture/46be65f44cd21014c8cddd0158bf75227adcb1fd179f4c1acd158c88871a13f").setHidenItemFlags().toItemStack();
		socialLinks.setItem(16, Twitch);

		ItemStack Background = new ItemStack (Material.STAINED_GLASS_PANE, 1, DyeColor.GRAY.getData());
		for(int i = 0; i < 27; i++) {
			if(socialLinks.getItem(i) == null || socialLinks
					.getItem(i).getType() == Material.AIR) {
				socialLinks.setItem(i, Background);
			}
		}

		player.openInventory(socialLinks);
	}

}
