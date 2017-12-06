<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set value='${pageContext.request.contextPath}' var="path"></c:set>

<br/>
<br/>
<br/>
<div class="container">
	<h2>Modifica utente: ${userDetail.username}</h2>
	<p></p>

	<br /> <br />
	<div class="table-responsive">
	
		<div><span style="color:red"><p>${message }</p></span></div>
		<form id="detailForm" action="${path}/userUpdate" method="post">
			<input type=hidden name="userId"
				value='${userDetail.idUtente}' />
			<div>
				<label for="name">Nome</label>
				<input type="text" id="name" name="name"
					value='${userDetail.nome}' />
			</div>
			<div>
				<label for="lastname">Cognome</label> <input
					type="text" id="lastname" name="lastName"
					value='${userDetail.cognome}'/>
				</div>
				<div>
							<label for="username">Username</label>
							<input type="text" id="username" name="username" value='${userDetail.username}' />
						</div>
				<div>
							<label for="password">Password</label>
							<input type="password" id="password" name="password" value='${userDetail.password}'/>
						</div>
				<div>
							<input type="submit" value="Salva"/>
						</div>
		</form>
	</div>
<br></br>
</div>
