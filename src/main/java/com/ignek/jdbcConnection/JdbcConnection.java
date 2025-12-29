package com.ignek.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnection {
	
	static String url = "jdbc:mysql://localhost:3306/mydb";
    static String username = "root";
    static String password = "ignek123";
    
    
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
    public static Connection getDbConnection() throws SQLException, ClassNotFoundException {
	
    	Class.forName("com.mysql.cj.jdbc.Driver");
		logger.log(Level.INFO, " Connection successfully..");
		return DriverManager.getConnection(url,username,password);
	}
}
