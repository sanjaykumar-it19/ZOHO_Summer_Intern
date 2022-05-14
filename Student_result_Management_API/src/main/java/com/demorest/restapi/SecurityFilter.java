package com.demorest.restapi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

@Provider

public class SecurityFilter implements ContainerRequestFilter {
	
	//declaring variable for security implementations
	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic ";
	private static final String SECURED_URL_PREFIX = "students";
	private String username,password,samplecheck;
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
		
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		
		if(authHeader != null &&authHeader.size()>0)
		{
			
			
		String authToken = authHeader.get(0);
		
		authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX,"");
		authToken = authToken.trim();
		
		byte[] valueDecoded = Base64.decodeBase64(authToken);
		
		String decodedString = new String(valueDecoded, StandardCharsets.UTF_8);
		
		samplecheck = "";
		for(int i =0;i<decodedString.length();i++)
		{
			if(decodedString.charAt(i)!= ':')
			{
				samplecheck = samplecheck + decodedString.charAt(i);
			}
			else
			{
				break;
			}
		}
		
		StringTokenizer tokenizer = new StringTokenizer(decodedString,":");
		if(samplecheck == "")		
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
		
		 Admin loginBean = new Admin();
		 loginBean.setUsername(username);
		 loginBean.setPassword(password);
		
		 try {
			 
			 
			if(AdminRepository.validate(loginBean))
			{
				
				return;
			
			}
		} 
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		
			 e.printStackTrace();
			 
		}
		}
if(username == null || password == null)
			
		{   if(username == null && password != null) {
			 Response create = Response.serverError().entity("Admin id cannot be blank").build();
			 requestContext.abortWith(create);
		}
		else if(username !=null && password == null)
		{
			Response responsepswd = Response.serverError().entity("Password cannot be blank").build();
			 requestContext.abortWith(responsepswd);
		}
		else {
			Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
					.entity("User cannot access the resource")
					.build();
			
			requestContext.abortWith(unauthorizedStatus);
			
		}
			
		}
      else {
		Response unauthorizedStatus = Response.status(Response.Status.UNAUTHORIZED)
				.entity("User cannot access the resource")
				.build();
		
		requestContext.abortWith(unauthorizedStatus);
		
	}}
	}
}
