package com.usermanagement.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermanagement.auth.*;

// login page servlet

@WebServlet("/login")
public class LoginadminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;
    private LoginUserDao loginuserDao;

    public void init() {
        loginDao = new LoginDao();
        loginuserDao = new LoginUserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Getting username and password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        LoginuserBean loginuserBean = new LoginuserBean();
        loginuserBean.setUsername(username);
        loginuserBean.setPassword(password);
        PrintWriter out = response.getWriter();
        
        try 
        {
          // validating the username and mail id as password
        	if (loginDao.validate(loginBean)) {
                HttpSession session = request.getSession();
                 session.setAttribute("username",username);
                 response.sendRedirect("user-list.jsp");
                // redirecting to user page
            }
        	
        	
               
        		
        	else if(loginuserDao.validate(loginuserBean)) {
        		HttpSession session = request.getSession();
                session.setAttribute("username",username);
                session.setAttribute("password",password);
            	// session management using username and password
            	response.sendRedirect("Searchjsp");

        	}
                
           
           
        	
        } 
        catch (ClassNotFoundException e)
        {
            
        	e.printStackTrace();
        }
        catch (SQLException e) {
			
        	
			e.printStackTrace();
		
        }
    }
}