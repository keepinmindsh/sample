package designpattern.gof_proxy.sample02;

import java.sql.SQLException;

public interface JDBCExecutor {

    public void executeQuery(String SQL) throws SQLException, ClassNotFoundException;
}
