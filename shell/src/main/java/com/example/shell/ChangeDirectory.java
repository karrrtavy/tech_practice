package com.example.shell;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@CommandInfo(name = "cd", description = "Change current directory")
public class ChangeDirectory implements Command {

    @Override
    public void exec(String[] args) throws CommandExecutionException {
        if (args.length == 0)
            System.setProperty("user.dir", System.getProperty("user.home"));

        Path curDir = Paths.get(System.getProperty("user.dir"));
        String newPath = args[0];
        Path newDir;

        newDir = Paths.get(newPath);
        if (!newDir.isAbsolute())
            newDir = curDir.resolve(newDir).normalize();

        File nextDir = newDir.toFile();

        if (!nextDir.exists()) throw new CommandExecutionException("cd", "Directory is not exists: " + newDir);
        if (!nextDir.isDirectory()) throw new CommandExecutionException("cd", "Path is not directory: " + newDir);

        System.setProperty("user.dir", newDir.toString());

    }
}