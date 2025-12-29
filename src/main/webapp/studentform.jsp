<%@page import="com.ignek.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Student student =(Student)request.getAttribute("studentid");
	%>
	
	<h2><%= (student == null) ? "Add Student" : "Update Student" %></h2>
	
	<form action ="<%= (student == null) ? "addstudent" : "updatestudent" %>" method="post">
	
		<% if (student != null) { %>
			<input type="hidden" name="studentid" value="<%=student.getId()%> ">
			
		<%}%>
		
		<label>Student Name :</label>
		<input type="text" name="studentname" value="<%=(student != null) ? student.getName() : "" %>"><br>
		<br>
		<label>Student RollNo :</label>
		<input type="text" name="studentrollno" value="<%=(student != null) ? student.getRollNo() : "" %>"><br>
		<br>
		<label>Student PhoneNo :</label>
		<input type="text" name="studentphoneno" value="<%=(student != null) ? student.getPhoneNO() : "" %>"><br>
		<br>
		<label>Student Email :</label>
		<input type="text" name="studentemail" value="<%=(student != null) ? student.getEmail() : "" %>"><br>
		<br>
		<input type="submit" value="Save">
	</form>
	
</body>
</html>