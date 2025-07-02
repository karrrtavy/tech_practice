package com.example.shell;

import java.io.File;


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