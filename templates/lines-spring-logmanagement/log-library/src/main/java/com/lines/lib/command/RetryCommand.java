package com.lines.lib.command;

public interface RetryCommand<ResultR> extends Command{
    public ResultR retry();
}
