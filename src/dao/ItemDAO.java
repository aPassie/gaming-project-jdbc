package dao;

import model.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    private Connection connection;

    public ItemDAO(Connection connection) {
        this.connection = connection;
    }

    public void addItem(Item item) throws SQLException {
        String query = "INSERT INTO Item (item_id, item_name, item_type, player_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, item.getItemId());
            stmt.setString(2, item.getItemName());
            stmt.setString(3, item.getItemType());
            stmt.setInt(4, item.getPlayerId());
            stmt.executeUpdate();
        }
    }

    public Item getItemById(int itemId) throws SQLException {
        String query = "SELECT * FROM Item WHERE item_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Item(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getString("item_type"),
                    rs.getInt("player_id")
                );
            }
        }
        return null;
    }

    public List<Item> getAllItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM Item";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                items.add(new Item(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getString("item_type"),
                    rs.getInt("player_id")
                ));
            }
        }
        return items;
    }

    public List<Item> getItemsByPlayerId(int playerId) throws SQLException {
        List<Item> items = new ArrayList<>();
        String query = "SELECT * FROM Item WHERE player_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, playerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                items.add(new Item(
                    rs.getInt("item_id"),
                    rs.getString("item_name"),
                    rs.getString("item_type"),
                    rs.getInt("player_id")
                ));
            }
        }
        return items;
    }

    public void updateItem(Item item) throws SQLException {
        String query = "UPDATE Item SET item_name = ?, item_type = ?, player_id = ? WHERE item_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, item.getItemName());
            stmt.setString(2, item.getItemType());
            stmt.setInt(3, item.getPlayerId());
            stmt.setInt(4, item.getItemId());
            stmt.executeUpdate();
        }
    }

    public void deleteItem(int itemId) throws SQLException {
        String query = "DELETE FROM Item WHERE item_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, itemId);
            stmt.executeUpdate();
        }
    }
}
