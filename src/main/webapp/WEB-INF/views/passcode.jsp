<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passcode</title>
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
<br><br>

<form:form action="/TaskAssignerr/checkpasscode" method="post" id="passcode" modelAttribute="Person" >

<form:label for="passcode" path="passcode">Pass code:</form:label>
<form:input class="form-control" type="password" id="passcode" name="passcode" path="passcode" required="required" />
<i>Please enter the pass code given to you by the task setter to access your tasks</i><br><br>
<div style="display: none;"><form:input type="text" id="pk_person_id" name="pk_person_id" path="pk_person_id"/></div>
<i class="text-danger">${status}</i>
<form:button type="submit" form="passcode" name = "pass" id="pass" value="pass" class="btn btn-primary btn-lg btn-block">Access Tasks</form:button> 


</form:form>

</div>
</body>
</html>