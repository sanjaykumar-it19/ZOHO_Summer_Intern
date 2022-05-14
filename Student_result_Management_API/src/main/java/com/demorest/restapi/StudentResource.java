package com.demorest.restapi;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
// students root path
@Path("students")
public class StudentResource {
	//student repository obj
    StudentRepository repo = new StudentRepository();
	
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent() throws ClassNotFoundException, SQLException
	{  
		System.out.println("Student class...");
        
	
		return repo.getStudents();
		
		
	}
	
    // view resource
    
    @GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentbyID(@PathParam("id")int id) throws ClassNotFoundException, SQLException
	{  
		System.out.println("Student class...");
        if(repo.getStudent(id).getId() ==0) {
        	return Response.status(Response.Status.NOT_FOUND).entity("Id doesn't exists ").build();
		
        }
        Student json = repo.getStudent(id);
	    return Response.ok(json, MediaType.APPLICATION_JSON).build();
			
		
		
	}
	
    // create resource
    
    @Path("studentcreate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public Response createStudent(Student s1) throws ClassNotFoundException, SQLException
	{   
		System.out.println(s1);
		int id = s1.getId();
	
		if(id != repo.getStudent(id).getId()) {
			 repo.createStudent(s1);
			 Student json = repo.getStudent(s1.getId());
			 return Response.ok(json, MediaType.APPLICATION_JSON).build();
		}
		return Response.status(Response.Status.BAD_REQUEST).entity("User Key already found ").build();
		
		
		
		
	}
    
    //edit resource
	@Path("studentedit")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public Student updateStudent(Student s1) throws ClassNotFoundException, SQLException
	{   
		System.out.println(s1);
		if(repo.getStudent(s1.getId()).getId() == 0)
		{
			repo.createStudent(s1);
		
		}
		else {
		 repo.update(s1);
		}
		 return s1;
		
	}
	
	//delete id
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@DELETE
	public Response deleteStudent(@PathParam("id")int id) throws ClassNotFoundException, SQLException
	{
     System.out.println("Delete called");
     System.out.println(id);
		Student std = repo.getStudent(id);
		if(std.getId()!=0)
		{
			repo.delete(id);
		}
		else
		{
			return Response.status(Response.Status.NOT_FOUND).entity("Id doesn't exists ").build();
		}
		
		 Student json = std;
		 return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	

}
