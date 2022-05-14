package com.usermanagement.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// login filter
@WebFilter("/login")
public class logincheck extends HttpServlet implements Filter {
   
    public logincheck() {
        super();
       
    }

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String id = (String)req.getParameter("username");
		session.setAttribute("id1", id);
	     
		if(id == null)
			res.sendRedirect("loginsuccess.jsp");

		else {
			
		    
		  
		        System.out.println("In filter");
		       chain.doFilter(req, res);
		
		

		

		} 
	

	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
