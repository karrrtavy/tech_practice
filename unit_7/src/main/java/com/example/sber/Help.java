package com.example.sber;

import java.util.Map;


@CommandInfo(name = "help", description = "Show all commands")
public class Help implements Command{
    private final Map<String, Command> COMMANDS;

    public Help(Map<String, Command> COMMANDS) {
        this.COMMANDS = COMMANDS;
    }

    public Map<String, Command> getCommands() {
        return COMMANDS;
    }

    @Override
    public void exec() {
        for(Command cmd: COMMANDS.values())
            System.out.println(cmd.getName() + " - " + cmd.getDescription());
    }

        @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Show all commands";
    }
}