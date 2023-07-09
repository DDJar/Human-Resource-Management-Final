<%-- 
    Document   : list
    Created on : Feb 20, 2023, 7:00:00 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/menu.jsp" %>
<div class="container-xl px-4 mt-4">
    <div class="row">
        <div class="col-lg-10 mx-auto mb-4">
            <div class="section-title text-center ">


            </div>
        </div>
    </div>
    <!-- Account page navigation-->

    <hr class="mt-0 mb-4">
    <div class="row">

        <div class="col-xl-12">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">Account Details</div>
                <div class="card-body">
                    <form action="edit" method="post">
                        <!-- Form Group (username)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Username:</label><br>
                                <input  class="form-control" id="inputUsername" type="hidden" placeholder="${u.fullName}" value="${u.fullName}">${u.fullName}
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Gender:</label><br>
                                <c:if test="${u.getGender() == 'M'}">
                                    <input  class="form-control" id="inputUsername" type="hidden" placeholder="${u.gender}" value="${u.gender}">Male
                                </c:if>
                                <c:if test="${u.getGender() == 'F'}">
                                    <input  class="form-control" id="inputUsername" type="hidden" placeholder="${u.gender}" value="${u.gender}">Female
                                </c:if>

                            </div>
                        </div>

                        <!-- Form Row-->

                        <!-- Form Row        -->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (organization name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Birthday:</label><br>
                                <input type="hidden" class="form-control" id="inputBirthday" type="date" name="birthday" placeholder="${u.dob}" value="${u.dob}">${u.dob}
                            </div>
                            <!-- Form Group (location)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLocation">Address:</label><br>
                                <input type="hidden" class="form-control" id="inputLocation" type="text" placeholder="${u.address}" value="${u.address}">${u.address}
                            </div>
                        </div>
                        <!-- Form Group (email address)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Email:</label><br>
                                <input type="hidden" class="form-control"  name="email" placeholder="${u.email}" value="${u.email}">${u.email}
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Department:</label><br>
                               <c:forEach items="${DepDB.getAll()}" var="c">
                                   <c:if test="${c.did == u.department_ID}">
                                            <input type="hidden" class="form-control" name="deparment_ID" placeholder="${u.department}" value="${u.department}">${c.dname}
                                        </c:if>
                                    </c:forEach>
                                
                            </div>
                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Password:</label><br>
                                <input type="hidden" class="form-control" id="inputUsername" type="password" placeholder="${u.password}" value="${u.password}">${u.password}
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Role:</label><br>
                                <c:if test="${u.role == 'EE'}">
                                     <input type="hidden" class="form-control" id="inputUsername" name="role" placeholder="${u.role}" value="${u.role}">Employees
                                </c:if>
                                      <c:if test="${u.role == 'MN'}">
                                     <input type="hidden" class="form-control" id="inputUsername" name="role" placeholder="${u.role}" value="${u.role}">Manager
                                </c:if>
                               
                                      <c:if test="${u.role == 'ST'}">
                                     <input type="hidden" class="form-control" id="inputUsername" name="role" placeholder="${u.role}" value="${u.role}">Staff
                                </c:if>
                               
                               
                            </div>
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputPhone">Phone number:</label><br>
                                <input class="form-control" id="inputPhone" type="hidden" placeholder="${u.phone}" value="${u.phone}">${u.phone}
                            </div>
                            <!-- Form Group (birthday)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputBirthday">Job: </label><br>
                                <c:forEach items="${JobDB.getAll()}" var="c">
                                        <c:if test="${c.jid == u.job_id}">
                                           <input type="hidden" class="form-control"  name="job_id" placeholder="${u.job}" value="${u.job}">${c.jobName}
                                        </c:if>
                                        
                                    </c:forEach>
                                
                            </div>
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="inputOrgName">Manager ID:</label><br>
                             <input type="hidden" class="form-control"  name="manager_id" placeholder="${u.manager_id}" value="${u.manager_id}">${u.manager_id}
                        </div>
                        <!-- Save changes button-->
                       <a style="color: white" href="update.jsp?id=${u.getUserID()}"> <button class="btn btn-primary" type="button">Update</button></a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>