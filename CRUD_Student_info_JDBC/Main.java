package ExtendedDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Main  {
	
	public static void main(String [] args)
	
	{ 
		
		
		
	try{
		
		
		// establishing connection  
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3307/task?characterEncoding=latin1","root","sanjay");
        
        
        Statement stmt=con.createStatement();
        Scanner scint = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        
        
        do {
        	
        	System.out.println("***********************");
        	System.out.println("New");
            System.out.println("1.View all User");
        	System.out.println("2.Insert the User");
        	System.out.println("3.Update the User");
        	System.out.println("4.Delete the User");
        	System.out.println("0.Terminate the program");
        	System.out.println("***********************");
            
        	int userChoice = scint.nextInt();
            
        	if(userChoice == 1)
            {  
              
            	try {
            		// view the student details
                	new OverviewStudent(stmt);
                	}
                	catch (Exception e) {
    					System.out.println("Record not found!!");
    				}
               
               
            }
            
        	
            else if(userChoice == 2)
            {   
            	
            	
            	try {
            		// insert the student details
            	new InsertStudentdetails(stmt);
            	}
            	
            	catch (Exception e) {
            		System.out.println("Please Check the id the given id is already exists!!");
				}
            
            }
        	
        	
            else if(userChoice == 3)
            {   
            	
            	try {
            		// Calling edit student details
            	new EditStudentDetails(stmt);
            	}
            	
            	
            	catch (Exception e) {
            		System.out.println("The given Id Number is Not found");
				}
            }
        	
        	
            else if(userChoice == 4)
            {   
            	try {
            		// calling delete student details
            	new DeleteStudentDetails(stmt);
            	}
            	
            	catch (Exception e) {
            		System.out.println("Record not found!!");
				}
           
            }
        	
        	
            else if(userChoice == 0)
            {  // terminate the database connectivity
            	
            	System.out.println("Database Connection Disconnected Successfully!!");
            	con.close();
            	System.exit(0);
            
            }
        	
        	
        }
        
        while(true);
        
        
        
        
	}
	
	
	catch(Exception e){ System.out.println(e);}
	
	
	}
	
}
