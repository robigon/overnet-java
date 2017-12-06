<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<c:set value='${pageContext.request.contextPath}' var="path"></c:set>
<nav class="navbar navbar-inverse navbar-fixed-top">

	
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Opengest</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
			
                <form>
					<ul class="nav navbar-nav">
						<li class="active"><a href="dashboard">Home</a></li>
						<li><a href="${path}/users">Gestione Utenti</a></li>
						<li><a href="${path}/customers">Gestione Clienti</a></li>
						<li><a href="${path}/warehouse">Magazzino</a></li>
					</ul>
				</form>
            
				<form class="navbar-form navbar-right">
					<div class="form-group">
							<p>
								<span style="color: white;">Benvenuto
									${loggedUser.username} </span>
								<a href="logout" >Logout</a>
							</p>
					</div>

				</form>

			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>