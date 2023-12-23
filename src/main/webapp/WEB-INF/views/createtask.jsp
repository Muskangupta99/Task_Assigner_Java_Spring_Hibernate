<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Tasks</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.center {
  margin: auto;
  width: 50%;
  padding: 10px;
}
.center-text {
  margin: auto;
  width: 50%;
  padding: 10px;
    text-align: center;
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
   text-align: center;
}

.center-in-div{
  text-align: center;
  
}

.table-height {
    max-height:300px;
}

.table-wrapper {
  max-height: 300px;
  overflow-y: auto;
 
}
</style>
<script>
function callajax(){
    //alert("hello");
    var task_description = $('#task_description').val();
    var person_id = $('#person_id').val()       
    
    var data = 'task_description='
            + task_description
            + '&person_id='
            + person_id;
    $.ajax({
        url : "/TaskAssignerr/addtask",
        data : data,
        type : "POST",

        success : function(){
        	//alert(id);
        	var x=document.getElementById('tasks').insertRow(0);
        	var y = x.insertCell(0);
        	y.innerHTML=document.getElementById('task_description').value
        	document.getElementById('task_description').value="";
        	var z = x.insertCell(1);
        	z.innerHTML="Not Completed";
        
        	
        	
        } ,
        error : function(e) {
            alert("E : "+JSON.stringify(e)+" ");
        }
   
   
  
});
}

function setpasscode(){
	alert("set pass code");
	var passcode=document.getElementById("passcode").value;
	var person_id=document.getElementById("person_id").value;
	var data = "passcode="+passcode+"&person_id="+person_id;
	$.ajax({
		url: "/TaskAssignerr/addpasscode",
		type:"POST",
		data:data,
		 success : function(){
	        	alert("passcode set successfully, please share it with the required people");
	        	
	        } ,
	        error : function(e) {
	        	alert("Something went wrong X/, please check dev tools");
	            console.log("E : "+JSON.stringify(e)+" ");
	        }
		
	})
	
}
</script>
</head>
<body>
<h2 class="center-text center-in-div text-primary">Add Tasks</h2>

<div class="center">

<input size="65" name="task_description" id="task_description" placeholder="enter task">&nbsp
<input  style="width:100%;" type="hidden" type="text" name="person_id" id="person_id" value="${fk_person_id}">
<button   type="button" name="add_task" id="add_task" onclick="callajax()">Add Task</button>
<br><br>
<i>Set a pass code for the assignee so they can access their tasks privately.</i>
<br>
<input size="63" type="text" name="passcode" id="passcode" placeholder="Current Pass code : ${passcode}">&nbsp
<button  type="button" name="setpasscode" id="setpasscode" onclick="setpasscode()">Change/Add</button><br><br>

Copy this link to share the tasks : <i class="text-primary"> http://localhost:8080/TaskAssignerr/passcode?person_id=${fk_person_id}</i>
<br>
<b><div class="center-text" >Tasks</div></b>
<div class="center-list table-wrapper center-in-div " style="width: 100%;">
<table class="table" id="tasks" border="1"> 
 <c:forEach items="${tasks}" var="tasks">
     <tr>
     <td>${tasks.description}</td>
     <c:choose>
     <c:when  test="${tasks.is_completed==0}">
     <td>Not Completed</td>
     </c:when>
     <c:otherwise>
        <td style="color:green;">Completed</td>
    </c:otherwise>
    </c:choose>
     <tr>
   </c:forEach>

</table><br> 
</div>


</body>
</html>