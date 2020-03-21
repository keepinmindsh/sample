package basic.PathClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClass {
    public static void main(String[] args) {
        Path path = Paths.get("D:/test/Hellow.txt");
        // 경로 루트
        System.out.printf("Root   : %s \n" , path.getRoot());
        // 경로의 부모
        System.out.printf("Parent : %s \n", path.getParent());
        // 경로의 요소
        for (int i = 0; i < path.getNameCount(); i++) {
            System.out.printf("getNameCount %d : %s \n"  ,i, path.getName(i));
        }
        // 서브경로
        System.out.printf("subu path : %s \n", path.subpath(0, path.getNameCount()));
        System.out.println();

        try {
            // 경로를 실제 경로로 변환
            // path가 실제로 존재하지 않으면 에러가 발생
            Path real_path = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            System.out.println(real_path);

            // 경로를 파일로 변환
            File path_to_file = path.toFile();

            // 파일에서 path추출
            Path file_to_path = path_to_file.toPath();

            // 파일에서 파일 이름
            System.out.printf("Path to file name : %s \n" , path_to_file.getName());
            // 파일에서 추출한 path에서의 경로
            System.out.printf("File to path      : %s \n" , file_to_path.toString());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
