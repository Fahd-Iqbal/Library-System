<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Books Store Application</title>
    </head>
    <body>

    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="Display_add_page">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="List_all_books">List All Books</a>
        </h2>
    </center>
    <div align="center">
        <c:if test="${book != null}">
            <form action="Update_1_book" method="post" enctype="multipart/form-data">
            </c:if>
            <c:if test="${book == null}">
                <form action="Add_1_book" method="post" enctype="multipart/form-data">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${book != null}">
                                Edit Book
                            </c:if>
                            <c:if test="${book == null}">
                                Add New Book
                            </c:if>
                        </h2>
                    </caption>
                    <c:if test="${book != null}">
                        <input type="hidden" name="id" value="<c:out value='${book.id}' />" />
                    </c:if>           
                    <tr>
                        <th>Title: </th>
                        <td>
                            <input type="text" name="title" size="45"
                                   value="<c:out value='${book.title}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Description: </th>
                        <td>
                            <input type="text" name="description" size="45"
                                   value="<c:out value='${book.description}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Isbn: </th>
                        <td>
                            <input type="text" name="isbn" size="45"
                                   value="<c:out value='${book.isbn}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Author (first name): </th>
                        <td>
                            <input type="text" name="author_first_name" size="45"
                                   value="<c:out value='${book.myAuthor.firstName}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Author (last name): </th>
                        <td>
                            <input type="text" name="author_last_name" size="45"
                                   value="<c:out value='${book.myAuthor.lastName}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher Company: </th>
                        <td>
                            <input type="text" name="publisherCompany" size="45"
                                   value="<c:out value='${book.publisherCompany}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Publisher Address: </th>
                        <td>
                            <input type="text" name="publisherAddress" size="45"
                                   value="<c:out value='${book.publisherAddress}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Cover: </th>
                        <td>
                            <input type="file" name="cover" size="45" accept="image/*"
                                   value="<c:out value='${book.myCoverImage.imageData}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
            <br>Click <a href="Display_logout_page">here</a> to log out.
    </div>   
</body>
</html>
