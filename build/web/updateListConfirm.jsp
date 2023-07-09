
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="include/menu.jsp" %>

<jsp:useBean id="user" class="model.Users" scope="session" />
<jsp:setProperty name="user" property="*"/>
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
            <div class="card mb-8">
                <div class="card-header">Update List Confirm</div>
                <div class="card-body">
                    <form action="update-list" method="post">
                        <div class="mb1">
                            <label class="small mb-1" for="inputUsername">Users ID :</label>
                            ${user.userID}
                        </div>
                        <!-- Form Group (username)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Username:</label>
                                ${user.fullName}
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Gender:</label>
                                <c:if test="${user.gender == 'M'}">
                                   Male
                                </c:if>
                                <c:if test="${user.gender == 'F'}">
                                   Female
                                </c:if>

                            </div>
                        </div>

                        <!-- Form Row-->

                        <!-- Form Row        -->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (organization name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Birthday:</label>
                                ${user.dateOB}
                            </div>
                            <!-- Form Group (location)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLocation">Address:</label>
                                ${user.address}
                            </div>
                        </div>
                        <!-- Form Group (email address)-->
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Email:</label>
                                ${user.email}
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputBirthday">Department:</label>
                                <c:forEach items="${DepDB.getAll()}" var="c">
                                        <c:if test="${c.did == user.department_ID}"> ${c.dname}  </c:if>
                                    </c:forEach>
                            </div>
                        </div>
                        <div class="row gx-3 mb-3">
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputEmailAddress">Password:</label> ................
                            </div><!-- comment -->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputUsername">Role:</label>
                                <c:if test="${user.role == 'EE'}">Employees </c:if>
                                <c:if test="${user.role == 'MN'}">Manager</c:if>
                                <c:if test="${user.role == 'ST'}">Staff </c:if>
                            </div>
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputPhone">Phone number:</label>
                                ${user.getPhone()}
                            </div>
                            <!-- Form Group (birthday)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputBirthday">Job: </label>
                                <c:forEach items="${JobDB.getAll()}" var="c">
                                    <c:if test="${c.jid == user.job_id}">
                                        ${c.jobName} </c:if>
                                </c:forEach>

                            </div>   
                        </div>
                        
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                 <label class="small mb-1" for="inputOrgName">Manager ID:</label>
                            ${user.manager_id}
                            </div>
                            <!-- Form Group (birthday)-->
                            <div class="col-md-6">
                               <label class="small mb-1" for="inputOrgName">Status:</label>
                               <c:if test="${user.status == 'H'}">H </c:if>
                               <c:if test="${user.status =='L'}">L </c:if>

                            </div>   
                        </div>
                        <!-- Save changes button-->
                        <button class="btn btn-primary" type="submit">Save Change</button>
                    </form>
                </div>
            </div>
        </div>
    </div>