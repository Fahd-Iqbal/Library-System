package core;

//import static core.BookRepository.conn;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JUnit_test {

    public static String testIsbn() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        Book b = new Book();
        String isbn = "12";
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE isbn=?")) {
            stmt.setString(1, isbn);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    b.setId(parseInt(rs.getString("id")));
                    b.setTitle(rs.getString("title"));
//                    b.setFirst_name(rs.getString("first_name"));
//                    b.setLast_name(rs.getString("last_name"));
                    b.setDescription(rs.getString("description"));
                    b.setIsbn(isbn);

                }
                return b.getTitle();

            }
        } catch (Exception e) {
            return e.toString();
        }
    }

    public String failIsbnTest() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        Book b = new Book();
        String isbn = "12444";
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE isbn=?")) {
            stmt.setString(1, isbn);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    b.setId(parseInt(rs.getString("id")));
                    b.setTitle(rs.getString("title"));
//                    b.setFirst_name(rs.getString("first_name"));
//                    b.setLast_name(rs.getString("last_name"));
                    b.setDescription(rs.getString("description"));
                    b.setIsbn(isbn);

                }
                return b.getTitle();

            }
        } catch (Exception e) {
            return e.toString();
        }

    }

    public String testId() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        Book b = new Book();
        int id = 1;
        b.setId(id);
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE id=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    b.setId(id);
                    b.setTitle(rs.getString("title"));
//                    b.setFirst_name(rs.getString("first_name"));
//                    b.setLast_name(rs.getString("last_name"));
                    b.setDescription(rs.getString("description"));
                    b.setIsbn(rs.getString("isbn"));
                }
                return b.getTitle();
            }
        } catch (Exception e) {
            return null;
        }

    }

    public String testFailId() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        Book b = new Book();
        int id = 167;
        b.setId(id);
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE id=?")) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    b.setId(id);
                    b.setTitle(rs.getString("title"));
//                    b.setFirst_name(rs.getString("first_name"));
//                    b.setLast_name(rs.getString("last_name"));
                    b.setDescription(rs.getString("description"));
                    b.setIsbn(rs.getString("isbn"));
                }
                return b.getTitle();
            }
        } catch (Exception e) {
            return null;
        }

    }

    public String testBookList() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        String titles = "";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT title FROM book");
            while (rs.next()) {
                titles += "title: " + rs.getString("title");
            }
            return titles;
        } catch (Exception e) {
            return "Books not found, list book error";
        }
    }

    public String failTestBookList() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        String titles = "";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT title FROM bookz");
            while (rs.next()) {
                titles += "title: " + rs.getString("title");
            }
            return titles;
        } catch (Exception e) {
            return "Books not found, list book error";
        }
    }

    public boolean updateTest() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        Book b = new Book();
        int id = 3;
        b.setId(id);
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET title=?, descriptions=?, isbn=?, author_first_name =?, author_last_name=? WHERE id=?")) {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getDescription());
//            stmt.setString(3, b.getFirstName());
//            stmt.setString(4, b.getLastName());
            stmt.setString(5, b.getIsbn());
            stmt.setInt(6, id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String updateTestFail() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }
        Book b = new Book();
        int id = 300;
        b.setId(id);
        try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET title=?, descriptions=?, isbn=?, author_first_name =?, author_last_name=? WHERE id=?")) {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getDescription());
//            stmt.setString(3, b.getFirstName());
//            stmt.setString(4, b.getLastName());
            stmt.setString(5, b.getIsbn());
            stmt.setInt(6, id);
            return b.getTitle();
        } catch (Exception e) {
            return "false";
        }
    }

    public boolean deleteAllTestFail() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("Delete from bookz");
            return true;
        } catch (SQLException e) {
            System.out.println("Could not delete all.");
            return false;
        }
    }

    public boolean deleteRow() {
        Connection conn = null;
        String user = "root";
        String pass = "password";

        System.out.println("Testing something here.");
        System.out.println("------------------------------");

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore?autoReconnect=true&useSSL=false", user, pass);
        } catch (SQLException e) {
            System.out.println(e);
            for (Throwable t : e) {
                t.printStackTrace();
            }
        }

        Book b = new Book();
        int id = 6;
        try (PreparedStatement stmt = conn.prepareStatement("Delete from book Where id=?")) {
            stmt.setInt(1, id);
            stmt.executeLargeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
