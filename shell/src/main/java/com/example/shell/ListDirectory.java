package com.example.shell;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;


@CommandInfo(name = "ls", description = "List of directory")
public class ListDirectory implements Command {

    @Override
    public void exec(String[] args) {
        String dirPath = args.length > 0 ? args[0] : ".";
        File dir = new File(dirPath);

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }
}