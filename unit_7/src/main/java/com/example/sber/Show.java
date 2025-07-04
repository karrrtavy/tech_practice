package com.example.sber;

import java.sql.*;


@CommandInfo(name = "show", description = "Show all tasks")
public class Show implements Command {
    private final DBManager DBMANAGER;

    public Show(DBManager dbManager) {
        this.DBMANAGER = dbManager;
    }

    @Override
    public void exec() throws Exception {
        System.out.println("Task List:");
        
        try (ResultSet result = DBMANAGER.showTasks()) {
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                String status = result.getString("status");
                System.out.printf("%2d | %-6s | %s%n", id, status, name);
            }
        } catch (SQLException e) {
            throw new Exception("Failed to get tasks: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "Show all tasks";
    }
}