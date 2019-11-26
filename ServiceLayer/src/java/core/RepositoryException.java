package core;

public class RepositoryException extends Exception {

    private static final long serialVersionUID = 1L;

    public RepositoryException() {
        super("Error: User is not logged in.");
    }

    public RepositoryException(String message) {
        super(message);
    }
}
