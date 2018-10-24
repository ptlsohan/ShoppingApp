    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
          <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
</head>
<body background="${pageContext.request.contextPath}/images/bg.jpg">


<div class="bg-primary">
      <div class="row justify-content-center">
      <div class ="col-sm-8 m-1">
      <form class="" action="/OnlineShoppingApp/search">


      <div class="input-group">
      <div class="input-group-prepend">
      <select name="category" class="form-control">
          <option value="all"><tag:message code="allCategory"></tag:message></option>
          <option value="fashion"><tag:message code="fashion"></tag:message></option>
          <option value="laptop"><tag:message code="laptop"></tag:message></option>
          <option value="books"><tag:message code="books"></tag:message></option>
          <option value="mobile"><tag:message code="mobile"></tag:message></option>
      </select>

      </div>
      <input type="text" class="form-control" name="keyword" aria-label="Text input with dropdown button">
      <div class="input-group-append">
        <button class="btn btn-warning" type="submit">Search</button>
      </div>
      </div>

      </form>
</div>
</div>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="/OnlineShoppingApp/home">Shopping App</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
         <a class="nav-item nav-link" href="/OnlineShoppingApp/fashion?start=0"><tag:message code="fashion"></tag:message></a>
      </li>
      <li class="nav-item">
        <a class="nav-item nav-link" href="/OnlineShoppingApp/laptop?start=0"><tag:message code="laptop"></tag:message></a>
      </li>
<li class="nav-item">
        <a class="nav-item nav-link" href="/OnlineShoppingApp/book?start=0"><tag:message code="books"></tag:message></a>
      </li>
<li class="nav-item">
       <a class="nav-item nav-link" href="/OnlineShoppingApp/mobile?start=0"><tag:message code="mobile"></tag:message></a>
      </li>
      </ul>
      <ul class="navbar-nav ml-auto">
      
      
      <c:if test="${sessionScope.user==null}">
      <li class="nav-item" style="padding-top:5px;">
            <a href="/OnlineShoppingApp/showCart"  ><svg xmlns="http://www.w3.org/2000/svg"  width="40" height="40" viewBox="0 0 30 30"><path d="M0 0h24v24H0zm18.31 6l-2.76 5z" fill="none"/><path d="M11 9h2V6h3V4h-3V1h-2v3H8v2h3v3zm-4 9c-1.1 0-1.99.9-1.99 2S5.9 22 7 22s2-.9 2-2-.9-2-2-2zm10 0c-1.1 0-1.99.9-1.99 2s.89 2 1.99 2 2-.9 2-2-.9-2-2-2zm-9.83-3.25l.03-.12.9-1.63h7.45c.75 0 1.41-.41 1.75-1.03l3.86-7.01L19.42 4h-.01l-1.1 2-2.76 5H8.53l-.13-.27L6.16 6l-.95-2-.94-2H1v2h2l3.6 7.59-1.35 2.45c-.16.28-.25.61-.25.96 0 1.1.9 2 2 2h12v-2H7.42c-.13 0-.25-.11-.25-.25z"/> <span class="badge badge-danger" style="position: relative;top: -14px;right: 14px;">${cart.size()}</span></svg></a>
         </li>
<li class="nav-item">
       <a class="nav-item nav-link" href="/OnlineShoppingApp/register"><tag:message code="register"></tag:message></a>
 </li>
</li>
<li class="nav-item">
      <a class="nav-item nav-link" href="/OnlineShoppingApp/login"><tag:message code="login"></tag:message></a>

      </li>
      </c:if>
 <c:if test="${sessionScope.user!=null}">
 <li class="nav-item" style="padding-top:5px;">
            <a href="/OnlineShoppingApp/showCart"  ><svg xmlns="http://www.w3.org/2000/svg"  width="40" height="40" viewBox="0 0 30 30"><path d="M0 0h24v24H0zm18.31 6l-2.76 5z" fill="none"/><path d="M11 9h2V6h3V4h-3V1h-2v3H8v2h3v3zm-4 9c-1.1 0-1.99.9-1.99 2S5.9 22 7 22s2-.9 2-2-.9-2-2-2zm10 0c-1.1 0-1.99.9-1.99 2s.89 2 1.99 2 2-.9 2-2-.9-2-2-2zm-9.83-3.25l.03-.12.9-1.63h7.45c.75 0 1.41-.41 1.75-1.03l3.86-7.01L19.42 4h-.01l-1.1 2-2.76 5H8.53l-.13-.27L6.16 6l-.95-2-.94-2H1v2h2l3.6 7.59-1.35 2.45c-.16.28-.25.61-.25.96 0 1.1.9 2 2 2h12v-2H7.42c-.13 0-.25-.11-.25-.25z"/> <span class="badge badge-danger" style="position: relative;top: -14px;right: 14px;">${sessionScope.cartSize}</span></svg></a>
         </li>
<li class="nav-item">
      <a class="nav-item nav-link" href="/OnlineShoppingApp/profile">Hi ${sessionScope.user.username}!</a>

      </li>
      <li class="nav-item">
      <a class="nav-item nav-link" href="/OnlineShoppingApp/showOrder">Orders</a>

      </li>
      <li class="nav-item">
      <a class="nav-item nav-link" href="/OnlineShoppingApp/logout">Logout</a>

      </li>
      </c:if>
      
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
         <tag:message code="language"></tag:message>
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="?language=en">English</a>
          <a class="dropdown-item" href="?language=es">Spanish</a>
        </div>
      </li>
     
    </ul>
    
  </div>
</nav>
  </div>