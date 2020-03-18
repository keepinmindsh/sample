package sample.SocketServerBroadCasting;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ServerSample01 extends Thread {
    static protected MulticastSocket socket = null;
    protected BufferedReader in = null;
    public InetAddress group;

    private static class Receive implements Runnable
    {

        public void run()
        {
            try
            {
                byte[] buf = new byte[256];
                DatagramPacket pkt = new DatagramPacket(buf,buf.length);
                socket.receive(pkt);
                String received = new String(pkt.getData(),0,pkt.getLength());
                System.out.println("From server@" + received);
                Thread.sleep(1000);
            }
            catch (IOException e)
            {
                System.out.println("Error:"+e);
            }
            catch (InterruptedException e)
            {
                System.out.println("Error:"+e);
            }

        }

    }


    public ServerSample01() throws IOException
    {
        super("server");
        socket = new MulticastSocket(4446);
        group = InetAddress.getByName("239.231.12.3");
        socket.joinGroup(group);
    }

    public void run()
    {

        while(1>0)
        {
            try
            {
                byte[] buf = new byte[256];
                DatagramPacket pkt = new DatagramPacket(buf,buf.length);
                //String msg = reader.readLine();
                String pid = ManagementFactory.getRuntimeMXBean().getName();
                buf = pid.getBytes();
                pkt = new DatagramPacket(buf,buf.length,group,4446);
                socket.send(pkt);
                Thread t = new Thread(new Receive());
                t.start();

                while(t.isAlive())
                {
                    t.join(1000);
                }
                sleep(1);
            }
            catch (IOException e)
            {
                System.out.println("Error:"+e);
            }
            catch (InterruptedException e)
            {
                System.out.println("Error:"+e);
            }

        }
        //socket.close();
    }

    public static void main(String[] args) throws IOException
    {
        new ServerSample01().start();
        //System.out.println("Hello");
    }
}
