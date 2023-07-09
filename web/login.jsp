<%-- 
    Document   : index
    Created on : Jan 18, 2023, 12:35:23 PM
    Author     : ASUS-PRO
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Human resources management system</title>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="img/icon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/loginStyle.css" />
        <style>
            body {

                background-image: url("img/background.jpg");
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size:100%;
                background-position : 50% 50%;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h1>Login</h1>

            <form method="post" action="login">
                <div class="text-item">
                    <p class="text-danger">${msq}</p>
                    <input type="text" placeholder="Email" name="email" value="${email1}"><br>
                    <br><input type="password" placeholder="Password" name="password"><br>
                </div>
                
                <div class="submit">
                    <br><input class="sub" type="submit" value="login "><br>
                </div>
                    <br> <a href="forgotPass.jsp"><input  class="res" type="button" value="Forgot password"></a><br>
            </form>

        </div>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
