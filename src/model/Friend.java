package model;

public class Friend {
    private int friendId;
    private int playerId;
    private int friendPlayerId;

    public Friend(int friendId, int playerId, int friendPlayerId) {
        this.friendId = friendId;
        this.playerId = playerId;
        this.friendPlayerId = friendPlayerId;
    }

    public int getFriendId() { return friendId; }
    public void setFriendId(int friendId) { this.friendId = friendId; }
    public int getPlayerId() { return playerId; }
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public int getFriendPlayerId() { return friendPlayerId; }
    public void setFriendPlayerId(int friendPlayerId) { this.friendPlayerId = friendPlayerId; }
}