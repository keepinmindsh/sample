package com.lines.comm.command;

public interface SimpleCommand<ReturnR> {

    void execute() throws Exception;

    ReturnR result();
}
