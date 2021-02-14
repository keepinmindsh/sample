package com.lines.sample;

import com.lines.serial.code.MessageType;
import com.lines.serial.code.RequestType;

public class Sample {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(MessageType.STX.getValue());

        String value = " ";

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

        String messageData = stringMessage.toString();

        String prefix = MessageType.STX.getValue();
        int binaryLength = Integer.parseInt(convertStringToBinary(messageData), 2);

        String suffix = MessageType.ETX.getValue();

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(prefix);
        resultBuilder.append(binaryLength);
        resultBuilder.append(messageData);
        resultBuilder.append(suffix);
        resultBuilder.append(lrc2hex(prefix + messageData + suffix));

        System.out.println(resultBuilder.toString());
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

    public static String lrc2hex (String str) {
        byte[] bytes = str.getBytes ();
        int lrc = 0;
        for (int i = 0; i < str.length (); i++) {
            lrc ^= (bytes[i] & 0xFF);
        }
        return String.format ("%02X ", lrc);
    }

    public static String lpad(String str, int len, String addStr) {
        String result = str;
        int templen   = len - result.length();

        for (int i = 0; i < templen; i++){
            result = addStr + result;
        }

        return result;
    }
}
