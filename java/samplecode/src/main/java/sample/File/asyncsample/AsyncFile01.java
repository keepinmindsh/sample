package sample.File.asyncsample;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncFile01 {
    public static void main(String[] args) throws IOException {
        // 스레드풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            Path path = Paths.get("./file" + i + ".txt");
            Files.createDirectories(path.getParent());

            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                    EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE), executorService);

            Charset charset = Charset.defaultCharset();
            ByteBuffer buffer = charset.encode("Hello ~ !!");

            class Attachment {
                Path path;
                AsynchronousFileChannel fileChannel;
            }

            Attachment attachment = new Attachment();
            attachment.path = path;
            attachment.fileChannel = fileChannel;

            CompletionHandler<Integer, Attachment> completionHandler = new CompletionHandler<Integer, Attachment>() {

                @Override
                public void completed(Integer result, Attachment attachment) {
                    System.out.println(attachment.path.getFileName() + " : " + result + " bytes written : "
                            + Thread.currentThread().getName());
                    try {
                        attachment.fileChannel.close();
                    } catch (IOException e) {
                    }
                }

                @Override
                public void failed(Throwable exc, Attachment attachment) {
                    exc.printStackTrace();
                    try {
                        attachment.fileChannel.close();
                    } catch (IOException e) {
                    }
                }

            };

            fileChannel.write(buffer, 0, attachment, completionHandler);
        }

        executorService.shutdown();
    }
}
