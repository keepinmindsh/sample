package designpattern.gof_proxy.sample02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCExecutorProxy implements JDBCExecutor {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/EMP";

    private static final String USER = "username";
    private static final String PASS = "password";

    STMTExecutor stmtExecutor;

    public JDBCExecutorProxy(STMTExecutor stmtExecutor) {
        this.stmtExecutor = stmtExecutor;
    }

    /**
     * SQL을 실행하는 Proxy 함수
     *
     * @param SQL
     * @throws SQLException
     */
    public void executeQuery(String SQL) throws SQLException, ClassNotFoundException {

        Class.forName(JDBC_DRIVER);

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ResultSet rs = stmtExecutor.executeSTMT(SQL, conn);

        try {
            rs.beforeFirst();
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("id");
                String first = rs.getString("first");
                System.out.print("ID: " + id);
                System.out.print(", First: " + first);
            }
        } finally {
            rs.close();
            conn.close();
        }
    }
}
