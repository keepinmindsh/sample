package designpattern.gof_command.sample03;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPRequest {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        StartThread();
    }

    private static void StartThread() {
        executorService.submit(() ->{
            try {
                CallServerSocket();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() ->{
            try {
                CallClientSocket(TCPRequest::StartThread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static void CallClientSocket(ThreadInvoker threadInvoker) throws Exception {
        try{
            // 1. 서버의 IP와 서버의 동작 포트 값(10001)을 인자로 넣어 socket 생성

            Socket sock = new Socket("127.0.0.1", 10001);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));


            // 2. 생성된 Socket으로부터 InputStream과 OutputStream을 구함
            OutputStream out = sock.getOutputStream();
            InputStream in = sock.getInputStream();

            // 3. InputStream은 BufferedReader 형식으로 변환
            //    OutputStream은 PrintWriter 형식으로 변환
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
            // 4. 키보드로부터 한 줄씩 입력받는 BufferedReader 객체 생성
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;

            // 5. 키보드로부터 한 줄을 입력받음
            while((line = keyboard.readLine()) != null){

                if(line.equals("quit")) break;
                // 6. PrintWriter에 있는 println() 메소드를 이용해 서버에게 전송
                pw.println(line);
                pw.flush();
                // 7. 서버가 다시 반환하는 문자열을 BufferedReader에 있는
                //    readLine()을 이용해서 읽어들임
                String echo = br.readLine();
                System.out.println("서버로부터 전달받은 문자열 :" + echo);
            }

            pw.close();
            br.close();
            sock.close();

        }catch(Exception e){
            System.out.println(e);
        }finally {
            threadInvoker.executeThread();
        }

    }

    private static void CallServerSocket() throws Exception {

        ServerSocket serverSocket = new ServerSocket(10001);

        System.out.println("Waiting Connection.....");

        Socket socket = serverSocket.accept();

        InetAddress inetAddress = socket.getInetAddress();
        System.out.println(inetAddress.getHostAddress() + " 로 부터 접속했습니다.");

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line = null;

        while ( ( line = bufferedReader.readLine()) != null ){
            System.out.println("시스템으로 부터 전송 받은 문자열 " + line);
            printWriter.println(line);
            printWriter.flush();
        }

        printWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
