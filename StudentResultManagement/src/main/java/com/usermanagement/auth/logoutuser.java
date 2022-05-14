package com.usermanagement.auth;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutuser")
public class logoutuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	// doGet() method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the print writer object to write into the response
		PrintWriter out = response.getWriter();

		// Set the content type of response to "text/html"
		response.setContentType("text/html");
		HttpSession session = request.getSession();
        session.removeAttribute("username");
        
		// For understanding purpose, print the session object in the console before
		// invalidating the session.
		System.out.println("Session before invalidate: "+ request.getSession(false));

		// Invalidate the session.
		request.getSession(false).invalidate();

		// Print the session object in the console after invalidating the session.
		System.out.println("Session after invalidate: "+ request.getSession(false));

		// Print success message to the user and close the print writer object.
		out.println("Thank you! You are successfully logged out.");
		
		response.sendRedirect("loginsuccess.jsp");
		out.close();
		
	}

}
