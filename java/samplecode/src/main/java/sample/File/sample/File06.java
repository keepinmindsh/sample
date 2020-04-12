package sample.File.sample;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.File;

@Slf4j
public class File06 {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new JavaFilter());
        fileChooser.setAcceptAllFileFilterUsed(false);
        int result = fileChooser.showOpenDialog(null);
        File file = null;
        if( result == JFileChooser.APPROVE_OPTION){
            file = fileChooser.getSelectedFile();
        }

        if(file.exists()){
            log.info(file.getName());
        }else{
            log.info("파일이 존재하지 않습니다. ");
        }
    }

    public static class JavaFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            if(file.isDirectory()){
                return true;
            }

            String name = file.getName();

            if(name.matches(".*\\.java")){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public String getDescription() {
            return "Java files (*.java)";
        }
    }
}
