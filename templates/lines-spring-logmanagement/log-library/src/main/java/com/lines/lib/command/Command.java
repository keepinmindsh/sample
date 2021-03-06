package com.lines.lib.command;

public interface Command<ResultR>{
    void execute();

    ResultR result();
}
