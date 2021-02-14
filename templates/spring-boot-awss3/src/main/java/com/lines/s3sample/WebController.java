package com.lines.s3sample;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Controller
public class WebController {

    private final S3Uploader s3Uploader;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        return s3Uploader.upload(multipartFile, "passport");
    }

    @GetMapping("/download")
    @ResponseBody
    public void download(HttpServletRequest request, HttpServletResponse response, @RequestParam("filename") String filename, @RequestParam("uuid") String uuid, @RequestParam("path") String path) throws Exception {

        response.setContentType("image/jpg;");
        response.setHeader("Content-Disposition", "filename=\"" +  filename + "\";");

        BufferedOutputStream outs = new BufferedOutputStream(response.getOutputStream());

        try {
            outs.write(s3Uploader.download(uuid, path));

        }finally {
            if (outs != null) {
                outs.close();
            }
        }
    }
}
