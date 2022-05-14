package com.resultmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.usermanagement.dao.UserDao;

import com.admin.usermanagement.bean.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserDao userDAO;
	
	public void init() {
		userDAO = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		//HttpSession session = request.getSession();
		//if(session.getAttribute("username")== null)
			//response.sendRedirect("loginsuccess.jsp");
		//else
		
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/editview":
				showEditFormview(request, response);
				break;
				// view particular user
			case "/updateviewUser":
				updateviewUser(request, response);
				break;	
				
			// displaying the user list by default
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
    
	
	
	// default will list all the users in the database
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	
	
	}
	
	
    // Showing new form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	
	}

	
	// Edit the details
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
		
		
	}
	// user edit view option
	private void showEditFormview(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("vieweditdept.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
		
		
	}

	// Insert the New User Details
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String mode= request.getParameter("mode");
		String university  = request.getParameter("university");
		String cgpa = request.getParameter("cgpa");
		
		
		User newUser = new User(name, department,email , mode , university , cgpa);
		userDAO.insertUser(newUser);
		response.sendRedirect("list");
		
		
	}

	
	// Updating the details 
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String mode= request.getParameter("mode");
		String university  = request.getParameter("university");
		String cgpa = request.getParameter("cgpa");

		
		User details = new User(id, name, department ,email, mode , university , cgpa);
		userDAO.updateUser(details);
		response.sendRedirect("list");
		
	}
	
	private void updateviewUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String email = request.getParameter("email");
		String mode= request.getParameter("mode");
		String university  = request.getParameter("university");
		String cgpa = request.getParameter("cgpa");

		
		User details = new User(id, name, department ,email, mode , university , cgpa);
		userDAO.updateUser(details);
		response.sendRedirect("Searchjsp");
		
	}
	
	// Deleting the details of the user
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		
		response.sendRedirect("list");

	}
	
	



}