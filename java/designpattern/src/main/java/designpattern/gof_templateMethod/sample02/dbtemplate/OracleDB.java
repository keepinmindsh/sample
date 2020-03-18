package designpattern.gof_templateMethod.sample02.dbtemplate;

import java.sql.*;

public class OracleDB extends DBTemplate {
    @Override
    public String[] getDBInformation() {
        String jdbcDriver = "jdbc:oracle:thin:@***.***.***.***:***/*****";
        String dbUser = "******";
        String dbPassword = "******";

        String[] resultInfo = {jdbcDriver, dbUser, dbPassword};

        return resultInfo;
    }

    @Override
    public Connection getConnection(String[] connectionInfo) throws SQLException {
        return DriverManager.getConnection(connectionInfo[0], connectionInfo[1], connectionInfo[2]);
    }

    @Override
    public PreparedStatement executeStatement(Connection connection, String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    @Override
    public ResultSet getResultSet(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }
}
