package sample.ProcessSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessScreen extends JFrame {

    // 메인
    public static void main(String[] args) {
        new ProcessScreen();
    }

    JTextArea textArea;

    // 생성자
    public ProcessScreen() {
        setTitle("Command Line Process 테스트");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        FlowLayout flowLayout = new FlowLayout();

        flowLayout.setAlignment(FlowLayout.LEFT);

        setLayout(flowLayout);
        JButton button1 = new JButton("메모장 실행");
        JButton button2 = new JButton("그림판 실행");
        JButton button3 = new JButton("새창 실행");
        JButton button4 = new JButton("아무거나 실행하기");

        JPanel panel = new JPanel();

        textArea = new JTextArea();

        JTextField textField = new JTextField();
        textArea.setColumns(20);
        textArea.setRows(20);

        textField.setColumns(30);
        textField.setBackground(Color.WHITE);
        panel.add(textField);
        // panel.add(textArea);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(panel);

        actionListner01 btnBtn1 = new actionListner01();
        actionListner02 btnBtn2 = new actionListner02();
        actionListner03 btnBtn3 = new actionListner03();
        //actionListner04 btnBtn4 = new actionListner04();

        button1.addActionListener(btnBtn1);
        button2.addActionListener(btnBtn2);
        button3.addActionListener(btnBtn3);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Runnable runnable = () -> {
                    try {
                        Process p = Runtime.getRuntime().exec(textField.getText());
                        byte[] msg = new byte[128];
                        int len;
                        BufferedReader in;
                        //while((len=p.getInputStream().read(msg)) > 0) {

                        in = new BufferedReader(new InputStreamReader(p.getInputStream(), "UTF-8"));

                        StringBuffer sb = new StringBuffer();
                        String thisLine = null;
                        while ((thisLine = in.readLine()) != null) {

                            textArea.append(thisLine);
                            textArea.append("\r\n");
                        }
                        //}
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                };


                Thread thread = new Thread(runnable);

                thread.start();

            }
        });


        //안에 들어갈 내용물들, 레이아웃, 패널설정, 컴포넌트들
        this.setVisible(true);
    }
}

class actionListner01 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Runnable runnable = () -> {
            ProcessRunner runner = new ProcessRunner();

            String[] command = {"notepad.exe", ""};

            try {
                runner.byProcessBuilder(command);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}

class actionListner02 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Runnable runnable = () -> {
            ProcessRunner runner = new ProcessRunner();

            String[] command = {"mspaint.exe", ""};

            try {
                runner.byProcessBuilder(command);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}

class actionListner03 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Runnable runnable = () -> {
            ProcessRunner runner = new ProcessRunner();

            String[] command = {"explorer.exe", ""};

            try {
                runner.byProcessBuilder(command);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);

        thread.start();

    }
}

class actionListner04 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Process p = Runtime.getRuntime().exec("ping https://wingspms.sanhait.com/pms");
            byte[] msg = new byte[128];
            int len;
            while ((len = p.getInputStream().read(msg)) > 0) {
                System.out.print(new String(msg, 0, len));
            }
            byte[] rb = new byte[]{(byte) 'n'}; //rs.getBytes();
            OutputStream os = p.getOutputStream();
            os.write(rb);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
