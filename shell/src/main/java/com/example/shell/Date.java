package com.example.shell;

import java.time.LocalDate;


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