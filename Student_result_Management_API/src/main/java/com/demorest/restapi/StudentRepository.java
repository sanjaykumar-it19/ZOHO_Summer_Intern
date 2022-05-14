package com.demorest.restapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public  class StudentRepository {
	 Connection con = null;
	    String url = "jdbc:mysql://localhost:3307/userdb?useSSL=false";
		String username = "root";
		String password = "sanjay";
	public StudentRepository()
     {
    
     }
		
	// getting the list of students via admin
	public List<Student> getStudents() throws SQLException, ClassNotFoundException
	{
		
	    List<Student> stdlist = new ArrayList<>();
	    String sql = "select * from results";
	    try
	    {   Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
	    	PreparedStatement view = con.prepareStatement(sql);
	    	ResultSet studentData = view.executeQuery();
	    	
	    	while(studentData.next()){
				
				Student student = new Student();
				student.setId(studentData.getInt(1));
				student.setName(studentData.getString(2));
				student.setDepartment(studentData.getString(3));
				student.setEmail(studentData.getString(4));
				student.setMode(studentData.getString(5));
				student.setUniversity(studentData.getString(6));
				student.setCgpa(studentData.getString(7));
				stdlist.add(student);
			}
	    }
	    catch (SQLException var)
	    {
	    	 var.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    }
	    
		return stdlist;
	}
	
	// Getting the student via id in admin
	public Student getStudent(int id) throws ClassNotFoundException, SQLException
	{  
		Student student = new Student();
	    String sql = "select * from results where id = ?";
	   
	    try
	    {   Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
	    	PreparedStatement view = con.prepareStatement(sql);
			view.setInt(1, id);
			ResultSet studentData = view.executeQuery();
	    	if(studentData.next()){
				
				
	    		student.setId(studentData.getInt(1));
				student.setName(studentData.getString(2));
				student.setDepartment(studentData.getString(3));
				student.setEmail(studentData.getString(4));
				student.setMode(studentData.getString(5));
				student.setUniversity(studentData.getString(6));
				student.setCgpa(studentData.getString(7));
				
			}
	    }
	    catch (SQLException var)
	    {
	    	 var.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    }
	    
		return student;
		
	}
	
	//create student via Json 
	public void createStudent(Student s1) throws ClassNotFoundException, SQLException
	{  
		
	    String sql = "insert into results (id,name,department,email,mode,university,cgpa) VALUES(?,?,?,?,?,?,?)";
	    try
	    {   Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
	    	PreparedStatement insert = con.prepareStatement(sql);
	    	insert.setInt(1, s1.getId());
			insert.setString(2, s1.getName());
			insert.setString(3, s1.getDepartment());
			insert.setString(4, s1.getEmail());
			insert.setString(5, s1.getMode());
			insert.setString(6, s1.getUniversity());
			insert.setString(7, s1.getCgpa());
			
			insert.executeUpdate();
			
	    
	    }
	    catch (SQLException var)
	    {
	    	 var.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    }
	    
		
	}
	
	// student update via admin
	public void  update(Student s1) throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE results SET name = ?, department = ?,email=?,mode = ?,university =?,cgpa =? WHERE id = ?";
	    try
	    {   Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
	    	PreparedStatement insert = con.prepareStatement(sql);
	    	
	    	insert.setInt(7, s1.getId());
			insert.setString(1, s1.getName());
			insert.setString(2, s1.getDepartment());
			insert.setString(3, s1.getEmail());
			insert.setString(4, s1.getMode());
			insert.setString(5, s1.getUniversity());
			insert.setString(6, s1.getCgpa());
			insert.executeUpdate();
			
	    
	    }
	    catch (SQLException var)
	    {
	    	 var.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    }
	}
	
	
	// update via student api
	public void  updatestd(Student s1) throws ClassNotFoundException, SQLException
	{
		String sql = "UPDATE results SET name = ?, department = ?,email=?,mode = ?,university =? WHERE id = ?";
	    try
	    {   Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
	    	PreparedStatement insert = con.prepareStatement(sql);
	    	
	    	insert.setInt(6, s1.getId());
			insert.setString(1, s1.getName());
			insert.setString(2, s1.getDepartment());
			insert.setString(3, s1.getEmail());
			insert.setString(4, s1.getMode());
			insert.setString(5, s1.getUniversity());
			
			insert.executeUpdate();
			
	    
	    }
	    catch (SQLException var)
	    {
	    	 var.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    }
	}
	
	

// deleting through id
	public void delete(int id) throws ClassNotFoundException, SQLException {
		
		
		
		String sql = "DELETE FROM results WHERE id = ?";
	    try
	    {   Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url,username,password);
	    	PreparedStatement delete = con.prepareStatement(sql);
	    	
	    	delete.setInt(1, id);
			delete.executeUpdate();
	    
	    }
	    catch (SQLException var)
	    {
	    	 var.printStackTrace();
	    }
	    finally
	    {
	    	con.close();
	    }
		
	}
}
