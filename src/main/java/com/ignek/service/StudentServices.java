package com.ignek.service;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.ignek.jdbcConnection.JdbcConnection;
import com.ignek.model.Student;


public class StudentServices {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
	public static void addStudent(Student student ) throws SQLException, ClassNotFoundException {
		String query = "insert into Students(studentName, studentRollNo, studentPhoneNo, studentEmail) values(?,?,?,?)";
		
		Connection connection = JdbcConnection.getDbConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, student.getName());
		preparedStatement.setInt(2, student.getRollNo());
		preparedStatement.setString(3, student.getPhoneNO());
        preparedStatement.setString(4, student.getEmail());
        	
        preparedStatement.executeUpdate();
        connection.close();
        }
	
	 public static void updateStudent(Student student) throws SQLException, ClassNotFoundException
	 	{
		      
		 String query = "update Students set studentName=?, studentRollNo=?,studentPhoneno=?, studentEmail=? "
		 		+ "where studentId =?";
		 Connection connection = JdbcConnection.getDbConnection();
		 PreparedStatement preparedStatement = connection.prepareStatement(query);
	
		 preparedStatement.setString(1, student.getName());
		 preparedStatement.setInt(2, student.getRollNo());
		 preparedStatement.setString(3, student.getPhoneNO());
	     preparedStatement.setString(4, student.getEmail());
	     preparedStatement.setInt(5, student.getId());
		      
	      int rows = preparedStatement.executeUpdate();
	      if (rows > 0) {
	    	    System.out.println("Student updated successfully");
	    	} else {
	    	    System.out.println("Update failed: No rows affected");
	    	}    
		 connection.close();
		 }
	 
	 public static void deleteStudent(int id) throws SQLException, ClassNotFoundException {
		 
	     String query = "delete from Students where studentId =?";
	     Connection connection = JdbcConnection.getDbConnection();
	     PreparedStatement preparedStatement = connection.prepareStatement(query);
		
	     preparedStatement.setInt(1,id);
	     preparedStatement.executeUpdate();
	     connection.close();
	     }
	 
	 public static List<Student> getAllStudents() throws SQLException, ClassNotFoundException
	 {
		 List<Student> list = new ArrayList<Student>();

		 String query = "Select * from Students";
	     Connection connection = JdbcConnection.getDbConnection();
	     PreparedStatement preparedStatement = connection.prepareStatement(query);
	     logger.log(Level.INFO, " Connection successfully..");
	     
	     ResultSet resultSet = preparedStatement.executeQuery();
		 
	     while (resultSet.next()) {
	    	 
	    	 Student student = new Student();
	    	 student.setId(resultSet.getInt(1));
	    	 student.setName(resultSet.getString(2));
	    	 student.setRollNo(resultSet.getInt(3));
	    	 student.setPhoneNO(resultSet.getString(4));
	    	 student.setEmail(resultSet.getString(5));
	    	 
	    	 list.add(student);
	    	 }
	     connection.close();
	     return list;
	     }	 
	 
	 public static Student getStudentByID(int id) throws SQLException, ClassNotFoundException {
		
		 String query = "Select * from Students where studentID=?";
	     Connection connection = JdbcConnection.getDbConnection();
	     PreparedStatement preparedStatement = connection.prepareStatement(query);
	     preparedStatement.setInt(1, id);
	     ResultSet resultSet = preparedStatement.executeQuery();
	     
	     Student student = new Student();
	     if	(resultSet.next()) {
	    	 
	    	 student.setId(resultSet.getInt(1));
	    	 student.setName(resultSet.getString(2));
	    	 student.setRollNo(resultSet.getInt(3));
	    	 student.setPhoneNO(resultSet.getString(4));
	    	 student.setEmail(resultSet.getString(5));
		}
	     connection.close();
		return student;
		}
	 }
