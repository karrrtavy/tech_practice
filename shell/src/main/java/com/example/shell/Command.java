package com.example.shell;

public interface Command {
    void run();
    String name();
    String description();
}