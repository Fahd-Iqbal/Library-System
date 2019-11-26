// The following code represents an interface.
package core;

import java.io.InputStream;
import java.util.List;

public interface IBookRepository {

    public List<Book> listBooks(Session mySession);

    public Book infoById(Session mySession, int id);

    public Book infoByIsbn(Session mySession, String isbn);

    public int addBook(Session mySession, Book myBook);

    public boolean updateBook(Session mySession, int id, Book myBook);

    public boolean setImage(Session mySession, int myId, String mimeType, InputStream inputStream);

    public boolean deleteBook(Session mySession, int id);

    public boolean deleteAll(Session mySession);
}
