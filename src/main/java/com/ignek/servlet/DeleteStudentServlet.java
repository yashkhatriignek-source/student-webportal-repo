package com.ignek.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import com.ignek.service.*;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int studentid = Integer.parseInt(request.getParameter("id"));
		
		StudentServices studentservice = new StudentServices();
		
		try {
			studentservice.deleteStudent(studentid);
		} catch (Exception e ) {
			e.printStackTrace();
		}
		response.sendRedirect("liststudent");
	}
}
