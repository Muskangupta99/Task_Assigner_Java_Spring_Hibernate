<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.center {
  margin: auto;
  width: 50%;
  border: 1px solid grey;
  padding: 10px;
  
}
.vertical-center {
  margin: 0;
  position: absolute;
  top: 50%;
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);
}
.center-list {
  margin: auto;
  width: 50%;
  padding: 10px;
}
.center-user{
margin: auto;
  width: 50%;
  padding: 10px;
}
.center-in-div{
  text-align: center;
  
}
.content {
 width: 50%;
  position: absolute;
  left: 50%;
  top: 50%;
   border: 1px solid grey;
  padding: 10px;
  -webkit-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}
</style>
</head>
<body>


<div class="content" id="Register">
<h1 class="center-in-div center-in-div text-primary">Register for Task Assigner</h1>
<div  class="form-group ">

<form:form action="/TaskAssignerr/registerUser" method="post" id="RegisterForm" modelAttribute="Users" >

<form:label for="email" path="email">Email:</form:label>
<form:input class="form-control" type="text" id="email" name="email" path="email"/><br><br>

<form:label for="password" path="password">Password:</form:label>
<form:input class="form-control" type="password" id="password" name="password" path="password"/><br><br>

<form:label for="confirm-password" path="password">Confirm Password:</form:label>
<form:input class="form-control" type="password" id="confirm-password" name="confirm-password" path="confirm_password" /><br><br>
<p>${status}</p>

<form:button type="submit" form="RegisterForm" name = "register" id="register" value="Submit" class="btn btn-primary btn-lg btn-block ">Register</form:button> 


</form:form>
</div>
</div>

</body>
</html>