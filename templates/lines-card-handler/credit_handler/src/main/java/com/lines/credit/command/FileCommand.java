package com.lines.credit.command;

import com.lines.comm.command.SimpleCommand;
import com.lines.credit.model.FileResultVO;
import com.lines.credit.model.LinesFile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileCommand implements SimpleCommand<FileResultVO> {

    private final LinesFile linesFile;

    @Override
    public void execute() throws Exception {

    }

    @Override
    public FileResultVO result() {
        return null;
    }
}
