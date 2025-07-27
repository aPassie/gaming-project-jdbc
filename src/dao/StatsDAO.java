package dao;

import model.Stats;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatsDAO {
    private Connection connection;

    public StatsDAO(Connection connection) {
        this.connection = connection;
    }

    public void addStats(Stats stats) throws SQLException {
        String query = "INSERT INTO Stats (stats_id, player_id, ranking, progression) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stats.getStatsId());
            stmt.setInt(2, stats.getPlayerId());
            stmt.setInt(3, stats.getRanking());
            stmt.setInt(4, stats.getProgression());
            stmt.executeUpdate();
        }
    }

    public Stats getStatsById(int statsId) throws SQLException {
        String query = "SELECT * FROM Stats WHERE stats_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, statsId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Stats(
                    rs.getInt("stats_id"),
                    rs.getInt("player_id"),
                    rs.getInt("ranking"),
                    rs.getInt("progression")
                );
            }
        }
        return null;
    }

    public Stats getStatsByPlayerId(int playerId) throws SQLException {
        String query = "SELECT * FROM Stats WHERE player_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Stats(
                    rs.getInt("stats_id"),
                    rs.getInt("player_id"),
                    rs.getInt("ranking"),
                    rs.getInt("progression")
                );
            }
        }
        return null;
    }

    public List<Stats> getAllStats() throws SQLException {
        List<Stats> statsList = new ArrayList<>();
        String query = "SELECT * FROM Stats";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                statsList.add(new Stats(
                    rs.getInt("stats_id"),
                    rs.getInt("player_id"),
                    rs.getInt("ranking"),
                    rs.getInt("progression")
                ));
            }
        }
        return statsList;
    }

    public void updateStats(Stats stats) throws SQLException {
        String query = "UPDATE Stats SET player_id = ?, ranking = ?, progression = ? WHERE stats_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, stats.getPlayerId());
            stmt.setInt(2, stats.getRanking());
            stmt.setInt(3, stats.getProgression());
            stmt.setInt(4, stats.getStatsId());
            stmt.executeUpdate();
        }
    }

    public void deleteStats(int statsId) throws SQLException {
        String query = "DELETE FROM Stats WHERE stats_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, statsId);
            stmt.executeUpdate();
        }
    }
}
