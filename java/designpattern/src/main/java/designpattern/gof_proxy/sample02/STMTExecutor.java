package designpattern.gof_proxy.sample02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface STMTExecutor {

    public ResultSet executeSTMT(String SQL, Connection connection) throws SQLException;
}
