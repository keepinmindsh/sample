package basic.FileClass;

import java.io.File;
import java.io.IOException;

public class FileMethods {
    public static void main(String[] args) throws IOException {
        String folerPath ="F:"+ File.separator + "GIT"+ File.separator + "JavaUtil"+ File.separator + "Java-Util"+ File.separator ;
        String filePath = "TEXT.txt";
        File file = new File(folerPath + filePath);

        if(file.createNewFile()){
            System.out.println("파일이 없어 만들었다");
        }

        if(file.canRead()){
            System.out.println("읽을 수 있다.");
        }

        if(file.canWrite()){
            System.out.println("쓸수 있다.");
        }

        if(file.exists()){
            System.out.println("파일이 존재한다.");
        }

        if(file.renameTo(new File(folerPath + "test.txt"))){
            System.out.println("이름이 변경되었습니다.");
        }

        if(file.delete()){
            System.out.println("파일을 지우다.");
        }

        getFileListFromDirecty(folerPath);
    }

    public static void getFileListFromDirecty(String path){
        File dir = new File(path);

        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            for (File file : files) {
                System.out.println(file.getName() + "  파일인가 ? " + file.isFile());
            }
        }
    }
}
