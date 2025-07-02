package com.example.shell;

import java.util.Map;


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