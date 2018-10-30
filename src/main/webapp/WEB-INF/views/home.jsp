<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
      <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
    
<jsp:include page="header.jsp"></jsp:include>


  

<!-- corosel -->
    


   <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner" style="height:300px;max-width:100%;max-height:100%;">
    <div class="carousel-item active" >
      <img class="d-block w-100 h-25" src="images/sale1.jpg" alt="First slide" style="max-height:300px;">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100 h-25" src="images/sale2.jpg" alt="Second slide" style="max-height:300px;">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100 h-25" src="images/sale3.png" alt="Third slide" style="max-height:300px;">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>



<div class="container">
  <div class="row justify-content-center">

  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: rgba(245,105,84,0.9);color: #fff;">


  <div class="card-body" >
<h3 class="card-title"><tag:message code="fashion"></tag:message></h3>
    <a href="fashion?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>


  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: rgba(0,115,183,0.9);color: #fff;">

  <div class="card-body">
    <h3 class="card-title"><tag:message code="laptop"></tag:message></h3>
    <p class="card-text"></p>
    <a href="laptop?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>

  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: rgba(0,166,90,0.9);color: #fff;">

  <div class="card-body">
    <h3 class="card-title"><tag:message code="mobile"></tag:message></h3>
    
    <a href="mobile?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>

  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: rgba(119,78,130,0.9);color: #fff;">

  <div class="card-body">
    <h3 class="card-title"><tag:message code="books"></tag:message></h3>
    
    <a href="book?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>
  <div class="card col-sm-3 m-1" style="width: 18rem; background-color: rgba(189,47,105,0.8);color: #fff;">

  <div class="card-body">
    <h5 class="card-title"><tag:message code="allCategory"></tag:message></h5>
    <p class="card-text"></p>
    <a href="displayProduct?start=0" class="btn btn-primary">Shop</a>
  </div>
  </div>

</div>
</div>
<!-- <img src="./images/bg.jpg"> -->
<script src="JS/autocomplete.js"></script>
</body>
</html>