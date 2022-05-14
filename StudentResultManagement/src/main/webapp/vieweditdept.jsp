

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Result Dashboard  Management</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<% 

if(session.getAttribute("username")== null)
	response.sendRedirect("loginsuccess.jsp");
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies.y
%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="#" class="navbar-brand"> Result Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/Searchjsp"
					class="nav-link">Users</a></li>
			
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="updateviewUser" method="post">
				</c:if>
				
                 
				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Department</label> <input type="text"
						value="<c:out value='${user.department}' />" class="form-control"
						name="department">
				</fieldset>
				<fieldset class="form-group">
					 <input type="hidden"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>User Mode</label> <input type="text"
						value="<c:out value='${user.mode}' />" class="form-control"
						name="mode">
				</fieldset>
				<fieldset class="form-group">
					<label>User University</label> <input type="text"
						value="<c:out value='${user.university}' />" class="form-control"
						name="university">
				</fieldset>
                <fieldset class="form-group">
					<input type="hidden"
						value="<c:out value='${user.cgpa}' />" class="form-control"
						name="cgpa">
				</fieldset>
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>