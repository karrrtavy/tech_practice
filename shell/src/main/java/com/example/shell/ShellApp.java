package com.example.shell;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ShellApp {
    private final Map<String, Command> commands = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new ShellApp().run();
    }

    public void run() {
        loadCommands();
        System.out.println("Input 'help' for commands list.");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) continue;

            String[] parts = input.split(" ");
            String commandName = parts[0];
            String[] commandArgs = new String[parts.length - 1];
            System.arraycopy(parts, 1, commandArgs, 0, commandArgs.length);

            if (commandName.equals("help")) {
                Help();
                continue;
            }

            Command command = commands.get(commandName);
            if (command == null) {
                System.out.println("Unknown command: " + commandName);
                continue;
            }

            try {
                command.exec(commandArgs);
            } catch (CommandExecutionException e) {
                System.out.println("Error in command '" + e.getName() + "': " + e.getMessage());
            }
        }
    }

    private void Help() {
        System.out.println("All commands:");
        for(Command cmd: commands.values())
            System.out.println(cmd.name() + " - " + cmd.description());
    }

    private void loadCommands() {
        String[] commandClasses = {
            "com.example.shell.Time",
            "com.example.shell.Date",
            "com.example.shell.Catalog",
            "com.example.shell.ChangeDirectory",
            "com.example.shell.ListDirectory",
            "com.example.shell.Exit",
        };

        for (String className : commandClasses) {
            try {
                Class<?> clazz = Class.forName(className);
                if (Command.class.isAssignableFrom(clazz)) {
                    CommandInfo info = clazz.getAnnotation(CommandInfo.class);
                    if (info != null) {
                        Command command = (Command) clazz.getDeclaredConstructor().newInstance();
                        commands.put(info.name(), command);
                    }
                }
            } catch (Exception e) {
                System.err.println("Failed to load command " + className + ": " + e.getMessage());
            }
        }
    }
}