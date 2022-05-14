<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<head>

</head>
<title>Student Log In</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div align = "center">
		
				<a href="#" class="navbar-brand" >&emsp;&emsp; Student Log In </a>
			
			</div>
		</nav>
		
	
	<div class = "container mt-5">
		<div class = "row">
		<div class = "col-sm-6">
		<img src="https://preview.colorlib.com/theme/bootstrap/login-form-07/images/undraw_remotely_2j6y.svg"
          alt="Sample image" height = "400px" width = "700px">
		</div>
	<br>
	<div class = "col-sm-6">
		<div class = "container">
			<div class = "container">
				
					<form action="<%=request.getContextPath()%>/Userlogin" method="post">
			<br>  <br>  <br>  <br>  <br>  
			  
				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${loginuserBean.username}' />" class="form-control"
						name="username" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>password</label> <input type="password"
						value="<c:out value='${loginuserBean.password}' />" class="form-control"
						name="password">
				</fieldset>

				<br>
				<button type="submit" class="btn btn-success">Login</button>
				</form>
			</div>
		</div>
		</div>
		</div>
	</div>
</body>
</html>