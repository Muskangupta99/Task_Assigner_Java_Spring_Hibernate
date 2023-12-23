<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
<div class="content">
<h1 class="center-in-div text-primary">Task Assigner</h1>
<h5 class="center-in-div">Hi there! Please see the steps below to manage tasks. </h5> <br>

<h4 class="center-in-div">1. Add people or groups&nbsp&nbsp&nbsp&nbsp2. Add tasks&nbsp&nbsp&nbsp&nbsp3. Share</h4>

<div  id="login" class="form-group ">
<form:form action="/TaskAssignerr/login" method="post" id="LoginForm" modelAttribute="Users"  >

<form:label for="email" path="email">Email:</form:label>
<form:input class="form-control" type="text" id="email" name="email" path="email" required="required" /><br><br>

<form:label for="password" path="password">Password:</form:label>
<form:input type="password" class="form-control" id="password" name="password" path="password" required="required" />
<i class="text-danger">${status}</i>
<br><br>
<form:button type="submit" form="LoginForm" name = "login" id="login" value="Submit" class="btn btn-primary btn-lg btn-block " >Login</form:button> 


</form:form>

</div>

<h5 class="center-in-div">New here? Please <a href="/TaskAssignerr/register">Register</a></h5>

</div>
</body>
</html>