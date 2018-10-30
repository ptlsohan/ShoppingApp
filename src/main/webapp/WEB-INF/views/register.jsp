<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>

<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
<c:if test="${ error!=null }">
<div class="alert alert-danger" role="alert">
	<div style="color:red">${error}</div>
	</div>
</c:if>
<div class="row justify-content-center" style="color:black;">
  <div class="col-md-8">
<div class="card" style="margin:20px; padding:10px; background-color: rgba(0,0,0,.6);color:white;" >
  <div class="card-header">
   <h4><tag:message code="register"></tag:message> </h4> 
  </div>
<form action="validate" method="post" >

<div class="row">
              <div class="col-md-6 mb-3">
<label for="firstname">First Name</label>
    <input type="text" class="form-control" id="firstname"  name="firstName" placeholder="firstname" required/>
</div>


              <div class="col-md-6 mb-3">
  
    <label for="lastname">Last Name</label>
    <input type="text" class="form-control" id="lastname"  name="lastName" placeholder="lastname" required>

  </div>
  </div>
  <div class="form-group">
    <label for="uname"><tag:message code="username"></tag:message></label>
    <input type="text" class="form-control" id="uname" name="username"  placeholder="Username">

  </div>
  
  <div class="row">
              <div class="col-md-6 mb-3">
    <label for="password"><tag:message code="password"></tag:message></label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
 
  
 <div class="col-md-6 mb-3">
    <label for="confirmPassword"><tag:message code="confirmPassword"></tag:message></label>
    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password">
  </div>
  </div>
 <div class="radio">
  <label><input type="radio" name="role" value="CUSTOMER" checked><tag:message code="customer"></tag:message></label>
</div>
<div class="radio">
  <label><input type="radio" name="role" value="ADMIN"><tag:message code="admin"></tag:message></label>
</div>

  
  <div class="form-group">
    <label for="age">Age</label>
    <input type="number" class="form-control" id="age"  name="age" placeholder="" max="100" min="0" />

  </div>
<label for="gender">Gender</label>
<div class="radio" id="gender">
  <label><input type="radio" name="gender" value="MALE" checked>male</label>
</div>
<div class="radio">
  <label><input type="radio" name="gender" value="FEMALE">female</label>
</div>
<div class="radio">
  <label><input type="radio" name="gender" value="OTHER">other</label>
</div>
  
  


  <button type="submit" class="btn btn-primary"><tag:message code="register"></tag:message></button>

</form>
</div>
</div>
</div>
</div>
<script>
$().ready(function(){
$('form').validate({
rules: {
uname: {
required: true,
minlength: 2
},
password: {
required: true,
minlength: 5
},
confirmPassword: {
required: true,
minlength: 5,
equalTo: password
}
},
messages: {
confirm_password: {
	equalTo: "please enter the same password"
}
}

});
});

</script>
<script src="JS/autocomplete.js"></script>
</body>
</html>