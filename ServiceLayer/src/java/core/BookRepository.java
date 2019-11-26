// The following code implements the methods from IBookRepository.java.
package core;

import DataAccessLayer.TableDataGateway;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

//****************************************************************************************************
//****************************************************************************************************
public class BookRepository implements IBookRepository {

    TableDataGateway gateway = null;
    
    
//    private Connection conn = null;
    private static BookRepository repo = null;
//
//    private String user = "root";
//    private String pass = "iolnyno";
//    private String host = "jdbc:mysql://localhost:3306/books?autoReconnect=true&useSSL=false";
//    
//    //****************************************************************************************************
//    //****************************************************************************************************
//    public BookRepository() throws SQLException, ClassNotFoundException {
//        Class.forName("com.mysql.jdbc.Driver");
//        this.conn = DriverManager.getConnection(host, user, pass);
//        
//    }
    public BookRepository() throws SQLException, ClassNotFoundException{
        gateway= new TableDataGateway();
    }
    
    public static synchronized BookRepository getInstance(ServletContext context) throws SQLException, ClassNotFoundException {
        if (context == null) {
            return null;
        } else if (repo == null) {
            
            repo = new BookRepository();
        }
        return repo;
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public List<Book> listBooks() {
   return gateway.ListOfBooks();
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public Book infoById(int id) {
       return gateway.getInfoById(id);
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public Book infoByIsbn(String isbn) {
        return gateway.getInfoByIsbn(isbn);
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public int addBook(Book myBook) {
     return gateway.InsertNewBook(myBook);
    }
        

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean updateBook(int id, Book myBook) {
       return gateway.updateBook(id, myBook);
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean setImage(int myId, String mimeType, InputStream inputStream) {
        return gateway.setImage(myId, mimeType, inputStream);
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean deleteBook(int id) {
         return gateway.deleteBook(id);
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean deleteAll() {
      return gateway.deleteAll();
    }
}
