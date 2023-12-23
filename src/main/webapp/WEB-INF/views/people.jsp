<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>People</title>
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
  max-height: 390px;
  overflow-y: auto;
 
}
</style>

</head>
<body>
<script>

function callajax(){
    //alert("hello");
    var person_name = $('#person_name2').val();
    var user_id = $('#fk_user_id2').val()       
    
    var data = 'person_name='
            + person_name
            + '&fk_user_id='
            + user_id;
    $.ajax({
        url : "/TaskAssignerr/addperson",
        data : data,
        type : "POST",

        success : function(id){
        	//alert(id);
        	var x=document.getElementById('people').insertRow(0);
        	var y = x.insertCell(0);
        	y.innerHTML="<a href=createtask?person_id="+id+"&passcode=\"\">"+document.getElementById('person_name2').value+"</a>"
        	document.getElementById('person_name2').value="";
        	var z = x.insertCell(1);
        	z.innerHTML="No pass code";
        
        	
        	
        } ,
        error : function(e) {
            alert("E : "+JSON.stringify(e)+" ");
        }
   
   
  
});
}
</script>
<h2 class="center-text center-in-div text-primary">Add People</h2>
<div class="center-user">Assign tasks to the people you add here! Click on their names to assign pass codes & tasks.</div>
<div class="center-user">Your user ID is : ${user_id}</div>

<div  class="center center-in-div">
<input type="text" name="person_name" id="person_name2" placeholder="Enter person name">
<input type="hidden" type="text" name="fk_user_id" id="fk_user_id2" value="${user_id}">
<button  type="button" name="add_person" id="add_person" onclick="callajax()" class="btn btn-primary btn-sm">Add Person</button>
</div>


<div class="center-text" ><b>People</b><br>
<div class="center-list table-wrapper center-in-div " style="width: 100%;">
<table class="table " id="people" border="1">
 <c:forEach items="${persons}" var="person">
     <tr><td><a  href="createtask?person_id=${person.pk_person_id}&passcode=${person.passcode}">${person.person_name}</a></td>
     <c:choose>
     <c:when  test="${empty person.passcode}">
     <td ><i>No pass code</i></td>
     </c:when>
     <c:otherwise>
     <td >${person.passcode}</td>
     </c:otherwise>
     </c:choose>
     </tr>
   </c:forEach>

</table><br> 
</div>

</div>

</body>
</html>