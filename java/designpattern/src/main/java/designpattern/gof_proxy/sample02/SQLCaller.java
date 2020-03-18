package designpattern.gof_proxy.sample02;

import java.sql.SQLException;

public class SQLCaller {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCExecutor jdbcExecutor = new JDBCExecutorProxy(new SelectExecutor());

        jdbcExecutor.executeQuery("SELECT * FROM USERS;");
    }
}
