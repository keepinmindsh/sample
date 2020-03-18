package sample.ProcessSample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ProcessRunner {

/*
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] command = new String[] { "notepad" , "" };

        ProcessRunner runner = new ProcessRunner();

        //runner.byRuntimeExecutor(command);
        runner.byProcessBuilder(command);
    }
*/


    public void byRuntimeExecutor(String[] command) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        printStream(process);
    }

    public void byProcessBuilder(String[] command)
            throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder(command);
        Process process = builder.start();
        printStream(process);
    }

    private void printStream(Process process)
            throws IOException, InterruptedException {
        process.waitFor();
        try (InputStream psout = process.getInputStream()) {
            copy(psout, System.out);
        }
    }

    public void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        int n = 0;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
    }
}
