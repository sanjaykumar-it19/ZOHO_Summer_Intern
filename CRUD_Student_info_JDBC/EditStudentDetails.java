package ExtendedDb;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Statement;
public class EditStudentDetails extends Methods{

	EditStudentDetails(Statement stmt)
	{   int count1 = 0;
		System.out.println("***********************");
        System.out.println("1.Edit all");
    	System.out.println("2.Edit id");
    	System.out.println("3.Edit name");
    	System.out.println("4.Edit Department");
    	System.out.println("5.Edit Year");
    	System.out.println("6.Edit Gender");
    	System.out.println("7.Edit skill");
    	System.out.println("8.Edit project");
    	System.out.println("9.Edit percentage");
    	System.out.println("10.Edit Mentor Name");
    	System.out.println("11.Edit Mentor Department");
    	
    	
    	System.out.println("***********************");
           int editChoice = scint.nextInt();
            switch(editChoice)
            {
            
            case 1:
            {   System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
            	System.out.println("user id");
            	int new_id = scint.nextInt();
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
            	count1 =0;
            	int count2,count3 =0;
            	String query1 = "UPDATE studentsdetails  SET id="+new_id+", name = '"+name +"', Department= '"+Department+"',Year = '"+year+"',gender ='"+gender+"' WHERE id = "+id+";";
            	String query2 = "UPDATE otherinfo SET id="+new_id+", skill ='"+skill+"',project ='"+project+"',percentage ='"+percentage+"' WHERE id ="+id+";";
            	String query3 = "UPDATE mentorinfo SET id="+new_id+", mentorname ='"+Mentor_name+"',mentordept ='"+Mentor_department+"' WHERE id = "+id+";";
            	               
            	try {
    				count1 = stmt.executeUpdate(query1);
    				count2 = stmt.executeUpdate(query2);
    				count3 = stmt.executeUpdate(query3);
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	
            	
            	break;
            }
            case 2:
            {   System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
        	    System.out.println("new user id");
        	    int new_id = scint.nextInt();
        	    count1 =0;
        		int count2,count3 =0;
            	String query1 = "UPDATE studentsdetails  SET id="+new_id+" WHERE id = "+id+";";
            	String query2 = "UPDATE otherinfo SET id="+new_id+" WHERE id ="+id+";";
            	String query3 = "UPDATE mentorinfo SET id="+new_id+" WHERE id = "+id+";";
            	               
            	               
            	try {
    				count1 = stmt.executeUpdate(query1);
    				count2 = stmt.executeUpdate(query2);
    				count3 = stmt.executeUpdate(query3);
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	
            	
            	break;
            }
            case 3:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
        	    System.out.println(" user name");
            	String name = scStr.nextLine();
        	    count1 =0;
        		int count2,count3 =0;
            	String query1 = "UPDATE studentsdetails  SET name="+name+" WHERE id = "+id+";";                      
            	try {
    				count1 = stmt.executeUpdate(query1);
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 4:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Department");
            	String Department = scStr.nextLine();
        	    count1 =0;
        		
            	String query1 = "UPDATE studentsdetails  SET Department='"+Department+"' WHERE id = "+id+";";                      
            	try {
    				count1 = stmt.executeUpdate(query1);
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 5:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Year");
            	int year = scint.nextInt();
        	    count1 =0;
        	
            	String query1 = "UPDATE studentsdetails  SET Year="+year+" WHERE id = "+id+";";
            
            	               
            	               
            	try {
    				count1 = stmt.executeUpdate(query1);
    			
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 6:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Gender");
            	String gender = scStr.nextLine();
        	    count1 =0;
            	String query1 = "UPDATE studentsdetails  SET gender='"+gender+"' WHERE id = "+id+";";
            	
            	               
            	               
            	try {
    				count1 = stmt.executeUpdate(query1);
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 7:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Skill");
            	String skill = scStr.nextLine();
        	    count1 =0;
        		
            	
            	String query2 = "UPDATE otherinfo SET skill='"+skill+"' WHERE id ="+id+";";
            	
            	               
            	               
            	try {
    				
    				count1 = stmt.executeUpdate(query2);
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 8:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Project");
            	String project = scStr.nextLine();
        	    count1 =0;
        		
            	
            	String query2 = "UPDATE otherinfo SET project='"+project+"' WHERE id ="+id+";";
            	
            	               
            	               
            	try {
    				count1 = stmt.executeUpdate(query2);
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 9:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Percentage");
            	int percentage = inp.nextInt();
        	    count1 =0;
        		
            	
            	String query2 = "UPDATE otherinfo SET percentage="+percentage+" WHERE id ="+id+";";
            	
            	               
            	try {
    				count1 = stmt.executeUpdate(query2);
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 10:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Mentor Name");
            	String Mentor_name = scStr.nextLine();
        	    count1 =0;
        		
            	
            	String query3 = "UPDATE mentorinfo SET mentorname='"+Mentor_name+"' WHERE id = "+id+";";
            	               
            	               
            	try {
    				count1 = stmt.executeUpdate(query3);
    			
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            case 11:
            {
            	System.out.println("Enter the user row you need to edit");
                int id = scint.nextInt();
                System.out.println("Mentor Department");
            	String Mentor_department = scStr.nextLine();
        	    count1 =0;
        		
            	
            	String query3 = "UPDATE mentorinfo SET mentordept='"+Mentor_department+"'WHERE id = "+id+";";
            	               
            	               
            	try {
    				count1 = stmt.executeUpdate(query3);
    			
    				
    			} catch (SQLException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	break;
            }
            
            
            
            }
            System.out.println(" ------------------------");
        	System.out.println("|   "+count1+" rows affected !!  |");
        	System.out.println(" ------------------------");
            
            
            }
	}

