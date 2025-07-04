package com.example.shell;


public interface Command {
    void exec(String[] args) throws CommandExecutionException;

    default String name() {
        CommandInfo info = this.getClass().getAnnotation(CommandInfo.class);
        if(info == null) {
            throw new IllegalStateException("Command " + this.getClass().getSimpleName() + 
                                         " must be annotated with @CommandInfo");
        }
        return info.name();
    }

    default String description() {
        CommandInfo info = this.getClass().getAnnotation(CommandInfo.class);
        if (info == null) {
            throw new IllegalStateException("Command " + this.getClass().getSimpleName() + 
                                         " must be annotated with @CommandInfo");
        }
        return info.description();
    }
}