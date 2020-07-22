package eu.grayroot.anarchyhub;

import eu.grayroot.anarchyhub.command.SpawnCommand;
import eu.grayroot.anarchyhub.listener.ChatListener;
import eu.grayroot.anarchyhub.listener.PlayerListener;
import eu.grayroot.anarchyhub.listener.WorldListener;
import eu.grayroot.anarchyhub.listener.gui.MenuGuiListener;
import eu.grayroot.anarchyhub.sql.SqlConnection;
import eu.grayroot.anarchyhub.utils.ConfigUtils;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends JavaPlugin {

    private static Main instance;
    private static SqlConnection sql;
    private static Connection sqlConnection;

    @Override
    public void onEnable() {
        instance = this;
        sql = new SqlConnection("jdbc:mysql://", "127.0.0.1", 3306, "dbName", "dbUser", "dbPassword");
        try {
            sql.connect();
            log("Successfully connected to SQL Database!");
        } catch (SQLException | ClassNotFoundException e) {
            log("Unable to connect to Database! Closing the server");
            getServer().shutdown();
            e.printStackTrace();
        }
        sqlConnection = sql.getConnection();
        new ConfigUtils().loadConfiguration();
        registerEvents();
        registerCommands();
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    @Override
    public void onDisable() {
        sql.disconnect();
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        //NORMAL LISTENERS
        pm.registerEvents(new PlayerListener(), this);
        pm.registerEvents(new WorldListener(), this);
        pm.registerEvents(new ChatListener(), this);

        //GUI LISTENERS
        pm.registerEvents(new MenuGuiListener(), this);
    }

    private void registerCommands() {
        getCommand("spawn").setExecutor(new SpawnCommand());
    }

    public static Main getInstance() {
        return instance;
    }

    public void sendPlayerToServer(Player player, String server) {

        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }

    public void log(String log) {
        getLogger().info(log);
    }

    public Connection getConnection() {
        return sqlConnection;
    }

}
