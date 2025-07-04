package com.example.shell;

import java.util.Map;


@CommandInfo(name = "help", description = "list of commands")
class Help implements Command {
    private final Map<String, Command> COMMANDS;

    public Help(Map<String, Command> COMMANDS) {
        this.COMMANDS = COMMANDS;
    }

    public Map<String, Command> getCommands() {
        return COMMANDS;
    }

    @Override
    public void exec(String[] args) {
        for(Command cmd: COMMANDS.values())
            System.out.println(cmd.name() + " - " + cmd.description());
    }
}