package com.lines.serial;

import com.lines.serial.code.MessageType;
import com.lines.serial.code.RequestType;
import sun.misc.Request;

import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Stream;

public class SerialWriter implements Runnable{

    OutputStream outputStream;

    public SerialWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {


            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(MessageType.STX.getValue());

            String value = " ";

            StringBuilder stringMessage = new StringBuilder();

            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.Version.getValue()));
            //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.TransType.getValue()));
            stringMessage.append("01");
            //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.TransAmount.getValue()));
            stringMessage.append("000000572500");

            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.PAN.getValue()));
            //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.ExpiryDate.getValue()));
            stringMessage.append("0000");
            //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.CancelReason.getValue()));
            stringMessage.append("00");
            //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.InvoiceNumber.getValue()));
            stringMessage.append("000000");
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.AuthorizationIDResponse.getValue()));
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.InstallmentFlag.getValue()));
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.RedeemFlag.getValue()));
            //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.DCCFlag.getValue()));
            stringMessage.append("N");
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.InstallmentPlan.getValue()));
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.InstallmentTenor.getValue()));
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.GenericData.getValue()));
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.ReffNumber.getValue()));
            stringMessage.append(Stream.generate(() -> " ").limit(RequestType.Filler.getValue()));

            String messageData = stringMessage.toString();

            String prefix = MessageType.STX.getValue();
            int binaryLength = Integer.parseInt(messageData, 2);

            String suffix = MessageType.ETX.getValue();

            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(prefix);
            resultBuilder.append(binaryLength);
            resultBuilder.append(messageData);
            resultBuilder.append(suffix);
            resultBuilder.append(lrc2hex(prefix + binaryLength + messageData + suffix));
            this.outputStream.write(value.getBytes());

        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static String lrc2hex (String str) {
        byte[] bytes = str.getBytes ();
        int lrc = 0;
        for (int i = 0; i < str.length (); i++) {
            lrc ^= (bytes[i] & 0xFF);
        }
        return String.format ("%02X ", lrc);
    }
}
