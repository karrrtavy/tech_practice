package com.example.sber;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Command {
    void run();
    String name();
    String description();
}

class Help implements Command {
    private final Map<String, Command> commands;

    public Help(Map<String, Command> commands) {
        this.commands = commands;
    }

    public void run() {
        System.out.println("Commands list:");
        for (Command  cmd : commands.values())
            System.out.println(cmd.name() + " - "  + cmd.description());
    }

    public String name() {
        return "help";
    } 

    public String description() {
        return "List of commands";
    } 
}

class Date implements Command {
    public void run() {
        System.out.println("Current date: " + LocalDate.now());
    }

    public String name() {
        return "date";
    } 

    public String description() {
        return "Shows the date";
    } 
}

class Time implements Command {
    public void run() {
        System.out.println("Current time: " + LocalTime.now());
    }

    public String name() {
        return "time";
    } 

    public String description() {
        return "Shows the time";
    } 
}

class Catalog implements Command {
    public void run() {
        System.out.println("Current catalog: " + new File("").getAbsolutePath());
    }

    public String name() {
        return "pwd";
    } 

    public String description() {
        return "Shows the current catalog";
    } 
}

class Exit implements Command {
    public void run() {
        System.out.println("App complete!");
        System.exit(0);
    }

    public String name() {
        return "exit";
    } 

    public String description() {
        return "Completion of the programm";
    } 
}

 class ShellApp {
    private final Map<String, Command> commands = new HashMap<String, Command>();
    // мапа - интерфейс, хэшмапа - реализация. если объявлять и создавать только мапу, то будет ошибка компиляции. Можно массивами и тд, но не очень будет
    private final Scanner input = new Scanner(System.in);
    private void addCommand(Command command) {
        commands.put(command.name(), command);
    }

    public ShellApp() {
        addCommand(new Help(commands));
        addCommand(new Date());
        addCommand(new Time());
        addCommand(new Catalog());
        addCommand(new Exit());
    }

    public void run() {
        System.out.println("Input 'help' for commands list");

        while (true) {
            String in = input.nextLine();

            if (in.isEmpty()) continue;

            Command command = commands.get(in.toLowerCase());
            if (command != null) command.run();
            else System.out.println("Unknown command. Input 'help' for commands list");
        }
    }
 }

public class Main {
    public static void main(String[] args) {
        new ShellApp().run();
    }

}
