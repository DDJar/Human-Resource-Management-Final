<%-- 
    Document   : list
    Created on : Feb 20, 2023, 7:00:00 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/menu.jsp" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
                min-width: 100%;
            }
            .table-title h2 {
                margin: 8px 0 0;
                font-size: 22px;
            }
            .search-box {
                position: relative;
                float: right;
            }
            .search-box input {
                height: 34px;
                border-radius: 20px;
                padding-left: 35px;
                border-color: #ddd;
                box-shadow: none;
            }
            .search-box input:focus {
                border-color: #3FBAE4;
            }
            .search-box i {
                color: #a0a5b1;
                position: absolute;
                font-size: 19px;
                top: 8px;
                left: 10px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child {
                width: 130px;
            }
            table.table td a {
                color: #a0a5b1;
                display: inline-block;
                margin: 0 5px;
            }
            table.table td a.view {
                color: #03A9F4;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 95%;
                width: 30px;
                height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 30px !important;
                text-align: center;
                padding: 0;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 6px;
                font-size: 95%;
            }
            a.active{
                color: green;
                font-weight: bold;
            }

        </style>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });
        </script>
    </head>

    <body>
        <div class="container-xl">
            <div class="row">
                <div class="col-lg-10 mx-auto mb-4">
                    <div class="section-title text-center ">


                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <form action="search" method="post">
                            <div class="row">
                                <div class="col-sm-5"><h2>List <b>${MS}</b></h2></div>
                                <div class="col-sm-1" style="padding-left:14%;padding-right: 10%;" >
                                    <select class="section-bg" name="sCriteria">  
                                        <option value="all" ${sCriteria == "all" ? "selected" : ""}>All</option>
                                        <option value="usersID" ${sCriteria == "usersID" ? "selected" : ""}>Users ID</option>
                                        <option value="fullName"${sCriteria == "fullName" ? "selected" : ""}>Name</option>
                                        <option value="dob"${sCriteria == "dob" ? "selected" : ""}>Dob</option>
                                        <option value="job"${sCriteria == "job" ? "selected" : ""}>Position</option>
                                        <option value="email"${sCriteria == "email" ? "selected" : ""}>Email</option>
                                        <option value="phone"${sCriteria == "phone" ? "selected" : ""}>Phone</option>
                                        <option value="deparment"${sCriteria == "deparment" ? "selected" : ""}>Department</option>
                                    </select></div>
                                <div class="col-sm-3 input-group">
                                    <input type="text" class="searchinput form-control" name="txt" placeholder="Search&hellip;" style="margin-bottom: 0;"> 
                                    <div class="input-group-btn" style="padding-right: 0; display: flex"> <div class="input-group input-group-sm">
                                            <button type="submit"class="searchbutton btn btn-dark" style="padding-left: 10%;border-radius: 0" ><i class="material-icons">&#xE8B6;</i></button>
                                        </div>


                                    </div>
                                </div>

                            </div>
                        </form>

                    </div>
                    <table class="table table-striped table-hover table-bordered" >
                        <thead>

                            <tr>
                                <th>ID</th>
                                <th>Name  </th>
                                <th>Dob</th>
                                <th>Position </th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Status</th>
                                <th style="padding-right: 10px;">Department</th>
                                    <c:if test="${role =='MN'}">
                                    <th>Option</th>
                                    </c:if>
                                    <c:if test="${role =='ST'}">
                                    <th>Option</th>
                                    </c:if>

                            </tr>
                        </thead>

                        <c:forEach var="o" items="${listA}" >
                            <c:set var="user2" value="${u.getUserID()}"/>
                            <c:if test="${user2 != o.getUserID()}">
                                <c:if test="${o.getStatus() != 'D'}">
                                    <tbody>
                                        <tr>
                                            <td>${o.getUserID()}</td>
                                            <td>${o.getFullName()}</td>
                                            <td>${o.getDob()}</td>
                                            <td>${o.getJob()}</td>
                                            <td>${o.getPhone()}</td>
                                            <td>${o.getEmail()}</td>
                                            <td>${o.getStatus()}</td>
                                            <td>${o.getDepartment()}</td>
                                            <c:if test="${role =='MN' }">
                                                <td>
                                                    <a href="update-list?id=${o.getUserID()}" class="view" type="button" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                                    <a href="delete?id=${o.getUserID()}" class="delete" type="button" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                                </c:if>
                                                <c:if test="${role =='ST' }">
                                                <td>
                                                    <a href="update-list?id=${o.getUserID()}" class="view" type="button" title="View" data-toggle="tooltip"><i class="material-icons">&#xE417;</i></a>
                                                    <a href="delete?id=${o.getUserID()}" class="delete" type="button" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>
                                                </td>
                                            </c:if>

                                        
                                    </tbody>  
                                </c:if>
                            </c:if>

                        </c:forEach>
                        </tr>
                    </table><h3 style="text-align: center"> ${MSG}</h3>
                    <div style="float: end; width: 80%">
                        <table border="2" cellpadding="5" cellspacing="5" style="border-color:#03A9F4" >
                            <tr>
                                <c:if test="${tag > 1}">
                                    <td ><a href="list?page=${tag-1}"> Previous</a> <td>
                                    </c:if>
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                    <td style="border-color: #03A9F4;border-width: 1px;padding-right:10px"> <a class="${tag==i? "active" : ""}" href="list?page=${i}"> ${i}</a>
                                    </c:forEach> 
                                </td>
                                <c:if test="${tag < endPage}">
                                    <td> <a  href="list?page=${tag+1}"> Next</a> <td>
                                    </c:if>
                            </tr>
                        </table>
                    </div>               

                </div>
            </div>  
        </div>   
    </body>
</html>
