package eu.grayroot.anarchyhub.utils;

import eu.grayroot.anarchyhub.Main;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

@SuppressWarnings("deprecation")
public class SpawnUtils {

	public SpawnUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void spawnPlayer(final Player player) {
		player.sendTitle("§6§lTéléportation", "§e§len cours...");
		Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstance(), new Runnable() {
			
			public void run() {
				player.playEffect(player.getLocation(), Effect.MOBSPAWNER_FLAMES, 10);
				player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 1, 1);
				Configuration config = Main.getInstance().getConfig();
				Location spawn = new Location(Bukkit.getWorld(config.getString("spawn.world")), config.getDouble("spawn.x"), config.getDouble("spawn.y"), config.getDouble("spawn.z"), (float)config.getDouble("spawn.yaw"), (float)config.getDouble("spawn.pitch"));
				player.teleport(spawn);
				
			}
		}, 20*3);
	}

}
