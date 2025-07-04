package com.example.sber;

import java.sql.SQLException;

public interface Command {
    String getName();
    String getDescription();
    void exec() throws Exception;
}
