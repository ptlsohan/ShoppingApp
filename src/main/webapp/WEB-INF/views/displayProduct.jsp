<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="header.jsp"></jsp:include>

<div class="container">
  <div class="row ">
  <c:forEach items="${list}" var="li">
  <div class="card col-md-3 m-1" style="width: 18rem;">
    <img class="card-img-top" src="${pageContext.request.contextPath}/images/product.png" alt="Card image cap">
  <div class="card-body">
    <h5 class="card-title">${li.companyName} ${li.name}</h5>
    <p class="card-text">Price: $${li.price}</p>
    <a href="${li.category}/${li.id}" class="btn btn-primary">Product detail</a>
  </div>
  </div>
  </c:forEach>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous</a>
    </li>
    <li class="page-item"><a class="page-link" href="?start=0">1</a></li>
    <li class="page-item"><a class="page-link" href="?start=1">2</a></li>
    <li class="page-item"><a class="page-link" href="?start=2">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav>

</div>

</body>
</html>