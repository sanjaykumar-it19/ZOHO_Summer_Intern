package ExtendedDb;
import java.util.*;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class InsertStudentdetails extends Methods {
    
	InsertStudentdetails(java.sql.Statement stmt)throws SQLException
	{
		
		   // select the user choice of edit
    	System.out.println("Enter the insert query for the table ");
    	System.out.println("user id");
    	int id = scint.nextInt();
    	System.out.println(" user name");
    	String name = scStr.nextLine();
    	System.out.println("Department");
    	String Department = scStr.nextLine();
    	System.out.println("Year");
    	int year = scint.nextInt();
    	System.out.println("Gender");
    	String gender = scStr.nextLine();
    	System.out.println("Skill");
    	String skill = scStr.nextLine();
    	System.out.println("Project");
    	String project = scStr.nextLine();
    	System.out.println("Percentage");
    	int percentage = inp.nextInt();
    	System.out.println("Mentor Name");
    	String Mentor_name = scStr.nextLine();
    	System.out.println("Mentor Department");
    	String Mentor_department = scStr.nextLine();
    	
    	
    	// inserting the query into the three tables
    	int count =0;
    	String query1 = "INSERT INTO studentsdetails ( id, Name , Department , Year, Gender) VALUES ("+id+" , '"+name+"', '"+Department+"', '"+year+"', '"+gender+"'); ";
    	String query2 = "INSERT INTO otherinfo ( id, skill , project , Percentage ) VALUES ( "+id+" , '"+skill+"', '"+project+"', "+percentage+") ;";
    	String query3 = "INSERT INTO mentorinfo ( id, mentorname , mentordept) VALUES ( "+id+" , '"+Mentor_name+"', '"+Mentor_department+"');";
    	
    	
    	// executing the query one by one
    	count = stmt.executeUpdate(query1);
    	int count1 = stmt.executeUpdate(query2);
    	int count2 = stmt.executeUpdate(query3);
    	
    	
    	System.out.println(" ------------------------");
    	System.out.println("|   "+count+" rows affected !!  |");
    	System.out.println(" ------------------------");
	
	}

}
