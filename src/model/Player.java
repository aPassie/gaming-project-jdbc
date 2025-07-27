package model;

public class Player {
    private int playerId;
    private String username;
    private String email;
    private String preferences;
    private String achievements;

    public Player(int playerId, String username, String email, String preferences, String achievements) {
        this.playerId = playerId;
        this.username = username;
        this.email = email;
        this.preferences = preferences;
        this.achievements = achievements;
    }

    public int getPlayerId() { return playerId; }
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPreferences() { return preferences; }
    public void setPreferences(String preferences) { this.preferences = preferences; }
    public String getAchievements() { return achievements; }
    public void setAchievements(String achievements) { this.achievements = achievements; }
}
