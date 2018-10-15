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
<form action="validate" method="post" id="form" class="form-horizontal">
  <div class="form-group">
    <label for="uname">Username</label>
    <input type="text" class="form-control" id="uname"  name="username" placeholder="Username">

  </div>
  <div class="form-group">
    <label for="fname">First name</label>
    <input type="text" class="form-control" id="firstName"  name="firstName" placeholder="firstname" required>

  </div>

<div class="form-group">
    <label for="lname">Last name</label>
    <input type="text" class="form-control" id="lastName"  name="lastName" placeholder="lastname" required>

  </div>
  
  <div class="form-group">
    <label for="password">Password</label>
    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
  </div>
  <div class="form-group">
    <label for="confirm_password">Confirm Password</label>
    <input type="password" class="form-control" id="confirm_password" name="confirm_password" placeholder="Confirm Password">
  </div>

   <div class="form-group">
    <label for="email">Email</label>
    <input type="email" class="form-control" id="email"  name="email" >

  </div>
 
   <div class="radio">
  <label><input type="radio" name="gender" value="Male">Male</label>

  <label><input type="radio" name="gender" value="Female">Female</label>
</div>
  
   
 <button type="submit" class="btn btn-primary">Register</button>
</form>
</div>
</body>
</html>