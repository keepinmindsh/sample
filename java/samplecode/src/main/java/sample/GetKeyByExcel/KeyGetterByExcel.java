package sample.GetKeyByExcel;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KeyGetterByExcel {
    public static void main(String[] args) {
        final String filePath = "C:/********/********/Desktop/********.xlsx";
        try {
            // DB Connection
            // JDBC driver name and database URL
            final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
            final String DB_URL = "jdbc:oracle:thin:@********/********";

            //  Database credentials
            final String USER = "********";
            final String PASS = "********";


            // 드라이버를 로딩한다.
            Class.forName(JDBC_DRIVER);
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filePath));
            OPCPackage opcPackage = OPCPackage.open(new File(filePath));
            XSSFWorkbook wb = new XSSFWorkbook(opcPackage);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell jpnCell;
            XSSFCell keyCell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for (int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if (tmp > cols) cols = tmp;
                }
            }

            for (int r = 1; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    jpnCell = row.getCell((short) 8);
                    keyCell = row.getCell((short) 3);

                    if (jpnCell != null && keyCell.getCellType() == CellType.STRING) {
                        if (jpnCell.getCellType() == CellType.NUMERIC) {
                            DBConnector.DBExecutor(String.valueOf(keyCell.getStringCellValue()), String.valueOf(jpnCell.getNumericCellValue()), conn);
                        } else if (jpnCell.getCellType() == CellType.STRING) {
                            DBConnector.DBExecutor(String.valueOf(keyCell.getStringCellValue()), String.valueOf(jpnCell.getStringCellValue()), conn);
                        }
                    }
                }
            }

            try {
                // Connection를 닫는다.
                conn.close();
            } catch (SQLException e) {
                // Connection를 닫는다.
                conn.close();
            } finally {
                // Connection를 닫는다.
                conn.close();
            }
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
