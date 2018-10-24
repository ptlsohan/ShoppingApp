<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
${error }
<form action="payment" method="post" id="form" class="form-horizontal">
  <div class="form-group">
    <label for="creditcard">Credit card</label>
    <input type="text" class="form-control" id="creditcard"  name="creditcard" placeholder="">

  </div>
  <div class="form-group">
    <label for="fullname">Full Name</label>
    <input type="text" class="form-control" id="fullname"  name="fullname" placeholder="fullname" required>

  </div>
  
  <div class="form-group">
    <label for="creditcard">Credit card</label>
    <input type="text" class="form-control" id="creditcard"  name="creditcard" placeholder="">

  </div>

<div class="form-group">
    <label for="expDate">Expiration date</label>
    <input type="text" class="form-control" id="expDate"  name="expDate" placeholder="expDate" required>

  </div>
  
  <div class="form-group">
    <label for="street">Street</label>
    <input type="text" class="form-control" id="street" name="street" placeholder="">
  </div>
  <div class="form-group">
    <label for="apt">Apt</label>
    <input type="text" class="form-control" id="apt" name="apt" >
  </div>

   <div class="form-group">
    <label for="city">City</label>
    <input type="text" class="form-control" id="city"  name="city" >

  </div>
 
  <div class="form-group">
    <label for="state">State</label>
    <input type="text" class="form-control" id="state"  name="state" >

  </div>
  
  <div class="form-group">
    <label for="zip">Zipcode</label>
    <input type="text" class="form-control" id="zip"  name="zip" >

  </div>
   <div class="form-group">
    <label for="country">Country</label>
    <input type="text" class="form-control" id="country"  name="country" >

  </div>
  
   <div class="form-group">
    <label for="phone">Phone</label>
    <input type="text" class="form-control" id="phone"  name="phone" >

  </div>
 
  
   
 <button type="submit" class="btn btn-primary">Register</button>
</form>
</div>
</body>
</html>