package sample.TailJava;


import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TailJava extends JPanel implements Runnable {

    private boolean debug = false;

    private static JTextArea textArea = new JTextArea("The quick brown fox ");
    private static JScrollPane scrollPane = new JScrollPane(textArea);

    private int crunchifyRunEveryNSeconds = 2000;
    private long lastKnownPosition = 0;
    private boolean shouldIRun = true;
    private File crunchifyFile = null;
    private static int crunchifyCounter = 0;

    public TailJava(String myFile, int myInterval) {

        crunchifyFile = new File(myFile);
        this.crunchifyRunEveryNSeconds = myInterval;
    }

    private void initializeUI() {

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        this.setPreferredSize(new Dimension(1028, 768));
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
    }


    private void printLine(String message) {
        System.out.println(message);
    }

    public void stopRunning() {
        shouldIRun = false;
    }

    public void run() {
        try {
            while (shouldIRun) {
                Thread.sleep(crunchifyRunEveryNSeconds);
                long fileLength = crunchifyFile.length();
                if (fileLength > lastKnownPosition) {

                    // Reading and writing file
                    RandomAccessFile readWriteFileAccess = new RandomAccessFile(crunchifyFile, "rw");
                    readWriteFileAccess.seek(lastKnownPosition);
                    String crunchifyLine = null;
                    while ((crunchifyLine = readWriteFileAccess.readLine()) != null) {
                        this.printLine(crunchifyLine);
                        crunchifyCounter++;
                    }
                    lastKnownPosition = readWriteFileAccess.getFilePointer();
                    readWriteFileAccess.close();
                } else {
                    if (debug)
                        this.printLine("Hmm.. Couldn't found new line after line # " + crunchifyCounter);
                }
            }
        } catch (Exception e) {
            stopRunning();
        }
        if (debug)
            this.printLine("Exit the program...");
    }

    public static void main(String argv[]) {


        ExecutorService crunchifyExecutor = Executors.newFixedThreadPool(4);

        // Replace username with your real value
        // For windows provide different path like: c:\\temp\\crunchify.log
        String filePath = "D:/00.PosAgent_Log/20181102/20181102.log";
        TailJava crunchify_tailF = new TailJava(filePath, 2000);

        crunchify_tailF.initializeUI();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                crunchify_tailF.setOpaque(true);

                JFrame frame = new JFrame("JTextArea Demo");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setContentPane(crunchify_tailF);
                frame.pack();
                frame.setVisible(true);
            }
        });


        // Start running log file tailer on crunchify.log file
        crunchifyExecutor.execute(crunchify_tailF);

        // Start pumping data to file crunchify.log file
        appendDataFileRandomAcess(filePath, true, 5000);

    }

    /**
     * Use appendData method to add new line to file, so above tailer method can print the same in Eclipse Console
     *
     * @param filePath
     * @param shouldIRun
     * @param crunchifyRunEveryNSeconds
     */
    private static void appendData(String filePath, boolean shouldIRun, int crunchifyRunEveryNSeconds) {
        FileWriter fileWritter;
        try {
            while (shouldIRun) {
                Thread.sleep(crunchifyRunEveryNSeconds);

                fileWritter = new FileWriter(filePath, true);

                BufferedWriter bufferWritter = new BufferedWriter(fileWritter);

                String data = "\nCrunchify.log file content: " + Math.random();

                bufferWritter.write(data);

                bufferWritter.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void appendDataFile(String filePath, boolean shouldIRun, int crunchifyRunEveryNSeconds) {
        File file;
        try {
            while (shouldIRun) {

                Thread.sleep(crunchifyRunEveryNSeconds);

                file = new File(filePath);

                FileReader fileReader = new FileReader(file);

                BufferedReader bufferedReader = new BufferedReader(fileReader);

                StringBuffer stringBuffer = new StringBuffer();

                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    textArea.append(line);
                    textArea.append("\n");
                }

                fileReader.close();

                System.out.println("Contents of file:");

                System.out.println(stringBuffer.toString());
            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }

    public static void appendDataFileRandomAcess(String filePath, boolean shouldIRun, int crunchifyRunEveryNSeconds) {
        File file;
        try {
            while (shouldIRun) {

                Thread.sleep(crunchifyRunEveryNSeconds);

                RandomAccessFile logfile = new RandomAccessFile(filePath, "r");

                long logFileSize = logfile.length();

                long pos = logFileSize - 1;

                logfile.seek(pos); //파일 라인 끝으로 이동

                while (true) {
                    String line = logfile.readLine();
                    if (line == null) {

                        Thread.sleep(1 * 1000);

                    } else {

                        textArea.append(line);

                        int posLine = textArea.getText().length();

                        textArea.append("\n");

                        textArea.setCaretPosition(posLine);

                        textArea.requestFocus();
                    }

                }

            }
        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}
