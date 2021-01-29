package com.schedular.job;

import com.wings.util.code.ScheduleType;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class QueryExecutor {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String driverName = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@222.239.73.170:1537:WPMS07";
    String user = "WINGSINTEGRATION";
    String password = "WINGS_4172";

    public QueryExecutor() {
        try {
            Class.forName(this.driverName);
        } catch (ClassNotFoundException var2) {
            System.out.println("[로드 오류]\n" + var2.getStackTrace());
        }

    }

    public void closeDatabase() {
        try {
            if (this.connection != null) {
                this.connection.close();
            }

            if (this.statement != null) {
                this.statement.close();
            }

            if (this.resultSet != null) {
                this.resultSet.close();
            }
        } catch (SQLException var2) {
            System.out.println("[닫기 오류]\n" + var2.getStackTrace());
        }

    }

    public Map<ScheduleType, Object> getScheduledTimerInfo(String systemId, String profileId) {
        HashMap timerSettingMap = new HashMap();

        try {
            String queryString = "SELECT                                            A.TIMER_SETTING,                           A.START_YN                           FROM TB_IS_SYSTEM_SCHEDULED A             WHERE A.SYSTEM_ID = '" + systemId + "'   AND A.PROFILE_ID = '" + profileId + "'";
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(queryString);

            while(this.resultSet.next()) {

            }
        } catch (SQLException var8) {
            var8.printStackTrace();
            System.out.println("[쿼리 오류]\n" + var8.getMessage());
        } finally {
            this.closeDatabase();
        }

        return timerSettingMap;
    }
}
