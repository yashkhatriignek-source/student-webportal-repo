<%@page import="com.ignek.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Optional"%>
<%@ page import="java.util.logging.Logger" %>
<%@ page import="java.util.logging.Level" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List of Students</h1>
	<a href="studentform.jsp">Add student</a><br>
	<br>
<table border="1">
	<tr>
		<th>Id</th><th>Name</th><th>Roll No</th><th>Phone No</th><th>Email</th><th>Action</th>
	</tr>
	
 <%
	 Logger logger = Logger.getLogger("studentlist.jsp");
	 List<Student> list = (List<Student>)request.getAttribute("students");
	
	 if(list == null){
		 
		 logger.log(Level.INFO, "have not any student");
	 }else{
		 logger.log(Level.INFO, "have a student");
	 }
	 
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
			<a href="updatestudent?id=<%=student.getId()%>">Update</a>
			<a href="deletestudent?id=<%=student.getId()%>">Delete</a>
		</td>
	</tr>
	
	<% }  %> 
	<% } else { %>
      <tr><td colspan="*">No students found.</td></tr>
  <% } %> 


</table>		
</body>
</html>