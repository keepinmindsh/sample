package sample.ProcessSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ProcessPortChecker {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> commands6 = Arrays.asList(
                "netstat",
                "-ano"
        );

        checkPortExist(commands6);
    }

    public static void checkPortExist(List<String> commands) throws IOException, InterruptedException {
        Process process = new ProcessBuilder(commands).start();

        BufferedReader br1 = new BufferedReader(new InputStreamReader(((java.lang.Process) process).getInputStream(), "MS949"));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(((java.lang.Process) process).getErrorStream(), "MS949"));

        String logBuilder = "";
        String errorBuilder = "";

        while ((logBuilder = br1.readLine()) != null) {
            if (logBuilder.indexOf(":80") > 0) {
                System.out.println(logBuilder);
            }
        }
        ;

        while ((errorBuilder = br2.readLine()) != null) {
            System.out.println(errorBuilder);
        }
        ;

        br1.close();
        br2.close();
        process.waitFor();
        process.destroy();
    }
}
