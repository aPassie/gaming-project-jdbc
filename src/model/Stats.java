package model;

public class Stats {
    private int statsId;
    private int playerId;
    private int ranking;
    private int progression;

    public Stats(int statsId, int playerId, int ranking, int progression) {
        this.statsId = statsId;
        this.playerId = playerId;
        this.ranking = ranking;
        this.progression = progression;
    }

    public int getStatsId() { return statsId; }
    public void setStatsId(int statsId) { this.statsId = statsId; }
    public int getPlayerId() { return playerId; }
    public void setPlayerId(int playerId) { this.playerId = playerId; }
    public int getRanking() { return ranking; }
    public void setRanking(int ranking) { this.ranking = ranking; }
    public int getProgression() { return progression; }
    public void setProgression(int progression) { this.progression = progression; }
}
