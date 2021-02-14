package com.lines.s3sample;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class S3Uploader {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(MultipartFile multipartFile, String dirName) throws IOException {
        File uploadFile = convert(multipartFile);
        return upload(uploadFile, dirName);
    }

    private String upload(File uploadFile, String dirName) {
        String fileName = dirName + "/" + uploadFile.getName();
        String uploadImageUrl = putS3(uploadFile, fileName);
        removeNewFile(uploadFile);
        return uploadImageUrl;
    }

    private String putS3(File uploadFile, String fileName) {
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
        return amazonS3Client.getUrl(bucket, fileName).toString();
    }

    public byte[] download(String fileName, String path) throws IOException {

        S3Object s3Object = amazonS3Client.getObject(new GetObjectRequest(bucket +  "/" + path, fileName));
        S3ObjectInputStream objectInputStream  = s3Object.getObjectContent();
        byte[] bytes = IOUtils.toByteArray(objectInputStream);

        return bytes;
    }

    private void removeNewFile(File targetFile) {
        if (targetFile.delete()) {
            log.info("파일이 삭제되었습니다.");
        } else {
            log.info("파일이 삭제되지 못했습니다.");
        }
    }

    private File convert(MultipartFile file) throws IOException {
        FileOutputStream fos = null;
        File returnFile = null;
        try{
            returnFile = new File(file.getOriginalFilename());
            returnFile.createNewFile();

            fos = new FileOutputStream(returnFile);
            fos.write(file.getBytes());
        }catch (Exception exception){
            exception.printStackTrace();
            log.error(exception.getMessage());
        }finally {
            fos.close();
        }

        return returnFile;
    }
}
