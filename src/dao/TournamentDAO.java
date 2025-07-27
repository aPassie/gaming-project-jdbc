package dao;

import model.Tournament;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TournamentDAO {
    private Connection connection;

    public TournamentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addTournament(Tournament tournament) throws SQLException {
        String query = "INSERT INTO Tournament (tournament_id, name, bracket_type, prize) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, tournament.getTournamentId());
            stmt.setString(2, tournament.getName());
            stmt.setString(3, tournament.getBracketType());
            stmt.setString(4, tournament.getPrize());
            stmt.executeUpdate();
        }
    }

    public Tournament getTournamentById(int tournamentId) throws SQLException {
        String query = "SELECT * FROM Tournament WHERE tournament_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, tournamentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Tournament(
                    rs.getInt("tournament_id"),
                    rs.getString("name"),
                    rs.getString("bracket_type"),
                    rs.getString("prize")
                );
            }
        }
        return null;
    }

    public List<Tournament> getAllTournaments() throws SQLException {
        List<Tournament> tournaments = new ArrayList<>();
        String query = "SELECT * FROM Tournament";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                tournaments.add(new Tournament(
                    rs.getInt("tournament_id"),
                    rs.getString("name"),
                    rs.getString("bracket_type"),
                    rs.getString("prize")
                ));
            }
        }
        return tournaments;
    }

    public void updateTournament(Tournament tournament) throws SQLException {
        String query = "UPDATE Tournament SET name = ?, bracket_type = ?, prize = ? WHERE tournament_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tournament.getName());
            stmt.setString(2, tournament.getBracketType());
            stmt.setString(3, tournament.getPrize());
            stmt.setInt(4, tournament.getTournamentId());
            stmt.executeUpdate();
        }
    }

    public void deleteTournament(int tournamentId) throws SQLException {
        String query = "DELETE FROM Tournament WHERE tournament_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, tournamentId);
            stmt.executeUpdate();
        }
    }

    public List<Tournament> getTournamentsByBracketType(String bracketType) throws SQLException {
        List<Tournament> tournaments = new ArrayList<>();
        String query = "SELECT * FROM Tournament WHERE bracket_type = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, bracketType);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tournaments.add(new Tournament(
                    rs.getInt("tournament_id"),
                    rs.getString("name"),
                    rs.getString("bracket_type"),
                    rs.getString("prize")
                ));
            }
        }
        return tournaments;
    }
}
