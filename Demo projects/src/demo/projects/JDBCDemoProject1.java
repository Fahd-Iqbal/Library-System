package core;

import java.sql.*;

public class JDBCDemoProject1 {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");
        
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/murach_test", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from user");
            while (myRs.next()) {
                System.out.println(myRs.getString("LastName") + ", " + myRs.getString("FirstName"));
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}
