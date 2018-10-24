<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
      <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
    
<jsp:include page="header.jsp"></jsp:include>


  <div class="jumbotron">

<!-- corosel -->
    


    <h1 class="display-4">Home Page </h1>
    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    <hr class="my-4">
    
  </div>




<div class="container">
  <div class="row justify-content-center">

  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: #f56954;color: #fff;">


  <div class="card-body" >
<h3 class="card-title"><tag:message code="fashion"></tag:message></h3>
    <a href="fashion?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>


  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: #0073b7;color: #fff;">

  <div class="card-body">
    <h3 class="card-title"><tag:message code="laptop"></tag:message></h3>
    <p class="card-text"></p>
    <a href="laptop?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>

  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: #00a65a;color: #fff;">

  <div class="card-body">
    <h3 class="card-title"><tag:message code="mobile"></tag:message></h3>
    
    <a href="mobile?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>

  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: #ba79cb;color: #fff;">

  <div class="card-body">
    <h3 class="card-title"><tag:message code="books"></tag:message></h3>
    
    <a href="book?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>
  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: #ec3b83;color: #fff;">

  <div class="card-body">
    <h5 class="card-title"><tag:message code="allCategory"></tag:message></h5>
    <p class="card-text"></p>
    <a href="displayProduct?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>

</div>
</div>
<!-- <img src="./images/bg.jpg"> -->
</body>
</html>