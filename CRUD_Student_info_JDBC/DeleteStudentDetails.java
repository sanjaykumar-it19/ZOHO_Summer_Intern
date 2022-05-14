package ExtendedDb;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteStudentDetails extends Methods{
// deleting the details of the student

	DeleteStudentDetails(Statement stmt)
	{
    	System.out.println("Enter the remove query for the table ");
    	System.out.println("user id");
    	// remove the required id
    	int id = scint.nextInt();
    	
    	int count =0;
    	
    	// executing the delete query one by one
    	
    	String s1 = "DELETE FROM studentsdetails where id ="+id+";";
    	String s2 = "DELETE FROM otherinfo where id ="+id+";";
    	String s3 = "DELETE FROM mentorinfo where id ="+id+";";
    	
    	String query = s1;
    	String query1 = s2;
    	String query2 = s3;
    	
                
    	try {
    		
    		
			count = stmt.executeUpdate(query);
			int count1 = stmt.executeUpdate(query1);
			int count2 = stmt.executeUpdate(query2);
		
    	
    	} 
    	
    	catch (SQLException e) {
    		
    		
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
    	
    	
    	System.out.println(" ------------------------");
    	System.out.println("|   "+count+" rows affected !!  |");
    	System.out.println(" ------------------------");
    	
    	
    		
	}
}
