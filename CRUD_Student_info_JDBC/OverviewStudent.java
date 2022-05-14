package ExtendedDb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class OverviewStudent extends Methods {



	OverviewStudent(Statement stmt) throws SQLException
	{
		
		System.out.println("***********************");
        System.out.println("1.view all");
	    System.out.println("2.view by id");
	 
	
	System.out.println("******************************************************************************************************************************************");
    	int selectChoice = scint.nextInt();
        if(selectChoice == 1) {
        	
        	
        	
        	
        	String s = "SELECT * FROM studentsdetails s natural join otherinfo o natural join mentorinfo m;" ;
            ResultSet rs=stmt.executeQuery(s);
            System.out.println("         ID"
                    + "             Name  "
                    + "      Department  "
                    + " Year  "
                    + "  Gender  "
                    + "  Skill  "
                    + "         Project  "
                    + "    Percentage     "
                  
                    + " Mentor Name  "
                    + "       Mentor department  ");
            while(rs.next())
            	
            {
            	int id = rs.getInt("id");
                String name = rs.getString("Name");
                String Department = rs.getString("Department");
                String year
                    = rs.getString("Year");
                String gender = rs.getString("gender");
                String skill = rs.getString("skill");
                String project = rs.getString("project");
                int percentage = rs.getInt("percentage");
                String mentorname = rs.getString("mentorname");
                String mentordept = rs.getString("mentordept");
                System.out.format(
                        "%10d %20s%10s%10s%10s%10s%20s%10d%20s%30s\n", id,
                      name,Department, year, gender,skill,project,percentage,mentorname,mentordept);
                }
            }
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5));
        	
        

        else if(selectChoice ==2)
        {
     System.out.println("Enter the id for the table to view");
        	int id = scint.nextInt();
        	String s = "SELECT * FROM studentsdetails s natural join otherinfo o natural join mentorinfo m  where s.id = "+id+";";
        	ResultSet rs=stmt.executeQuery(s);
            System.out.println("         ID"
                    + "             Name  "
                    + "      Department  "
                    + " Year  "
                    + "  Gender  "
                    + "  Skill  "
                    + "         Project  "
                    + "    Percentage     "
                  
                    + " Mentor Name  "
                    + "       Mentor department  ");
        
            rs.next();
            int stdid = rs.getInt("id");
            String name = rs.getString("Name");
            String Department = rs.getString("Department");
            String year
                = rs.getString("Year");
            String gender = rs.getString("gender");
            String skill = rs.getString("skill");
            String project = rs.getString("project");
            int percentage = rs.getInt("percentage");
            String mentorname = rs.getString("mentorname");
            String mentordept = rs.getString("mentordept");
            System.out.format(
                    "%10d %20s%10s%10s%10s%10s%20s%10d%20s%30s\n", stdid,
                  name,Department, year, gender,skill,project,percentage,mentorname,mentordept);
        }
  
    	
	}
	
}
