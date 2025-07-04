package com.example.sber;

@CommandInfo(name = "add", description = "Add a new task")
public class Add implements Command {
    private final DBManager dbManager;
    private final String taskName;

    public Add(DBManager dbManager, String taskName) {
        this.dbManager = dbManager;
        this.taskName = taskName;
    }

    @Override
    public void exec() throws Exception {
        dbManager.addTask(taskName);
        System.out.println("Task added: " + taskName);
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "Add a new task";
    }
}