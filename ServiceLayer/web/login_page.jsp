<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Books Management</title>
    </head>
    <body>
        <div style="text-align: center">
            <h1>Books Management</h1>
            <h4>Please sign in below</h4>
            <form action="logIn" method="post">
                <label for="username">Username</label>
                <br>
                <input name="username" size="30" />
                <br><br>
                <label for="password">Password</label>
                <br>
                <input type="password" name="password" size="30" />
                <br>${message}
                <br><br>           
                <button type="submit">Login</button>
                
                
<select name="format" >
          
          
          

  <option value="NoCover">No Cover</option>
  <option value="Cover">Cover</option>
  
</select>
                
                
                
            </form>
        </div>
    </body>
</html>
