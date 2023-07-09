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

    <div class="card bg-light"  style="height:  66%">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Add new job</h4>
            <form action="addNewJob" method="post">
                <div class="form-group input-group">
                    <input name="name" class="form-control" placeholder="Job name" type="text">
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <input name="minsalary" class="form-control" placeholder="Min salary" type="txt">
                </div> 
                <div class="form-group input-group">
                    <input name="maxsalary" class="form-control" placeholder="Max salary" type="txt">
                </div>              
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Add </button>
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
