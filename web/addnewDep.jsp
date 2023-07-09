<%-- 
    Document   : adnew
    Created on : Feb 21, 2023, 6:11:30 PM
    Author     : ASUS-PRO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="include/menu.jsp" %>
<div class="container">
    <br>  <p class="text-center">More bootstrap 4 components on <a href="http://bootstrap-ecommerce.com/"> Bootstrap-ecommerce.com</a></p>
    <hr>

    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Add new Department</h4>
             <p class="text-danger">${msq}</p>
            <form action="new-department" method="post">
                <div class="form-group input-group">
                    <input name="did" class="form-control" placeholder="Department id" type="txt">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <input name="dname" class="form-control" placeholder="Department name" type="txt">
                </div>      
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Add  </button>
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
