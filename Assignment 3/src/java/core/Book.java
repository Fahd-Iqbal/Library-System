// The following code represents the Book entity class.
package core;

public class Book {

    private int id;
    private String title;
    private String description;
    private String isbn;
    private Author myAuthor;
    private String publisherCompany;
    private String publisherAddress;
    private CoverImage myCoverImage;

    public Book() {
        this.id = 0;
        this.title = "";
        this.description = "";
        this.isbn = "";
        this.myAuthor = null;
        this.publisherCompany = "";
        this.publisherAddress = "";
        this.myCoverImage = null;
    }

    public Book(int id, String title, String description, String isbn,
            Author myAuthor, String publisherCompany, String publisherAddress, CoverImage myCoverImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.myAuthor = myAuthor;
        this.publisherCompany = publisherCompany;
        this.publisherAddress = publisherAddress;
        this.myCoverImage = myCoverImage;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getMyAuthor() {
        return myAuthor;
    }

    public String getAuthorFirstName() {
        return myAuthor.getFirstName();
    }

    public String getAuthorLastName() {
        return myAuthor.getLastName();
    }

    public String getPublisherCompany() {
        return publisherCompany;
    }

    public String getPublisherAddress() {
        return publisherAddress;
    }

    public CoverImage getMyCoverImage() {
        return myCoverImage;
    }

    public String getCoverMimeType() {
        return myCoverImage.getMimeType();
    }

    public byte[] getCoverImageData() {
        return myCoverImage.getImageData();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setMyAuthor(Author myAuthor) {
        this.myAuthor = myAuthor;
    }

    public void setAuthorFirstName(String first_name) {
        this.myAuthor.setFirst_name(first_name);
    }

    public void setAuthorLastName(String last_name) {
        this.myAuthor.setLast_name(last_name);
    }

    public void setPublisherCompany(String publisherCompany) {
        this.publisherCompany = publisherCompany;
    }

    public void setPublisherAddress(String publisherAddress) {
        this.publisherAddress = publisherAddress;
    }

    public void setMyCoverImage(CoverImage myCoverImage) {
        this.myCoverImage = myCoverImage;
    }

    public void setCoverMimeType(String mimeType) {
        this.myCoverImage.setMimeType(mimeType);
    }

    public void setCoverImageType(byte[] imageType) {
        this.myCoverImage.setImageData(imageType);
    }
}
