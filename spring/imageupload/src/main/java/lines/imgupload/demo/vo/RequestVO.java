package lines.imgupload.demo.vo;

import org.springframework.web.multipart.MultipartFile;

public class RequestVO {

    private String appFilePath;
    private String screenType;
    private String key;
    private MultipartFile file;

    public String getAppFilePath() {
        return appFilePath;
    }

    public void setAppFilePath(String appFilePath) {
        this.appFilePath = appFilePath;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
