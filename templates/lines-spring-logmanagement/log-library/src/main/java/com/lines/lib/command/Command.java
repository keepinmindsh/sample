package com.lines.lib.command;

public interface Command<ResultR>{
    void execute() throws Exception;

    ResultR result();
}
