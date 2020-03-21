package basic.FileClass;

import javax.swing.*;
import java.io.File;

public class FileSelector {

    public static void main(String[] args) {
        File file = getFile();

        System.out.println(file.getName());
    }

    private static File getFile(){
        JFileChooser jFileChooser = new JFileChooser();

        int result = jFileChooser.showDialog(null, "선택");

        File file = null;
        if(result == JFileChooser.APPROVE_OPTION){
            file = jFileChooser.getSelectedFile();
        }

        return file;

    }
}
