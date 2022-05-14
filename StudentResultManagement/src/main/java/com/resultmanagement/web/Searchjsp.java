package com.resultmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.admin.usermanagement.bean.User;
import com.usermanagement.auth.LoginuserBean;
@WebServlet("/Searchjsp")

public class Searchjsp extends HttpServlet {

       public void doGet(HttpServletRequest request, HttpServletResponse response)

                     throws ServletException, IOException {

              
    	      response.setContentType("text/html");

              PrintWriter out = response.getWriter();  
              
              // Session Management 
              HttpSession session = request.getSession();
              if(session.getAttribute("username")== null) {
            	  
          	  //response.sendRedirect("loginsuccess.jsp");
              
              }
              // Clearing Cache 
              response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
              response.setHeader("Pragma", "no-cache"); 
              response.setHeader("Expires", "0");
              
              // Session Management for getting specific user id info
              String name = (String) session.getAttribute("username");
              // Session Management for sending mail to the user email
              String password = (String) session.getAttribute("password");
             
              Connection con = null;

              try{

                     Class.forName("com.mysql.jdbc.Driver");
                      con=DriverManager.getConnection("jdbc:mysql://localhost:3307/userdb?useSSL=false","root","sanjay");               
                     
                     PreparedStatement ps=con.prepareStatement("select * from results where id = ?");

                     ps.setString(1,name);                   

                     
                     // executing the query   
                     ResultSet rs=ps.executeQuery(); 
                     // Storing list obj for view the specific user
                     List<User> list = new ArrayList<User>();
                     // Initialising an empty string for send mail Content
                     String s = "";
                     if (rs.next()) {
                         // Setting the details fetched from the database
                    	 User user = new User();
                         user.setId(rs.getInt("id"));
                         user.setName(rs.getString("name"));
                         user.setDepartment(rs.getString("department"));
                         user.setEmail(rs.getString("email"));
                         user.setMode(rs.getString("mode"));
                         user.setUniversity(rs.getString("university"));
                         user.setCgpa(rs.getString("cgpa"));
                         
                         // Writing Body of Content for the mail
                         s = "\nUser Id :" +rs.getInt(1)+"\n"
                         +"User Name :" + rs.getString(2)+"\n"
                         +"Department: "+ rs.getString(3)+"\n"
                         +"Email: "+rs.getString(4)+"\n"
                         +"Mode: "+rs.getString(5)+"\n"
                        +"University: "+rs.getString(6)+"\n"
                        +"CGPA "+rs.getString(7)+"\n";
                         // adding the details of the user into a list
                         list.add(user);

                     }
                     // Maintaining session for the user login
                     request.setAttribute("list",list);
                     request.setAttribute("password", password);
                     request.setAttribute("mesg", s);
                    
                     RequestDispatcher rd= request.getRequestDispatcher("demo.jsp");
                     rd.forward(request, response);
 

              }
              
              catch (Exception e2)

                {

                    e2.printStackTrace();

                }
                finally{
            	  out.close();
                  try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}                  
                }

       }

 

} 
