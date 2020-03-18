package sample.GetProperty;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertyGetter {

    public static void main(String[] args) throws IOException {
        CrunchifyGetPropertyValues values = new CrunchifyGetPropertyValues();

        values.getPropValues();
    }
}

class CrunchifyGetPropertyValues {
    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "dbcon.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            String company1 = prop.getProperty("DSNS_LYJ.ora.url");
            String company2 = prop.getProperty("DSNS_LYJ.ora.username");
            String company3 = prop.getProperty("DSNS_LYJ.ora.password");

            result = "Company List = " + company1 + ", " + company2 + ", " + company3;
            System.out.println(result + "\nProgram Ran on " + time);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}