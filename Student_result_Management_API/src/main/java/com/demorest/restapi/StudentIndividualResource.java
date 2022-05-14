package com.demorest.restapi;
import java.sql.SQLException;




import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
//Root resource
@Path("results")
public class StudentIndividualResource extends SecurityUserFilter{
	
	//creating a student repository
	StudentRepository repo = new StudentRepository();
	
	
	// Getting a individual student details by id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	
	public Response getStudentbyID(@PathParam("id")int id) throws ClassNotFoundException, SQLException
	{ 
		
		System.out.println("In Student individual class...");
        
		if(repo.getStudent(id).getId() == 0 || repo.getStudent(id).getId() != ls.get(0) ) {
	     
		 System.out.println("Id doesnt exits");
	     System.out.println("In view"+ls);
	     ls.clear();
	     
	     System.out.println("In view"+ls);
	     
	     return Response.status(Response.Status.NOT_FOUND).entity("Not Authorised to view id:" + id).build();
		
        }
        
		
		 Student json = repo.getStudent(id);
				    return Response.ok(json, MediaType.APPLICATION_JSON).build();
			
		
		
	}
	
	
	// student details edit path
	@Path("edit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	
	
	public Response updateStudent(Student s1) throws ClassNotFoundException, SQLException
	{   
		
		
		System.out.println(s1);
		
		
	
		
		//if the id is there then will update
		if (repo.getStudent(s1.getId()).getId() == ls.get(0)){
	    System.out.println("In edit"+ls); 
		
	    repo.updatestd(s1);
		ls.clear();
		System.out.println("In edit"+ls);
		 Student json = repo.getStudent(s1.getId());
		 return Response.ok(json, MediaType.APPLICATION_JSON).build();		}
		
		
		return Response.status(Response.Status.NOT_FOUND).entity("Not Authorised to edit ").build();
	}
	
}
