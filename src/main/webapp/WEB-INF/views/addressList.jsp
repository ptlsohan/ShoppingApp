<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>



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
    <h1>Address List</h1>
  </div>
</div>
<div class="w3-container" >

 	<c:forEach items="${addresses}" var="entry">
            <li class="list-group-item d-flex justify-content-between lh-condensed" style="background-color:rgba(255,255,255,0.5)">
             
             
              <div>
                <h6 class="my-0">
                ${entry.street} ${entry.apt}, <br>
                 ${entry.city}, ${entry.state} <br>
                 ${entry.country}
                 
         <form action="editAddress" >
                <input type="hidden" name="id" value="${entry.addressId}" />
                <button type="submit" class="btn btn-secondary">Edit</button>
                </form>
                
               <%--  <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalLong${entry.addressId}">
					  Remove</button>
				 <div class="modal fade" id="exampleModalLong${entry.addressId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  					<div class="modal-dialog modal-dialog-centered" role="document">
    					<div class="modal-content">
   						   <div class="modal-header">
   						     <h5 class="modal-title" id="exampleModalLongTitle">Alert!</h5>
   						     <button type="button" class="close" data-dismiss="modal" aria-label="Close">
   						       <span aria-hidden="true">&times;</span>
   						     </button>
  						    </div>
 					     <div class="modal-body">
   						     Remove Address?
     					 </div>
    				  <div class="modal-footer">
   		     <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      		  <form action="removeAddress" method="post"><input type="hidden" id="id" name="id" value="${entry.addressId}">
								 <button type="submit" class="btn btn-danger">Delete</button></form>	
								 
      </div>
    </div>
  </div>
</div>			 --%>				
                
                <form action="removeAddress" >
                <input type="hidden" name="id" value="${entry.addressId}">
                <button type="submit" class="btn btn-danger">Remove</button>
                </form>
        </h6>
               
              </div>
             
            </li>
            </c:forEach>




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