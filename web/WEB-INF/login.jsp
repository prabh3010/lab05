<%-- 
    Document   : login
    Created on : 11-Oct-2022, 2:36:45 PM
    Author     : prabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="login" method="post">
            <div>
                <label>Username:</label>
                <input type="text" name="username" value="${user.username}">
            </div>
            <div>
                <label>Password:</label>
                <input type="password" name="password" value="${user.password}">
            </div>
            <div>   
                <input type="submit" value="Log in"> 
            </div>
   
        </form>
            <p>${message}</p>
                
    </body>
</html>
