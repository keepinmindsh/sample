package com.lines.credit.command.operation.file.factory;

import com.lines.credit.command.operation.file.type.DownloadCreditFileByURL;
import com.lines.credit.command.operation.file.type.FileOperation;
import com.lines.credit.model.LinesFile;

public class LinesFileFactory {
    public static FileOperation getFileOperation(LinesFile linesFile){
        switch (linesFile.getFileType()){
            case UPLOAD:
            case DOWNLOAD:
            default:
                return new DownloadCreditFileByURL();
        }
    }
}
