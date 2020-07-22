package eu.grayroot.anarchyhub.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage();

        String playerRank = "§7Joueur§f";
        message = message.replaceAll("%", "%%");
        e.setFormat(playerRank + " " + player.getName() + "§8: §r" + message);
    }
}
