package com.ignek.servlet;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ignek.model.Student;
import com.ignek.service.*;

@WebServlet("/updatestudent")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UpdateStudentServlet() {
        super();
    }
    
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		StudentServices studentservice = new StudentServices();
		RequestDispatcher dispatcher;
		int studentID = Integer.parseInt(request.getParameter("id"));
		
		logger.log(Level.INFO, "Student-id is get...");
		
		try {
			Student studentId = studentservice.getStudentByID(studentID);
			request.setAttribute("studentid", studentId);
			logger.log(Level.INFO, "Student is get...");
			dispatcher = request.getRequestDispatcher("studentform.jsp");
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("studentid");
		String studentName = request.getParameter("studentname");
		int studentRollNo = Integer.parseInt(request.getParameter("studentrollno"));
		String studentPhoneNo = request.getParameter("studentphoneno");
		String studentEmail= request.getParameter("studentemail");
		
		Student students = new Student();
		
		if (id !=  null) {
			
			int studentId = Integer.parseInt(id.trim());
		
			students.setId(studentId);
			students.setName(studentName);
			students.setRollNo(studentRollNo);
			students.setPhoneNO(studentPhoneNo);
			students.setEmail(studentEmail);
			}else {
				logger.log(Level.INFO, "Student-Id parameter is not passed..");
			}
		
		try {
			StudentServices.updateStudent(students);
			logger.log(Level.INFO, "Student is updated..");
			response.sendRedirect("liststudent");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
