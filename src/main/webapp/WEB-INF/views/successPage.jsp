<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<jsp:include page="header.jsp"></jsp:include>

<div class="jumbotron">
  <h1 class="display-4">Order placed successfully!</h1>
 
  <hr class="my-4">
  <p>Order id: ${orderId}</p>
  <p>Order id: ${order.totalAmt}</p>
  <p class="lead">
    <a class="btn btn-primary btn-lg" href="home" role="button">Continue shopping</a>
  </p>
</div>
<script src="JS/autocomplete.js"></script>
</body>
</html>