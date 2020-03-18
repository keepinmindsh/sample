package designpattern.gof_templateMethod.sample02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCall {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatementResult = null;
        ResultSet resultSet = null;

        String jdbcDriver = "jdbc:oracle:thin:@222.239.73.170:1537/WPMS07";
        String dbUser = "WINGSPMS5";
        String dbPassword = "WINGS_4172";

        Throwable occuredException = null;

        try {

            connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPassword);

            preparedStatementResult = connection.prepareStatement("SELECT * FROM TB_ZZ_USER");

            resultSet = preparedStatementResult.executeQuery();

            while(resultSet.next()){
                System.out.println("id : " + resultSet.getString("USER_ID"));
                System.out.println("---------------------------------------------");
            }
        } catch (Throwable e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if(resultSet != null ) resultSet.close();
                if(preparedStatementResult != null ) preparedStatementResult.close();
                if(connection != null) connection.close();
            }catch (Throwable e){
                System.out.println(e.getMessage());
            }
        }


    }
}
