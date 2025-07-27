package dao;

import model.Friend;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO {
    private Connection connection;

    public FriendDAO(Connection connection) {
        this.connection = connection;
    }

    public void addFriend(Friend friend) throws SQLException {
        String query = "INSERT INTO Friend (friend_id, player_id, friend_player_id) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, friend.getFriendId());
            stmt.setInt(2, friend.getPlayerId());
            stmt.setInt(3, friend.getFriendPlayerId());
            stmt.executeUpdate();
        }
    }

    public Friend getFriendById(int friendId) throws SQLException {
        String query = "SELECT * FROM Friend WHERE friend_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, friendId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Friend(
                    rs.getInt("friend_id"),
                    rs.getInt("player_id"),
                    rs.getInt("friend_player_id")
                );
            }
        }
        return null;
    }

    public List<Friend> getAllFriends() throws SQLException {
        List<Friend> friends = new ArrayList<>();
        String query = "SELECT * FROM Friend";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                friends.add(new Friend(
                    rs.getInt("friend_id"),
                    rs.getInt("player_id"),
                    rs.getInt("friend_player_id")
                ));
            }
        }
        return friends;
    }

    public void updateFriend(Friend friend) throws SQLException {
        String query = "UPDATE Friend SET player_id = ?, friend_player_id = ? WHERE friend_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, friend.getPlayerId());
            stmt.setInt(2, friend.getFriendPlayerId());
            stmt.setInt(3, friend.getFriendId());
            stmt.executeUpdate();
        }
    }

    public void deleteFriend(int friendId) throws SQLException {
        String query = "DELETE FROM Friend WHERE friend_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, friendId);
            stmt.executeUpdate();
        }
    }

    public List<Friend> getFriendsOfPlayer(int playerId) throws SQLException {
        List<Friend> friends = new ArrayList<>();
        String query = "SELECT * FROM Friend WHERE player_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                friends.add(new Friend(
                    rs.getInt("friend_id"),
                    rs.getInt("player_id"),
                    rs.getInt("friend_player_id")
                ));
            }
        }
        return friends;
    }
}
