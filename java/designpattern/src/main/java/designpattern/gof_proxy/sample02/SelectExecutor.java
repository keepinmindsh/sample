package designpattern.gof_proxy.sample02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExecutor implements STMTExecutor {

    /**
     * STMT를 실행하는 함수
     *
     * @param SQL
     * @param connection
     * @return
     * @throws SQLException
     */
    public ResultSet executeSTMT(String SQL, Connection connection) throws SQLException {
        ResultSet rs;
        Statement statement = connection.createStatement();

        try {
            rs = statement.executeQuery(SQL);
        } finally {
            statement.close();
        }

        return rs;
    }
}
