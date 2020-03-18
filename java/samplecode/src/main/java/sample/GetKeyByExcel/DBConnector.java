package sample.GetKeyByExcel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnector {

    static {
        // JDBC driver name and database URL
        final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        final String DB_URL = "jdbc:oracle:thin:@********:********/********";

        //  Database credentials
        final String USER = "********";
        final String PASS = "********";

        Connection conn = null;

        try {
            // 드라이버를 로딩한다.
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param key
     * @param value
     * @param conn
     * @throws ClassNotFoundException
     */
    public static void DBExecutor(String key, String value, Connection conn) throws ClassNotFoundException {
        PreparedStatement stmt = null;
        final String query = "UPDATE ******** " +
                "   SET ******** = ?," +
                "                     ******** = SYSDATE  " +
                " WHERE KEY = ? ";

        try {
            // Statement를 가져온다.
            stmt = conn.prepareStatement(query);

            stmt.setString(1, value);
            stmt.setString(2, key);
            // SQL문을 실행한다.
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ResultSet를 닫는다.
            try {
                // Statement를 닫는다.
                stmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        System.out.println(value + "is finished");
    }
}
