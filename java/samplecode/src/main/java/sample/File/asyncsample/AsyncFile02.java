package sample.File.asyncsample;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class AsyncFile02 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < 10; i++) {
            Path path = Paths.get("c:/r_temp/file" + i + ".txt");

            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,
                    EnumSet.of(StandardOpenOption.READ), executorService);

            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());

            class Attachment {
                Path path;
                AsynchronousFileChannel fileChannel;
                ByteBuffer byteBuffer;

                public Attachment(Path path, AsynchronousFileChannel fileChannel, ByteBuffer byteBuffer) {
                    this.path = path;
                    this.fileChannel = fileChannel;
                    this.byteBuffer = byteBuffer;
                }
            }

            Attachment attachment = new Attachment(path, fileChannel, buffer);

            CompletionHandler<Integer, Attachment> completionHander = new CompletionHandler<Integer, Attachment>() {

                @Override
                public void completed(Integer result, Attachment attachment) {
                    attachment.byteBuffer.flip();

                    Charset charset = Charset.defaultCharset();
                    String data = charset.decode(buffer).toString();

                    log.info(
                            attachment.path.getFileName() + " : " + data + " : " + Thread.currentThread().getName());

                    try {
                        fileChannel.close();
                    } catch (IOException e) {

                    }
                }

                @Override
                public void failed(Throwable exc, Attachment attachment) {
                    exc.printStackTrace();
                    try {
                        fileChannel.close();
                    } catch (IOException e) {

                    }
                }
            };

            fileChannel.read(buffer, 0, attachment, completionHander);

        }
        executorService.shutdown();
    }
}
