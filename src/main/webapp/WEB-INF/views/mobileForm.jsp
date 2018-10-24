<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<c:if test="${ error!=null }">
	<div style="color:red">${error}</div>
</c:if>
<div class="row justify-content-center" style="color:black;">
  <div class="col-md-8">
<div class="card" style="margin:20px; padding:10px;" >
  <div class="card-header">
   <h4><tag:message code="login"></tag:message> </h4> 
  </div>
<form action="addMobile" method="post" >
  <div class="form-group">
    <label for="name"><tag:message code="name"></tag:message></label>
    <input type="text" class="form-control" id="name" name="name"  placeholder="name">

  </div>
  
  <div class="form-group">
    <label for="companyName"><tag:message code="companyName"></tag:message></label>
    <input type="text" class="form-control" id="companyName" name="companyName" placeholder="companyName">
  </div>
  
  <div class="form-group">
    <label for="price"><tag:message code="price"></tag:message></label>
    <input type="number" class="form-control" id="price" name="price" placeholder="price">
  </div>
 <div class="form-group">
    <label for="image"><tag:message code="image"></tag:message></label>
    <input type="text" class="form-control" id="image" name="image" placeholder="image">
  </div>
  
  <div class="form-group">
    <label for="quantity"><tag:message code="quantity"></tag:message></label>
    <input type="number" class="form-control" id="quantity" name="quantity" placeholder="quantiy" min="0">
  </div>
<div class="form-group">
    
    <input type="hidden" class="form-control" id="category" name="category" value="mobile">
  </div>
  
  <div class="form-group">
    <label for="screenSize"><tag:message code="screenSize"></tag:message></label>
    <input type="text" class="form-control" id="screenSize" name="screenSize" placeholder="screenSize" min="0">
  </div>
  
  <div class="form-group">
    <label for="ram"><tag:message code="ram"></tag:message></label>
    <input type="number" class="form-control" id="ram" name="ram" placeholder="ram" min="0">
  </div>
  
  <div class="form-group">
    <label for="camera"><tag:message code="camera"></tag:message></label>
    <input type="number" class="form-control" id="camera" name="camera" placeholder="camera" min="0">
  </div>
  
  <div class="form-group">
    <label for="os"><tag:message code="os"></tag:message></label>
    <input type="text" class="form-control" id="os" name="os" placeholder="os" >
  </div>
  
  <div class="form-group">
    <label for="processor"><tag:message code="processor"></tag:message></label>
    <input type="text" class="form-control" id="processor" name="processor" placeholder="processor" >
  </div>

  <button type="submit" class="btn btn-primary"><tag:message code="register"></tag:message></button>

</form>
</div>
</div>
</div>
</div>

</body>
</html>