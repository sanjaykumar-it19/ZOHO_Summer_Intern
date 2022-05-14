<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<body>

<% 
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies.

if(session.getAttribute("username")== null)
	response.sendRedirect("login.jsp");
String password = (String)request.getAttribute("password");
String mesg = (String)request.getAttribute("mesg");
%>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: green">
			<div align = "center">
		
				<a href="#" class="navbar-brand" >Welcome!! Find Your Results!!</a>
			
			</div>
		</nav>
		<div class = "row">
		
		</div>
	</header>
</body>
<div class="container">
<br>
<br>
			<h3 class="text-center">User Info</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/logoutuser" class="btn btn-success">log out</a>
			</div>
			<div class="container text-right">
                <%session.setAttribute("email1",password); %>
                <%session.setAttribute("mesg",mesg); %>
				<a href="<%=request.getContextPath()%>/SendEmail" class="btn btn-success">mail me</a>
				
			</div>
<center>
 <table class="table table-bordered">
 <br>
 <br>
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Department</th>
						<th>Email</th>
						<th>Mode</th>
						<th>University</th>
						<th>CGPA</th>
						<th>Actions</th>
						
					</tr>
				</thead>
<tbody>
        <c:forEach items="${list}" var="record">
            <tr>
                <td>${record.id }</td>
                <td>${record.name }</td>
                 <td>${record.department }</td>
                <td>${record.email }</td>
                <td>${record.mode }</td>
                <td>${record.university}</td>
                <td>${record.cgpa }</td>
                <td><a href="editview?id=<c:out value='${record.id}' />">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
   </center>