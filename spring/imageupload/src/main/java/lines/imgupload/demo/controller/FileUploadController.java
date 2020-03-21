package lines.imgupload.demo.controller;

import lines.imgupload.demo.vo.RequestVO;
import io.swagger.annotations.Api;
import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.util.Optional;

@Api(value="Lines API")
@Controller
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @GetMapping("/form")
    public String from(Model model){

        model.addAttribute("message", "Hello World");
        model.addAttribute("tasks", "taskName");

        return "uploadForm";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@ModelAttribute RequestVO requestParam) throws URISyntaxException, IOException {
        logger.info("### upload");

        File targetFile = new File("/Users/dream/test/uploadsfile/" + requestParam.getFile().getOriginalFilename());

        OutputStream outputStream = new FileOutputStream("/Users/dream/test/uploadsfile/thumnail/" +  requestParam.getFile().getOriginalFilename());

        ByteArrayOutputStream thumbOutput = null;
        try {
            InputStream fileStream = requestParam.getFile().getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile);

            thumbOutput= createThumbnail(requestParam.getFile(), 512);

            thumbOutput.writeTo(outputStream);
        } catch (IOException e) {
            FileUtils.deleteQuietly(targetFile);
            e.printStackTrace();
        } finally {

            Optional.ofNullable(thumbOutput).ifPresent(output -> {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputStream.close();
        }
        return "redirect:/form";
    }

    private ByteArrayOutputStream createThumbnail(MultipartFile orginalFile, Integer width) throws IOException{
        ByteArrayOutputStream thumbOutput = new ByteArrayOutputStream();
        BufferedImage thumbImg = null;
        BufferedImage img = ImageIO.read(orginalFile.getInputStream());
        thumbImg = Scalr.resize(img, Scalr.Method.AUTOMATIC, Scalr.Mode.AUTOMATIC, width, Scalr.OP_ANTIALIAS);
        ImageIO.write(thumbImg, orginalFile.getContentType().split("/")[1] , thumbOutput);
        return thumbOutput;
    }
}
