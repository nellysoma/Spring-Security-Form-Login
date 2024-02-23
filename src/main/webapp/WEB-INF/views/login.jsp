<%-- 
    Document   : login
    Created on : Feb 11, 2024, 3:04:34 PM
    Author     : Harmony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="f" action="/login" method="POST">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td><input name="submit" type="submit" value="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
