/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccessLayer;

import core.Author;
import core.Book;
import core.BookRepository;
import core.CoverImage;
import core.Session;
import java.io.InputStream;
import static java.lang.Integer.parseInt;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author fahd_
 */
public class TableDataGateway {
    
    
    private Connection conn = null;

    private String user = "root";
    private String pass = "iolnyno";
    private String host = "jdbc:mysql://localhost:3306/books?autoReconnect=true&useSSL=false";
    
    //****************************************************************************************************
    //****************************************************************************************************
    public TableDataGateway() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.conn = DriverManager.getConnection(host, user, pass);
        
    }
    
    public List<Book> ListOfBooks(){
       List<Book> booksList = new ArrayList<>();
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT * FROM book");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String description = rs.getString("descriptions");
                    String isbn = rs.getString("isbn");
                    Author myAuthor = new Author(rs.getString("author_first_name"), rs.getString("author_last_name"));
                    String publisherCompany = rs.getString("publisher_company");
                    String publisherAddress = rs.getString("publisher_address");
                    String mimeType = rs.getString("mimeType");

                    Book myBook = null;
                    Blob picture = rs.getBlob("cover");
                    if (picture == null) {
                        myBook = new Book(id, title, description, isbn, myAuthor, publisherCompany, publisherAddress, null);
                    } else {
                        byte[] pictureData = picture.getBytes(1, (int) picture.length());
                        CoverImage myCover = new CoverImage(mimeType, pictureData);
                        myBook = new Book(id, title, description, isbn, myAuthor, publisherCompany, publisherAddress, myCover);
                    }
                    booksList.add(myBook);
                }
                return booksList;
            } catch (SQLException e) {
                return null;
            } 
        
    }
    
    
    public Book getInfoById(int id){
                   Book myBook = new Book();
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE id=?")) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        myBook.setId(parseInt(rs.getString("id")));
                        myBook.setTitle(rs.getString("title"));
                        myBook.setDescription(rs.getString("descriptions"));
                        myBook.setIsbn(rs.getString("isbn"));
                        String author_first_name = rs.getString("author_first_name");
                        String author_last_name = rs.getString("author_last_name");
                        Author myAuthor = new Author(author_first_name, author_last_name);
                        myBook.setMyAuthor(myAuthor);
                        myBook.setPublisherCompany(rs.getString("publisher_company"));
                        myBook.setPublisherAddress(rs.getString("publisher_address"));
                        String mimeType = rs.getString("mimeType");
                        Blob picture = rs.getBlob("cover");

                        if (picture == null) {
                            myBook.setMyCoverImage(null);
                        } else {
                            byte[] pictureData = picture.getBytes(1, (int) picture.length());
                            CoverImage myCover = new CoverImage(mimeType, pictureData);
                            myBook.setMyCoverImage(myCover);
                        }
                    }
                    return myBook;
                }
            } catch (SQLException e) {
                return null;
            }
        
        
        
        
    }

    public Book getInfoByIsbn(String isbn)
   {
                    Book myBook = new Book();
            try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM book WHERE isbn=?")) {
                stmt.setString(1, isbn);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        myBook.setId(parseInt(rs.getString("id")));
                        myBook.setTitle(rs.getString("title"));
                        myBook.setDescription(rs.getString("descriptions"));
                        myBook.setIsbn(rs.getString("isbn"));
                        String author_first_name = rs.getString("author_first_name");
                        String author_last_name = rs.getString("author_last_name");
                        Author myAuthor = new Author(author_first_name, author_last_name);
                        myBook.setMyAuthor(myAuthor);
                        myBook.setPublisherCompany(rs.getString("publisher_company"));
                        myBook.setPublisherAddress(rs.getString("publisher_address"));
                        String mimeType = rs.getString("mimeType");
                        Blob picture = rs.getBlob("cover");

                        if (picture == null) {
                            myBook.setMyCoverImage(null);
                        } else {
                            byte[] pictureData = picture.getBytes(1, (int) picture.length());
                            CoverImage myCover = new CoverImage(mimeType, pictureData);
                            myBook.setMyCoverImage(myCover);
                        }
                    }
                    return myBook;
                }
            } catch (SQLException e) {
                return null;
            }
        
        
        
    }
    
    public int InsertNewBook(Book myBook) {
                try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO book (id, title, descriptions, isbn, author_first_name, author_last_name, publisher_company, publisher_address) Values(?, ?, ?, ?, ?, ?, ?, ?)")) {
                stmt.setInt(1, myBook.getId());
                stmt.setString(2, myBook.getTitle());
                stmt.setString(3, myBook.getDescription());
                stmt.setString(4, myBook.getIsbn());
                stmt.setString(5, myBook.getAuthorFirstName());
                stmt.setString(6, myBook.getAuthorLastName());
                stmt.setString(7, myBook.getPublisherCompany());
                stmt.setString(8, myBook.getPublisherAddress());
                stmt.executeUpdate();
                return myBook.getId();
            } catch (SQLException e) {
                return -1;
            }
        }
    
    
    
     public boolean updateBook(int id, Book myBook){

            try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET title=?, descriptions=?, isbn=?, author_first_name=?, author_last_name=?, publisher_company=?, publisher_address=? WHERE id=?")) {
                stmt.setString(1, myBook.getTitle());
                stmt.setString(2, myBook.getDescription());
                stmt.setString(3, myBook.getIsbn());
                stmt.setString(4, myBook.getAuthorFirstName());
                stmt.setString(5, myBook.getAuthorLastName());
                stmt.setString(6, myBook.getPublisherCompany());
                stmt.setString(7, myBook.getPublisherAddress());
                stmt.setInt(8, id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
     

     
     public boolean setImage(int myId, String mimeType, InputStream inputStream){
         try (PreparedStatement stmt = conn.prepareStatement("UPDATE book SET mimeType=?, cover=? WHERE id=?")) {
                stmt.setString(1, mimeType);
                stmt.setBlob(2, inputStream);
                stmt.setInt(3, myId);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
     }
     
     
     public boolean deleteBook(int id){
          try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE id=?")) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } catch (SQLException e) {
                return false;
            }
         
     } 
     
      public boolean deleteAll(){
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM book");
                return true;
            } catch (SQLException e) {
                return false;
            }
      }
     
     
     
     
}
    
    
    
    






    
    
    

