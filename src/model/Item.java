package model;

public class Item {
    private int itemId;
    private String itemName;
    private String itemType;
    private int playerId;

    public Item(int itemId, String itemName, String itemType, int playerId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.playerId = playerId;
    }

    public int getItemId() { return itemId; }
    public void setItemId(int itemId) { this.itemId = itemId; }
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }
    public int getPlayerId() { return playerId; }
    public void setPlayerId(int playerId) { this.playerId = playerId; }
}

