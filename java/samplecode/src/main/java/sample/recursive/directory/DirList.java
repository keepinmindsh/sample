package sample.recursive.directory;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.Scanner;

@Slf4j
public class DirList {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        log.info("Welcome to the Directory Lister");

        do {
            log.info("\nEnter a path : ");
            String path = scanner.nextLine();
            File dir = new File(path);
            if(!dir.exists() || !dir.isDirectory() ){
                log.info("\nThat directory doesn't exist.");
            }else{
                log.info("\nListing directory tree of:");
                log.info(dir.getPath());
                listDirectories(dir, "  ");
            }
        } while(askAgain());
    }

    private static void listDirectories(File dir, String indent){
        File[] dirs = dir.listFiles();
        for (File file :
                dirs) {
            if (file.isDirectory()) {
                log.info(indent + file.getName());
                listDirectories(file, indent + "  ");

            }
        }
    }

    private static boolean askAgain(){
        log.info("Another ? ( Y or N ) ");
        String reply = scanner.nextLine();
        if(reply.equalsIgnoreCase("Y")){
            return true;
        }
        return false;
    }
}
