# 🎮 Gaming Platform (JDBC + MySQL)

A console-based gaming service backend built using **Java**, **JDBC**, and **MySQL**. This project enables core gaming functionalities like player registration, tournament participation, virtual item trading, and player performance tracking. Built as part of a DBMS improvement task.

---

## ✨ Features

- 👤 Player Profile Creation (with region & achievements)
- 🕹️ Game and Match Management (match types, skill levels)
- 📈 Player Statistics (ranking, wins, progression)
- 🏆 Tournament Registration and Bracket Management
- 💰 Virtual Items (purchase, trade, earn)
- 💬 Social Features (friend lists, team formation - optional)
- 🚫 Moderation (basic schema support for cheating/account flags)
- 📊 Analytics-ready schema for in-game economy, rankings, and retention

---

## 🛠 Tech Stack

- 💻 Java 17+
- 🔌 JDBC (MySQL Connector J 9.4.0)
- 🗄️ MySQL 8+
- 🖥️ Console-based Java Application
- 🧾 SQL Schema (`schema.sql`)

---

## 🚀 How to Run This Project

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/aPassie/gaming-project-jdbc.git
cd gaming-project-jdbc
```

---

### 2️⃣ Import the Database Schema

In **MySQL Workbench** or **MySQL CLI**, execute:

```sql
SOURCE schema.sql;
```

---

### 3️⃣ Configure Database Credentials

Open `DBConnection.java` and update your MySQL credentials:

```java
private static final String URL = "jdbc:mysql://localhost:3306/gaming_platform";
private static final String USER = "your_mysql_username";
private static final String PASSWORD = "your_mysql_password";
```

---

### 4️⃣ Compile the Java Code

```bash
javac -cp ".;lib/mysql-connector-j-9.4.0.jar" -d bin src/dao/*.java src/Main.java
```

On **Linux/macOS**, use `:` instead of `;` for the classpath separator.

---

### 5️⃣ Create the Executable .jar File

Make sure your `manifest.txt` contains:

```text
Main-Class: Main
Class-Path: lib/mysql-connector-j-9.4.0.jar
```

Then run:

```bash
jar cfm gaming_platform.jar manifest.txt -C bin .
```

---

### 6️⃣ Run the Application

```bash
java -jar gaming_platform.jar
```

A console menu should appear, allowing you to:
- Register players
- Join tournaments
- Purchase items
- Track player progress

---

## 📁 Project Structure

```text
gaming-project-jdbc/
├── bin/                        # Compiled .class files (for manual builds)
├── out/                        # IntelliJ build output
├── lib/
│   └── mysql-connector-j-9.4.0.jar
├── manifest.txt                # JAR manifest with main class and classpath
├── gaming_project.jar          # Final JAR output
├── gaming_project.zip          # Zipped archive of the project (for submission)
├── gaming-project-jdbc.iml     # IntelliJ project metadata
└── src/
    ├── dao/
    │   ├── FriendDAO.java
    │   ├── GameDAO.java
    │   ├── ItemDAO.java
    │   ├── PlayerDAO.java
    │   ├── StatsDAO.java
    │   └── TournamentDAO.java
    ├── Main.java
    └── model/
        ├── Friend.java
        ├── Game.java
        ├── Item.java
        ├── Player.java
        ├── Stats.java
        └── Tournament.java
```

---

