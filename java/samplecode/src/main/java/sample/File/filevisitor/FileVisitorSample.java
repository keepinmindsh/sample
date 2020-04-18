package sample.File.filevisitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorSample {

    public static void main(String[] args) {
        Path start = Paths.get("./");

        MyFileVisitor myFileVisitor = new MyFileVisitor();

        try{
            Files.walkFileTree(start, myFileVisitor);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static class MyFileVisitor extends SimpleFileVisitor<Path> {
        public FileVisitResult visitFile(Path file, BasicFileAttributes basicFileAttributes){
            System.out.println(file.toString());
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult visitFileFailed(Path file, BasicFileAttributes basicFileAttributes){
            System.out.println(file.toString() + " Could Not Access!");
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult preVisitDirectoryFailed(Path dir, IOException ioException){
            System.out.println(dir.toString() + " Could Not Access!");
            return FileVisitResult.CONTINUE;
        }
    }
}
