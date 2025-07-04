package com.example.sber;

import java.util.*;


public class ToDoApp {
    private final DBManager DBMANAGER;
    private final Map<String, Command> COMMANDS;
    private final Scanner SCANNER;

    public ToDoApp() {
        this.DBMANAGER = new DBManager();
        this.COMMANDS = new HashMap<>();
        this.SCANNER = new Scanner(System.in);
        registerCommands();
    }

    private void registerCommands() {
        COMMANDS.put("help", new Help(COMMANDS));
        COMMANDS.put("exit", new Exit());
        COMMANDS.put("add", new Add(DBMANAGER, ""));
        COMMANDS.put("show", new Show(DBMANAGER));
        COMMANDS.put("done", new Done(DBMANAGER, 0));
    }

    public void run() {
        System.out.println("Input 'help' for commands.");

        while (true) {
            String input = SCANNER.nextLine();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ", 2);
            String commandName = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";

            Command command = createCommand(commandName, argument);
            if (command == null) {
                System.out.println("Unknown command. Input 'help' for commands.");
                continue;
            }

            try {
                command.exec();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private Command createCommand(String name, String argument) {
        switch (name) {
            case "add":
                return new Add(DBMANAGER, argument);
            case "help":
                return COMMANDS.get("help");
            case "exit":
                return COMMANDS.get("exit");
            case "show":
                return COMMANDS.get("show");
            case "done":
                return COMMANDS.get("done");
            default:
                return null;
        }
    }
}