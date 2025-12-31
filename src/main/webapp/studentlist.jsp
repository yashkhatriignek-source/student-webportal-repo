<%@page import="com.ignek.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Optional"%>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <script type="text/javascript">
        function confirmDelete(studentId) {
            if (confirm("Are you sure you want to delete this student?")) {
                window.location.href = "deletestudent?id=" + studentId;
            }
        }
    </script>
</head>
<body>
	
	<div class="container d-flex justify-content-center mt-5">
	
	<div class="col-xl-12">
	
	<h3 class="text-center mb-3">Student Web Portal</h3>
	
	<div class="d-flex flex-row justify-content-between mb-2">
	  <div>
	    <h3>List of Students</h3>
	  </div>
	  
	  <div>
	   <a href="studentform.jsp" class="btn btn-primary ms-auto" role="button">Add Student</a><br>
	  </div>
	</div>
<table class="table table-striped table-hover">
	
	<tr>
	<thead class="table-success">
		<th>Id</th><th>Name</th><th>Roll No</th><th>Phone No</th><th>Email</th><th>Action</th>
	</thead>
	</tr>
	
 <%
	 List<Student> list = (List<Student>)request.getAttribute("students");
	 
	 if (list != null && !list.isEmpty()) {
	 for (Student student : list) {
 %>
	<tr>
		<td><%= student.getId() %></td>
		<td><%= student.getName() %></td>
		<td><%= student.getRollNo() %></td>
		<td><%= student.getPhoneNO() %></td>
		<td><%= student.getEmail() %></td>
		
		<td>
			<a class="btn btn-warning btn-sm" role="button" href="updatestudent?id=<%=student.getId()%>">Update</a>
			<a class="btn btn-danger btn-sm" role="button" href="#" onclick="confirmDelete(<%= student.getId()%>)">Delete</a>
		</td>
	</tr>
	
	<% }  %> 
	<% } else { %>
      <tr><td colspan="*">No students found.</td></tr>
  <% } %> 

</table>
</div>
</div>	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>		
</body>
</html>