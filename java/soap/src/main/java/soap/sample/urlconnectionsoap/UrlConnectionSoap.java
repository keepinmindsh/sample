package soap.sample.urlconnectionsoap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionSoap {
    public static void main(String[] args) throws Exception {

        String xml = "            <SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:myNamespace=\"https://www.w3schools.com/xml/\">\n" +
                "                <SOAP-ENV:Header/>\n" +
                "                <SOAP-ENV:Body>\n" +
                "                    <myNamespace:CelsiusToFahrenheit>\n" +
                "                        <myNamespace:Celsius>100</myNamespace:Celsius>\n" +
                "                    </myNamespace:CelsiusToFahrenheit>\n" +
                "                </SOAP-ENV:Body>\n" +
                "            </SOAP-ENV:Envelope>";

        URL url = new URL("https://www.w3schools.com/xml/tempconvert.asmx");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        // Header 영역에 쓰기
        conn.addRequestProperty("Content-Type", "text/xml");
        // BODY 영역에 쓰기
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(xml);
        wr.flush();

        // 리턴된 결과 읽기
        String inputLine = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
        wr.close();


    }
}
