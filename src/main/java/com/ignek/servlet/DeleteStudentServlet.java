package com.ignek.servlet;

import jakarta.servlet.ServletException;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ignek.service.*;

@WebServlet("/deletestudent")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudentServlet() {
        super();
    }
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentid = Integer.parseInt(request.getParameter("id"));
		StudentServices studentservice = new StudentServices();
		
		try {
			studentservice.deleteStudent(studentid);
			logger.log(Level.INFO, "Student is deleted..");
			response.sendRedirect("liststudent");
		} catch (Exception e ) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
