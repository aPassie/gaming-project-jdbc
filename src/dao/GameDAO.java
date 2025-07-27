package dao;

import model.Game;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDAO {
    private Connection connection;

    public GameDAO(Connection connection) {
        this.connection = connection;
    }

    public void addGame(Game game) throws SQLException {
        String query = "INSERT INTO Game (game_id, match_type, skill_level, tournament_format) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, game.getGameId());
            stmt.setString(2, game.getMatchType());
            stmt.setString(3, game.getSkillLevel());
            stmt.setString(4, game.getTournamentFormat());
            stmt.executeUpdate();
        }
    }

    public Game getGameById(int gameId) throws SQLException {
        String query = "SELECT * FROM Game WHERE game_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, gameId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Game(
                    rs.getInt("game_id"),
                    rs.getString("match_type"),
                    rs.getString("skill_level"),
                    rs.getString("tournament_format")
                );
            }
        }
        return null;
    }

    public List<Game> getAllGames() throws SQLException {
        List<Game> games = new ArrayList<>();
        String query = "SELECT * FROM Game";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                games.add(new Game(
                    rs.getInt("game_id"),
                    rs.getString("match_type"),
                    rs.getString("skill_level"),
                    rs.getString("tournament_format")
                ));
            }
        }
        return games;
    }

    public void updateGame(Game game) throws SQLException {
        String query = "UPDATE Game SET match_type = ?, skill_level = ?, tournament_format = ? WHERE game_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, game.getMatchType());
            stmt.setString(2, game.getSkillLevel());
            stmt.setString(3, game.getTournamentFormat());
            stmt.setInt(4, game.getGameId());
            stmt.executeUpdate();
        }
    }

    public void deleteGame(int gameId) throws SQLException {
        String query = "DELETE FROM Game WHERE game_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, gameId);
            stmt.executeUpdate();
        }
    }
}
