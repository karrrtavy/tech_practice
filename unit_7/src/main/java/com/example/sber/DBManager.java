package com.example.sber;

import java.sql.*;


public class DBManager {
    private static final String URL = "jdbc:h2:mem:tododb";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private Connection connection;

    public DBManager() {
        createDatabase();
    }

    private void createDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createTables();
        } catch (SQLException e) {
            System.err.println("Database load failed: " + e.getMessage());
        }
    }

    private void createTables() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS Tasks (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100) NOT NULL,
                status BOOLEAN DEFAULT false
            )
            """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Created table");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error with closing connection: " + e.getMessage());
        }
    }

    public void addTask(String name) throws SQLException {
        String sql = "INSERT INTO Tasks (name) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
    }

    public ResultSet showTasks() throws SQLException {
        String sql = "SELECT * FROM Tasks";
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(sql);
    }

    public void markTask(int id) throws SQLException {
        String sql = "UPDATE Tasks SET status = 'DONE' WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
