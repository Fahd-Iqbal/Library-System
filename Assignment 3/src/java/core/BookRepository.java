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
    public List<Book> listBooks(Session mySession) {
        if (mySession.isUserLoggedIn()) {
           return gateway.ListOfBooks();
    
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public Book infoById(Session mySession, int id) {
        if (mySession.isUserLoggedIn()) {
          return gateway.getInfoById(id);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public Book infoByIsbn(Session mySession, String isbn) {
        if (mySession.isUserLoggedIn()) {
            return gateway.getInfoByIsbn(isbn);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public int addBook(Session mySession, Book myBook) {
        if (mySession.isUserLoggedIn()) {
             return gateway.InsertNewBook(myBook);
        }
            else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        }
    }
        

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean updateBook(Session mySession, int id, Book myBook) {
        if (mySession.isUserLoggedIn()) {
     return gateway.updateBook(id, myBook);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean setImage(Session mySession, int myId, String mimeType, InputStream inputStream) {
        if (mySession.isUserLoggedIn()) {
            return gateway.setImage(myId, mimeType, inputStream);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean deleteBook(Session mySession, int id) {
        if (mySession.isUserLoggedIn()) {
           return gateway.deleteBook(id);
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

    //****************************************************************************************************
    //****************************************************************************************************
    @Override
    public boolean deleteAll(Session mySession) {
        if (mySession.isUserLoggedIn()) {
          return gateway.deleteAll();
        } else {
            try {
                throw new RepositoryException();
            } catch (RepositoryException ex) {
                Logger.getLogger(BookRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }
}
