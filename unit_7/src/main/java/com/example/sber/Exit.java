package com.example.sber;

@CommandInfo(name = "exit", description = "Exit the application")
public class Exit implements Command {
    @Override
    public void exec() {
        System.out.println("Complete app");
        System.exit(0);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "Exit the application";
    }
}