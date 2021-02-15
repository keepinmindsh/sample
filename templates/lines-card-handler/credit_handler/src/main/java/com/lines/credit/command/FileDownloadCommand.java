package com.lines.credit.command;

import com.lines.comm.command.SimpleCommand;
import com.lines.credit.model.FileResultVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileDownloadCommand implements SimpleCommand<FileResultVO> {

    @Override
    public void execute() throws Exception {

    }

    @Override
    public FileResultVO result() {
        return null;
    }
}
