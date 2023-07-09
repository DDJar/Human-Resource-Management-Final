<%-- 
    Document   : list
    Created on : Feb 20, 2023, 7:00:00 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/menu.jsp" %>
<%@page import="model.Users"%>
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
                <div class="card-header">Account Update</div>
                <div class="card-body">
                    <form action="updateConfirm.jsp" method="post">
                        <!-- Form Group (username)-->
                        <div class="mb3">
                            <label class="small mb-1" for="inputUsername">Users ID </label><br>
                            <input class="form-control" name="userID"  type="hidden"  value="${u.userID}">${u.userID}
                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Username </label>
                                <input class="form-control" name="fullName" id="inputUsername" type="text" placeholder="${u.fullName}" value="${u.fullName}">
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Gender </label>
                                <select class="form-select" name="gender" >
                                    <option  value="M"  >Male</option>
                                    <option value="F"  >Female</option>
                                </select>
                            </div>
                        </div>
                        <!-- Form Row-->    
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (organization name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Birthday</label>
                                <input class="form-control" id="inputBirthday" type="txt" name="dob" placeholder="${u.dob}" value="${u.dob}">
                            </div>
                            <!-- Form Group (location)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLocation">Address</label>
                                <input class="form-control" id="inputLocation" name="address" type="text" placeholder="${u.address}" value="${u.address}">
                            </div>
                        </div>
                        <!-- Form Group (email address)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Email:</label><br>
                                <input  class="form-control" id="inputEmailAddress" type="text" name="email" placeholder="${u.email}" value="${u.email}">
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Department:</label><br>
                                <c:if test="${u.role == 'EE'}" >
                                    <c:forEach items="${DepDB.getAll()}" var="c">
                                        <c:if test="${c.did == u.department_ID}">
                                            <input type="hidden" class="form-control" name="department_ID" placeholder="${c.dname}" value="${c.did}">
                                            ${c.dname} 
                                        </c:if>
                                    </c:forEach>
                                </c:if>

                                <c:if test="${u.role == 'MN'}">
                                    <select class="form-select" name="department_ID" >
                                        <c:forEach items="${DepDB.getAll()}" var="c">
                                            <option value="${c.did}" ${u.getDepartment_ID() == c.did  ? "selected" : "" }> ${c.dname}
                                            </c:forEach> 
                                    </select>
                                </c:if>
                                <c:if test="${u.role == 'ST'}" >

                                    <select class="form-select" name="department_ID" >
                                        <c:forEach items="${DepDB.getAll()}" var="c">
                                            <option value="${c.did}" ${u.getDepartment_ID() == c.did  ? "selected" : "" }> ${c.dname}
                                            </c:forEach> 
                                    </select>
                                </c:if>
                            </div>
                        </div>

                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Password:</label><br>
                                <input  class="form-control"  type="text" name="password" placeholder="${u.password}" value="${u.password}">
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Role:</label><br>
                                <c:if test="${u.role == 'EE'}">
                                    <input type="hidden" class="form-control" name="role" placeholder="${u.role}" value="EE">Employees
                                </c:if>
                                <c:if test="${u.role == 'MN'}">
                                    <select class="form-select" name="role" >
                                        <option value="EE"   ${u.role == 'EE'  ? "selected" : "" } >Employees</option>
                                        <option value="ST"   ${u.role == 'ST'  ? "selected" : "" }>Staff </option>
                                        <option value="MN"  ${u.role == 'MN' ? "selected" : "" }>Manager </option>

                                    </select>
                                </c:if>
                                <c:if test="${u.role == 'ST'}">
                                    <select class="form-select" name="role" >
                                        <option value="EE"   ${u.role == 'EE'  ? "selected" : "" } >Employees</option>
                                        <option value="ST"   ${u.role == 'ST'  ? "selected" : "" }>Staff </option>
                                        <option value="MN"  ${u.role == 'MN' ? "selected" : "" }>Manager </option>

                                    </select>
                                </c:if>

                            </div>
                        </div>

                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputPhone">Phone number</label>
                                <input class="form-control" id="inputPhone" type="text" name="phone"placeholder="${u.phone}" value="${u.phone}">
                            </div>

                            <div class="col-md-6">
                                <label class="small mb-1" for="inputBirthday">Job</label>
                                <select class="form-select" name="job_id" >
                                    <c:forEach items="${JobDB.getAll()}" var="c">
                                        <option value="${c.jid}" ${u.getJob_id()== c.jid  ? "selected" : "" }>${c.jobName} </option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>
                            <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                            <label class="small mb-1" for="inputOrgName">Manager ID:</label><br>
                            <input class="form-control" id="inputPhone" type="hidden" name="manager_id"placeholder="${u.manager_id}" value="${u.manager_id}">${u.manager_id}
                        </div>

                         <div class="col-md-6">
                             <label class="small mb-1" for="inputOrgName">Status:</label>
                            <input class="form-control" id="inputPhone" type="hidden" name="status"placeholder="${u.status}" value="${u.status}">${u.status}
                        </div>

                        </div>
                        
                         
                        <!-- Save changes button-->
                        <button class="btn btn-primary" type="submit">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>