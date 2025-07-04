package com.example.shell;

import java.time.LocalDate;


@CommandInfo(name = "date", description = "get current date")
class Date implements Command {
    @Override
    public void exec(String[] args) {
        System.out.println(LocalDate.now());
    }
}