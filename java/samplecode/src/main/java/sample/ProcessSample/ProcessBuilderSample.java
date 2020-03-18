package sample.ProcessSample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ProcessBuilderSample {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> commands1 = Arrays.asList("C:\\JAVA64_Eclipse\\eclipse\\eclipse.exe");

        List<String> commands2 = Arrays.asList("netstat");

        List<String> commands3 = Arrays.asList(
                "C:\\Program Files\\Java\\jdk1.8.0_161\\bin\\java",
                "-jar",
                "-Dspring.profiles.active=7004",
                "C:\\oxygen-eclipse\\wings-module-workspace\\wings-api-service\\target\\wings-api-service7004.jar"
        );

        List<String> commands4 = Arrays.asList(
                "tasklist",
                "/v"
        );

        List<String> commands5 = Arrays.asList(
                "netstat",
                "-a",
                "-n",
                "-o",
                "| find",
                "135"
        );

        List<String> commands6 = Arrays.asList(
                "netstat",
                "-ano"
        );

        executeFile(commands6);

        //getExecuteCommand("netstat -a -n -o | find \"135\"");
    }

    public static void getExecuteCommand(String Command) {

        Process p = null;

        try {
            p = Runtime.getRuntime().exec(Command);
            p.waitFor();

            if (p.exitValue() != 0) {
                BufferedReader err = new BufferedReader(new InputStreamReader(p.getErrorStream(), "MS949"));
                while (err.ready())
                    System.out.println("ERR " + err.readLine());
                err.close();

            } else {
                BufferedReader out = new BufferedReader(new InputStreamReader(p.getInputStream(), "MS949"));
                while (out.ready())
                    System.out.println("O K " + out.readLine());
                out.close();

            }

            p.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void executeFile(List<String> commands) throws IOException, InterruptedException {

        //String filePath = "C:\\JAVA64_Eclipse\\eclipse\\eclipse.exe";

        List<String> cmd = commands;


        ProcessBuilder builer = new ProcessBuilder(cmd);

        Process process = builer.start();

        BufferedReader br1 = new BufferedReader(new InputStreamReader(((java.lang.Process) process).getInputStream(), "MS949"));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(((java.lang.Process) process).getErrorStream(), "MS949"));

        String logBuilder = "";
        String errorBuilder = "";

        while ((logBuilder = br1.readLine()) != null) {
            System.out.println(logBuilder);
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
