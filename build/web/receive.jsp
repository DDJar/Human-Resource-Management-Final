<%-- 
    Document   : adnew
    Created on : Feb 21, 2023, 6:11:30 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="include/menu.jsp" %>
<div class="container " >
    <br>  <p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
    <hr>
    <div class="card bg-light" style="height:  66%">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Receive Project</h4>
            <p class="text-danger">${msq}</p>
            <form action="receive" method="post">
                <div class="form-group input-group">
                    <label for="inputUsername">Users ID: </label>
                    <input  name="uid" class="form-control" value="${u.getUserID()}" type="hidden">${u.getUserID()}
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <label style="margin: 0">Project ID: </label>
                    <select class="form-select-sm form-group" style="margin: 0;padding: 0;" name="pID" >
                        <c:forEach items="${ProjectDB.getAllProject()}" var="c">
                            <option value="${c.pid}"> ${c.title} (${c.pid})
                            </c:forEach> 
                    </select>
                </div>      
                <div class="form-group input-group">
                    <input name="description" class="form-control" placeholder="Description" type="txt">
                </div>
                <c:if test="${u.getRole()=='MN'}">
                    <input name="day"  value="90"type="hidden">
                </c:if>
                <c:if test="${u.getRole()=='ST'}">
                    <input name="day"  value="90"type="hidden">
                </c:if>
                <c:if test="${u.getRole()=='EE'}">
                    <input name="day"  value="30"type="hidden">
                </c:if>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Receive  </button>
                </div> <!-- form-group// -->                                                                         
            </form>
        </article>
    </div> <!-- card.// -->

</div> 
<!--container end.//-->
<br><br>
<div class="footer-bottom">
    <article class="bg-secondary mb-3 footer-bottom" >  
    <div class="card-body text-center" >  
    </div>
    <br><br>
</article>
</div>

