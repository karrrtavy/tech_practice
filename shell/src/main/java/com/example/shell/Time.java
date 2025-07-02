package com.example.shell;

import java.time.LocalTime;


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