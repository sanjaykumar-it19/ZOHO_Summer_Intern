package com.demorest.restapi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
//Login Filter for User api
//for providing user implementation
@Provider
public class SecurityUserFilter implements ContainerRequestFilter {
	
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "results";
	private String username,password,scheck;
	//handles user name for authorized access
	
	public static List<Integer> ls = new ArrayList<>();
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
		
			List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		// contains authorized header information
		if(authHeader != null &&authHeader.size()>0)
		{
			
		String authToken = authHeader.get(0);
		
		
		authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
		// replaces the header prefix with empty string
		
		authToken = authToken.trim();
		
		// decoding the information in the string
		byte[] valueDecoded = Base64.decodeBase64(authToken);
		String decodedString = new String(valueDecoded, StandardCharsets.UTF_8);
		 
		scheck = "";
			for(int i =0;i<decodedString.length();i++)
			{
				if(decodedString.charAt(i)!= ':')
				{
					scheck = scheck + decodedString.charAt(i);
				}
				else
				{
					break;
				}
			}
			StringTokenizer tokenizer = new StringTokenizer(decodedString,":");
			//if username is null the we assigning to null
			if(scheck == "")		
			{
				username = null;
				System.out.println("In if Username: "+ username);
				
				password = tokenizer.nextToken();
				System.out.println("In if password: "+ password);
			}
			
			else {		
				username = tokenizer.nextToken();
				System.out.println("In else Username: "+ username);
				if(tokenizer.hasMoreTokens())
				password = tokenizer.nextToken();
				else
				password = null;
				System.out.println("In else password: "+ password);
				}
			int id;
			try {
				if(username!= null) {
					// parsing the string value to integer
					id = Integer.parseInt(username);
					
					ls.clear();
					ls.add(id);
					}
			} catch (NumberFormatException e) {
				 Response numberformat = Response.serverError().entity("Only Interger type is allowed").build();
				 requestContext.abortWith(numberformat);
			}
	
		
		// adding id to list
		
		Admin loginBean = new Admin();
		 loginBean.setUsername(username);
		 loginBean.setPassword(password);
		
		 
		 try {
			
			 
			 //Validation of user name and password with database
			if(UserRepository.validate(loginBean))
			{
				
				return;
			}
			
		} 
		 
		 catch (ClassNotFoundException | SQLException e) {
			
			
			 e.printStackTrace();
		
		 }
		
		}
		if(username == null || password == null)
			
		{   if(username == null && password !=null) {
			// Giving back a response of username blank
			Response create = Response.serverError().entity("User id cannot be blank").build();
			 requestContext.abortWith(create);
		}
		else if(username !=null && password == null)
		{    // Giving back a response of password blank
			Response check = Response.serverError().entity("Passsword cannot be blank").build();
			 requestContext.abortWith(check);
		}
		else {
			
			// Giving back a response of unauthourised access
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource")
					.build();
			
			requestContext.abortWith(unauthorizedStatus);
			}
			
		}
		else {
		
		// Giving back a response of unauthourised access
		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
				.entity("User cannot access the resource")
				.build();
		
		requestContext.abortWith(unauthorizedStatus);
		}
	}
	}
}
