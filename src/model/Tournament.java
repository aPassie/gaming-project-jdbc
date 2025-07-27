package model;

public class Tournament {
    private int tournamentId;
    private String name;
    private String bracketType;
    private String prize;

    public Tournament(int tournamentId, String name, String bracketType, String prize) {
        this.tournamentId = tournamentId;
        this.name = name;
        this.bracketType = bracketType;
        this.prize = prize;
    }

    public int getTournamentId() { return tournamentId; }
    public void setTournamentId(int tournamentId) { this.tournamentId = tournamentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBracketType() { return bracketType; }
    public void setBracketType(String bracketType) { this.bracketType = bracketType; }
    public String getPrize() { return prize; }
    public void setPrize(String prize) { this.prize = prize; }
}
