<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
.form-popup {
  display: none;
  top: 50%;
        left: 50%;
        width: 30em;
        height: 18em;
        transform: translate(-50%, -50%);
        border: 1px solid #666;
        position: fixed;
}

.center {
  margin: auto;
  width: 50%;
  border: 3px solid green;
  padding: 10px;
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

</style>
<body>
<div class="center">
<h1 class="center-in-div">Task Assigner</h1>
<h5 class="center-in-div">Hi there! Please see the steps below to manage tasks. </h5> <br>

<h4 class="center-in-div">1. Make an account &nbsp 2. Add people or groups &nbsp 3. Add tasks and share</h4>

<table class="center-list table">
<tr>
<td>
<button onclick="login()">Login</button><br>If you have an account&nbsp&nbsp
<td>
<button onclick="register()">Register</button><br>If you are new here&nbsp&nbsp
</td>
</tr>
</table>


<br>
${message}
</div>
</body>

<script type="text/javascript">

function login() {
	 window.open("http://localhost:8080/TaskAssignerr/loginpage");
	}

	
	
function register() {
	 window.open("http://localhost:8080/TaskAssignerr/register");
		}


</script>
</html>