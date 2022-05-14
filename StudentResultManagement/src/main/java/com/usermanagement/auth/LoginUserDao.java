package com.usermanagement.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUserDao {
	 public  boolean validate(LoginuserBean loginuserBean) throws ClassNotFoundException, SQLException {
	        boolean status = false;
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3307/userdb?useSSL=false", "root", "sanjay");
	        try {

            String query = "select * from results where id = ? and email = ? ";
	      

	            // Create a statement using connection object
	        	
	            PreparedStatement preparedStatement = connection.prepareStatement(query); 
	            preparedStatement.setString(1, loginuserBean.getUsername());
	            preparedStatement.setString(2, loginuserBean.getPassword());

	            System.out.println(preparedStatement);
	            ResultSet rs = preparedStatement.executeQuery();
	            status = rs.next();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        finally
	        {
	        	connection.close();
	        }
	        
	        return status;
	    }

	    private  void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
