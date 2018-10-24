<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">

	<div>
	<div class="row justify-content-center" style="color:black;">
  <div class="col-md-6">

<c:if test="${invalid}">
<div class="alert alert-danger" role="alert">
  ${msg} 
</div>
</c:if>
<div class="card" style="margin:20px; padding:10px;" >
  <div class="card-header">
   <h4><tag:message code="loginHead"></tag:message> </h4> 
  </div>
    <form action="loginValidate" method="post" >
  <div class="form-group">
    <label for="uname"><tag:message code="username"></tag:message></label>
    <input type="text" class="form-control" id="uname" name="username"  placeholder="Username">

  </div>
  
  <div class="form-group">
    <label for="password"><tag:message code="password"></tag:message></label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  

 <div class="radio">
  <label><input type="radio" name="role" value="CUSTOMER" checked><tag:message code="customer"></tag:message></label>
</div>
<div class="radio">
  <label><input type="radio" name="role" value="ADMIN"><tag:message code="admin"></tag:message></label>
</div>
  <button type="submit" class="btn btn-primary"><tag:message code="login"></tag:message></button>
</form>
  </div>
  </div>
  </div>
  </div>
  
</div>
<!-- <script src="./JS/loginValidation.js"></script> -->
</body>

</html>