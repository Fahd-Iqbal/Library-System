<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Books Management</title>
        <link href="image_css.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <% if("Cover" == null){
            
        }
            
            %>
            
    <center>
        <h1>Books Management</h1>
        <h2>
            <a href="Display_add_page">Add New Book</a>
            &nbsp;&nbsp;&nbsp;
            <a href="Delete_all_books" onclick="return confirm('Are you sure you want to delete all books?');">Delete All Books</a>
            &nbsp;&nbsp;&nbsp;
            <a href="List_all_books">List All Books</a>
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Isbn</th>
                <th>Author</th>
                <th>Publisher Company</th>
                <th>Publisher Address</th>
                
                
            </tr>
            <c:forEach var="book" items="${booksList}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.description}" /></td>
                    <td><c:out value="${book.isbn}" /></td>
                    <td><c:out value="${book.myAuthor.firstName}${' '}${book.myAuthor.lastName}" /></td>
                    <td><c:out value="${book.publisherCompany}" /></td>
                    <td><c:out value="${book.publisherAddress}" /></td>
                    <td>
                        <a href="Display_update_page?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="Delete_1_book?id=<c:out value='${book.id}' />" onclick="return confirm('Are you sure you want to delete this book?');">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>Click <a href="Display_logout_page">here</a> to log out.
    </div>   
</body>
</html>