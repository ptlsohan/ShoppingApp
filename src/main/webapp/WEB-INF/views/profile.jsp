<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
<form action="updateProfile" method="post" id="form" class="form-horizontal">
 
 
  <div class="form-group">
    <label for="firstname">First Name</label>
    <input type="text" class="form-control" id="firstname"  name="firstName" placeholder="firstname" value="${profile.firstName}" required>

  </div>
  <div class="form-group">
    <label for="lastname">Last Name</label>
    <input type="text" class="form-control" id="lastname"  name="lastName" placeholder="lastname" value="${profile.lastName}" required>

  </div>
  <input type="hidden" name="profileId" value="${profile.profileId}">
  
  <div class="form-group">
    <label for="age">Age</label>
    <input type="number" class="form-control" id="age"  name="age" placeholder="" max="100" min="0" value="${profile.age}" />

  </div>


 
  
   
 <button type="submit" class="btn btn-primary">Update</button>
</form>
</div>
</body>
</html>