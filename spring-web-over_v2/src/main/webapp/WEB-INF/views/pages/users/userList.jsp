<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container">
		<br />
		<br />
		<br />
			<br />
		<br />
		<br />
		<table class="table table-striped">
			<thead class="order-table-header">
				<h3>Elenco Utenti</h3>
				<tr class="order-table-header">
					<th class="order-table-header">Username</th>
					<th class="order-table-header">Nome</th>
					<th class="order-table-header">Cognome</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items='${userList}' var="current">
					<tr class="order-table-odd-row,order-table-even-row">
						<td><a href="user/${current.idUtente}"> <c:out
									value="${current.username}" />
						</a></td>
						<td><c:out value="${current.nome}" /></td>
						<td><c:out value="${current.cognome}" /></td>
						<td><a href="users/delete/${current.idUtente}"></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
