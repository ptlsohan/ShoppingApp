<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>


 
      <c:if test="${ error!=null }">
<div class="alert alert-danger" role="alert">
	<div style="color:red">${error}</div>
	</div>
	</c:if>
	
	<div class="w3-sidebar w3-bar-block w3-card w3-animate-left" style="display:none;background-color:rgba(0,0,0,0.5);color:white;" id="mySidebar">
  <button class="w3-bar-item w3-button w3-large"
  onclick="w3_close()">Close &times;</button>
  <a href="profile" class="w3-bar-item w3-button">Edit Profile</a>
  <a href="addressList" class="w3-bar-item w3-button">List Address</a>
  <a href="addAddressForm" class="w3-bar-item w3-button">Add Address</a>

</div>

<div id="main">

<div class="w3-primary">
  <button id="openNav" class="w3-button w3-blue w3-xlarge" onclick="w3_open()">&#9776;</button>
  <div class="w3-container">
    <h1>Edit Address</h1>
  </div>
</div>
<div class="w3-container">
	
	        <form action="updateAddress" class="needs-validation" novalidate="">
           

       
	 <fieldset >
	  <input type="hidden" id="addressId" name="addressId" value="${address.addressId}"> 
            <div class="mb-3">
              <label for="street"><tag:message code="street"></tag:message></label>
              <input type="text" class="form-control" id="street" name="street" value="${address.street}">
              
            </div>

            <div class="mb-3">
              <label for="apt"><tag:message code="apt"></tag:message> </label>
              <input type="text" class="form-control" id="apt" name="apt" value="${address.apt}">
            </div>
            
            <div class="mb-3">
              <label for="city"><tag:message code="city"></tag:message> </label>
              <input type="text" class="form-control" id="city" name="city" value="${address.city}">
            </div>

            <div class="row">
              <div class="col-md-5 mb-3">
                <label for="state">S<tag:message code="state"></tag:message> </label>
              <input type="text" class="form-control" id="state" name="state"  value="${address.state}">
              </div>
              <div class="col-md-4 mb-3">
                <label for="country"><tag:message code="country"></tag:message> </label>
              <input type="text" class="form-control" id="country" name="country"  value="${address.country}">
              </div>
              <div class="col-md-3 mb-3">
                <label for="zip"><tag:message code="zip"></tag:message></label>
                <input type="text" class="form-control" id="zip" name="zip"  value="${address.zip}"">
                <div class="invalid-feedback">
                  Zip code required.
                </div>
              </div>
            </div>
            <div class="mb-3">
              <label for="phone"><tag:message code="phone"></tag:message></label>
              <input type="text" class="form-control" id="phone" name="phone"  value="${address.phone}">
            </div>
            <input type="submit" class="btn btn-primary" value="update"/>
           <!--  <button type="button" class="btn btn-secondary" >Back</button> -->
           </fieldset>
           </form>
</div>
</div>
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