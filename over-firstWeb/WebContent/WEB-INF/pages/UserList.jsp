<%@page import="it.webapp.model.vo.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User list</title>
</head>
<body>

	<%
		List<UserVo> userlist = (List<UserVo>) request.getAttribute("userList");
	%>

	<div>

		<%
			if (userlist != null && !userlist.isEmpty()) {
		%>

		<table>
			<thead>
				<tr>
					<th>Username</th>
					<th>Name</th>
					<th>Lastname</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (UserVo u : userlist) {
				%>

				<tr>
					<td><a href="loadUserDetail?userId=<%= u.getUserId()%>"> <%=u.getUsername()%></a></td>
					<td><%=u.getName()%></td>
					<td><%=u.getLastName()%></td>
					<td><a href="loadUserGroups?userId=<%=u.getUserId()%>">Gruppi
					</a></td>
				</tr>
				<%
					}
				%>

			</tbody>
		</table>

		<%
			} else {
		%>

		<p>Nessun utente presente</p>

		<%
			}
		%>
	</div>
</body>
</html>