<%@page import="beans.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link href="<c:url value='/ressources/bootstrap.min.css'/> " rel="stylesheet">
</head>
<body>
	<%@include file='/WEB-INF/menu.jsp' %>
	<div class="container">
	
		<div class="d-flex justify-content-center">
			<div class="shadow p-5 mt-5 bg-white rounded w-50" >
				<h1>Login ... </h1>
					<form method="post" class="mt-5">
					
			  		  <div class="form-group my-3">
					    <label for="username"> Username: </label>
						<input type="text" class="form-control" name="username" id="username"/>
					  </div>
					  
					  <div class="form-group my-3">
					    <label for="password">Password:</label>
					    <input type="password" class="form-control" name="password" id="password">
					  </div>
					  
					  <button type="submit" class="my-3 btn btn-primary">VALIDER</button>
					  
					</form>
				<p class="text-danger">${status }</p>
			</div>
		</div>
		
		
	</div>
</body>
</html>