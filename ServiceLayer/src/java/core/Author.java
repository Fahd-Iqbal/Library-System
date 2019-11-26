// The following code represents the Author entity class.
package core;

public class Author {

    private String firstName;
    private String lastName;

    public Author() {
        this.firstName = "";
        this.lastName = "";
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
    }
}
