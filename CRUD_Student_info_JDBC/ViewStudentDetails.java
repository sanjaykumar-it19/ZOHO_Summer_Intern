package ExtendedDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ViewStudentDetails extends Methods {

	//Statement stmt;

	ViewStudentDetails(Statement stmt) throws SQLException
	{
		//this.stmt = stmt;
		System.out.println("***********************");
        System.out.println("1.view all");
	    System.out.println("2.view by id");
	 
	
	System.out.println("***********************");
    	int selectChoice = scint.nextInt();
        if(selectChoice == 1) {
        	System.out.println("Enter the type of query for the table to view");
        	
        	//switch(queryChoice) {
        	
        	//}
        	
        	String s = "select * from studentsdetails" ;
            ResultSet rs=stmt.executeQuery(s);
        
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
        	
        }
        else if(selectChoice ==2)
        {
     System.out.println("Enter the id for the table to view");
        	int id = scint.nextInt();
        	String s = "select * from studentsdetails where id="+id+";";
            ResultSet rs=stmt.executeQuery(s);
        
            rs.next();
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
        }
  
    	
	}
	
}
