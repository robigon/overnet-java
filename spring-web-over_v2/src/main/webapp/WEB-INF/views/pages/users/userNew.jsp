<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<br />
<br />
<br />
<div class="container">
	<h2>Nuovo utente</h2>
	<p></p>

	<br /> <br />
	<div class="table-responsive">
		<form id="detailForm" action="user">
			<c:param name="userId" value=""></c:param>
				<div>
							<label for="name">Nome</label>
							<input type="text" id="name" name="name" />
						</div>
				<div>
							<label for="lastname">Cognome</label>
							<input type="text" id="lastname" name="lastname" />
						</div>
				<div>
							<label for="username">Username</label>
							<input type="text" id="username" name="username" />
						</div>
				<div>
							<label for="password">Password</label>
							<input type="password" id="password" name="password" />
						</div>
				<div>
							<label for="email">Email</label>
							<input type="text" id="email" name="email" />
						</div>
				<div>
							<input type="submit" value="Salva"/>
						</div>
		</form>
	</div>
</div>

<br></br>
