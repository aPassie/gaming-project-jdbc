package model;

public class Game {
    private int gameId;
    private String matchType;
    private String skillLevel;
    private String tournamentFormat;

    public Game(int gameId, String matchType, String skillLevel, String tournamentFormat) {
        this.gameId = gameId;
        this.matchType = matchType;
        this.skillLevel = skillLevel;
        this.tournamentFormat = tournamentFormat;
    }

    public int getGameId() { return gameId; }
    public void setGameId(int gameId) { this.gameId = gameId; }
    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }
    public String getSkillLevel() { return skillLevel; }
    public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }
    public String getTournamentFormat() { return tournamentFormat; }
    public void setTournamentFormat(String tournamentFormat) { this.tournamentFormat = tournamentFormat; }
}
