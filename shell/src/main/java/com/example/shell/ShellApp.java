package com.example.shell;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


 class ShellApp {
    private final Map<String, Command> commands = new HashMap<String, Command>();
    // мапа - интерфейс, хэшмапа - реализация. если объявлять и создавать только мапу, то будет ошибка компиляции. Можно массивами и тд, но не очень будет
    private final Scanner input = new Scanner(System.in);
    private void addCommand(Command command) {
        commands.put(command.name(), command);
    }

    public ShellApp() {
        addCommand(new Help(commands));
        addCommand(new Date());
        addCommand(new Time());
        addCommand(new Catalog());
        addCommand(new Exit());
    }

    public void run() {
        System.out.println("Input 'help' for commands list");

        while (true) {
            String in = input.nextLine();

            if (in.isEmpty()) continue;

            Command command = commands.get(in.toLowerCase());
            if (command != null) command.run();
            else System.out.println("Unknown command. Input 'help' for commands list");
        }
    }
 }