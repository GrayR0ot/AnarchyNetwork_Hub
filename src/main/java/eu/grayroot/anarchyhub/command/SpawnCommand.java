package eu.grayroot.anarchyhub.command;

import eu.grayroot.anarchyhub.utils.SpawnUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			new SpawnUtils().spawnPlayer(player);
		}
		return false;
	}

}
