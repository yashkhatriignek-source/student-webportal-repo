package com.ignek.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ignek.model.Student;
import com.ignek.service.StudentServices;

@WebServlet("/liststudent")
public class ListStudentServlet extends HttpServlet {
       
    public ListStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		RequestDispatcher requestDispatcher;
		
		try {
			List<Student> students = StudentServices.getAllStudents();
			
			if(students == null || students.isEmpty()) {
				logger.log(Level.INFO, "Student is empty");
			}
			else {	
				logger.log(Level.INFO, "have a student");
			}
			
			request.setAttribute("students", students);
			
			logger.log(Level.INFO, "Student attribute is set..");
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		requestDispatcher = request.getRequestDispatcher("studentlist.jsp");
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	
}