<%-- 
    Document   : addNew
    Created on : Feb 21, 2023, 4:53:47 PM
    Author     : ASUS-PRO
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="include/signup-l.jsp" %>

<!------ Include the above in your HEAD tag ---------->

<body>
    <div class="container">
        <div class="row main">
            <div class="panel-heading">
                <div class="panel-title text-center">
                    <h1 class="title">Forgot password</h1>
                    <hr />
                </div>
            </div> 
            <div class="main-login main-center">
                <form class="form-horizontal" method="post" action="reset-pass">
                    <p class="text-danger">${msq}</p>
                    <div class="form-group">
                        <label for="name" class="cols-sm-2 control-label">Your Name</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="name" id="name"  placeholder="Enter your users name"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="cols-sm-2 control-label">Your Email</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                <input type="text" class="form-control" name="email" id="email"  placeholder="Enter your Email"/>
                            </div>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">Old Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="pass" id="password"  placeholder="Enter your Password"/>
                            </div>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="password" class="cols-sm-2 control-label">New Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="pass1" id="password"  placeholder="Enter your Password"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                <input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password"/>
                            </div>
                        </div>
                    </div>

                    <div class="form-group ">
                        <input type="submit" class="btn btn-primary btn-lg btn-block login-button"value="Register"><br>                 
                        <a href="login.jsp"> <button type="button" class="btn btn-primary btn-lg btn-block login-button" style="background-color: #0c3c53">Back</button></a>
                    </div>

                </form>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>