package eu.grayroot.anarchyhub.sql;

import eu.grayroot.anarchyhub.Main;
import eu.grayroot.anarchyhub.object.AnarchyServer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServerData {

	private Connection connection;

	public ServerData(Connection connection) {
		this.connection = Main.getInstance().getConnection();
	}
	
	public boolean isRegistered(AnarchyServer server){
		try {
			PreparedStatement q = connection.prepareStatement("SELECT `name` FROM `servers` WHERE `name` = ?");
			q.setString(1, server.getName());
			ResultSet resultat = q.executeQuery();
			boolean isRegistered = resultat.next();
			q.close();
			return isRegistered;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void registerServer(AnarchyServer anarchyServer){
		try {
			PreparedStatement rs = connection.prepareStatement("INSERT INTO `servers` (name, players, max_players, status) VALUES (?,?,?,?)");
			rs.setString(1, anarchyServer.getName());
			rs.setInt(2, anarchyServer.getPlayers());
			rs.setInt(3, anarchyServer.getMaxPlayers());
			rs.setBoolean(4, anarchyServer.isStatus());
			rs.executeUpdate();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public AnarchyServer getServerData(String name) {
		AnarchyServer anarchyServer = null;
		try {
			PreparedStatement q = connection.prepareStatement("SELECT * FROM `servers` WHERE `name` = ?");
			q.setString(1, name);
			ResultSet rs = q.executeQuery();
			while (rs.next()) {
				anarchyServer = new AnarchyServer(rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("players"),
						rs.getInt("max_players"),
						rs.getBoolean("status"));
			}
			q.close();
			return anarchyServer;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return anarchyServer;
	}

	public void updateServerData(AnarchyServer anarchyServer){
		try {
			PreparedStatement rs = connection.prepareStatement("UPDATE `servers` SET `players`=?, `max_players`=?, `status`=? WHERE `name`=?");
			rs.setInt(1, anarchyServer.getPlayers());
			rs.setInt(2, anarchyServer.getMaxPlayers());
			rs.setBoolean(3, anarchyServer.isStatus());
			rs.setString(4, anarchyServer.getName());
			rs.executeUpdate();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
