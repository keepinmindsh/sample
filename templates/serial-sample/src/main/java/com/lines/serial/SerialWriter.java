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

            int intValue = 2;

            String value = " ";

            StringBuilder stringMessage = getStringBuilder2();

            String messageData = stringMessage.toString();

            String prefix = MessageType.STX.getValue();

            String suffix = MessageType.ETX.getValue();

            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append(prefix);
            resultBuilder.append(bcd2str(DecToBCDArray(stringMessage.toString().getBytes().length)));
            resultBuilder.append(messageData);
            resultBuilder.append(suffix);
            resultBuilder.append(lrc2hex(prefix + bcd2str(DecToBCDArray(stringMessage.toString().getBytes().length)) + messageData + suffix));

            System.out.println(resultBuilder.toString());
            this.outputStream.write(resultBuilder.toString().getBytes());

        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public static byte[] DecToBCDArray(int num) {
        int digits = 0;

        long temp = num;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        int byteLen = digits % 2 == 0 ? digits / 2 : (digits + 1) / 2;
        boolean isOdd = digits % 2 != 0;

        byte bcd[] = new byte[byteLen];

        for (int i = 0; i < digits; i++) {
            byte tmp = (byte) (num % 10);

            if (i == digits - 1 && isOdd)
                bcd[i / 2] = tmp;
            else if (i % 2 == 0)
                bcd[i / 2] = tmp;
            else {
                byte foo = (byte) (tmp << 4);
                bcd[i / 2] |= foo;
            }

            num /= 10;
        }

        for (int i = 0; i < byteLen / 2; i++) {
            byte tmp = bcd[i];
            bcd[i] = bcd[byteLen - i - 1];
            bcd[byteLen - i - 1] = tmp;
        }

        return bcd;
    }

    public static String bcd2str(byte[] bcd)
    {
        if (null == bcd || bcd.length == 0)
        {
            return "";
        }
        else
        {
                         // Store the transcoded string
            StringBuilder sb = new StringBuilder();

            // loop array decoding
            for (int i = 0; i < bcd.length; i++)
            {
                // convert low byte
                int low = (bcd[i] & 0x0f);
                sb.append(low);

                // convert high byte
                int high = ((bcd[i] & 0xf0) >> 4);

                // If the high byte is equal to 0xf, it is a complement byte, just throw it away.
                if (high != 0xf)
                {
                    sb.append(high);
                }
            }

            // return the decoded string
            return sb.toString();
        }
    }


    private StringBuilder getStringBuilder2() {
        StringBuilder stringMessage = new StringBuilder();

        stringMessage.append(" ");  // Version - 1
        stringMessage.append("01"); // TransType - 2
        stringMessage.append("000000572500"); // TransAmount - 12
        stringMessage.append("000000000000"); // OtherAmount - 12
        stringMessage.append("                   "); // PAN - 19
        stringMessage.append("0000"); // ExpiryDate - 4
        stringMessage.append("00"); // CancelReason - 2
        stringMessage.append("000000"); // Invoice Number - 6
        stringMessage.append("      "); // Authorization ID Response - 6
        stringMessage.append(" "); // Installment Flag - 1
        stringMessage.append(" "); // Redeem Flag - 1
        stringMessage.append("N"); // DCC Flag - 1
        stringMessage.append("   "); // Installment Plan
        stringMessage.append("  ");  // Installment Tenor
        stringMessage.append("            "); // Generic Data
        stringMessage.append("            "); // Reff Number
        stringMessage.append("                                                      ");
        return stringMessage;
    }

    private StringBuilder getStringBuilder() {
        StringBuilder stringMessage = new StringBuilder();

        stringMessage.append(lpad("" , RequestType.Version.getValue() , " "));
        //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.TransType.getValue()));
        stringMessage.append("01");
        //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.TransAmount.getValue()));
        stringMessage.append("000000572500");

        stringMessage.append(lpad("" , RequestType.PAN.getValue() , " "));
        //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.ExpiryDate.getValue()));
        stringMessage.append("0000");
        //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.CancelReason.getValue()));
        stringMessage.append("00");
        //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.InvoiceNumber.getValue()));
        stringMessage.append("000000");
        stringMessage.append(lpad("" , RequestType.AuthorizationIDResponse.getValue() , " "));
        stringMessage.append(lpad("" , RequestType.InstallmentFlag.getValue() , " "));
        stringMessage.append(lpad("" , RequestType.RedeemFlag.getValue() , " "));
        //stringMessage.append(Stream.generate(() -> " ").limit(RequestType.DCCFlag.getValue()));
        stringMessage.append("N");
        stringMessage.append(lpad("" , RequestType.InstallmentPlan.getValue() , " "));
        stringMessage.append(lpad("" , RequestType.InstallmentTenor.getValue() , " "));
        stringMessage.append(lpad("" , RequestType.GenericData.getValue() , " "));
        stringMessage.append(lpad("" , RequestType.ReffNumber.getValue() , " "));
        stringMessage.append(lpad("" , RequestType.Filler.getValue() , " "));
        return stringMessage;
    }


    public static String convertStringToBinary(String input) {

        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")        // zero pads
            );
        }
        return result.toString();

    }

    public static String lpad(String str, int len, String addStr) {
        String result = str;
        int templen   = len - result.length();

        for (int i = 0; i < templen; i++){
            result = addStr + result;
        }

        return result;
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
