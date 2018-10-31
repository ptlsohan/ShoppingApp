<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>






<div class="container">

  <div class="row mt-5 justify-content-center">
  <c:forEach items="${list}" var="li">
  <div class="card col-md-3 m-1" style="width: 18rem; background-color: rgba(0,0,0,.5); color:white; "">
    <img class="card-img-top mt-2" src="${pageContext.request.contextPath}/images/product/${li.image}"  alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title"> ${li.name}</h5>
    <p class="card-text">Price: $${li.price}</p>
    <a href="${li.category}/${li.id}" class="btn btn-primary">Product detail</a>
  </div>
  </div>
  </c:forEach>
</div>




</div>
<script src="${pageContext.request.contextPath}/JS/sidebar.js">


</script>
<script src="${pageContext.request.contextPath}/JS/autocomplete.js"></script>
</body>
</html>