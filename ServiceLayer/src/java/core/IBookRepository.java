// The following code represents an interface.
package core;

import java.io.InputStream;
import java.util.List;

public interface IBookRepository {

    public List<Book> listBooks();

    public Book infoById(int id);

    public Book infoByIsbn(String isbn);

    public int addBook(Book myBook);

    public boolean updateBook(int id, Book myBook);

    public boolean setImage(int myId, String mimeType, InputStream inputStream);

    public boolean deleteBook(int id);

    public boolean deleteAll();
}
