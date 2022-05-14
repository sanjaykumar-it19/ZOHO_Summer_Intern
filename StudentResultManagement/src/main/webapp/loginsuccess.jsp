

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<head>

 

</head>
<title>Admin Log In</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
		
				<a href="loginsuccess.jsp" class="navbar-brand" style = "text-align:center">&emsp;&emsp;Log In </a>
			
			</div>
			
		</nav>
		<div class = "container mt-5">
		<div class = "row">
		<div class = "col-sm-6">
		<img src="https://media.istockphoto.com/vectors/system-administrator-concept-vector-id1289687310?b=1&k=20&m=1289687310&s=612x612&w=0&h=bfUa5aFvnkf0AIvGQCd9lT1eGU0UHHbsMgDoUp5xiLk="
          alt="Sample image" height = "400px" width = "700px">
		</div>
		
	
	<br>
	<div class="col-sm-6">
		<div class = "container">
			<div class = "container">
					<form action="<%=request.getContextPath()%>/login" method="post">
			  <br>  <br>  <br>  <br>  <br>  
				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${loginBean.username}' />" class="form-control"
						name="username" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>password</label> <input type="password"
						value="<c:out value='${loginBean.password}' />" class="form-control"
						name="password">
				</fieldset>
  <br>
  		
				<button type="submit" class="btn btn-success">Login</button>
				</form>
				<div >
		
				
			
			</div>
			</div>
			</div>	</div>	
		</div>
	</div>
</body>
</html>