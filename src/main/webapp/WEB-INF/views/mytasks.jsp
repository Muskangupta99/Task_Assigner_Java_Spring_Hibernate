<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Tasks</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
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
h3 {
  display: inline;
}
</style>
</head>
<body>
<br><br>
<div class="center-list"><h3>Hi, </h3><h3 id="fk_person_name">${fk_person_name}</h3><h3>!</h3>
<br>Here are your tasks.
Notification will be sent to <b id="email">${notify}</b>. Click on done when you complete a task</div>
<input type="hidden" value="${fk_person_id}" id="person_id"></input>
<div class="center">
<br>
<b><div class="center-list">Tasks</div></b><br>
<table class="center-list table" id="task_table" border="1"> 
 <c:forEach items="${tasks}" var="task">
     <tr><td >${task.description}</td>
     <c:choose>
     <c:when  test="${task.is_completed==0}">
     <td><button type="button" class="btn btn-outline-success" value="${task.pk_task_id}" id ="${task.pk_task_id}" onclick="done('${task.pk_task_id}','${task.description}')">Done</button></td>
     </c:when>
     <c:otherwise>
        <td><button type="button" class="btn btn-outline-success" disabled="true">Completed</button></td>
    </c:otherwise>
    </c:choose>
     <tr>
   </c:forEach>
   

</table>
<br> 
</div>
<script>
function done(id,description){
	
	document.getElementById(id).disabled = true;
	document.getElementById(id).innerHTML="Completed";
	
    var person_name = document.getElementById("fk_person_name").innerHTML;
    var email = document.getElementById("email").innerHTML
    var task_id = id;
    var task_description = description;
    
    var data = 'person_name='
            + person_name
            + '&email='
            + email
            + '&task_id='
            +id
            +'&task_description='
            +task_description;
    //alert(data);
    $.ajax({
        url : "/TaskAssignerr/email",
        data : data,
        type : "POST",

        success : function(){
        	//alert(id);
        	console.log("email successfully sent");
        	
        	
        } ,
        error : function(e) {
            alert("E : "+JSON.stringify(e)+" ");
        }
    })
}

</script>
</body>
</html>