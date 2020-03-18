package sample.ConvertToXML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringWriter;

public class JaxbExample {

    public static void main(String[] args) {

        RequestVO requestVO = new RequestVO();

        requestVO.setBsnsCode("11");
        requestVO.setIntfType("INF");
        requestVO.setPropertyNo("11");
        requestVO.setLangType("KOR");
        requestVO.setUperIp("admin");
        requestVO.setUperIp("1.1.1.1");
        requestVO.setResultMsg("This is a message.");
        requestVO.setResultYN("Y");
        requestVO.setResultRefCursor("Cursor is not good");

        jaxbObjectToXML(requestVO);

        jaxbObjectToXMLWithFile(requestVO);


        String fileName = "employee.xml";

        jaxbXmlFileToObject(fileName);
    }

    private static void jaxbObjectToXML(RequestVO requestVO)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(RequestVO.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            StringWriter sw = new StringWriter();

            //Write XML to StringWriter
            jaxbMarshaller.marshal(requestVO, sw);

            //Verify XML Content
            String xmlContent = sw.toString();
            System.out.println( xmlContent );

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void jaxbObjectToXMLWithFile(RequestVO requestVo)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(RequestVO.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("employee.xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(requestVo, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    private static void jaxbXmlFileToObject(String fileName) {

        File xmlFile = new File(fileName);

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(RequestVO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            RequestVO reqeustVO = (RequestVO) jaxbUnmarshaller.unmarshal(xmlFile);

            System.out.println(reqeustVO.toString());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
