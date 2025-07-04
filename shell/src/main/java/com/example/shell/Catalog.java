package com.example.shell;

import java.nio.file.Paths;


@CommandInfo(name = "pwd", description = "Change current directory")
public class Catalog implements Command {
    
    @Override
    public void exec(String[] args) {
        System.out.println(Paths.get("").toAbsolutePath());
    }
}