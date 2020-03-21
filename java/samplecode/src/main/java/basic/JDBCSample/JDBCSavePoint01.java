package basic.JDBCSample;

import java.sql.*;

public class JDBCSavePoint01 {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/EMP";

    static final String USER = "username";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com,mysql.jdbc.Driver");

            System.out.println("Connecting to database ....");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            conn.setAutoCommit(false);

            System.out.println("Creating Statement....");
            stmt = conn.createStatement();

            String sql = "SELECT id, first, last, age FROM Employees";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("List result set for reference....");


            Savepoint savepoint1 = conn.setSavepoint("ROWS_DELETED_1");

            System.out.println("Deleting row....");
            String SQL = "DELETE FROM Employees WHERE ID = 110";
            stmt.executeUpdate(SQL);

            conn.rollback();

            Savepoint savepoint2 = conn.setSavepoint("ROWS_DELETED_2");

            System.out.println("Deleting row...");
            SQL = "DELETE FROM Employees WHERE ID = 95";
            stmt.executeUpdate(SQL);

            sql = "SELECT id, first, last, age FROM Employees";
            rs = stmt.executeQuery(sql);
            System.out.println("List result set for references....");


            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("Rolling back data here ...");
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Good Bye");
    }

    public static void printRs(ResultSet rs) throws SQLException {
        //Ensure we start with first row
        rs.beforeFirst();
        while (rs.next()) {
            //Retrieve by column name
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
        }
        System.out.println();

    }
}
