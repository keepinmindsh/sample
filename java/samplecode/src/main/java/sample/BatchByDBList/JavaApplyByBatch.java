package sample.BatchByDBList;

import java.sql.*;

public class JavaApplyByBatch {

    static final String JDBC_DRIVER = "com.oracle.jdbc.Driver";

    private static void callBatchProcess(String url, String user, String password, String sqlStr) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connection to Database .......");
            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            String sql = sqlStr;

            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {

            }

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
