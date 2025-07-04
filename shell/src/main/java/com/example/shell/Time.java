package com.example.shell;

import java.time.LocalTime;


@CommandInfo(name = "time", description = "get current time")
class Time implements Command {
    @Override
    public void exec(String[] args) {
        System.out.println(LocalTime.now());
    }
}