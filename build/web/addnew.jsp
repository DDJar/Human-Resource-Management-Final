<%-- 
    Document   : adnew
    Created on : Feb 21, 2023, 6:11:30 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" errorPage="error.jsp" pageEncoding="UTF-8"%>
<%@ include file="include/menu.jsp" %>
<div class="container">
    <br>  <p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
    <hr>

    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <p class="text-danger">${msq}</p>
            <h4 class="card-title mt-3 text-center">Create new staff</h4>
            <p class="text-center">Get started with your free account</p>

            <form action="addNewStaff" method="post">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="fullName" class="form-control" placeholder="Full name" type="text">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="dob" class="form-control" placeholder="Dob" type="date">
                </div> 
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <select class="form-select" name="gender" >
                        <option  value="M"  >Male</option>
                        <option value="F"  >Female</option>
                    </select>
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="phone" class="form-control" placeholder="Phone" type="txt">
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                    </div>
                    <input name="address" class="form-control" placeholder="Address" type="txt">
                </div>

                <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-building"></i> </span>
                    </div>
                    <select class="form-select" name="job_id" >
                        <c:forEach items="${JobDB.getAll()}" var="c">
                            <option value="${c.jid}">${c.jobName}</option>
                        </c:forEach>
                    </select>
                </div> 
                <c:if test="${u.role == 'MN'}">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-building"></i> </span>
                        </div>
                        <select class="form-select" name="role" >
                            <option value="EE" >Employees</option>
                            <option value="ST" >Staff </option>
                            <option value="MN" >Manager </option>
                        </select>
                    </div>

                </c:if>

                <c:if test="${u.role == 'ST'}">
                    <div class="form-group input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"> <i class="fa fa-building"></i> </span>
                        </div>
                        <select class="form-select" name="role" >
                            <option value="EE"   >Employees</option>
                            <option value="ST"   >Staff </option>
                            <option value="MN"  >Manager </option>
                        </select>
                    </div>
                </c:if>
                <!-- form-group end.// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                    </div>
                    <input name="email" class="form-control" placeholder="Email address" type="email">
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="password"class="form-control" placeholder="Create password" type="password">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                    </div>
                    <input name="repeatPassword" class="form-control" placeholder="Repeat password" type="password">
                </div> <!-- form-group// -->                                      
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Create staff  </button>
                </div> <!-- form-group// -->                                                                         
            </form>
        </article>
    </div> <!-- card.// -->

</div> 
<!--container end.//-->

<br><br>
<article class="bg-secondary mb-3" >  
    <div class="card-body text-center" >  
    </div>
    <br><br>
</article>
