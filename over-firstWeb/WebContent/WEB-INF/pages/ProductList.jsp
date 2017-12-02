<%@page import="it.webapp.model.vo.ProductVo"%>
<%@page import="java.util.List"%>
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
		List<ProductVo> productList = (List<ProductVo>) request.getAttribute("productList");
	%>

	<div>

		<%
			if (productList != null && !productList.isEmpty()) {
		%>

		<table>
			<thead>
				<tr>
					<th>Codice</th>
					<th>Descrizione</th>
					<th>Prezzo</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (ProductVo u : productList) {
				%>

				<tr>
					<td><a href="loadUserDetail?userId=<%=u.getId()%>"> <%=u.getCode()%>
					</a></td>
					<td><%=u.getDescription()%></td>
					<td><%=u.getPrice()%></td>
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