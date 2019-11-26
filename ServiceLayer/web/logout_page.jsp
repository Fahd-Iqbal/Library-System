<%@page import="core.Session"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Books Management</title>
        <link href="logout_css.css" rel="stylesheet" type="text/css">
    </head>
    <body>

        <div style="text-align: center">
            <h1>Books Management</h1>
            <h4>You have successfully logged out!</h4>
            Click <a href="login_page.jsp">here</a> to return to the login page.
            <br><br>
            <form>
                <input type="button" value="Close this window" onclick="self.close()">
            </form>
            <br>
        </div>
    </body>
</html>
