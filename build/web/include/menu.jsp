
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${USER}" var="u"/>
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <link href="../img/icon.ico" rel="icon">
          <link rel="shortcut icon" href="img/icon.ico">
        <title>Human resources management system</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->


        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Jost:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

        <!-- Vendor CSS Files -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
        <link href="assets/vendor/aos/aos.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
        <link href="assets/css/listStyle.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <!-- Template Main CSS File -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/viewStyle.css" rel="stylesheet">
    </head>

    <body>

        <!-- =======================================================
        * Template Name: Arsha - v4.11.0
        * Template URL: https://bootstrapmade.com/arsha-free-bootstrap-html-template-corporate/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->

        <c:set var="user1" value="${u}"/>
        <c:set var="role" value="${u.getRole()}"/>
        <header id="header" class="fixed-top " style="background-color: #37517e ">
            <div class="container d-flex align-items-center">

                <h1 class="logo me-auto"><a href="index.jsp"><img src="img/images.png" width="100px" height="120px" alt="alt"/></a></h1>
                <nav id="navbar" class="navbar">
                    <ul>
                        <li><a class="nav-link scrollto active" href="index.jsp">Home</a></li>
                            <c:if test="${user1 == null}">
                            <li><a class="nav-link scrollto" href="addnew.jsp">Create New Accounts</a></li>
                             <li><a class="getstarted scrollto" href="login.jsp">Login</a></li>
                            </c:if>
                        <c:if test="${user1 != null}">
                            <li><a class="nav-link scrollto" href="addnew.jsp">Create New Users</a></li>
                            <li class="dropdown"><a href="#"><span>Event</span> <i class="bi bi-chevron-down"></i></a>
                                <ul>                                
                                     <li><a href="dummy">Jobs</a></li>
                                    <li><a href="list-department">Department</a></li>
                                      <li><a href="list-project">Project</a></li>
                                    <li><a href="receive.jsp">Receive Project</a></li>
                                    
                                     <c:if test="${user1.getRole() == 'MN'}">
                                      <li><a href="list-allreceive">List receive</a></li>
                                    </c:if>
                                      <c:if test="${user1.getRole() == 'ST'}">
                                      <li><a href="list-allreceive">List receive</a></li>
                                    </c:if>
                                    <c:if test="${user1.getRole() == 'MN'}">
                                      <li><a href="history-list">History list</a></li>
                                    </c:if>
                                   <c:if test="${user1.getRole() == 'ST'}">
                                      <li><a href="history-list">History list</a></li>
                                    </c:if>
                                </ul>
                            </li>
                            <li><a class="nav-link scrollto" href="list">List</a></li>
                            <li class="dropdown" class="nav-item">
                                <a class="getstarted scrollto" href="#">${u.getFullName()}</a>
                                <ul>
                                    <li><a href="view.jsp">Profile</a></li>
                                    <li><a href="list-receive"> Job received</a></li>
                                    <li><a href="logout">Logout</a></li>
                                </ul>
                            </li>
                        </c:if>
                        
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar -->

            </div>
        </header>