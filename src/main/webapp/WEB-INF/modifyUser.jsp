<%@page import="beans.Utilisateur"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	Utilisateur user = (Utilisateur) request.getAttribute("user"); 
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modification</title>
	<link href="<c:url value='/ressources/bootstrap.min.css'/> " rel="stylesheet">
	
</head>
<body>
	<%@include file='/WEB-INF/menu.jsp' %>
	<div class="container">
		<div class="d-flex justify-content-center">
			<div class="shadow p-5 mt-5 bg-white rounded w-50">
				<h1>Modification...</h1>
				<c:choose>
					<c:when test="${user == null }">
						<p>Cet utilisateur n'existe pas.</p>
					</c:when>
					<c:otherwise>
					
						<form method="post" class="mt-5">
							<input type="text" style="display:none;" value="${user.id }" name="id" id="id"/>
						
						  <div class="form-group my-3">
						  	<label for="prenom">Prenom : </label>
							<input type="text" value="${ user.prenom }" class="form-control" name="prenom" id="prenom"/>
						  	<span class='d-inline mt-2 mb-5 text-danger'>${erreurs.prenom }</span>
						  </div>
						  
						  <div class="form-group my-3">
						    <label for="nom">Nom: </label>
							<input type="text" value="${user.nom }" class="form-control" name="nom" id="nom"/>
							<span class='d-inline mt-2 mb-5 text-danger'>${erreurs.nom }</span>
						  </div>
						  
				  		  <div class="form-group my-3">
						    <label for="username"> Username: </label>
							<input type="text" value="${ user.username }" class="form-control" name="username" id="username"/>
						  	<span class='d-inline mt-2 mb-5 text-danger'>${erreurs.username }</span>
						  </div>
						  
						  <div class="form-group my-3">
						    <label for="password">Password:</label>
						    <input type="text" value="${ user.password }" class="form-control" name="password" id="password">
						  	<span class='d-inline mt-2 mb-5 text-danger'>${erreurs.password }</span>
						  </div>
						  
						  <button type="submit" class="btn btn-primary">VALIDER</button>
						  
						</form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>

</body>
</html>