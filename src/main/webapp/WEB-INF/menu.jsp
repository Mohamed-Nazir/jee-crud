<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<nav class="shadow rounded mb-5 navbar navbar-expand-sm bg-light navbar-light justify-content-between">
	<div class="container">
	  	<ul class="navbar-nav">
		    <li class="nav-item mx-3">
		      <a class="nav-link" href="<c:url value='/Liste' />">Lister</a>
		    </li>
		    <li class="nav-item ml-3">
		      <a class="nav-link" href="<c:url value='/AddUser'/> " >Ajouter</a>
		    </li>
	  	</ul>
	  	<ul class="navbar-nav">
		  	<c:choose>
		  		<c:when test="${sessionScope.isConnected != null}">
		  			<li class="nav-item">
				      <a class="btn btn-danger text-light p-2 nav-link" href="<c:url value='/Logout' /> ">Se Déconnecter</a>
				    </li>
		  		</c:when>
		  		<c:otherwise>
		  			<li class="nav-item">
			      		<a class="btn btn-primary text-light p-2 nav-link" href="<c:url value='/Auth' /> ">Se Connecter</a>
				    </li>
		  		</c:otherwise>
		  	</c:choose>
	  	</ul>
	  </div>  
</nav>