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
			<form class="navbar-form navbar-right" method="post" action="login-attempt">
				<div class="form-group">
					<input type="text" name="username" id="username" class="form-control" />
				</div>
				<div class="form-group">
					<input type="password" name="password" id="password" class="form-control" />
				</div>
				<div class="form-group">
					<input type="submit" value="Login" class="btn btn-success" />
				</div>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			</form>
		</div>
		<!--/.navbar-collapse -->
	</div>
</nav>