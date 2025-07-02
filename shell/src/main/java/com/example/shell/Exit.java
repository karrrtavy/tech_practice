package com.example.shell;

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