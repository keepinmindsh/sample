package soap.sample.javaxsoap;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.util.Iterator;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;

import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.dom.DOMSource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import org.json.simple.parser.JSONParser;

@Slf4j
public class SoapClient2 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder parser = factory.newDocumentBuilder();

            //request SOAP message DOMSource create
            String sendMessage = "            <SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:myNamespace=\"https://www.w3schools.com/xml/\">\n" +
                    "                <SOAP-ENV:Header/>\n" +
                    "                <SOAP-ENV:Body>\n" +
                    "                    <myNamespace:CelsiusToFahrenheit>\n" +
                    "                        <myNamespace:Celsius>100</myNamespace:Celsius>\n" +
                    "                    </myNamespace:CelsiusToFahrenheit>\n" +
                    "                </SOAP-ENV:Body>\n" +
                    "            </SOAP-ENV:Envelope>";

            StringReader reader = new StringReader(sendMessage);
            InputSource is = new InputSource(reader);
            Document document = parser.parse(is);
            DOMSource requestSource = new DOMSource(document);

            //SOAPMessage create
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage requestSoapMessage = messageFactory.createMessage();
            SOAPPart requestSoapPart = requestSoapMessage.getSOAPPart();
            requestSoapPart.setContent(requestSource);

            //SOAPConnection create instance
            SOAPConnectionFactory scf = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = scf.createConnection();

            //SOAP SEND MESSAGE
            SOAPMessage responseSoapMessage = connection.call(requestSoapMessage, "https://www.w3schools.com/xml/tempconvert.asmx");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            responseSoapMessage.writeTo(out);
            //String soapResult = new String(out.toByteArray(), "UTF-8");

            SOAPBody soapBody = responseSoapMessage.getSOAPBody();

            Iterator i = soapBody.getChildElements();
            Node node = (Node) i.next();

            JSONParser jsonParser = new JSONParser();
            Object soapResult1 =  jsonParser.parse(node.getChildNodes().item(0).getChildNodes().item(0).getNodeValue());
            Object soapResult2 =  node.getChildNodes().toString();

            log.debug(soapBody.getValue());
            log.debug(soapResult1.toString());
            log.debug(soapResult2.toString());

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            responseSoapMessage.writeTo(stream);
            String message = new String(stream.toByteArray(), "utf-8");

            log.debug("Soap String Result : {}", message);

            DOMSource source = new DOMSource(soapBody);
            CelsiusToFahrenheitResponse results = JAXB.unmarshal(source, CelsiusToFahrenheitResponse.class);

            log.debug(results.toString());

            /*
                TODO
                Saop Body를 VO로 변경하는 부분에 대해서 분석 필요
            */

//            Unmarshaller unmarshaller = JAXBContext.newInstance(CelsiusToFahrenheitResponse.class).createUnmarshaller();
//            CelsiusToFahrenheitResponse farm = (CelsiusToFahrenheitResponse)unmarshaller.unmarshal(responseSoapMessage.getSOAPBody().extractContentAsDocument());
//
//            log.debug(farm.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

@Getter
@Setter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class CelsiusToFahrenheitResponse {
    @XmlElement(name = "CelsiusToFahrenheitResult")
    private int CelsiusToFahrenheitResult;
}
