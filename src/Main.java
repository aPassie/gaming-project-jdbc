import dao.*;
import model.*;

import java.sql.*;
import java.util.*;

public class Main {
    private static Connection connection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // Connect to MySQL
            String url = "jdbc:mysql://localhost:3306/gaming_platform";
            String user = "your_mysql_username";
            String password = "your_mysql_password";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL successfully!");

            // DAOs
            PlayerDAO playerDAO = new PlayerDAO(connection);
            FriendDAO friendDAO = new FriendDAO(connection);
            ItemDAO itemDAO = new ItemDAO(connection);
            GameDAO gameDAO = new GameDAO(connection);
            TournamentDAO tournamentDAO = new TournamentDAO(connection);
            StatsDAO statsDAO = new StatsDAO(connection);

            // Menu loop
            while (true) {
                System.out.println("\n=== Gaming Platform Menu ===");
                System.out.println("1. Manage Players");
                System.out.println("2. Manage Friends");
                System.out.println("3. Manage Items");
                System.out.println("4. Manage Games");
                System.out.println("5. Manage Tournaments");
                System.out.println("6. Manage Stats");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // clear newline

                switch (choice) {
                    case 1 -> managePlayers(playerDAO);
                    case 2 -> manageFriends(friendDAO);
                    case 3 -> manageItems(itemDAO);
                    case 4 -> manageGames(gameDAO);
                    case 5 -> manageTournaments(tournamentDAO);
                    case 6 -> manageStats(statsDAO);
                    case 0 -> {
                        System.out.println("Exiting...");
                        connection.close();
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 1. Players
    private static void managePlayers(PlayerDAO dao) throws SQLException {
        System.out.println("\n1. Add Player\n2. View All Players\n3. Delete Player");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Email: ");
                String email = scanner.nextLine();
                System.out.print("Preferences: ");
                String preferences = scanner.nextLine();
                System.out.print("Achievements: ");
                String achievements = scanner.nextLine();
                dao.addPlayer(new Player(0, username, email, preferences, achievements));
            }
            case 2 -> dao.getAllPlayers().forEach(p ->
                    System.out.println(p.getPlayerId() + ": " + p.getUsername()));
            case 3 -> {
                System.out.print("Enter Player ID: ");
                dao.deletePlayer(scanner.nextInt());
            }
        }
    }

    // 2. Friends
    private static void manageFriends(FriendDAO dao) throws SQLException {
        System.out.println("\n1. Add Friend\n2. View All Friends\n3. Delete Friend");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Player ID: ");
                int pid = scanner.nextInt();
                System.out.print("Friend Player ID: ");
                int fid = scanner.nextInt();
                dao.addFriend(new Friend(0, pid, fid));
            }
            case 2 -> dao.getAllFriends().forEach(f ->
                    System.out.println(f.getFriendId() + ": " + f.getPlayerId() + " ↔ " + f.getFriendPlayerId()));
            case 3 -> {
                System.out.print("Enter Friend ID: ");
                dao.deleteFriend(scanner.nextInt());
            }
        }
    }

    // 3. Items
    private static void manageItems(ItemDAO dao) throws SQLException {
        System.out.println("\n1. Add Item\n2. View All Items\n3. Delete Item");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Item Name: ");
                String name = scanner.nextLine();
                System.out.print("Item Type: ");
                String type = scanner.nextLine();
                System.out.print("Player ID: ");
                int pid = scanner.nextInt();
                dao.addItem(new Item(0, name, type, pid));
            }
            case 2 -> dao.getAllItems().forEach(i ->
                    System.out.println(i.getItemId() + ": " + i.getItemName() + " (" + i.getItemType() + ")"));
            case 3 -> {
                System.out.print("Enter Item ID: ");
                dao.deleteItem(scanner.nextInt());
            }
        }
    }

    // 4. Games
    private static void manageGames(GameDAO dao) throws SQLException {
        System.out.println("\n1. Add Game\n2. View All Games\n3. Delete Game");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Match Type: ");
                String matchType = scanner.nextLine();
                System.out.print("Skill Level: ");
                String skillLevel = scanner.nextLine();
                System.out.print("Tournament Format: ");
                String format = scanner.nextLine();
                dao.addGame(new Game(0, matchType, skillLevel, format));
            }
            case 2 -> dao.getAllGames().forEach(g ->
                    System.out.println(g.getGameId() + ": " + g.getMatchType() + ", " + g.getSkillLevel()));
            case 3 -> {
                System.out.print("Enter Game ID: ");
                dao.deleteGame(scanner.nextInt());
            }
        }
    }

    // 5. Tournaments
    private static void manageTournaments(TournamentDAO dao) throws SQLException {
        System.out.println("\n1. Add Tournament\n2. View All Tournaments\n3. Delete Tournament");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Bracket Type: ");
                String bracket = scanner.nextLine();
                System.out.print("Prize: ");
                String prize = scanner.nextLine();
                dao.addTournament(new Tournament(0, name, bracket, prize));
            }
            case 2 -> dao.getAllTournaments().forEach(t ->
                    System.out.println(t.getTournamentId() + ": " + t.getName() + " (" + t.getBracketType() + ")"));
            case 3 -> {
                System.out.print("Enter Tournament ID: ");
                dao.deleteTournament(scanner.nextInt());
            }
        }
    }

    // 6. Stats
    private static void manageStats(StatsDAO dao) throws SQLException {
        System.out.println("\n1. Add Stats\n2. View All Stats\n3. Delete Stats");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1 -> {
                System.out.print("Player ID: ");
                int pid = scanner.nextInt();
                System.out.print("Ranking: ");
                int ranking = scanner.nextInt();
                System.out.print("Progression: ");
                int progression = scanner.nextInt();
                dao.addStats(new Stats(0, pid, ranking, progression));
            }
            case 2 -> dao.getAllStats().forEach(s ->
                    System.out.println(s.getStatsId() + ": Player " + s.getPlayerId() + " → Rank: " +
                            s.getRanking() + ", Progress: " + s.getProgression()));
            case 3 -> {
                System.out.print("Enter Stats ID: ");
                dao.deleteStats(scanner.nextInt());
            }
        }
    }
}
