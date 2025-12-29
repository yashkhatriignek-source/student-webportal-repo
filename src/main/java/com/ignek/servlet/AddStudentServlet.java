package com.ignek.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import com.ignek.model.Student;
import com.ignek.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet("/addstudent")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String studentName = request.getParameter("studentname");
		int studentRollNo = Integer.parseInt(request.getParameter("studentrollno"));
		String studentPhoneNo = request.getParameter("studentphoneno");
		String studentEmail= request.getParameter("studentemail");
		
		Student students = new Student();
		students.setName(studentName);
		students.setRollNo(studentRollNo);
		students.setPhoneNO(studentPhoneNo);
		students.setEmail(studentEmail);
    
		try {
			StudentServices.addStudent(students);
			logger.log(Level.INFO, " Student add successfully..");
			response.sendRedirect("liststudent");
		 
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
}
