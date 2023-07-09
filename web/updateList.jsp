<%-- 
    Document   : list
    Created on : Feb 20, 2023, 7:00:00 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/menu.jsp" %>
<%@page import="model.Users"%>
<jsp:useBean id="user" class="model.Users" scope="session" />
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
            <div class="card mb-7">
                <div class="card-header">Update List</div>
                <div class="card-body">
                    <form action="updateListConfirm.jsp" method="post">
                        <!-- Form Group (username)-->
                        <div class="mb3">
                            <label class="small mb-1" for="inputUsername">Users ID </label><br>
                            <input class="form-control" name="userID"  type="hidden"  value="${user.userID}">${user.userID}
                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Username: </label><br>
                                <input class="form-control" name="fullName" id="inputUsername" type="hidden" placeholder="${user.fullName}" value="${user.fullName}">${user.fullName}
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Gender: </label><br>
                                <c:if test="${user.gender == 'M'}">
                                    <input class="form-control" id="inputBirthday" type="hidden" name="gender" placeholder="${user.gender}" value="${user.gender}">Male
                                </c:if>
                                <c:if test="${user.gender == 'F'}">
                                    <input class="form-control" id="inputBirthday" type="hidden" name="gender" placeholder="${user.gender}" value="${user.gender}">Female
                                </c:if>
                            </div>
                        </div>
                        <!-- Form Row-->    
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (organization name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Birthday:</label><br>
                                <input class="form-control" id="inputBirthday" type="hidden" name="dob" placeholder="${user.dob}" value="${user.dob}">${user.dob}
                            </div>
                            <!-- Form Group (location)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLocation">Address:</label><br>
                                <input class="form-control" id="inputLocation" name="address" type="hidden" placeholder="${user.address}" value="${user.address}">${user.address}
                            </div>
                        </div>
                        <!-- Form Group (email address)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Email:</label><br>
                                <input  class="form-control" id="inputEmailAddress" type="hidden" name="email" placeholder="${user.email}" value="${user.email}">${user.email}
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Department:</label><br>
                                <c:if test="${u.role=='MN'}">
                                    <select class="form-select" name="department_ID" >
                                        <c:forEach items="${DepDB.getAll()}" var="c">
                                            <option value="${c.did}" ${user.department_ID == c.did  ? "selected" : "" }> ${c.dname}</c:forEach> 
                                        </select>
                                </c:if>
                                <c:if test="${u.role=='ST'}">
                                     <c:forEach items="${DepDB.getAll()}" var="c">
                                   <c:if test="${c.did == user.department_ID}">
                                            <input type="hidden" class="form-control" name="department_ID" placeholder="${user.department_ID}" value="${user.department_ID}">${c.dname}
                                        </c:if>
                                    </c:forEach>
                                </c:if>

                            </div>
                        </div>

                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Password:</label><br>
                                <input  class="form-control" type="hidden" type="password" name="password" placeholder="${user.password}" value="${user.password}">.................
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Role:</label><br>
                                <c:if test="${u.role=='MN'}">
                                    <select class="form-select" name="role" >
                                        <option value="EE"   ${user.role == 'EE'  ? "selected" : "" } >Employees</option>
                                        <option value="ST"   ${user.role == 'ST'  ? "selected" : "" }>Staff </option>
                                        <option value="MN"  ${user.role == 'MN' ? "selected" : "" }>Manager </option>
                                    </select>
                                </c:if>
                                <c:if test="${u.role=='ST'}">
                                    <c:if test="${user.role == 'EE'}">
                                        <input type="hidden"  name="role"  value="${user.role}">Employees
                                    </c:if>
                                    <c:if test="${user.role == 'MN'}">
                                        <input type="hidden"  name="role"  value="${user.role}">Manager
                                    </c:if>

                                    <c:if test="${user.role == 'ST'}">
                                        <input type="hidden" name="role" value="${user.role}">Staff
                                    </c:if>
                                </c:if>
                            </div>
                        </div>

                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputPhone">Phone number: </label><br>
                                <input class="form-control" id="inputPhone" type="hidden" name="phone"placeholder="${user.phone}" value="${user.phone}">${user.phone}
                            </div>

                            <div class="col-md-6">
                                <label class="small mb-1" for="inputBirthday">Job:</label><br>
                                <c:forEach items="${JobDB.getAll()}" var="c">
                                    <c:if test="${user.job_id== c.jid}">
                                        <input class="form-control" id="inputBirthday" type="hidden" name="job_id"
                                               placeholder="${c.jobName}" value="${user.job_id}">${c.jobName}
                                    </c:if>
                                </c:forEach>
                            </div>

                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Manager ID:</label><br>
                                <input class="form-control" id="inputPhone" type="hidden" name="manager_id"placeholder="${user.manager_id}" value="${user.manager_id}">${user.manager_id}
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Status:</label>
                                <select class="form-select" name="status" >
                                    <option value="H" ${user.status== "H"  ? "selected" : "" }>H </option>
                                    <option value="L" ${user.status== "L"  ? "selected" : "" }>L </option>
                                    <option value="D" ${user.status== "D"  ? "selected" : "" }>D </option>
                                </select>

                            </div>
                        </div>

                        <!-- Save changes button-->
                        <button class="btn btn-primary" type="submit">UPDATE</button>
                        <button class="btn btn-primary" type="Button" value="Back"onclick="javascript:history.go(-1)">Back</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>