package com.lines.digger.command.operation;

import com.lines.lib.operation.Operate;
import lombok.RequiredArgsConstructor;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.reactive.function.server.ServerRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RequiredArgsConstructor
public class FileDownload implements Operate {

    private final ServerRequest serverRequest;

    @Override
    public Object operate() throws Exception {

        HttpServletResponse response = null;

        String startPath = serverRequest.queryParam("path").orElse("/");

        File file = new File( startPath);
        if (file.exists() && file.isFile()) {
            response.setContentType("application/octet-stream; charset=utf-8");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Transfer-Encoding", "binary");
            OutputStream out = response.getOutputStream();
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            FileCopyUtils.copy(fis, out);
            if (fis != null)
                fis.close();
            out.flush();
            out.close();
        }

        return null;
    }
}
