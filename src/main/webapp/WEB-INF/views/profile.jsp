<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>


<c:if test="${sessionScope.user !=null}">

<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none;background-color:rgba(0,0,0,0.5);color:white;" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large"
  onclick="w3_close()">Close &times;</button>
  <a href="profile" class="w3-bar-item w3-button">Edit Profile</a>
   <a href="addressList" class="w3-bar-item w3-button">List Address</a>
  <a href="add" class="w3-bar-item w3-button">Add Address</a>
  

</div>

<div id="main">

<div class="w3-primary">
  <button id="openNav" class="w3-button w3-blue w3-xlarge" onclick="w3_open()">&#9776;</button>
  <div class="w3-container">
    <h1>Profile</h1>
  </div>
</div>
<div class="w3-container">

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
</div>
</c:if>
<c:if test="${sessionScope.user ==null}">
Please log in <a href="login">Login</a>
</c:if>

<script>
function w3_open() {
  document.getElementById("main").style.marginLeft = "25%";
  document.getElementById("mySidebar").style.width = "25%";
  document.getElementById("mySidebar").style.display = "block";
  document.getElementById("openNav").style.display = 'none';
}
function w3_close() {
  document.getElementById("main").style.marginLeft = "0%";
  document.getElementById("mySidebar").style.display = "none";
  document.getElementById("openNav").style.display = "inline-block";
}
</script>
<script src="JS/autocomplete.js"></script>
</body>
</html>