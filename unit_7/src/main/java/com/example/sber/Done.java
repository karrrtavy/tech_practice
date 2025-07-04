package com.example.sber;

@CommandInfo(name = "done", description = "Mark task")
public class Done implements Command {
    private final DBManager DBMANAGER;
    private final int TASKID;

    public Done(DBManager dbManager, int taskId) {
        this.DBMANAGER = dbManager;
        this.TASKID = taskId;
    }

    @Override
    public void exec() throws Exception {
        try {
            DBMANAGER.markTask(TASKID);
            System.out.println("Task " + TASKID + " marked");
        } catch (SQLException e) {
            throw new Exception("Failed to mark task as done: " + e.getMessage());
        }
    }

    @Override
    public String getName() {
        return "done";
    }

    @Override
    public String getDescription() {
        return "Mark task as done";
    }
}