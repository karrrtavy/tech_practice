package com.example.shell;

import lombok.Getter;


public class CommandExecutionException extends Exception {
    private final String name;

    public CommandExecutionException(String name, String message) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}