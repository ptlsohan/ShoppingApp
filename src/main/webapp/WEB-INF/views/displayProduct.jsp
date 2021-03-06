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

<%-- <nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item disabled">
      <a class="page-link" href="#" tabindex="-1">Previous</a>
    </li>
    
    <c:url var="nextUrl1" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'start'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="start" value="0" />
</c:url>
    <li class="page-item"><a class="page-link" href="${nextUrl1 }">1</a></li>

<c:url var="nextUrl2" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'start'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="start" value="1" />
</c:url>
    <li class="page-item"><a class="page-link" href="${nextUrl2 }">2</a></li>
<c:url var="nextUrl3" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'start'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="start" value="${2}" />
</c:url>
    <li class="page-item"><a class="page-link" href="${nextUrl3 }">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#">Next</a>
    </li>
  </ul>
</nav> --%>


<nav class="m-5" aria-label="...">
  <ul class="pagination justify-content-center">
   <c:url var="prevUrl" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'start'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="start" value='<%= String.valueOf(Integer.parseInt(request.getParameter("start"))-1)%>' />
</c:url>
    <li class='page-item <%=Integer.parseInt(request.getParameter("start"))== 0 ? "disabled" : ""%>'>
    
      <a class="page-link" href="${prevUrl }" tabindex="-1">Previous</a>
    </li>
    <% for(int i=1;i<=(int)request.getAttribute("total");i++) {%>
    <c:url var="nextUrl3" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'start'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="start" value="<%=String.valueOf(i-1) %>" />
</c:url>
    <li class='page-item <%=Integer.parseInt(request.getParameter("start"))== i-1 ? "active" : ""%>'><a class="page-link" href="${nextUrl3 }"><%=i %></a></li>
    <% }%>
    <c:url var="nextUrl" value="">
<c:forEach items="${param}" var="entry">
    <c:if test="${entry.key != 'start'}">
        <c:param name="${entry.key}" value="${entry.value}" />
    </c:if>
</c:forEach>
<c:param name="start" value='<%= String.valueOf(Integer.parseInt(request.getParameter("start"))+1)%>' />
</c:url>
    <li class='page-item <%=Integer.parseInt(request.getParameter("start"))>= (int)request.getAttribute("total")-1 ? "disabled" : ""%>'>
      <a class="page-link" href="${nextUrl }">Next</a>
    </li>
  </ul>
</nav>

</div>
<script src="${pageContext.request.contextPath}/JS/sidebar.js">


</script>
<script src="${pageContext.request.contextPath}/JS/autocomplete.js"></script>
</body>
</html>