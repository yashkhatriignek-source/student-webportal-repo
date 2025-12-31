<%@page import="com.ignek.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Add Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<%
		Student student =(Student)request.getAttribute("studentid");
		boolean isEdit = (student != null);
	%>
	
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-6">
        
	<h3 class="text-center"><%= isEdit ? "Update a Student" : "Add a Student"%></h3>
	
	<form action ="<%= isEdit ? "updatestudent" : "addstudent" %>" method="post">
	
		<% if (isEdit) { %>
			<input type="hidden" name="studentid" value="<%=student.getId()%> ">
		<%}%>
		
	  <div class="mb-1 mt-3">
		<label class="form-label">Name:</label>
		<input type="text" class="form-control" name="studentname" placeholder="Enter Name" value="<%=isEdit ? student.getName() : "" %>"><br>
	  </div>
	  
	  <div class="mb-1">	
		<label class="form-label"> RollNo:</label>
		<input type="text" class="form-control" placeholder="Enter RollNo" name="studentrollno" value="<%=isEdit ? student.getRollNo() : "" %>"><br>
	  </div>
	  
	  <div class="mb-1">	
		<label class="form-label"> PhoneNo:</label>
		<input type="text" class="form-control" placeholder="Enter PhoneNo"name="studentphoneno" value="<%=isEdit ? student.getPhoneNO() : "" %>"><br>
	  </div>
	  	
	  <div class="mb-1">
		<label class="form-label"> Email:</label>
		<input type="email" class="form-control" placeholder="Enter Email" name="studentemail" value="<%=isEdit ? student.getEmail() : "" %>"><br>
	  </div>
	  
	  <div class="text-center">	
	   <input type="submit" class="btn btn-primary" value="Save">
	  </div>
	</form>
     </div>
   </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>	
</body>
</html>