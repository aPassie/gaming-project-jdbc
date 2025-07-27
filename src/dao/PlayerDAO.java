package dao;

import model.Player;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerDAO {
    private Connection connection;

    public PlayerDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPlayer(Player player) throws SQLException {
        String query = "INSERT INTO Player (player_id, username, email, preferences, achievements) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, player.getPlayerId());
            stmt.setString(2, player.getUsername());
            stmt.setString(3, player.getEmail());
            stmt.setString(4, player.getPreferences());
            stmt.setString(5, player.getAchievements());
            stmt.executeUpdate();
        }
    }

    public Player getPlayerById(int playerId) throws SQLException {
        String query = "SELECT * FROM Player WHERE player_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Player(
                    rs.getInt("player_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("preferences"),
                    rs.getString("achievements")
                );
            }
        }
        return null;
    }

    public List<Player> getAllPlayers() throws SQLException {
        List<Player> players = new ArrayList<>();
        String query = "SELECT * FROM Player";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                players.add(new Player(
                    rs.getInt("player_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("preferences"),
                    rs.getString("achievements")
                ));
            }
        }
        return players;
    }

    public void updatePlayer(Player player) throws SQLException {
        String query = "UPDATE Player SET username = ?, email = ?, preferences = ?, achievements = ? WHERE player_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, player.getUsername());
            stmt.setString(2, player.getEmail());
            stmt.setString(3, player.getPreferences());
            stmt.setString(4, player.getAchievements());
            stmt.setInt(5, player.getPlayerId());
            stmt.executeUpdate();
        }
    }

    public void deletePlayer(int playerId) throws SQLException {
        String query = "DELETE FROM Player WHERE player_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            stmt.executeUpdate();
        }
    }

    public Player getPlayerByUsername(String username) throws SQLException {
        String query = "SELECT * FROM Player WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Player(
                    rs.getInt("player_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("preferences"),
                    rs.getString("achievements")
                );
            }
        }
        return null;
    }
}
