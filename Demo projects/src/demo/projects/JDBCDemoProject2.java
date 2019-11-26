package core;

import java.sql.*;

public class JDBCDemoProject2 {

    public static void main(String[] args) throws SQLException {
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");
        IBookRepository single = BookRepository.getInstance();
        
        System.out.println(single.listBooks());
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", user, pass);
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from book");
            while (myRs.next()) {
                int numColumns = myRs.getMetaData().getColumnCount();
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" => " + myRs.getObject(i));
                }
                System.out.println();
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
