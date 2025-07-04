package com.example.shell;


@CommandInfo(name = "exit", description = "completion of the programm")
class Exit implements Command {
    @Override
    public void exec(String[] args) {
        System.out.println("App complete!");
        System.exit(0);
    }
}