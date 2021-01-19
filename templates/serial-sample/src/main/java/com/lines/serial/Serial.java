package com.lines.serial;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.InputStream;
import java.io.OutputStream;

public class Serial {

    public Serial() {
        super();
    }


    void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if(portIdentifier.isCurrentlyOwned()){
            System.out.println("Error : Port is currently in use");
        }else{
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 20000);

            if(commPort instanceof SerialPort){
                SerialPort serialPort = (SerialPort) commPort;

                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                InputStream inputStream = serialPort.getInputStream();
                OutputStream outputStream = serialPort.getOutputStream();

                (new Thread(new SerialReader(inputStream))).start();
                (new Thread(new SerialWriter(outputStream))).start();
            }else {
                System.out.println("Error : Only serial ports are handled by this example.");
            }
        }
    }
}
