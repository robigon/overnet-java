<%@page import="it.webapp.model.vo.UserVo"%>
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
	UserVo u = (UserVo)request.getAttribute("userDetail");
%>
	<form action="saveUserDetail" method="post">
	
				<input type="hidden" name="userPk" value="<%=u.getUserId() %>">
			<div>
				<label>Username</label>
				<input type="text" name="username" value="<%=u.getUsername() %>">
			</div>
			<div>
				<label>Name</label>
				<input type="text" name="name" value="<%=u.getName() %>">
			</div>
			<div>
				<label>Lastname</label>
				<input type="text" name="lastname" value="<%=u.getLastName() %>">
			</div>
		<br>
		<input type="submit">	
	</form>
</body>
</html>