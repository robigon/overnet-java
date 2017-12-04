<%@page import="it.webapp.model.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		UserDto user = (UserDto) session.getAttribute("loggedUser");
		String username = user.getUsername();
	%>

	<p>
		Benvenuto
		<%= username %>&nbsp; <a href="logout">logout</a>
	</p>
	<br />

	<div>
		<a href="loadUsers">Elenco utenti</a>
	</div>
	<div>
		<a href="loadProductList">Elenco prodotti</a>
	</div>
	<div>
		<a>Elenco clienti</a>
	</div>
</body>
</html>